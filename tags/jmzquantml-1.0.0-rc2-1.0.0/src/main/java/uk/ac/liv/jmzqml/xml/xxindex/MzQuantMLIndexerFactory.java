/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.liv.jmzqml.xml.xxindex;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import psidev.psi.tools.xxindex.SimpleXmlElementExtractor;
import psidev.psi.tools.xxindex.StandardXpathAccess;
import psidev.psi.tools.xxindex.XmlElementExtractor;
import psidev.psi.tools.xxindex.index.IndexElement;
import psidev.psi.tools.xxindex.index.XpathIndex;

/**
 *
 * @author Da Qi @time 00:42:25 11-May-2012 @institution University of Liverpool
 */
public class MzQuantMLIndexerFactory {

    private static final MzQuantMLIndexerFactory instance = new MzQuantMLIndexerFactory();
    private static String[] xpathsArray = {"/MzQuantML/CvList",
        "/MzQuantML/CvList/Cv",
        "/MzQuantML/Provider",
        "/MzQuantML/Provider/ContactRole",
        "/MzQuantML/Provider/ContactRole/Role",
        "/MzQuantML/AuditCollection",
        "/MzQuantML/AuditCollection/Person",
        "/MzQuantML/AuditCollection/Person/Affiliation",
        "/MzQuantML/AuditCollection/Organization",
        "/MzQuantML/AuditCollection/Organization/Parent",
        "/MzQuantML/AnalysisSummary",
        "/MzQuantML/InputFiles",
        "/MzQuantML/InputFiles/RawFilesGroup",
        "/MzQuantML/InputFiles/RawFilesGroup/RawFile",
        "/MzQuantML/InputFiles/MethodFiles",
        "/MzQuantML/InputFiles/MethodFiles/MethodFile",
        "/MzQuantML/InputFiles/IdentificationFiles",
        "/MzQuantML/InputFiles/IdentificationFiles/IdentificationFile",
        "/MzQuantML/InputFiles/SearchDatabase",
        "/MzQuantML/InputFiles/SearchDatabase/DatabaseName",
        "/MzQuantML/InputFiles/SourceFile",
        "/MzQuantML/SoftwareList",
        "/MzQuantML/SoftwareList/Software",
        "/MzQuantML/DataProcessingList",
        "/MzQuantML/DataProcessingList/DataProcessing",
        "/MzQuantML/DataProcessingList/DataProcessing/ProcessingMethod",
        "/MzQuantML/BibliographicReference",
        "/MzQuantML/AssayList",
        "/MzQuantML/AssayList/Assay",
        "/MzQuantML/AssayList/Assay/Label",
        "/MzQuantML/StudyVariableList",
        "/MzQuantML/StudyVariableList/StudyVariable",
        "/MzQuantML/RatioList",
        "/MzQuantML/RatioList/Ratio",
        "/MzQuantML/RatioList/Ratio/RatioCalculation",
        "/MzQuantML/ProteinGroupList",
        "/MzQuantML/ProteinGroupList/ProteinGroup",
        "/MzQuantML/ProteinGroupList/GlobalQuantLayer",
        "/MzQuantML/ProteinGroupList/AssayQuantLayer",
        "/MzQuantML/ProteinGroupList/StudyVariableQuantLayer",
        "/MzQuantML/ProteinGroupList/RatioQuantLayer",
        "/MzQuantML/ProteinList",
        "/MzQuantML/ProteinList/Protein",
        "/MzQuantML/ProteinList/GlobalQuantLayer",
        "/MzQuantML/ProteinList/AssayQuantLayer",
        "/MzQuantML/ProteinList/StudyVariableQuantLayer",
        "/MzQuantML/ProteinList/RatioQuantLayer",
        "/MzQuantML/PeptideConsensusList",
        "/MzQuantML/PeptideConsensusList/PeptideConsensus",
        "/MzQuantML/PeptideConsensusList/GlobalQuantLayer",
        "/MzQuantML/PeptideConsensusList/AssayQuantLayer",
        "/MzQuantML/PeptideConsensusList/StudyVariableQuantLayer",
        "/MzQuantML/PeptideConsensusList/RatioQuantLayer",
        "/MzQuantML/SmallMoleculeList",
        "/MzQuantML/SmallMoleculeList/SmallMolecule",
        "/MzQuantML/SmallMoleculeList/GlobalQuantLayer",
        "/MzQuantML/SmallMoleculeList/AssayQuantLayer",
        "/MzQuantML/SmallMoleculeList/StudyVariableQuantLayer",
        "/MzQuantML/SmallMoleculeList/RatioQuantLayer",
        "/MzQuantML/FeatureList",
        "/MzQuantML/FeatureList/Feature",
        "/MzQuantML/FeatureList/FeatureQuantLayer",
        "/MzQuantML/FeatureList/MS2AssayQuantLayer",
        "/MzQuantML/FeatureList/MS2StudyVariableQuantLayer",
        "/MzQuantML/FeatureList/MS2RatioQuantLayer"};
    private static Set<String> xpathsToIndex = new HashSet<String>(Arrays.asList(xpathsArray));
    static {
        xpathsToIndex = Collections.unmodifiableSet(xpathsToIndex);
    }
    private static final Set<String> XML_INDEXED_XPATHS = xpathsToIndex;

