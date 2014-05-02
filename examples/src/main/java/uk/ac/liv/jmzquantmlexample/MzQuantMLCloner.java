
package uk.ac.liv.jmzquantmlexample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.*;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLMarshaller;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

/**
 *
 * An example of using the API to make a clone file from CPTAC-Progenesis-small-example.mzq.
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 20-Jun-2013 14:48:18
 */
public class MzQuantMLCloner {

    public static void main(String[] args)
            throws IOException {
        File mzqFile = new File("CPTAC-Progenesis-small-example.mzq");
        // create an MzQuantMLUnmarsahller object
        MzQuantMLUnmarshaller um = new MzQuantMLUnmarshaller(mzqFile);
        // create an MzQuantML object for marsahlling
        MzQuantML mzq = new MzQuantML();
        // retrieve every attributes and elements from the mzQuantML file
        String mzqId = um.getMzQuantMLId();
        String mzqName = um.getMzQuantMLName();
        String mzqVersion = um.getMzQuantMLVersion();
        // three ways of unmarshalling an mzQuantML element: 
        CvList cvList = um.unmarshal(uk.ac.liv.jmzqml.model.mzqml.CvList.class);       //1. class name
        AuditCollection ac = um.unmarshal(MzQuantMLElement.AuditCollection);           //2. member of MzQuantMLElement
        AnalysisSummary as = um.unmarshal("/MzQuantML/AnalysisSummary");               //3a. XPath
        InputFiles inputFiles = um.unmarshal(MzQuantMLElement.InputFiles.getXpath());  //3b. XPath
        SoftwareList softList = um.unmarshal(MzQuantMLElement.SoftwareList);
        DataProcessingList dpList = um.unmarshal(MzQuantMLElement.DataProcessingList);
        Iterator<BibliographicReference> brIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.BibliographicReference);
        AssayList assayList = um.unmarshal(MzQuantMLElement.AssayList);
        StudyVariableList svList = um.unmarshal(MzQuantMLElement.StudyVariableList);
        ProteinList protList = um.unmarshal(MzQuantMLElement.ProteinList);
        Iterator<PeptideConsensusList> pepConListIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.PeptideConsensusList);
        Iterator<FeatureList> ftListIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.FeatureList);

        MzQuantMLMarshaller m = new MzQuantMLMarshaller();
        FileWriter writer = null;
        try {
            writer = new FileWriter("clonedMzQuantML.mzq");
            // XML header
            writer.write(m.createXmlHeader() + "\n");
            // mzQuantML start tag
            writer.write(m.createMzQuantMLStartTag(mzqId) + "\n");

            m.marshall(cvList, writer);
            writer.write("\n");
            m.marshall(ac, writer);
            writer.write("\n");
            m.marshall(as, writer);
            writer.write("\n");
            m.marshall(inputFiles, writer);
            writer.write("\n");
            m.marshall(softList, writer);
            writer.write("\n");
            m.marshall(dpList, writer);
            writer.write("\n");
            while (brIter.hasNext()) {
                BibliographicReference bibRef = brIter.next();
                m.marshall(bibRef, writer);
                writer.write("\n");
            }
            m.marshall(assayList, writer);
            writer.write("\n");
            m.marshall(svList, writer);
            writer.write("\n");
            m.marshall(protList, writer);
            writer.write("\n");
            while (pepConListIter.hasNext()) {
                PeptideConsensusList pepConList = pepConListIter.next();
                m.marshall(pepConList, writer);
                writer.write("\n");
            }
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
    }

}