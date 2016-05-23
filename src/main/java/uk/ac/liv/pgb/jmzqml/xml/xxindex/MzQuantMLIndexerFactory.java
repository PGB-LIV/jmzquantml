/*
 * Date: 11-May-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexerFactory.java
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

package uk.ac.liv.pgb.jmzqml.xml.xxindex;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.ConfigurationException;

import org.apache.log4j.Logger;

import psidev.psi.tools.xxindex.SimpleXmlElementExtractor;
import psidev.psi.tools.xxindex.StandardXpathAccess;
import psidev.psi.tools.xxindex.XmlElementExtractor;
import psidev.psi.tools.xxindex.XpathAccess;
import psidev.psi.tools.xxindex.index.IndexElement;
import psidev.psi.tools.xxindex.index.XpathIndex;
import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.pgb.jmzqml.model.mzqml.IdOnly;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable;
import uk.ac.liv.pgb.jmzqml.xml.Constants;

/**
 *
 * @author Da Qi
 * @time 00:42:25 11-May-2012
 * @institution University of Liverpool
 */
public final class MzQuantMLIndexerFactory {

    private static final Logger LOGGER = Logger.getLogger(
            MzQuantMLIndexerFactory.class);
    private static final MzQuantMLIndexerFactory INSTANCE
            = new MzQuantMLIndexerFactory();
    private static final Pattern ID_PATTERN = Pattern.compile(
            "\\sid\\s*=\\s*['\"]([^'\"]*)['\"]", Pattern.CASE_INSENSITIVE);

    /**
     * constructor.
     */
    private MzQuantMLIndexerFactory() {
    }

    /**
     * A static method to construct an object of MzQuantMLIndexerFactory.
     *
     * @return an instance of MzQuantMLIndexerFactory.
     */
    public static MzQuantMLIndexerFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Build an MzQuantMLIndexer from the mzQuantML file.
     *
     * @param xmlFile the mzQuantML file.
     *
     * @return an object of MzQuantMLIndexer.
     */
    public MzQuantMLIndexer buildIndex(final File xmlFile) {
        return buildIndex(xmlFile, Constants.XML_INDEXED_XPATHS, false);
    }

    /**
     * Build an MzQuantMLIndexer from the mzQuantML file based on specified set
     * of xpath.
     *
     * @param xmlFile the mzQuantML file.
     * @param xpaths  a set of xpath
     *
     * @return an object of MzQuantMLIndexer.
     */
    public MzQuantMLIndexer buildIndex(final File xmlFile,
                                       final Set<String> xpaths) {
        return new MzQuantMLIndexerImpl(xmlFile, xpaths, false);
    }

    /**
     *
     * @param xmlFile  XML file
     * @param inMemory inMemory
     *
     * @return MzQuantMLIndexer
     */
    public MzQuantMLIndexer buildIndex(final File xmlFile,
                                       final boolean inMemory) {
        return new MzQuantMLIndexerImpl(xmlFile, Constants.XML_INDEXED_XPATHS,
                                        inMemory);
    }

    /**
     *
     * @param xmlFile  XML file
     * @param xpaths   xpaths
     * @param inMemory inMemory
     *
     * @return MzQuantMLIndexer
     */
    public MzQuantMLIndexer buildIndex(final File xmlFile,
                                       final Set<String> xpaths,
                                       final boolean inMemory) {
        return new MzQuantMLIndexerImpl(xmlFile, xpaths, inMemory);
    }

    private static final class MzQuantMLIndexerImpl implements MzQuantMLIndexer {

        private File xmlFile;
        private boolean inMemory;
        private byte[] xmlFileBuffer;
        private XpathAccess xpathAccess;
        private XmlElementExtractor xmlExtractor;
        private MemoryMappedXmlElementExtractor memoryMappedXmlElementExtractor;
        private XpathIndex index;
        private String mzQuantMLAttributeXMLString;
        // a unified cache of all the id maps
        private Map<Class<? extends MzQuantMLObject>, Map<String, IndexElement>> idMapCache
                = new HashMap<>();

