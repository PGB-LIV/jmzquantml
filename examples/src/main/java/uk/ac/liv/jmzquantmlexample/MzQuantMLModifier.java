
package uk.ac.liv.jmzquantmlexample;

import java.io.File;
import java.util.Iterator;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.AnalysisSummary;
import uk.ac.liv.jmzqml.model.mzqml.AssayList;
import uk.ac.liv.jmzqml.model.mzqml.AuditCollection;
import uk.ac.liv.jmzqml.model.mzqml.BibliographicReference;
import uk.ac.liv.jmzqml.model.mzqml.CvList;
import uk.ac.liv.jmzqml.model.mzqml.DataProcessingList;
import uk.ac.liv.jmzqml.model.mzqml.InputFiles;
import uk.ac.liv.jmzqml.model.mzqml.MzQuantML;
import uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList;
import uk.ac.liv.jmzqml.model.mzqml.ProteinList;
import uk.ac.liv.jmzqml.model.mzqml.SoftwareList;
import uk.ac.liv.jmzqml.model.mzqml.StudyVariableList;
import uk.ac.liv.jmzqml.xml.io.MzQuantMLUnmarshaller;

public class MzQuantMLModifier {

    public static void main(String[] args) {
        File mzqFile = new File("CPTAC-Progenesis-small-example.mzq");
        MzQuantMLUnmarshaller um = new MzQuantMLUnmarshaller(mzqFile);

        MzQuantML mzq = new MzQuantML();

        String mzqId = um.getMzQuantMLId();
        String mzqName = um.getMzQuantMLName();
        String mzqVersion = um.getMzQuantMLVersion();

        CvList cvList = um.unmarshal(uk.ac.liv.jmzqml.model.mzqml.CvList.class);
        AuditCollection ac = um.unmarshal(MzQuantMLElement.AuditCollection);
        AnalysisSummary as = um.unmarshal("/MzQuantML/AnalysisSummary");
        InputFiles inputFiles = um.unmarshal(MzQuantMLElement.InputFiles);
        SoftwareList softList = um.unmarshal(MzQuantMLElement.SoftwareList);
        DataProcessingList dpList = um.unmarshal(MzQuantMLElement.DataProcessingList);
        Iterator<BibliographicReference> brIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.BibliographicReference);
        AssayList assayList = um.unmarshal(MzQuantMLElement.AssayList);
        StudyVariableList svList = um.unmarshal(MzQuantMLElement.StudyVariableList);
        ProteinList protList = um.unmarshal(MzQuantMLElement.ProteinList);
        Iterator<PeptideConsensusList> pepConIter = um.unmarshalCollectionFromXpath(MzQuantMLElement.PeptideConsensusList); 
    }

}
