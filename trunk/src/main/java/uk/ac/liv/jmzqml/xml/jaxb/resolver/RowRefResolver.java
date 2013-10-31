/*
 * Date: 24-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.resolver.RowRefResolver.java
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

import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.Feature;
import uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus;
import uk.ac.liv.jmzqml.model.mzqml.Protein;
import uk.ac.liv.jmzqml.model.mzqml.ProteinGroup;
import uk.ac.liv.jmzqml.model.mzqml.Row;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 24-May-2013 14:36:33
 */
public class RowRefResolver extends AbstractReferenceResolver<Row> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public RowRefResolver(MzQuantMLIndexer index, MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object Row
     */
    @Override
    public void updateObject(Row object) {
        // add objects for the refID                      
        String ref = object.getObjectRef();
        if (ref != null) {
            ProteinGroup pgObject = this.unmarshal(ref, ProteinGroup.class);
            Protein protObject = this.unmarshal(ref, Protein.class);
            PeptideConsensus pepObject = this.unmarshal(ref, PeptideConsensus.class);
            Feature ftObject = this.unmarshal(ref, Feature.class);
            if (pgObject != null) {
                object.setObject(pgObject);
            }
            if (protObject != null) {
                object.setObject(protObject);
            }
            if (pepObject != null) {
                object.setObject(pepObject);
            }
            if (ftObject != null) {
                object.setObject(ftObject);
            }
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
        if (Row.class.isInstance(target) && MzQuantMLElement.Row.isAutoRefResolving()) {
            updateObject((Row) target);
        } // else, not business of this resolver
    }

}
