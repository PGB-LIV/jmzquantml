/*
 * Date: 24-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.RowRefResolver.java
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
import uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Protein;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Row;
import uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

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
    public RowRefResolver(final MzQuantMLIndexer index,
                          final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object Row
     */
    @Override
    public final void updateObject(final Row object) {
        // add objects for the refID                      
        String ref = object.getObjectRef();
        if (ref != null) {
            String protGroupXML = this.getIndexer().getXmlString(ref, ProteinGroup.class);
            String protXML = this.getIndexer().getXmlString(ref, Protein.class);
            String pepXML = this.getIndexer().getXmlString(ref, PeptideConsensus.class);
            String featureXML = this.getIndexer().getXmlString(ref, Feature.class);
            String smallMolXML = this.getIndexer().getXmlString(ref, SmallMolecule.class);

            if (protGroupXML != null) {
                ProteinGroup refObject = this.unmarshal(ref, ProteinGroup.class);
                object.setObject(refObject);
            }
            else if (protXML != null) {
                Protein refObject = this.unmarshal(ref, Protein.class);
                object.setObject(refObject);
            }
            else if (pepXML != null) {
                PeptideConsensus refObject = this.unmarshal(ref, PeptideConsensus.class);
                object.setObject(refObject);
            }
            else if (featureXML != null) {
                Feature refObject = this.unmarshal(ref, Feature.class);
                object.setObject(refObject);
            }
            else if (smallMolXML != null) {
                SmallMolecule refObject = this.unmarshal(ref, SmallMolecule.class);
                object.setObject(refObject);
            }
            else {
                throw new IllegalStateException("Could not uniquely resolve object reference " + ref);
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
    public final void afterUnmarshal(final Object target, final Object parent) {
        if (Row.class.isInstance(target) && MzQuantMLElement.Row.isAutoRefResolving()) {
            updateObject((Row) target);
        } // else, not business of this resolver
    }

}
