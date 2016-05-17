/*
 * Date: 07-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.ProteinRefRefResolver.java
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

import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Protein;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 07-May-2013 12:20:40
 */
public class ProteinRefRefResolver extends AbstractReferenceResolver<ProteinRef> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public ProteinRefRefResolver(final MzQuantMLIndexer index,
                                 final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object ProteinRef
     */
    @Override
    public void updateObject(final ProteinRef object) {
        String ref = object.getProteinRef();
        if (ref != null) {
            Protein refObject = this.unmarshal(ref, Protein.class);
            object.setProtein(refObject);
        }
    }

    /**
     * Method to perform the afterUnmarshal operation if the resolver
     * applies to the specified object.
     *
     * @param target the object to modify after unmarshalling.
     * @param parent object referencing the target. Null if target is root element.
     */
    @Override
    public void afterUnmarshal(final Object target, final Object parent) {
        if (ProteinRef.class.isInstance(target) && MzQuantMLElement.ProteinRef.isAutoRefResolving()) {
            updateObject((ProteinRef) target);
        } // else, not business of this resolver
    }

}
