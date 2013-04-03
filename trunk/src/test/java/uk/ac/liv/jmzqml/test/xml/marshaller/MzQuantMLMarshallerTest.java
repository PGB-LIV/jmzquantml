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

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import static org.junit.Assert.*;
import org.junit.Test;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.AnalysisSummary;
import uk.ac.liv.jmzqml.model.mzqml.AuditCollection;
import uk.ac.liv.jmzqml.model.mzqml.CvList;
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
            writer.write(m.createMzQuantMLStartTag("12345") + "\n");

            CvList cvList = unmarshaller.unmarshal(MzQuantMLElement.CvList.getXpath());
            cvCount = cvList.getCv().size();
            m.marshall(cvList, writer);
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
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
