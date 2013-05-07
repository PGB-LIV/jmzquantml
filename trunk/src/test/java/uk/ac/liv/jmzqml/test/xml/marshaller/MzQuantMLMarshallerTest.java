/*
 * Date: 02-Apr-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.test.xml.marshaller.MzQuantMLMarshallerTest.java
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

package uk.ac.liv.jmzqml.test.xml.marshaller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import static org.junit.Assert.*;
import org.junit.Test;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.*;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLMarshaller;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 02-Apr-2013 15:47:27
 */
public class MzQuantMLMarshallerTest {

    @Test
    public void testIncrementalMarshalling()
            throws IOException {

        int cvCount = -1;
        int personCount = -1;
        int orgCount = -1;
        int analSumCount = -1;
        int swCount = -1;
        int dpCount = -1;
        int assCount = -1;
        int svCount = -1;
        int protCount = -1;

        URL xmlFileURL = MzQuantMLMarshallerTest.class.getClassLoader().getResource("CPTAC-Progenesis-small-example.mzq");
        assertNotNull(xmlFileURL);
        MzQuantMLUnmarshaller unmarshaller = new MzQuantMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);

        MzQuantMLMarshaller m = new MzQuantMLMarshaller();
        assertNotNull(m);

        FileWriter writer = null;
        try {
            writer = new FileWriter("output.xml");

            /*
             * MzQuantML
             * --CvList
             * --AuditCollection
             * ----Person
             * ----Organization
             * --AnalysisSummary
             * --InputFiles
             * --SoftwareList
             * --DataProcessingList
             * --BibliographicReference
             * --AssayList
             * --StudyVariableList
             * --ProteinList
             * --PeptideConsensusList
             * --FeatureList
             * /MzQuantML
             *
             */

            // Note: writing of '\n' characters is optional and only for readability of the produced XML document
            // Also note: since the XML is produced in individual parts, the overall formatting of the document
            //            is not as nice as it would be when marshalling the whole structure at once.

            // XML header
            writer.write(m.createXmlHeader() + "\n");
            // mzQuantML start tag
            writer.write(m.createMzQuantMLStartTag("Free12345") + "\n");

            CvList cvList = unmarshaller.unmarshal(MzQuantMLElement.CvList.getXpath());
            cvCount = cvList.getCv().size();
            m.marshall(cvList, writer);
            writer.write("\n");

            Provider provider = unmarshaller.unmarshal(MzQuantMLElement.Provider.getXpath());
            Object ref = provider.getContactRole().getContactRef();
            Person contact = provider.getContactRole().getPerson();
            m.marshall(provider, writer);
            writer.write("\n");

            AuditCollection auditCollection = unmarshaller.unmarshal(MzQuantMLElement.AuditCollection.getXpath());
            personCount = auditCollection.getPerson().size();
            orgCount = auditCollection.getOrganization().size();
            m.marshall(auditCollection, writer);
            writer.write("\n");

            AnalysisSummary analSum = unmarshaller.unmarshal(MzQuantMLElement.AnalysisSummary.getXpath());
            analSumCount = analSum.getParamGroup().size();
            m.marshall(analSum, writer);
            writer.write("\n");

            InputFiles inFiles = unmarshaller.unmarshal(MzQuantMLElement.InputFiles.getXpath());
            m.marshall(inFiles, writer);
            writer.write("\n");

            SoftwareList swList = unmarshaller.unmarshal(MzQuantMLElement.SoftwareList.getXpath());
            swCount = swList.getSoftware().size();
            m.marshall(swList, writer);
            writer.write("\n");

            DataProcessingList dpList = unmarshaller.unmarshal(MzQuantMLElement.DataProcessingList.getXpath());
            dpCount = dpList.getDataProcessing().size();
            m.marshall(dpList, writer);
            writer.write("\n");

            Iterator<BibliographicReference> bibliRefIter = unmarshaller.unmarshalCollectionFromXpath(MzQuantMLElement.BibliographicReference);
            while (bibliRefIter.hasNext()) {
                BibliographicReference bibliRef = bibliRefIter.next();
                m.marshall(bibliRef, writer);
                writer.write("\n");
            }

            AssayList assList = unmarshaller.unmarshal(MzQuantMLElement.AssayList.getXpath());
            assCount = assList.getAssay().size();
            m.marshall(assList, writer);
            writer.write("\n");

            StudyVariableList svList = unmarshaller.unmarshal(MzQuantMLElement.StudyVariableList.getXpath());
            svCount = svList.getStudyVariable().size();
            m.marshall(svList, writer);
            writer.write("\n");

            ProteinList protList = unmarshaller.unmarshal(MzQuantMLElement.ProteinList.getXpath());
            protCount = protList.getProtein().size();
            m.marshall(protList, writer);
            writer.write("\n");

            Iterator<PeptideConsensusList> pepConListIter = unmarshaller.unmarshalCollectionFromXpath(MzQuantMLElement.PeptideConsensusList);
            while (pepConListIter.hasNext()) {
                PeptideConsensusList pepConList = pepConListIter.next();
                m.marshall(pepConList, writer);
                writer.write("\n");
            }

            Iterator<FeatureList> ftListIter = unmarshaller.unmarshalCollectionFromXpath(MzQuantMLElement.FeatureList);
            while (ftListIter.hasNext()) {
                FeatureList ftList = ftListIter.next();
                m.marshall(ftList, writer);
                writer.write("\n");
            }

            writer.write(m.createMzQuantMLClosingTag());
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }

