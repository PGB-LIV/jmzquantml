/*
 * Date: 10-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.test.xml.unmarshaller.MzQuantMLUnmarshallerTest.java
 *
 * jmzquantml is Copyright 2012 University of Liverpool.
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

package uk.ac.liv.jmzqml.test.xml.unmarshaller;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.naming.ConfigurationException;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.*;
import org.junit.Test;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.*;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 10-Jul-2012 11:37:50
 */
public class MzQuantMLUnmarshallerTest {

    private static MzQuantMLUnmarshaller unmarshaller;
    private static MzQuantMLUnmarshaller noidUM;

    static {
        String fileName = "CPTAC-Progenesis-small-example.mzq";
        URL xmlFileURL = MzQuantMLUnmarshallerTest.class.getClassLoader().getResource(fileName);
        assertNotNull(xmlFileURL);

        unmarshaller = new MzQuantMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
    }

    @Test(expected = IllegalStateException.class)
    public void testNoIDUnmarshaller() {
        String noidFile = "NoRefIdTest.mzq";
        URL noidFileURL = MzQuantMLUnmarshallerTest.class.getClassLoader().getResource(noidFile);
        assertNotNull(noidFileURL);
        noidUM = new MzQuantMLUnmarshaller(noidFileURL);
    }

    @Test
    public void testAttributeRetrieval()
            throws Exception {

        // Number of software
        int total = unmarshaller.getObjectCountForXpath(MzQuantMLElement.Software.getXpath());
        assertEquals(1, total);

        Software software = unmarshaller.unmarshal(MzQuantMLElement.Software);
        assertNotNull(software);
        String id = "Progenesis";
        Map<String, String> attributes = unmarshaller.getElementAttributes(id, MzQuantMLElement.Software.getClazz());
        assertNotNull(attributes);
        assertEquals(id, attributes.get("id"));

        assertEquals(2, attributes.keySet().size());
        assertEquals("2.3", attributes.get("version"));

        // test cv 
        Cv cv = unmarshaller.unmarshal(MzQuantMLElement.Cv);
        assertNotNull(cv);

        id = "PSI-MS";
        attributes = unmarshaller.getElementAttributes(id, MzQuantMLElement.Cv.getClazz());
        assertNotNull(attributes);
        assertEquals(id, attributes.get("id"));

        assertEquals(4, attributes.keySet().size());
        assertEquals("Proteomics Standards Initiative Mass Spectrometry Vocabularies", attributes.get("fullName"));
        assertEquals("http://psidev.cvs.sourceforge.net/viewvc/*checkout*/psidev/psi/psi-ms/mzML/controlledVocabulary/psi-ms.obo", attributes.get("uri"));
        assertEquals("2.25.0", attributes.get("version"));
    }

    @Test
    public void testRootAttributeRetrieval()
            throws Exception {
        // check the root element (mzQuantML) attributes
        assertEquals("Progenesis-Label-Free-26112012", unmarshaller.getMzQuantMLId());
        assertEquals("1.0.0", unmarshaller.getMzQuantMLVersion());
        assertNull(unmarshaller.getMzQuantMLName());

        String id = "Progenesis-Label-Free-26112012";
        Map<String, String> attributes = unmarshaller.getElementAttributes(id, MzQuantMLElement.MzQuantML.getClazz());
        assertNotNull(attributes);
        assertEquals(6, attributes.keySet().size());
        assertEquals("http://www.w3.org/2001/XMLSchema-instance", attributes.get("xmlns:xsi"));
        assertEquals("http://psidev.info/psi/pi/mzQuantML/1.0.0 ../../../schema/mzQuantML_1_0_0.xsd", attributes.get("xsi:schemaLocation"));
        assertEquals("http://psidev.info/psi/pi/mzQuantML/1.0.0", attributes.get("xmlns"));
        assertEquals("2012-11-26T13:10:55.529Z", attributes.get("creationDate"));
        assertEquals("1.0.0", attributes.get("version"));
        assertEquals(id, attributes.get("id"));
    }

