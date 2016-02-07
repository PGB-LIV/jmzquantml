
/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package uk.ac.liv.pgb.jmzqml.xml.io;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.*;
import javax.naming.ConfigurationException;
import javax.xml.bind.*;
import javax.xml.transform.sax.SAXSource;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList;
import uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.unmarshaller.filters.MzQuantMLNamespaceFilter;
import uk.ac.liv.pgb.jmzqml.xml.util.EscapingXMLUtilities;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.FileUtils;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexerFactory;

/**
 * Class for unmarshalling an mzQuantML file.
 * <p>
 *
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class MzQuantMLUnmarshaller {

    private static final int ATT_GRP_NUM = 2;
    private static final Logger logger = Logger.getLogger(MzQuantMLUnmarshaller.class);
    protected final MzQuantMLIndexer index;
    private final MzQuantMLObjectCache cache;
    /**
     * Members.
     */
    private String mzqName;
    private String mzqID;
    private String mzqVersion;
    private static final Pattern ID_PATTERN = Pattern.compile("id\\s*=\\s*[\"']([^\"'>]*)?[\"']", Pattern.CASE_INSENSITIVE);
    private static final Pattern VERSION_PATTERN = Pattern.compile("version\\s*=\\s*[\"']([^\"'>]*)?[\"']", Pattern.CASE_INSENSITIVE);
    private static final Pattern NAME_PATTERN = Pattern.compile("name\\s*=\\s*[\"']([^\"'>]*)?[\"']", Pattern.CASE_INSENSITIVE);
    private static final Pattern XML_ATT_PATTERN = Pattern.compile("\\s+([A-Za-z_:]+)\\s*=\\s*[\"']([^\"'>]+?)[\"']", Pattern.DOTALL);

    /*
     * Constructor
     */
    /**
     * The Constructor of mzQuantMLUnmarshaller from URL.
     *
     * @param mzQuantMLFileURL a mzQuantML file URL.
     */
    public MzQuantMLUnmarshaller(URL mzQuantMLFileURL) {
        this(FileUtils.getFileFromURL(mzQuantMLFileURL));
    }

    /**
     * The Constructor of mzQuantMLUnmarshaller from a mzQuantML File.
     *
     * @param mzQuantMLFile a mzQuantML File.
     */
    public MzQuantMLUnmarshaller(File mzQuantMLFile) {
        this(MzQuantMLIndexerFactory.getInstance().buildIndex(mzQuantMLFile));
    }

    /**
     * Constructor of the MzQuantMLUnmarshaller from the file name string.
     *
     * @param mzQuantMLFileName the full name string of the file to be unmarshalled.
     */
    public MzQuantMLUnmarshaller(String mzQuantMLFileName) {
        this(new File(mzQuantMLFileName));
    }

    public MzQuantMLUnmarshaller(URL mzQuantMLFileURL, boolean inMemory) {
        this(FileUtils.getFileFromURL(mzQuantMLFileURL), inMemory);
    }

    public MzQuantMLUnmarshaller(File mzQuantMLFile, boolean inMemory) {
        this(MzQuantMLIndexerFactory.getInstance().buildIndex(mzQuantMLFile, inMemory));
    }

    public MzQuantMLUnmarshaller(String mzQuantMLFileName, boolean inMemory) {
        this(new File(mzQuantMLFileName), inMemory);
    }

    /**
     * The Constructor of mzQuantMLUnmarshaller from {@link uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer}.
     *
     * @param indexer an {@link uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer} object.
     */
    public MzQuantMLUnmarshaller(MzQuantMLIndexer indexer) {
        this.index = indexer;
        this.cache = null;
    }

    /*
     * public methods
     */
    /**
     * Get mzQuantML schema version of the file.
     *
     * @return a version String.
     */
    public String getMzQuantMLVersion() {
        if (mzqVersion == null) {
            Matcher match = VERSION_PATTERN.matcher(index.getMzQuantMLAttributeXMLString());
            if (match.find()) {
                mzqVersion = match.group(1);
            }
        }
        return mzqVersion;
    }

    /**
     * Get the value of the 'id' attribute of the mzQuantML file.
     *
     * @return an ID String.
     */
    public String getMzQuantMLId() {
        if (mzqID == null) {
            Matcher match = ID_PATTERN.matcher(index.getMzQuantMLAttributeXMLString());
            if (match.find()) {
                mzqID = match.group(1);
            }
        }
        return mzqID;
    }

    /**
     * Get the value of the 'name' attribute of the file.
     *
     * @return a name String.
     */
    public String getMzQuantMLName() {
        if (mzqName == null) {
            Matcher match = NAME_PATTERN.matcher(index.getMzQuantMLAttributeXMLString());
            if (match.find()) {
                mzqName = match.group(1);
            }
        }
        return mzqName;
    }

    /**
     * Method to retrieve attribute name-value pairs for a XML element defined
     * by it's id and Class.
     *
     * @param id    the value of the 'id' attribute of the XML element.
     * @param clazz the Class representing the XML element.
     *
     * @return A map of all the found name-value attribute pairs or null if no
     *         element with the specified id was found.
     */
    public Map<String, String> getElementAttributes(String id,
                                                    Class<? extends MzQuantMLObject> clazz) {

        // retrieve the start tag of the corresponding XML element
        String tag = index.getStartTag(id, clazz);
        if (tag == null) {
            return null;
        }

        // parse the tag for attributes
        return getElementAttributes(tag);
    }

    public Map<String, String> getElementAttributes(String xmlTag) {

        Map<String, String> attributes = new HashMap<>();

        // parse the tag for attributes
        Matcher match = XML_ATT_PATTERN.matcher(xmlTag);
        while (match.find()) {
            if (match.groupCount() == ATT_GRP_NUM) {
                // found name - value pair
                String name = match.group(1);
                String value = match.group(2);
                // stick the found attributes in the map
                attributes.put(name, value);
            }
            else {
                // not a name - value pair, something is wrong!
                System.out.println("Unexpected number of groups for XML attribute: " + match.groupCount() + " in tag: " + xmlTag);
            }

        }
        return attributes;
    }

    /**
     * Method to get the count of specific object/element by the xpath.
     *
     * @param xpath the xpath defining the XML element.
     *
     * @return the number of XML elements matching the xpath or -1 if no
     *         elements were found for the specified xpath.
     */
    public int getObjectCountForXpath(String xpath) {
        if (xpath != null) {
            return index.getCount(xpath);
        }
        else {
            return -1;
        }
    }

    /**
     * Unmarshal one object for the specified class. Note: The class has to
     * refer to MzQuantMLObject elements.
     *
     * @param <T>   extends {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     *
     * @see #unmarshal(uk.ac.liv.pgb.jmzqml.MzQuantMLElement)
     * @param clazz the type of Object to sub-class. It has to be a sub-class of
     *              MzQuantMLObject.
     *
     * @return an object of the specified class.
     */
    public <T extends MzQuantMLObject> T unmarshal(Class<T> clazz) {
        String xpath = MzQuantMLElement.getType(clazz).getXpath();
        return doUnmarshal(clazz, xpath);
    }

    /**
     * Unmarshal one object for the specified class. Note: The class has to
     * refer to MzQuantMLObject elements.
     *
     * @param <T>   extends {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     *
     * @see #unmarshal(uk.ac.liv.pgb.jmzqml.MzQuantMLElement)
     * @param xpath the xpath of the Object to be unmarshalled.
     *
     * @return an object of the specified class.
     */
    public <T extends MzQuantMLObject> T unmarshal(String xpath) {
        Class<T> clazz = MzQuantMLElement.getType(xpath).getClazz();
        return doUnmarshal(clazz, xpath);
    }

    /**
     * Unmarshal one element of the type defined by the {@link uk.ac.liv.pgb.jmzqml.MzQuantMLElement}. Note:
     * In case there are more than one element for the specified
     * MzQuantMLElement, only one found will be returned. This is usually the
     * first such element, but no order is guaranteed! Use appropriate methods
     * to check that there is only one such element or to deal with a collection
     * of elements.
     *
     * @param <T>     extends {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     *
     * @see #unmarshalCollectionFromXpath(uk.ac.liv.pgb.jmzqml.MzQuantMLElement)
     * @param element The MzQuantMLElement defining the type of element to
     *                unmarshal.
     *
     * @return an MzQuantMLObject according to the type defined by the
     *         MzQuantMLElement.
     */
    public <T extends MzQuantMLObject> T unmarshal(MzQuantMLElement element) {
        // Class and xpath of the element to unmarshal
        Class<T> clazz = element.getClazz();
        String xpath = element.getXpath();

        // first check if we have an element(s) for this Class in the cache
        return doUnmarshal(clazz, xpath);
    }

    /**
     * Unmarshal one object for the specified class according to the value of id attribute. Note: The class has to
     * refer to MzQuantMLObject elements.
     *
     * @param <T>   extends {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     *
     * @see #unmarshal(uk.ac.liv.pgb.jmzqml.MzQuantMLElement)
     * @param clazz the type of Object to sub-class. It has to be a sub-class of
     *              MzQuantMLObject.
     * @param id    the id of the MzQuantMLObject
     *
     * @return an object of the specified class by defined id.
     *
     * @throws JAXBException
     */
    public <T extends MzQuantMLObject> T unmarshal(Class<T> clazz, String id)
            throws JAXBException {
        if (!index.isIDmapped(id, clazz)) {
            throw new IllegalArgumentException("No entry found for ID: " + id + " and Class: " + clazz
                    + ". Make sure the element you are looking for has an ID attribute and is id-mapped!");
        }
        String xmlSt = index.getXmlString(id, clazz);
        return generateObject(clazz, xmlSt);
    }

    /**
     * Unmarshal a collection of elements of the type defined by the {@link uk.ac.liv.pgb.jmzqml.MzQuantMLElement}.
     *
     * @param <T>     extends {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     * @param element The MzQuantMLElement defining the type of elements to unmarshal.
     *
     * @return an Iterator of MzQuantMLObject according to the type defined by the MzQuantMLElement.
     */
    public <T extends MzQuantMLObject> Iterator<T> unmarshalCollectionFromXpath(
            MzQuantMLElement element) {
        // caching deactivated
//        int indexCnt = getObjectCount(element);
//
//        if (cache != null) {
//            List<MzIdentMLObject> list = cache.getEntries(element.getClazz());
//            if (list != null) {
//                int cacheCnt = list.size();
//                if (indexCnt == cacheCnt) {
//                    // all elements are already cached
//                    return cache.getEntries(element.<T>getClazz()).iterator();
//                }
//            }
//        }

        // we have to iterate over the XML elements
        return new MzQuantMLObjectIterator<>(element, index, cache);
    }

    /**
     * Depends on the element being indexed and ID mapped. See configuration of
     * elements via MzQuantMLElement.
     *
     * @see MzQuantMLElement
     * @param element the element for which to get the IDs.
     *
     * @return a Set of all IDs of the specified element.
     *
     * @throws ConfigurationException
     */
    public Set<String> getIDsForElement(MzQuantMLElement element)
            throws ConfigurationException {
        return index.getIDsForElement(element);
    }

    /*
     * private methods
     */
    private <T extends MzQuantMLObject> T doUnmarshal(Class<T> clazz,
                                                      String xpath) {
        T retval = null;
        if (xpath != null) {
            retval = retrieveFromXML(clazz, xpath);
        }
        else {
            logger.info("No xpath or index entry for class " + clazz + "! Can not unmarshal!");
        }
        return retval;
    }

    private <T extends MzQuantMLObject> T retrieveFromXML(Class<T> cls,
                                                          String xpath) {
        T retval = null;
        try {
            Iterator<String> xpathIter = index.getXmlStringIterator(xpath);
            /**
             * xpath may not be indexed or the requested cls might be optional
             * and not present in the input xml file.
             */
            if (xpathIter == null) {
                return null;
            }
            if (xpathIter.hasNext()) {
                String xmlSt = xpathIter.next();
                retval = generateObject(cls, xmlSt);
            }
        }
        catch (JAXBException e) {
            logger.error("MzQuantMLUnmarshaller unmarshal error: ", e);
            throw new IllegalStateException("Could not unmarshal object at xpath: " + xpath);
        }
        return retval;
    }

    private <T extends MzQuantMLObject> T generateObject(Class<T> cls,
                                                         String xmlSt)
            throws JAXBException {
        T retval;

        //need to clean up XML to ensure that there are no weird control characters
        String cleanXML = EscapingXMLUtilities.escapeCharacters(xmlSt);

        if (logger.isDebugEnabled()) {
            logger.trace("XML to unmarshal: " + cleanXML);
        }

//        if (cls.equals(MzQuantMLElement.AnalysisSummary.getClazz())) {
//            cls = MzQuantMLElement.ParamList.getClazz();
//        }
        if (cls.equals(MzQuantMLElement.AnalysisSummary.getClazz())) {
            MzQuantMLNamespaceFilter xmlFilter = new MzQuantMLNamespaceFilter();
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, null, xmlFilter);
            JAXBElement<ParamList> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), ParamList.class);
            ParamList pl = holder.getValue();
            AnalysisSummary as = new AnalysisSummary();
            for (CvParam cp : pl.getCvParam()) {
                as.getCvParam().add(cp);
            }
            for (UserParam up : pl.getUserParam()) {
                as.getUserParam().add(up);
            }
            return (T) as;
        }
        else {
            // Create a filter to intercept events -- and patch the missing namespace
            MzQuantMLNamespaceFilter xmlFilter = new MzQuantMLNamespaceFilter();

            //initializeUnmarshaller will assign the proper reader to the xmlFilter
            //TODO: add cache
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, null, xmlFilter);
            //unmarshall the desired object
            JAXBElement<T> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), cls);
            retval = holder.getValue();

            if (logger.isDebugEnabled()) {
                logger.debug("unmarshalled object = " + retval);
            }

            return retval;
        }
    }

}