        /*
         * Constructors
         */
        /**
         *
         * @param xmlFilep  XML file
         * @param xpaths    xpaths
         * @param inMemoryp inMemory
         */
        private MzQuantMLIndexerImpl(final File xmlFilep,
                                     final Set<String> xpaths,
                                     final boolean inMemoryp) {
            if (xmlFilep == null) {
                throw new IllegalStateException(
                        "XML File to index must not be null");
            }
            if (!xmlFilep.exists()) {
                throw new IllegalStateException(
                        "XML File to index does not exist: " + xmlFilep.
                        getAbsolutePath());
            }

            //store file reference
            this.xmlFile = xmlFilep;
            this.inMemory = inMemoryp;

            try {

                // create xml element extractor
                initXpathAccess(xmlFilep, xpaths, inMemoryp);

                // create index
                index = xpathAccess.getIndex();

                // check if the xxindex contains this root
                if (!index.containsXpath(MzQuantMLElement.MzQuantML.getXpath())) {
                    LOGGER.info(
                            "Index does not contain mzQuantML root! We are not "
                            + "dealing with an mzQuantML file!");
                    throw new IllegalStateException(
                            "Index does not contain mzQuantML root!");
                }

                // initalize the ID maps
                initIdMaps();

                // extract the MzQuantML attributes from the MzQuantML start tag
                mzQuantMLAttributeXMLString = extractMzQuantMLStartTag(xmlFilep);

            } catch (IOException e) {
                LOGGER.error(
                        "MzQuantMLIndexerFactory$MzQuantMLIndexerImpl.MzQuantMLIndexterImpl",
                        e);
                throw new IllegalStateException(
                        "Could not generate MzQuantML index for file: "
                        + xmlFilep);
            }
        }

        /**
         *
         * @param xmlFilep  XML file
         * @param xpaths    xpaths
         * @param inMemoryp imMemory
         *
         * @throws IOException io exception
         */
        private void initXpathAccess(final File xmlFilep,
                                     final Set<String> xpaths,
                                     final boolean inMemoryp)
                throws IOException {
            if (inMemoryp) {
                // load file into memory
                loadFileIntoMemory(xmlFilep);

                MemoryMappedStandardXpathAccess memoryMappedStandardXpathAccess
                        = new MemoryMappedStandardXpathAccess(
                                xmlFileBuffer, xpaths);
                memoryMappedXmlElementExtractor
                        = memoryMappedStandardXpathAccess.
                        getExtractor();
                xpathAccess = memoryMappedStandardXpathAccess;
            } else {
                xpathAccess = new StandardXpathAccess(xmlFilep, xpaths);
                xmlExtractor = new SimpleXmlElementExtractor();

                if (xmlExtractor.detectFileEncoding(xmlFilep.toURI().toURL())
                        != null) {
                    xmlExtractor.setEncoding(xmlExtractor.detectFileEncoding(
                            xmlFilep.toURI().toURL()));
                }
                // if XML header doesn't exit, the mzQuantML file should still be valid
//                else {
//                    throw new IllegalStateException(
//                            "The mzQuantML file doesn't contain encoding information in the header!");
//                }
            }
        }

        /**
         *
         * @param xmlFilep XML file
         *
         * @throws IOException io exception
         */
        private void loadFileIntoMemory(final File xmlFilep)
                throws IOException {
            FileInputStream fis = new FileInputStream(xmlFilep);
            FileChannel fc = fis.getChannel();

            MappedByteBuffer mmb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.
                                          size());

            xmlFileBuffer = new byte[(int) fc.size()];
            mmb.get(xmlFileBuffer);
            fis.close();
        }

        /*
         * public methods
         */
        @Override
        public String getMzQuantMLAttributeXMLString() {
            return mzQuantMLAttributeXMLString;
        }

        @Override
        public Iterator<String> getXmlStringIterator(
                final String xpathExpression) {
            if (index.containsXpath(xpathExpression)) {
                return xpathAccess.getXmlSnippetIterator(xpathExpression);
            } else {
                return null;
            }
        }