    @Test
    public void testAuditCollection()
            throws JAXBException {
        AuditCollection ac = unmarshaller.unmarshal(MzQuantMLElement.AuditCollection);
        assertNotNull(ac);
        Organization org = unmarshaller.unmarshal(Organization.class, "ORG_UOL");
        List<CvParam> cvParams = org.getCvParam();
        List<UserParam> userParams = org.getUserParam();
        assertTrue(cvParams.size() == 2);
        assertTrue(userParams.size() == 2);
        CvParam cvParam = cvParams.get(0);
        assertTrue(cvParam.getAccession().equals("MS:1000589"));
        UserParam userParam = userParams.get(0);
        assertTrue(userParam.getValue().equals("+44 (0)20 7486 1050"));
    }

    @Test
    public void testAssayList()
            throws JAXBException {
        AssayList assayList = unmarshaller.unmarshal(MzQuantMLElement.AssayList);
        assertNotNull(assayList);
        List<Assay> assays = assayList.getAssay();
        assertNotNull(assays);
    }

    @Test
    public void testAssay()
            throws ConfigurationException {
        int assayNumber = unmarshaller.getObjectCountForXpath(MzQuantMLElement.Assay.getXpath());
        assertEquals(12, assayNumber);
        Set<String> assayIDs = unmarshaller.getIDsForElement(MzQuantMLElement.Assay);
        Set<String> realAssayIDs = new HashSet(Arrays.asList(new String[]{"ass_0", "ass_1", "ass_2", "ass_3", "ass_4", "ass_5", "ass_6", "ass_7", "ass_8", "ass_9", "ass_10", "ass_11"}));
        assertEquals(realAssayIDs, assayIDs);

        Iterator<Assay> assays = unmarshaller.unmarshalCollectionFromXpath(MzQuantMLElement.Assay);
        assertNotNull(assays);

        AssayList assayList = unmarshaller.unmarshal(MzQuantMLElement.AssayList);
        assertNotNull(assayList);

        Assay assay = unmarshaller.unmarshal(MzQuantMLElement.Assay);
        assertTrue(assay.getId().equals("ass_0"));
        Label label = assay.getLabel();
        assertNotNull(label);
        ModParam mod = label.getModification().get(0);
        assertNotNull(mod);
        assertTrue("unlabeled sample".equals(mod.getCvParam().getName()));
        assertTrue(mod.getCvParam().getAccession().equals("MS:1002038"));
        assertTrue(mod.getCvParam().getCvRef().equals("PSI-MS"));
    }

    @Test
    public void testStudyVariableList()
            throws Exception {
        StudyVariableList studyVList = unmarshaller.unmarshal(MzQuantMLElement.StudyVariableList);
        assertNotNull(studyVList);
        StudyVariable studyV = studyVList.getStudyVariable().get(0);
        assertNotNull(studyV);
        assertTrue(studyV.getId().equals("SV_D"));
        List<Assay> assays = studyV.getAssays();
        assertNotNull(assays);
        Assay assay = (Assay) unmarshaller.unmarshal(MzQuantMLElement.Assay.getClazz(), "ass_7");
        assertTrue(assays.get(1).getName().equals(assay.getName()));
    }

    @Test
    public void testAnalysisSummary() {
        AnalysisSummary analysisSummary = unmarshaller.unmarshal(MzQuantMLElement.AnalysisSummary);
        assertNotNull(analysisSummary);
        CvParam cp = analysisSummary.getCvParam().get(1);
        assertTrue(cp.getAccession().equals("MS:1002019"));
        assertTrue(cp.getCvRef().equals("PSI-MS"));
        assertTrue(cp.getValue().equals("false"));
        assertTrue(cp.getName().equals("label-free raw feature quantitation"));
    }

