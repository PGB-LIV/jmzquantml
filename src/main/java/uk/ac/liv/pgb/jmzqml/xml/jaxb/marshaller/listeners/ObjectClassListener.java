/*
 * Date: 08-Mar-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.jaxb.marshaller.listeners.ObjectClassListener.java
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

package uk.ac.liv.pgb.jmzqml.xml.jaxb.marshaller.listeners;

import java.util.List;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Assay;
import uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Cv;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing;
import uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Feature;
import uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Organization;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus;
import uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Person;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Protein;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio;
import uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile;
import uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup;
import uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule;
import uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Software;
import uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable;
import uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 08-Mar-2013 15:20:25
 */
public class ObjectClassListener extends Marshaller.Listener {

    private static final Logger LOGGER = Logger.getLogger(ObjectClassListener.class);

    @Override
    public void beforeMarshal(Object source) {
        LOGGER.debug("Handling " + source.getClass() + " in beforeMarshal.");
        if (source instanceof ParamList) {
            List<AbstractParam> paramList = ((ParamList) source).getParamGroup();
            if (paramList.isEmpty()) {
                throw new IllegalArgumentException("ParamList contains an empty list of AbstractParam.");
            }
        }
        else if (source instanceof RawFilesGroup) {
            List<RawFile> rawFileList = ((RawFilesGroup) source).getRawFile();
            if (rawFileList.isEmpty()) {
                throw new IllegalArgumentException("RawFilesGroup contains an empty list of RawFile.");
            }
        }
        else if (source instanceof AnalysisSummary) {
            List<AbstractParam> paramList = ((AnalysisSummary) source).getParamGroup();
            if (paramList.isEmpty()) {
                throw new IllegalArgumentException("AnalysisSummary contains an empty list of AbstractParam.");
            }
        }
        else if (source instanceof SoftwareList) {
            List<Software> softwareList = ((SoftwareList) source).getSoftware();
            if (softwareList.isEmpty()) {
                throw new IllegalArgumentException("SoftwareList contains an empty list of Software.");
            }
        }
        else if (source instanceof CvList) {
            List<Cv> cvList = ((CvList) source).getCv();
            if (cvList.isEmpty()) {
                throw new IllegalArgumentException("CvList contains an empty list of Cv.");
            }
        }
        else if (source instanceof AuditCollection) {
            List<Organization> orgList = ((AuditCollection) source).getOrganization();
            List<Person> perList = ((AuditCollection) source).getPerson();
            if (orgList.isEmpty() && perList.isEmpty()) {
                throw new IllegalArgumentException("AuditCollection contains an empty list of AbstractContact.");
            }
        }
        else if (source instanceof DataProcessingList) {
            List<DataProcessing> dataProcessingList = ((DataProcessingList) source).getDataProcessing();
            if (dataProcessingList.isEmpty()) {
                throw new IllegalArgumentException("DataProcessingList contains an empty list of DataProcessing");
            }
        }
        else if (source instanceof AssayList) {
            List<Assay> assayList = ((AssayList) source).getAssay();
            if (assayList.isEmpty()) {
                throw new IllegalArgumentException("AssayList contains an empty list of Assay.");
            }
        }
        else if (source instanceof StudyVariableList) {
            List<StudyVariable> studyvariableList = ((StudyVariableList) source).getStudyVariable();
            if (studyvariableList.isEmpty()) {
                throw new IllegalArgumentException("StudyVariableList contains an empty list of StudyVariable.");
            }
        }
        else if (source instanceof RatioList) {
            List<Ratio> ratioList = ((RatioList) source).getRatio();
            if (ratioList.isEmpty()) {
                throw new IllegalArgumentException("RatioList contains an empty list of Ratio.");
            }
        }
        else if (source instanceof ProteinGroupList) {
            List<ProteinGroup> proteinGroupList = ((ProteinGroupList) source).getProteinGroup();
            if (proteinGroupList.isEmpty()) {
                throw new IllegalArgumentException("ProteinGroupList contains an empty list of ProteinGroup.");
            }
        }
        else if (source instanceof ProteinList) {
            List<Protein> proteinList = ((ProteinList) source).getProtein();
            if (proteinList.isEmpty()) {
                throw new IllegalArgumentException("ProteinList contains an empty list of Protein.");
            }
        }
        else if (source instanceof PeptideConsensusList) {
            List<PeptideConsensus> peptideConsensusList = ((PeptideConsensusList) source).getPeptideConsensus();
            if (peptideConsensusList.isEmpty()) {
                throw new IllegalArgumentException("PeptideConsensusList contains an empty list of PeptideConsensus.");
            }
        }
        else if (source instanceof SmallMoleculeList) {
            List<SmallMolecule> smallMoleculeList = ((SmallMoleculeList) source).getSmallMolecule();
            if (smallMoleculeList.isEmpty()) {
                throw new IllegalArgumentException("SmallMoleculeList contains an empty list of SmallMolecule.");
            }
        }
        else if (source instanceof FeatureList) {
            List<Feature> featureList = ((FeatureList) source).getFeature();
            if (featureList.isEmpty()) {
                throw new IllegalArgumentException("FeatureList contains an empty list of Feature.");
            }
        }

        // Handle the cases were we have ParamGroups, CvParams, UserParams, etc...
//        if (source instanceof ParamAlternative) {
//            ((ParamAlternative)source).beforeMarshalOperation();
//        } else if (source instanceof ParamGroupCapable) {
//            ParamGroupCapable apg = (ParamGroupCapable) source;
//            // we have to re-unite the CvParam and UserParam we split in the unmarshall process
//            apg.updateParamList();
//        }

        // Since the ID of a referenced object is updated when the referenced object is updated/added
        // and the object is not taken into account for the marshalling process, we don't really need
        // to do anything else here (regarding the automatic reference resolving).
    }

}