        File outputFile = new File("output.xml");
        unmarshaller = new MzQuantMLUnmarshaller(outputFile);
        MzQuantML mzq = unmarshaller.unmarshal(MzQuantMLElement.MzQuantML);
        /**
         * Do some shallow testing. Confirm correct number of child elements returned for each tested element.
         */
        assertTrue(mzq.getId().equals("Free12345"));
        assertTrue(cvCount >= 0);
        assertTrue(mzq.getCvList().getCv().size() == cvCount);
        assertTrue(personCount >= 0);
        assertTrue(mzq.getAuditCollection().getPerson().size() == personCount);
        assertTrue(orgCount >= 0);
        assertTrue(mzq.getAuditCollection().getOrganization().size() == orgCount);
        assertTrue(analSumCount > 0);
        assertTrue(mzq.getAnalysisSummary().getParamGroup().size() == analSumCount);
        assertTrue(swCount >= 0);
        assertTrue(mzq.getSoftwareList().getSoftware().size() == swCount);
        assertTrue(dpCount >= 0);
        assertTrue(mzq.getDataProcessingList().getDataProcessing().size() == dpCount);
        assertTrue(assCount >= 0);
        assertTrue(mzq.getAssayList().getAssay().size() == assCount);
        assertTrue(svCount >= 0);
        assertTrue(mzq.getStudyVariableList().getStudyVariable().size() == svCount);
        assertTrue(protCount >= 0);
        assertTrue(mzq.getProteinList().getProtein().size() == protCount);
        assertTrue(mzq.getBibliographicReference().get(0).getAuthors().equals("D. Qi, P. Brownridge, D. Xia, K. Mackay, F. F. Gonzalez-Galarza, J. Kenyani, V. Harman, R. J. Beynon and A. R. Jones"));
        assertTrue(mzq.getBibliographicReference().get(0).getId().equals("BF_DQ1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMarshallEmptyAuditCollection()
            throws Exception {
        URL xmlFileURL = MzQuantMLMarshallerTest.class.getClassLoader().getResource("CPTAC-Progenesis-small-example.mzq");
        assertNotNull(xmlFileURL);
        MzQuantMLUnmarshaller unmarshaller = new MzQuantMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        MzQuantMLMarshaller m = new MzQuantMLMarshaller();
        AuditCollection ac = unmarshaller.unmarshal(MzQuantMLElement.AuditCollection);
        ac.getOrganization().clear();
        ac.getPerson().clear();
        m.marshall(ac);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMarshallEmptyCvList()
            throws Exception {
        URL xmlFileURL = MzQuantMLMarshallerTest.class.getClassLoader().getResource("CPTAC-Progenesis-small-example.mzq");
        assertNotNull(xmlFileURL);
        MzQuantMLUnmarshaller unmarshaller = new MzQuantMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
        MzQuantMLMarshaller m = new MzQuantMLMarshaller();
        CvList cvList = unmarshaller.unmarshal(MzQuantMLElement.CvList.getXpath());
        cvList.getCv().clear();
        m.marshall(cvList);
    }

}
