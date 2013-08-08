/*
 * Date: 07-May-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.resolver.ProteinRefResolver.java
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

import java.util.ArrayList;
import java.util.List;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus;
import uk.ac.liv.jmzqml.model.mzqml.Protein;
import uk.ac.liv.jmzqml.model.mzqml.SearchDatabase;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectCache;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 07-May-2013 12:20:40
 */
public class ProteinRefResolver extends AbstractReferenceResolver<Protein> {

    public ProteinRefResolver(MzQuantMLIndexer index, MzQuantMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(Protein object) {
        String ref1 = object.getSearchDatabaseRef();
        if (ref1 != null) {
            SearchDatabase refObject1 = this.unmarshal(ref1, SearchDatabase.class);
            object.setSearchDatabase(refObject1);
        }

        List<String> refs = object.getPeptideConsensusRefs();
        List<PeptideConsensus> peptideConsensuses = object.getPeptideConsensuses();
        if (refs != null) {
            for (String ref2 : refs) {
                PeptideConsensus refObject2 = this.unmarshal(ref2, PeptideConsensus.class);
                peptideConsensuses.add(refObject2);
            }
            //object.setPeptideConsensuses(peptideConsensuses);
        }
    }

    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (Protein.class.isInstance(target) && MzQuantMLElement.Protein.isAutoRefResolving()) {
            updateObject((Protein) target);
        } // else, not business of this resolver
    }

}
