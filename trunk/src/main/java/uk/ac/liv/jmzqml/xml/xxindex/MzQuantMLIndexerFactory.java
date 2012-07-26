/*
 * Date: 11-May-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexerFactory.java
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
package uk.ac.liv.jmzqml.xml.xxindex;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.ConfigurationException;
import org.apache.log4j.Logger;
import psidev.psi.tools.xxindex.SimpleXmlElementExtractor;
import psidev.psi.tools.xxindex.StandardXpathAccess;
import psidev.psi.tools.xxindex.XmlElementExtractor;
import psidev.psi.tools.xxindex.index.IndexElement;
import psidev.psi.tools.xxindex.index.XpathIndex;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.mzqml.Identifiable;
import uk.ac.liv.jmzqml.xml.Constants;

/**
 *
 * @author Da Qi
 * @time 00:42:25 11-May-2012
 * @institution University of Liverpool
 */
public class MzQuantMLIndexerFactory {

    private static final Logger logger = Logger.getLogger(MzQuantMLIndexerFactory.class);
    private static final MzQuantMLIndexerFactory instance = new MzQuantMLIndexerFactory();
    private static final Pattern ID_PATTERN = Pattern.compile("\\sid\\s*=\\s*['\"]([^'\"]*)['\"]", Pattern.CASE_INSENSITIVE);

    private MzQuantMLIndexerFactory() {
    }

    public static MzQuantMLIndexerFactory getInstance() {
        return instance;
    }

