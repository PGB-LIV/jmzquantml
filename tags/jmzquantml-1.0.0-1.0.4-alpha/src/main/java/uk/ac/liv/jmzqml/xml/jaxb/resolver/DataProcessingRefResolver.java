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

package uk.ac.liv.jmzqml.xml.jaxb.resolver;

import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.DataProcessing;
import uk.ac.liv.jmzqml.model.mzqml.Software;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

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
