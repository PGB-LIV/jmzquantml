/*
 * Date: 08-Mar-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.marshaller.listeners.ObjectClassListener.java
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

package uk.ac.liv.jmzqml.xml.jaxb.marshaller.listeners;

import java.util.List;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import uk.ac.liv.jmzqml.model.mzqml.*;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 08-Mar-2013 15:20:25
 */
public class ObjectClassListener extends Marshaller.Listener {

    private static final Logger log = Logger.getLogger(ObjectClassListener.class);

    public void beforeMarshal(Object source) {
        log.debug("Handling " + source.getClass() + " in beforeMarshal.");
        if (source instanceof ParamList) {
            List<AbstractParam> paramList = ((ParamList) source).getParamGroup();
            if (paramList.size() == 0) {
                throw new IllegalArgumentException("ParamList contains an empty list of AbstractParam.");
            }
        }
        else if (source instanceof RawFilesGroup) {
            List<RawFile> rawFileList = ((RawFilesGroup) source).getRawFile();
            if (rawFileList.size() == 0) {
                throw new IllegalArgumentException("RawFilesGroup contains an empty list of RawFile.");
            }
        }
        else if (source instanceof SoftwareList) {
            List<Software> softwareList = ((SoftwareList) source).getSoftware();
            if (softwareList.size() == 0) {
                throw new IllegalArgumentException("SoftwareList contains an empty list of Software.");
            }
        }
        else if (source instanceof CvList) {
            List<Cv> cvList = ((CvList) source).getCv();
            if (cvList.size() == 0) {
                throw new IllegalArgumentException("CvList contains an empty list of Cv.");
            }
        }
        else if (source instanceof AuditCollection) {
            List<Organization> orgList = ((AuditCollection) source).getOrganization();
            List<Person> perList = ((AuditCollection) source).getPerson();
            if (orgList.size() == 0) {
                throw new IllegalArgumentException("AuditCollection contains an empty list of Organization.");
            }
            if (perList.size() == 0) {
                throw new IllegalArgumentException("AuditCollection contains an empty list of Person.");
            }
        }
        else if (source instanceof AssayList) {
            List<Assay> assayList = ((AssayList) source).getAssay();
            if (assayList.size() == 0) {
                throw new IllegalArgumentException("AssayList contains an empty list of Assay.");
            }
        }
        else if (source instanceof StudyVariableList) {
            List<StudyVariable> studyvariableList = ((StudyVariableList) source).getStudyVariable();
            if (studyvariableList.size() == 0) {
                throw new IllegalArgumentException("StudyVariableList contains an empty list of StudyVariable.");
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