    @Test
    public void testRawFilesGroup()
            throws JAXBException {
        int rfgCount = unmarshaller.getObjectCountForXpath(MzQuantMLElement.RawFilesGroup.getXpath());
        assertTrue(rfgCount == 12);
        Iterator<RawFilesGroup> rfgIter = unmarshaller.unmarshalCollectionFromXpath(MzQuantMLElement.RawFilesGroup);
        assertNotNull(rfgIter);

        RawFilesGroup rfg = (RawFilesGroup) unmarshaller.unmarshal(MzQuantMLElement.RawFilesGroup.getClazz(), "rg_6");
        assertNotNull(rfg);

        RawFile rawFile = rfg.getRawFile().get(0);
        String location = rawFile.getLocation();
        assertTrue(location.equals("../msmsdata/mam_042408o_CPTAC_study6_6D004.raw"));
        String name = rawFile.getName();
        assertTrue(name.equals("mam_042408o_CPTAC_study6_6D004.raw"));

        RawFile rawF = (RawFile) unmarshaller.unmarshal(MzQuantMLElement.RawFile.getClazz(), "raw_6");
        assertTrue(rawF.getLocation().equals("../msmsdata/mam_042408o_CPTAC_study6_6D004.raw"));
        assertTrue(rawF.getName().equals("mam_042408o_CPTAC_study6_6D004.raw"));
    }

    @Test
    public void testProteinList()
            throws JAXBException {
        ProteinList protList = unmarshaller.unmarshal(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class);
        assertNotNull(protList);
        String id = protList.getId();
        assertTrue(id.equals("ProtList1"));
        List<Protein> proteins = protList.getProtein();
        assertNotNull(proteins);
        Protein prot = unmarshaller.unmarshal(Protein.class, "prot_3");
        assertNotNull(prot);
        SearchDatabase searchDB = prot.getSearchDatabase();
        assertNotNull(searchDB);
        assertTrue(searchDB.getLocation().equals("sgd_orfs_plus_ups_prots.fasta"));
        assertTrue(searchDB.getId().equals("SD1"));
        assertNull(searchDB.getDatabaseName().getCvParam());
        UserParam up = searchDB.getDatabaseName().getUserParam();
        assertNotNull(up);
        assertTrue(up.getName().equals("sgd_orfs_plus_ups_prots.fasta"));
    }

    @Test
    public void testPeptideConsensusList()
            throws JAXBException {
        Iterator<PeptideConsensusList> pepConListIter = unmarshaller.unmarshalCollectionFromXpath(MzQuantMLElement.PeptideConsensusList);
        assertNotNull(pepConListIter);
        PeptideConsensusList pepConList1 = unmarshaller.unmarshal(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class, "PepList1");
        assertNotNull(pepConList1);
        boolean finalResult = pepConList1.isFinalResult();
        assertTrue(finalResult);
        List<PeptideConsensus> peptideConsensuses = pepConList1.getPeptideConsensus();
        assertNotNull(peptideConsensuses);
        int peptideSize = peptideConsensuses.size();
        assertEquals(44, peptideSize);
    }

    @Test
    public void testDataMatrix()
            throws JAXBException {
        ProteinList protList = unmarshaller.unmarshal(MzQuantMLElement.ProteinList);
        QuantLayer assayQL = protList.getAssayQuantLayer().get(0);
        assertNotNull(assayQL);
        DataMatrix assayDM = assayQL.getDataMatrix();
        assertNotNull(assayDM);
        List<Row> rows = assayDM.getRow();
        assertNotNull(rows);
        Row row = rows.get(1);
        assertNotNull(row);
        String refId = row.getObjectRef();
        assertTrue(refId.equals("prot_0"));
        Protein prot = unmarshaller.unmarshal(Protein.class, refId);
        assertNotNull(prot);
        String accession = prot.getAccession();
        assertTrue(accession.equals("YPR148C"));
    }

}