        /**
         *
         * @param xpathExpression the xpath defining the XML element.
         *
         * @return the number of XML elements matching the xpath or -1 if no
         *         elements were found for the specified xpath.
         */
        @Override
        public int getCount(final String xpathExpression) {
            int retValue = -1;
            if (index.containsXpath(xpathExpression)) {
                List<IndexElement> tmpList = index.getElements(xpathExpression);
                if (tmpList != null) {
                    retValue = tmpList.size();
                }
            }
            return retValue;
        }

        @Override
        public List<IndexElement> getIndexElements(final String xpath) {
            return new ArrayList<>(index.getElements(xpath));
        }

        @Override
        public Map<String, IndexElement> getIndexElements(
                final Class<? extends MzQuantMLObject> clazz) {
            return new HashMap<>(idMapCache.get(clazz));
        }

        @Override
        public Set<String> getXpath() {
            return new HashSet<>(index.getKeys());
        }

        @Override
        public String getXmlString(final String id,
                                   final Class<? extends MzQuantMLObject> clazz) {
            LOGGER.debug("Getting cached ID: " + id + " from cache: " + clazz);

            Map<String, IndexElement> idMap = idMapCache.get(clazz);
            IndexElement element = idMap.get(id);

            String xmlSnippet = null;
            if (element != null) {
                xmlSnippet = getXmlString(element);
                if (LOGGER.isTraceEnabled()) {
                    LOGGER.trace(
                            "Retrived xml for class " + clazz + " with ID" + id
                            + ": " + xmlSnippet);
                }
            }
            return xmlSnippet;
        }

        @Override
        public String getXmlString(final IndexElement byteRange) {
            return getXmlString(byteRange, 0);
        }

        /**
         *
         * @param byteRange byte range
         * @param maxChars  max char
         *
         * @return XML string
         */
        private String getXmlString(final IndexElement byteRange,
                                    final int maxChars) {
            try {
                if (byteRange != null) {
                    long stop;
                    long limitedStop = byteRange.getStart() + maxChars;
                    if (maxChars > 0 && byteRange.getStop() > limitedStop) {
                        stop = limitedStop;
                    } else {
                        stop = byteRange.getStop();
                    }
                    if (inMemory) {
                        return memoryMappedXmlElementExtractor.readString(
                                byteRange.getStart(), stop,
                                new ByteArrayInputStream(xmlFileBuffer));
                    } else {
                        return xmlExtractor.readString(byteRange.getStart(),
                                                       stop, xmlFile);
                    }
                } else {
                    throw new IllegalStateException(
                            "Attempting to read NULL ByteRange");
                }
            } catch (IOException e) {
                LOGGER.error(
                        "MzQuantMLIndexerFactory$MzQuantMLIndexerImpl.readXML",
                        e);
                throw new IllegalStateException(
                        "Could not extraxt XML from file: " + xmlFile);
            }
        }

        @Override
        public String getStartTag(final String id,
                                  final Class<? extends MzQuantMLObject> clazz) {
            LOGGER.debug(
                    "Getting start tag of element with id: " + id
                    + " for class: " + clazz);
            String tag = null;

            Map<String, IndexElement> idMap = idMapCache.get(clazz);
            if (idMap != null) {
                IndexElement element = idMap.get(id);
                if (element != null) {
                    try {
                        if (xpathAccess instanceof StandardXpathAccess) {
                            tag = ((StandardXpathAccess) xpathAccess).
                                    getStartTag(element);
                        } else if (xpathAccess instanceof MemoryMappedStandardXpathAccess) {
                            tag
                                    = ((MemoryMappedStandardXpathAccess) xpathAccess).
                                    getStartTag(element);
                        }
                    } catch (IOException e) {
                        java.util.logging.Logger.getLogger(FileUtils.class.
                                getName()).log(Level.SEVERE, null, e);
                    }
                }
//                else {
//                    // TODO: what if the element exists, but its id was not indexed?
//                    // TODO: throw an exception?
//                }
            }
            return tag;
        }

        @Override
        public boolean isIDmapped(final String id,
                                  final Class<? extends MzQuantMLObject> clazz) {
            if (clazz == null) {
                return false;
            }
            Map<String, IndexElement> idMap = idMapCache.get(clazz);
            return idMap != null && idMap.containsKey(id);
        }