    public static MzQuantMLIndexerFactory getInstance() {
        return instance;
    }

    public MzQuantMLIndexer buildIndex(File xmlFile) {
        return buildIndex(xmlFile, XML_INDEXED_XPATHS);
    }

    public MzQuantMLIndexer buildIndex(File xmlFile, Set<String> xpaths) {
        return new MzQuantMLIndexerImpl(xmlFile, xpaths);
    }

    private class MzQuantMLIndexerImpl implements MzQuantMLIndexer {

        private File xmlFile = null;
        private StandardXpathAccess xpathAccess = null;
        private XmlElementExtractor xmlExtractor = null;
        private XpathIndex index = null;
        private String mzQuantMLAttributeXMLString = null;
        /*
         * Constructor
         */

        private MzQuantMLIndexerImpl(File xmlFile, Set<String> xpaths) {
            if (xmlFile == null) {
                throw new IllegalStateException("XML File to index must not be null");
            }
            if (!xmlFile.exists()) {
                throw new IllegalStateException("XML File to index does not exist: " + xmlFile.getAbsolutePath());
            }

            //store file reference
            this.xmlFile = xmlFile;

            try {
                // generate XXINDEX
                xpathAccess = new StandardXpathAccess(xmlFile, xpaths);

                // create xml element extractor
                xmlExtractor = new SimpleXmlElementExtractor();
                xmlExtractor.setEncoding(xmlExtractor.detectFileEncoding(xmlFile.toURI().toURL()));

                // create index
                index = xpathAccess.getIndex();

                // check if the xxindex contains this root
                if (!index.containsXpath("/MzQuantML")) {
                    throw new IllegalStateException("Index does not contain mzQuantML root!");
                }

                // extract the MzQuantML attributes from the MzQuantML start tag
                mzQuantMLAttributeXMLString = extractMzQuantMLStartTag(xmlFile);

            } catch (IOException e) {
                throw new IllegalStateException("Could not generate MzQuantML index for file: " + xmlFile);
            }
        }

        /*
         * public methods
         */
        public String getMzQuantMLArrributeXMLString() {
            return mzQuantMLAttributeXMLString;
        }

        public Iterator<String> getXMLStringIterators(String xpathExpression) {
            if (index.containsXpath(xpathExpression)) {
                return xpathAccess.getXmlSnippetIterator(xpathExpression);
            } else {
                return null;
            }
        }

        /**
         *
         * @param xpathExpression the xpath defining the XML element.
         * @return the number of XML elements matching the xpath or -1 if no
         * elements were found for the specified xpath.
         */
        public int getCount(String xpathExpression) {
            int retValue = -1;
            if (index.containsXpath(xpathExpression)) {
                List<IndexElement> tmpList = index.getElements(xpathExpression);
                if (tmpList != null) {
                    retValue = tmpList.size();
                }
            }
            return retValue;
        }

        public List<IndexElement> getIndexElements(String xpath) {
            return index.getElements(xpath);
        }

        public Set<String> getXpath() {
            return index.getKeys();
        }

        /*
         * private methods
         */
        private String extractMzQuantMLStartTag(File xmlFile) throws IOException {
            // get start position of the mzIdentML element
            List<IndexElement> ie = index.getElements("/MzQuantML");
            // there is only one root
            long startPos = ie.get(0).getStart();

            // get end position of the mzIdentML start tag
            // this is the start position of the next tag (cvList)
            ie = index.getElements("/MzQuantML/CvList");
            // there will always be one and only one cvList
            long stopPos = ie.get(0).getStart() - 1;

            // get mzML start tag content
            String startTag = xmlExtractor.readString(startPos, stopPos, xmlFile);
            if (startTag != null) {
                //strip newlines that might interfere with later on regex matching
                startTag = startTag.replace("\n", "");
            }
            return startTag;
        }
    }
}
