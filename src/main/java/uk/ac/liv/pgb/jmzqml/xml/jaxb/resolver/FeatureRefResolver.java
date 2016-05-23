/*
 * Date: 02-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.FeatureRefResolver.java
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
import uk.ac.liv.pgb.jmzqml.model.mzqml.Feature;
import uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 02-May-2013 16:57:28
 */
public class FeatureRefResolver extends AbstractReferenceResolver<Feature> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public FeatureRefResolver(final MzQuantMLIndexer index,
                              final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object Feature
     */
    @Override
    public final void updateObject(final Feature object) {

        String ref = object.getRawFileRef();
        if (ref != null) {
            RawFile refObject = this.unmarshal(ref, RawFile.class);
            object.setRawFile(refObject);
        }
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
        if (Feature.class.isInstance(target) && MzQuantMLElement.Feature.
                isAutoRefResolving()) {
            updateObject((Feature) target);
        } // else, not business of this resolver
    }

}
