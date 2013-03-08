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
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

import static org.junit.Assert.*;
import uk.ac.liv.jmzqml.model.mzqml.*;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 10-Jul-2012 11:37:50
 */
public class MzQuantMLUnmarshallerTest {

    private static MzQuantMLUnmarshaller unmarshaller;

    static {
        String fileName = "CPTAC-Progenesis-small-example.mzq";
        URL xmlFileURL = MzQuantMLUnmarshallerTest.class.getClassLoader().getResource(fileName);
        assertNotNull(xmlFileURL);

        unmarshaller = new MzQuantMLUnmarshaller(xmlFileURL);
        assertNotNull(unmarshaller);
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
            throws Exception {
        AuditCollection ac = unmarshaller.unmarshal(MzQuantMLElement.AuditCollection);
        assertNotNull(ac);
    }

    @Test
    public void testAssayList()
            throws Exception {
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

    }

    @Test
    public void testStudyVariableList()
            throws Exception {
        StudyVariableList studyVList = unmarshaller.unmarshal(MzQuantMLElement.StudyVariableList);
        assertNotNull(studyVList);
    }

    @Test
    public void testAnalysisSummary() {
        AnalysisSummary analysisSummary = unmarshaller.unmarshal(MzQuantMLElement.AnalysisSummary);
        assertNotNull(analysisSummary);
    }

}
