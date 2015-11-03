/*
 * Date: 02-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.RatioRefResolver.java
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
import uk.ac.liv.pgb.jmzqml.model.mzqml.Assay;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio;
import uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 02-May-2013 17:09:51
 */
public class RatioRefResolver extends AbstractReferenceResolver<Ratio> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public RatioRefResolver(MzQuantMLIndexer index, MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object Ratio
     */
    @Override
    public void updateObject(Ratio object) {

        String refDen = object.getDenominatorRef();
        if (refDen != null) {
            String assayXML = this.getIndexer().getXmlString(refDen, Assay.class);
            String studyVariableXML = this.getIndexer().getXmlString(refDen, StudyVariable.class);
            if (assayXML != null && studyVariableXML == null) {
                Assay refObject = this.unmarshal(refDen, Assay.class);
                object.setDenominator(refObject);
            }
            else if (assayXML == null && studyVariableXML != null) {
                StudyVariable refObject = this.unmarshal(refDen, StudyVariable.class);
                object.setDenominator(refObject);
            }
            else {
                throw new IllegalStateException("Could not uniquely resolve Denominator reference " + refDen);
            }
        }

        String refNum = object.getNumeratorRef();
        if (refNum != null) {
            String assayXML = this.getIndexer().getXmlString(refNum, Assay.class);
            String studyVariableXML = this.getIndexer().getXmlString(refNum, StudyVariable.class);
            if (assayXML != null && studyVariableXML == null) {
                Assay refObject = this.unmarshal(refNum, Assay.class);
                object.setNumerator(refObject);
            }
            else if (assayXML == null && studyVariableXML != null) {
                StudyVariable refObject = this.unmarshal(refNum, StudyVariable.class);
                object.setNumerator(refObject);
            }
            else {
                throw new IllegalStateException("Could not uniquely resolve Numerator reference " + refNum);
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
        if (Ratio.class.isInstance(target) && MzQuantMLElement.Ratio.isAutoRefResolving()) {
            updateObject((Ratio) target);
        } // else, not business of this resolver
    }

}
