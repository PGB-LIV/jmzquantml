/*
 * Date: 07-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.EvidenceRefRefResolver.java
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
import uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Feature;
import uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 07-May-2013 12:20:40
 */
public class EvidenceRefRefResolver extends AbstractReferenceResolver<EvidenceRef> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public EvidenceRefRefResolver(final MzQuantMLIndexer index,
                                  final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object EvidenceRef
     */
    @Override
    public void updateObject(final EvidenceRef object) {
        //feature_ref
        String ref1 = object.getFeatureRef();
        if (ref1 != null) {
            Feature refObject1 = this.unmarshal(ref1, Feature.class);
            object.setFeature(refObject1);
        }

        //identificationFile_ref
        String ref2 = object.getIdentificationFileRef();
        if (ref2 != null) {
            IdentificationFile refObject2 = this.unmarshal(ref2, IdentificationFile.class);
            object.setIdentificationFile(refObject2);
        }

        //assay_refs
        List<String> refs3 = object.getAssayRefs();
        List<Assay> refObjects3 = object.getAssays();
        for (String ref3 : refs3) {
            Assay refObject3 = this.unmarshal(ref3, Assay.class);
            refObjects3.add(refObject3);
        }
        object.setAssays(refObjects3);
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
        if (EvidenceRef.class.isInstance(target) && MzQuantMLElement.EvidenceRef.isAutoRefResolving()) {
            updateObject((EvidenceRef) target);
        } // else, not business of this resolver
    }

}