        @Override
        public Set<String> getIDsForElement(final MzQuantMLElement element)
                throws ConfigurationException {
            if (element.isIdMapped()) {
                return idMapCache.get(element.<MzQuantMLObject>getClazz()).
                        keySet();
            } else {
                throw new ConfigurationException(
                        "API not configured to support ID mapping for element: "
                        + element.
                        getTagName());
            }
        }

        /**
         *
         * @param <T>   MzQuantMLObject
         * @param clazz class
         *
         * @return element id strings
         */
        public <T extends MzQuantMLObject> Set<String> getElementIDs(
                final Class<T> clazz) {
            if (idMapCache == null) {
                return null;
            }
            Map<String, IndexElement> classCache = idMapCache.get(clazz);
            if (classCache == null) {
                return null;
            }
            return classCache.keySet();
        }

        /**
         *
         * @param xmlFilep XML file
         *
         * @return mzQuantML file start tag
         *
         * @throws IOException io exception
         */
        private String extractMzQuantMLStartTag(final File xmlFilep)
                throws IOException {
            // get start position of the mzIdentML element
            List<IndexElement> ie = index.getElements("/MzQuantML");
            // there is only one root
            long startPos = ie.get(0).getStart();

            // get end position of the mzIdentML start tag
            // this is the start position of the next tag (cvList)
            ie = index.getElements(MzQuantMLElement.CvList.getXpath());
            // there will always be one and only one cvList
            long stopPos = ie.get(0).getStart() - 1;

            // get mzML start tag content
            String startTag = xmlExtractor.readString(startPos, stopPos,
                                                      xmlFilep);
            if (inMemory) {
                startTag = memoryMappedXmlElementExtractor.readString(startPos,
                                                                      stopPos,
                                                                      new ByteArrayInputStream(
                                                                              xmlFileBuffer));
            }
            if (startTag != null) {
                //strip newlines that might interfere with later on regex matching
                startTag = startTag.replace("\n", "");
            }
            return startTag;
        }

        /**
         * Method to generate and populate ID maps for the XML elements that.
         *
         * @throws IOException io exception
         */
        private void initIdMaps()
                throws IOException {
            for (MzQuantMLElement element : MzQuantMLElement.values()) {
                // only for elements were an ID map is needed and a xpath is given
                if (element.isIdMapped() && element.isIndexed()) {
                    if (element.getClazz().isAssignableFrom(Identifiable.class)
                            || element.getClazz().isAssignableFrom(IdOnly.class)) {
                        LOGGER.warn(
                                "Element for class " + element.getClazz()
                                + " may not contain an 'id' attribute, but was selected for id mapping!");
                    }
                    LOGGER.debug("Initiating ID map for " + element.getClazz().
                            getName());

                    Map<String, IndexElement> map = idMapCache.get(element.
                            getClazz());
                    if (map == null) {
                        map = new HashMap<>();
                        idMapCache.put(element.getClazz(), map);
                    }
                    initIdMapCache(map, element.getXpath());
                }
            }
        }

        /**
         *
         * @param idMap id map
         * @param xpath xpath string
         *
         * @throws IOException io exception
         */
        private void initIdMapCache(final Map<String, IndexElement> idMap,
                                    final String xpath)
                throws IOException {
            List<IndexElement> ranges = index.getElements(xpath);
            for (IndexElement byteRange : ranges) {
                String xml = null;
                if (xpathAccess instanceof StandardXpathAccess) {
                    xml = ((StandardXpathAccess) xpathAccess).getStartTag(
                            byteRange);
                } else if (xpathAccess instanceof MemoryMappedStandardXpathAccess) {
                    xml = ((MemoryMappedStandardXpathAccess) xpathAccess).
                            getStartTag(byteRange);
                }
                String id = getIdFromRawXML(xml);

                idMap.put(id, byteRange);

            }
        }

        /**
         *
         * @param xml XML string
         *
         * @return id string
         */
        private String getIdFromRawXML(final String xml) {
            Matcher match = ID_PATTERN.matcher(xml);

            // TODO: more checks: if no id found or more than one match, ...
            if (match.find()) {
                return match.group(1).intern();
            } else {
                throw new IllegalStateException("Invalid ID in xml: " + xml);
            }
        }

    }

}
