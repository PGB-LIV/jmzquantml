
package uk.ac.liv.jmzquantmlexample;

import java.io.File;
import java.util.Iterator;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.*;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLMarshaller;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 20-Jun-2013 14:48:18
 */
public class MzQuantMLCloner {

    public static void main(String[] args) {

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
        CvList cvList = um.unmarshal(uk.ac.liv.jmzqml.model.mzqml.CvList.class); //1. class name
        AuditCollection ac = um.unmarshal(MzQuantMLElement.AuditCollection);     //2. member of MzQuantMLElement
        AnalysisSummary as = um.unmarshal("/MzQuantML/AnalysisSummary");         //3. xPath
        InputFiles inputFiles = um.unmarshal(MzQuantMLElement.InputFiles);
        SoftwareList softList = um.unmarshal(MzQuantMLElement.SoftwareList);
        DataProcessingList dpList = um.unmarshal(MzQuantMLElement.DataProcessingList);
        Iterator<BibliographicReference> brIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.BibliographicReference);
        AssayList assayList = um.unmarshal(MzQuantMLElement.AssayList);
        StudyVariableList svList = um.unmarshal(MzQuantMLElement.StudyVariableList);
        ProteinList protList = um.unmarshal(MzQuantMLElement.ProteinList);
        Iterator<PeptideConsensusList> pepConListIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.PeptideConsensusList);
        Iterator<FeatureList> ftListIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.FeatureList);

        // set every attributes and elements to the new MzQuantML object
        mzq.setId(mzqId);
        mzq.setName(mzqName);
        mzq.setVersion(mzqVersion);

        mzq.setCvList(cvList);
        mzq.setAuditCollection(ac);
        mzq.setAnalysisSummary(as);
        mzq.setInputFiles(inputFiles);
        mzq.setSoftwareList(softList);
        mzq.setDataProcessingList(dpList);
        while (brIter.hasNext()) {
            BibliographicReference bibRef = brIter.next();
            mzq.getBibliographicReference().add(bibRef);
        }
        mzq.setAssayList(assayList);
        mzq.setStudyVariableList(svList);
        mzq.setProteinList(protList);
        while (pepConListIter.hasNext()) {
            PeptideConsensusList pepConList = pepConListIter.next();
            mzq.getPeptideConsensusList().add(pepConList);
        }
        while (ftListIter.hasNext()) {
            FeatureList ftList = ftListIter.next();
            mzq.getFeatureList().add(ftList);
        }

        // output the MzQuantML to a new file
        MzQuantMLMarshaller marshaller = new MzQuantMLMarshaller("modifiedMzQuantML.mzq");
        marshaller.marshall(mzq);
    }

}
