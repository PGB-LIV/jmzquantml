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
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import uk.ac.liv.jmzqml.MzQuantMLElement;
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
        //Todo: paramHandling(target, element);

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
            } catch (Exception e) {
                logger.error("Error trying to instantiate reference resolver: " + cls.getName(), e);
                throw new IllegalStateException("Could not instantiate reference resolver: " + cls.getName());
            }
        }
    }
}
