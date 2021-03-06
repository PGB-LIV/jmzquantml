/*
 * Date: 02-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.AssayRefResolver.java
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
import uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile;
import uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 02-May-2013 17:25:21
 */
public class AssayRefResolver extends AbstractReferenceResolver<Assay> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public AssayRefResolver(final MzQuantMLIndexer index,
                            final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object Assay
     */
    @Override
    public final void updateObject(final Assay object) {

        String ref1 = object.getRawFilesGroupRef();
        if (ref1 != null) {
            RawFilesGroup refObject1 = this.unmarshal(ref1, RawFilesGroup.class);
            object.setRawFilesGroup(refObject1);
        }

        List<String> refs = object.getIdentificationFileRefs();
        List<IdentificationFile> identificationFiles = object.
                getIdentificationFiles();
        for (String ref2 : refs) {
            IdentificationFile refObject2 = this.unmarshal(ref2,
                                                           IdentificationFile.class);
            identificationFiles.add(refObject2);
        }
        object.setIdentificationFiles(identificationFiles);
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
        if (Assay.class.isInstance(target) && MzQuantMLElement.Assay.
                isAutoRefResolving()) {
            updateObject((Assay) target);
        } // else, not business of this resolver
    }

}
