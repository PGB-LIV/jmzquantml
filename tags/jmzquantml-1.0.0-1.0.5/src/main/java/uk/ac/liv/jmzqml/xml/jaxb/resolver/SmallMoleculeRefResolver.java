/*
 * Date: 07-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.resolver.SmallMoleculeRefResolver.java
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

package uk.ac.liv.jmzqml.xml.jaxb.resolver;

import java.util.List;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.Feature;
import uk.ac.liv.jmzqml.model.mzqml.SmallMolecule;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 07-May-2013 12:20:40
 */
public class SmallMoleculeRefResolver extends AbstractReferenceResolver<SmallMolecule> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public SmallMoleculeRefResolver(MzQuantMLIndexer index,
                                    MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object SmallMolecule
     */
    @Override
    public void updateObject(SmallMolecule object) {
        List<String> refs = object.getFeatureRefs();
        List<Feature> features = object.getFeatures();
        if (refs != null) {
            for (String ref1 : refs) {
                Feature refObject = this.unmarshal(ref1, Feature.class);
                features.add(refObject);
            }
            object.setFeatures(features);
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
    public void afterUnmarshal(Object target, Object parent) {
        if (SmallMolecule.class.isInstance(target) && MzQuantMLElement.SmallMolecule.isAutoRefResolving()) {
            updateObject((SmallMolecule) target);
        } // else, not business of this resolver
    }

}
