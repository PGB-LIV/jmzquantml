/*
 * Date: 02-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.resolver.DataProcessingRefResolver.java
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
import uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing;
import uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.IdOnly;
import uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer;
import uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Software;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 02-May-2013 16:35:30
 */
public class DataProcessingRefResolver extends AbstractReferenceResolver<DataProcessing> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public DataProcessingRefResolver(MzQuantMLIndexer index,
                                     MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object DataProcessing
     */
    @Override
    public void updateObject(DataProcessing object) {
        String ref = object.getSoftwareRef();
        if (ref != null) {
            Software refObject = this.unmarshal(ref, Software.class);
            object.setSoftware(refObject);
        }

        List<String> refsInput = object.getInputObjectRefs();
        List<IdOnly> inputObjects = object.getInputObjects();
        if (refsInput != null) {
            for (String refInput : refsInput) {
                // Decide the class type
                String rawFilesGroupXML = this.getIndexer().getXmlString(refInput, RawFilesGroup.class);
                String featureListXML = this.getIndexer().getXmlString(refInput, FeatureList.class);
                String peptideListXML = this.getIndexer().getXmlString(refInput, PeptideConsensusList.class);
                String proteinListXML = this.getIndexer().getXmlString(refInput, ProteinList.class);
                String proteinGroupListXML = this.getIndexer().getXmlString(refInput, ProteinGroupList.class);
                String quantLayerXML = this.getIndexer().getXmlString(refInput, QuantLayer.class);
                if (rawFilesGroupXML != null) {
                    RawFilesGroup refObject = this.unmarshal(refInput, RawFilesGroup.class);
                    inputObjects.add(refObject);
                }
                else if (featureListXML != null) {
                    FeatureList refObject = this.unmarshal(refInput, FeatureList.class);
                    inputObjects.add(refObject);
                }
                else if (peptideListXML != null) {
                    PeptideConsensusList refObject = this.unmarshal(refInput, PeptideConsensusList.class);
                    inputObjects.add(refObject);
                }
                else if (proteinListXML != null) {
                    ProteinList refObject = this.unmarshal(refInput, ProteinList.class);
                    inputObjects.add(refObject);
                }
                else if (proteinGroupListXML != null) {
                    ProteinGroupList refObject = this.unmarshal(refInput, ProteinGroupList.class);
                    inputObjects.add(refObject);
                }
                else if (quantLayerXML != null) {
                    QuantLayer refObject = this.unmarshal(refInput, QuantLayer.class);
                    inputObjects.add(refObject);
                }
                else {
                    throw new IllegalStateException("Could not resolve input referecence " + refInput + " to required element");
                }
            }
            object.setInputObjects(inputObjects);
        }

        List<String> refsOutput = object.getOutputObjectRefs();
        List<IdOnly> outputObjects = object.getOutputObjects();
        if (refsOutput != null) {
            for (String refOutput : refsOutput) {
                // Decide the class type
                String rawFilesGroupXML = this.getIndexer().getXmlString(refOutput, RawFilesGroup.class);
                String featureListXML = this.getIndexer().getXmlString(refOutput, FeatureList.class);
                String peptideListXML = this.getIndexer().getXmlString(refOutput, PeptideConsensusList.class);
                String proteinListXML = this.getIndexer().getXmlString(refOutput, ProteinList.class);
                String proteinGroupListXML = this.getIndexer().getXmlString(refOutput, ProteinGroupList.class);
                String quantLayerXML = this.getIndexer().getXmlString(refOutput, QuantLayer.class);
                if (rawFilesGroupXML != null) {
                    RawFilesGroup refObject = this.unmarshal(refOutput, RawFilesGroup.class);
                    outputObjects.add(refObject);
                }
                else if (featureListXML != null) {
                    FeatureList refObject = this.unmarshal(refOutput, FeatureList.class);
                    outputObjects.add(refObject);
                }
                else if (peptideListXML != null) {
                    PeptideConsensusList refObject = this.unmarshal(refOutput, PeptideConsensusList.class);
                    outputObjects.add(refObject);
                }
                else if (proteinListXML != null) {
                    ProteinList refObject = this.unmarshal(refOutput, ProteinList.class);
                    outputObjects.add(refObject);
                }
                else if (proteinGroupListXML != null) {
                    ProteinGroupList refObject = this.unmarshal(refOutput, ProteinGroupList.class);
                    outputObjects.add(refObject);
                }
                else if (quantLayerXML != null) {
                    QuantLayer refObject = this.unmarshal(refOutput, QuantLayer.class);
                    outputObjects.add(refObject);
                }
                else {
                    throw new IllegalStateException("Could not resolve output referecence " + refOutput + " to required element");
                }
            }
            object.setOutputObjects(outputObjects);
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
        if (DataProcessing.class.isInstance(target) && MzQuantMLElement.DataProcessing.isAutoRefResolving()) {
            updateObject((DataProcessing) target);
        }
    }

}
