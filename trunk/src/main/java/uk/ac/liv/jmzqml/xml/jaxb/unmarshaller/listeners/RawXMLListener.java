/*
 * Date: 26-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.unmarshaller.listeners.RawXMLListener.java
 *
 * jmzquantml is Copyright 2012 University of Liverpool.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.liv.jmzqml.xml.jaxb.unmarshaller.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.ParamListMappings;
import uk.ac.liv.jmzqml.ParamMappings;
import uk.ac.liv.jmzqml.model.CvParamCapable;
import uk.ac.liv.jmzqml.model.CvParamListCapable;
import uk.ac.liv.jmzqml.model.ParamCapable;
import uk.ac.liv.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.jmzqml.model.ParamListCapable;
import uk.ac.liv.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.jmzqml.model.mzqml.Param;
import uk.ac.liv.jmzqml.model.mzqml.ParamList;
import uk.ac.liv.jmzqml.model.mzqml.UserParam;
import uk.ac.liv.jmzqml.model.utils.ParamUpdater;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.jaxb.resolver.AbstractReferenceResolver;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 26-Jul-2012 10:14:36
 */
public class RawXMLListener extends Unmarshaller.Listener {

    private static final Logger logger = Logger.getLogger(RawXMLListener.class);
    private final MzQuantMLIndexer index;
    private final MzQuantMLObjectCache cache;

    public RawXMLListener(MzQuantMLIndexer index, MzQuantMLObjectCache cache) {
        this.index = index;
        this.cache = cache;
    }

    @Override
    public void afterUnmarshal(Object target, Object parent) {

        logger.debug("Handling " + target.getClass() + " in afterUnmarshal.");
        // retreive the enum type for this class (for the meta data about this class/element)
        MzQuantMLElement element = MzQuantMLElement.getType(target.getClass());

        // splitting of Param into CvParam/UserParam and sub-classing
        paramHandling(target, element);

        // now perform the automatic reference resolving, if configured to do so
        referenceResolving(target, parent, element);
    }

    private void referenceResolving(Object target, Object parent,
                                    MzQuantMLElement element) {
        if (element.isAutoRefResolving()) {
            Class cls = element.getRefResolverClass();
            if (cls == null) {
                throw new IllegalStateException("Can not auto-resolve references if no reference resolver was defined for class: " + element.getClazz());
            }
            try {
                Constructor con = cls.getDeclaredConstructor(MzQuantMLIndexer.class, MzQuantMLObjectCache.class);
                AbstractReferenceResolver resolver = (AbstractReferenceResolver) con.newInstance(index, cache);
                resolver.afterUnmarshal(target, parent);
            }
            catch (Exception e) {
                logger.error("Error trying to instantiate reference resolver: " + cls.getName(), e);
                throw new IllegalStateException("Could not instantiate reference resolver: " + cls.getName());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void paramHandling(Object target, MzQuantMLElement ele) {
        try {
            if (target instanceof ParamCapable) {
                ParamMappings mapping = ParamMappings.getType(target.getClass());
                String className = mapping.getClassName();
                Method method = target.getClass().getMethod("get" + className);
                Param param = (Param) method.invoke(target);
                if (param != null) {
                    /**
                     * Use the retrieved class name to determine the correct subclasses of CvParam and UserParam to use.
                     */
                    if (param.getCvParam() != null) {
                        Class clazz = Class.forName("uk.ac.liv.jmzqml.model.mzqml.params." + className + "CvParam");
                        CvParam cvParam = ParamUpdater.updateCvParamSubclass(param.getCvParam(), clazz);
                        param.setParamGroup(cvParam);
                    }
                    else if (param.getUserParam() != null) {
                        Class clazz = Class.forName("uk.ac.liv.jmzqml.model.mzqml.params." + className + "UserParam");
                        UserParam userParam = ParamUpdater.updateUserParamSubclass(param.getUserParam(), clazz);
                        param.setParamGroup(userParam);
                    }
                }
            }

            // now we check what kind of object we are dealing with
            // NOTE: the order of the if statements is IMPORTANT!
            // (every AbstractParamGroup is a CvParamCapable, but not vice versa)
            if (target instanceof ParamListCapable) {
                ParamListMappings mappings = ParamListMappings.getType(target.getClass());
                String[] classNames = mappings.getClassNames();
                for (String className : classNames) {
                    /**
                     * Use the retrieved class name to dynamically call the appropriate get method in the class implementing
                     * ParamListCapable
                     */
                    Method method = target.getClass().getMethod("get" + className);
                    ParamList paramList = (ParamList) method.invoke(target);
                    if (paramList != null) {
                        /**
                         * Use the retrieved class name to determine the correct subclasses of CvParam and UserParam to use.
                         */
                        Class clazz = Class.forName("uk.ac.liv.jmzqml.model.mzqml.params." + className + "CvParam");
                        ParamUpdater.updateCvParamSubclassesList(paramList.getCvParam(), clazz);
                        clazz = Class.forName("uk.ac.liv.jmzqml.model.mzqml.params." + className + "UserParam");
                        ParamUpdater.updateUserParamSubclassesList(paramList.getUserParam(), clazz);
                    }
                }
            }
            else if (target instanceof ParamGroupCapable) {
                // in this case we not only have to subclass the params, but also to split them up
                ParamGroupCapable apg = (ParamGroupCapable) target;
                // first we are going to split the List<Param> in a List<CvParam> and a List<UserParam>
                // apg.splitParamList();
                // then we are going to subclass the params

                if (ele.getCvParamClass() == null) {
                    throw new IllegalStateException("Subclass of AbstractParamGroup does not have CvParam subclass! " + target.getClass());
                }
                ParamUpdater.updateCvParamSubclassesList(apg.getCvParam(), ele.getCvParamClass());
                if (ele.getUserParamClass() == null) {
                    throw new IllegalStateException("Subclass of AbstractParamGroup does not have UserParam subclass! " + target.getClass());
                }
                ParamUpdater.updateUserParamSubclassesList(apg.getUserParam(), ele.getUserParamClass());
            }
            else if (target instanceof CvParamCapable) {
                // no need to split up params, but we need to subclass them
                CvParamCapable cpc = (CvParamCapable) target;
                if (ele.getCvParamClass() == null) {
                    throw new IllegalStateException("Subcalss of  AbstactParamGroup does not have CvParam subclass! " + target.getClass());
                }
                CvParam param = cpc.getCvParam();
                cpc.setCvParam(ParamUpdater.updateCvParamSubclass(param, ele.<CvParam>getCvParamClass()));
            }
            else if (target instanceof CvParamListCapable) {
                CvParamListCapable cpc = (CvParamListCapable) target;
                if (ele.getCvParamClass() == null) {
                    throw new IllegalStateException("Subclass of AbstractParamGroup does not have CvParam subclass! " + target.getClass());
                }
                ParamUpdater.updateCvParamSubclassesList(cpc.getCvParam(), ele.getCvParamClass());
            }
            else {
                // no need to split or subclass params
                if (ele.getCvParamClass() != null || ele.getUserParamClass() != null) {
                    throw new IllegalStateException("Element with param subclasses has not been handled! " + target.getClass());
                }
            }
        }
        catch (Exception e) {
            logger.error("Exception during post unmarshall processing! ", e);
            throw new IllegalStateException("Error during post unmarshall processing!", e);
        }
    }

}