    public MzQuantMLIndexer buildIndex(File xmlFile) {
        return buildIndex(xmlFile, Constants.XML_INDEXED_XPATHS);
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
        // a unified cache of all the id maps
        private Map<Class, Map<String, IndexElement>> idMapCache =
                new HashMap<Class, Map<String, IndexElement>>();

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
                logger.info("Creating index: ");
                xpathAccess = new StandardXpathAccess(xmlFile, xpaths);
                logger.debug("done!");

                // create xml element extractor
                xmlExtractor = new SimpleXmlElementExtractor();
                xmlExtractor.setEncoding(xmlExtractor.detectFileEncoding(xmlFile.toURI().toURL()));

                // create index
                index = xpathAccess.getIndex();

                // check if the xxindex contains this root
                if (!index.containsXpath(MzQuantMLElement.MzQuantML.getXpath())) {
                    logger.info("Index does not contain mzQuantML root! We are not dealing with an mzQuantML file!");
                    throw new IllegalStateException("Index does not contain mzQuantML root!");
                }

                // initalize the ID maps
                initIdMaps();

                // extract the MzQuantML attributes from the MzQuantML start tag
                mzQuantMLAttributeXMLString = extractMzQuantMLStartTag(xmlFile);

            } catch (IOException e) {
                logger.error("MzQuantMLIndexerFactory$MzQuantMLIndexerImpl.MzQuantMLIndexterImpl", e);
                throw new IllegalStateException("Could not generate MzQuantML index for file: " + xmlFile);
            }
        }

        /*
         * public methods
         */
        @Override
        public String getMzQuantMLAttributeXMLString() {
            return mzQuantMLAttributeXMLString;
        }

        @Override
        public Iterator<String> getXmlStringIterator(String xpathExpression) {
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
         * elements were found for the specified xpath.
         */
        @Override
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

        @Override
        public List<IndexElement> getIndexElements(String xpath) {
            return index.getElements(xpath);
        }

        @Override
        public Set<String> getXpath() {
            return index.getKeys();
        }

        @Override
        public String getXmlString(String ID, Class clazz) {
            logger.debug("Getting cached ID: " + ID + " from cache: " + clazz);

            Map<String, IndexElement> idMap = idMapCache.get(clazz);
            IndexElement element = idMap.get(ID);

            String xmlSnippet = null;
            if (element != null) {
                xmlSnippet = readXML(element);
                if (logger.isTraceEnabled()) {
                    logger.trace("Retrived xml for class " + clazz + " with ID" + ID + ": " + xmlSnippet);;
                }
            }
            return xmlSnippet;
        }

        @Override
        public String getStartTag(String id, Class clazz) {
            logger.debug("Getting start tag of element with id: " + id + " for class: " + clazz);
            String tag = null;

            Map<String, IndexElement> idMap = idMapCache.get(clazz);
            if (idMap != null) {
                IndexElement element = idMap.get(id);
                if (element != null) {
                    try {
                        tag = xpathAccess.getStartTag(element);
                    } catch (IOException e) {
                        //ToDo: proper handling
                        e.printStackTrace();
                    }
                } else {
                    // ToDo: what if the element exists, but its id was not cached?
                    // ToDo: throw an exception?
                }
            }
            return tag;
        }

        @Override
        public boolean isIDmapped(String id, Class clazz) {
            if (clazz == null) {
                return false;
            }
            Map<String, IndexElement> idMap = idMapCache.get(clazz);
            return idMap != null && idMap.containsKey(id);
        }

        @Override
        public Set<String> getIDsForElement(MzQuantMLElement element) throws ConfigurationException {
            if (element.isIdMapped()) {
                return idMapCache.get(element.<MzQuantMLObject>getClazz()).keySet();
            } else {
                throw new ConfigurationException("API not configured to support ID mapping for element: " + element.getTagName());
            }
        }

        public <T extends MzQuantMLObject> Set<String> getElementIDs(
                Class<T> clazz) {
            if (idMapCache == null) {
                return null;
            }
            Map<String, IndexElement> classCache = idMapCache.get(clazz);
            if (classCache == null) {
                return null;
            }
            return classCache.keySet();
        }
        /*
         * private methods
         */

        private String readXML(IndexElement byteRange) {
            return readXML(byteRange, 0);
        }

        private String readXML(IndexElement byteRange, int maxChars) {
            try {
                if (byteRange != null) {
                    long stop;
                    long limitedStop = byteRange.getStart() + maxChars;
                    if (maxChars > 0 && byteRange.getStop() > limitedStop) {
                        stop = limitedStop;
                    } else {
                        stop = byteRange.getStop();
                    }
                    return xmlExtractor.readString(byteRange.getStart(), stop, xmlFile);
                } else {
                    throw new IllegalStateException("Attempting to read NULL ByteRange");
                }
            } catch (IOException e) {
                logger.error("MzQuantMLIndexerFactory$MzQuantMLIndexerImpl.readXML", e);
                throw new IllegalStateException("Could not extraxt XML from file: " + xmlFile);
            }
        }

        private String extractMzQuantMLStartTag(File xmlFile) throws IOException {
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
            String startTag = xmlExtractor.readString(startPos, stopPos, xmlFile);
            if (startTag != null) {
                //strip newlines that might interfere with later on regex matching
                startTag = startTag.replace("\n", "");
            }
            return startTag;
        }

        /**
         * Method to generate and populate ID maps for the XML elements that
         *
         * TODO: finish the comments
         */
        private void initIdMaps() throws IOException {
            for (MzQuantMLElement element : MzQuantMLElement.values()) {
                // only for elements were an ID map is needed and a xpath is given            
                if (element.isIdMapped() && element.isIndexed()) {
                    if (element.getClazz().isAssignableFrom(Identifiable.class)) {
                        logger.warn("Element for class " + element.getClass() + " may not contain an 'id' attribute, but was selected for id mapping!");
                    }
                    logger.debug("Initiating ID map for " + element.getClazz().getName());
                }

                Map<String, IndexElement> map = idMapCache.get(element.getClazz());
                if (map == null) {
                    map = new HashMap<String, IndexElement>();
                    idMapCache.put(element.getClazz(), map);
                }
                initIdMapCache(map, element.getXpath());
            }
        }

        private void initIdMapCache(Map<String, IndexElement> idMap,
                                    String xpath) throws IOException {
            List<IndexElement> ranges = index.getElements(xpath);
            for (IndexElement byteRange : ranges) {
                String xml = xpathAccess.getStartTag(byteRange);
                String id = getIdFromRawXML(xml);
                if (id != null) {
                    idMap.put(id, byteRange);
                } else {
                    throw new IllegalStateException("Error initializing ID cache: No id attribute found for element " + xml);
                }
            }
        }

        private String getIdFromRawXML(String xml) {
            Matcher match = ID_PATTERN.matcher(xml);

            // ToDo: more checks: if no id found or more than one match, ...
            if (match.find()) {
                return match.group(1).intern();
            } else {
                throw new IllegalStateException("Invalid ID in xml: " + xml);
            }
        }
    }
}
