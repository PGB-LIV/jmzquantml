/*
 * Date: 07-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.StudyVariableRefResolver.java
 *
 * jmzquantml is Copyright 2013 University of Liverpool.
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

package uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver;

import java.util.List;
import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Assay;
import uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 07-May-2013 12:20:40
 */
public class StudyVariableRefResolver extends AbstractReferenceResolver<StudyVariable> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public StudyVariableRefResolver(final MzQuantMLIndexer index,
                                    final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object StudyVariable
     */
    @Override
    public final void updateObject(final StudyVariable object) {
        List<String> refs = object.getAssayRefs();
        List<Assay> assays = object.getAssays();

        for (String ref : refs) {
            Assay refObject = this.unmarshal(ref, Assay.class);
            assays.add(refObject);
        }
        object.setAssays(assays);
    }

    /**
     * Method to perform the afterUnmarshal operation if the resolver
     * applies to the specified object.
     *
     * @param target the object to modify after unmarshalling.
     * @param parent object referencing the target. Null if target is root
     *               element.
     */
    @Override
    public final void afterUnmarshal(final Object target, final Object parent) {
        if (StudyVariable.class.isInstance(target)
                && MzQuantMLElement.StudyVariable.
                isAutoRefResolving()) {
            updateObject((StudyVariable) target);
        } // else, not business of this resolver
    }

}
