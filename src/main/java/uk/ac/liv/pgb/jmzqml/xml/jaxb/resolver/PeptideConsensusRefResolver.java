/*
 * Date: 07-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.PeptideConsensusRefResolver.java
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
import uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus;
import uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase;
import uk.ac.liv.pgb.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 07-May-2013 12:20:40
 */
public class PeptideConsensusRefResolver extends AbstractReferenceResolver<PeptideConsensus> {

    /**
     *
     * @param index MzQuantMLIndexer
     * @param cache MzQuantMLObjectCache
     */
    public PeptideConsensusRefResolver(final MzQuantMLIndexer index,
                                       final MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    /**
     *
     * @param object PeptideConsensus
     */
    @Override
    public final void updateObject(final PeptideConsensus object) {
        String ref = object.getSearchDatabaseRef();
        if (ref != null) {
            SearchDatabase refObject = this.unmarshal(ref, SearchDatabase.class);
            object.setSearchDatabase(refObject);
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
        if (PeptideConsensus.class.isInstance(target)
                && MzQuantMLElement.PeptideConsensus.
                isAutoRefResolving()) {
            updateObject((PeptideConsensus) target);
        } // else, not business of this resolver
    }

}
