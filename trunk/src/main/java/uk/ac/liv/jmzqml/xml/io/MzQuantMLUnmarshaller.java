
/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package uk.ac.liv.jmzqml.xml.io;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.ConfigurationException;
import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import javax.xml.bind.*;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.mzqml.AnalysisSummary;
import uk.ac.liv.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.jmzqml.model.mzqml.MzQuantML;
import uk.ac.liv.jmzqml.model.mzqml.ParamList;
import uk.ac.liv.jmzqml.model.mzqml.UserParam;
import uk.ac.liv.jmzqml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.liv.jmzqml.xml.jaxb.unmarshaller.filters.MzQuantMLNamespaceFilter;
import uk.ac.liv.jmzqml.xml.xxindex.FileUtils;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexer;
import uk.ac.liv.jmzqml.xml.xxindex.MzQuantMLIndexerFactory;
//import uk.ac.liv.jmzquantml.xml.xxindex.MzQuantMLIndexer;
//import uk.ac.liv.jmzquantml.xml.xxindex.MzQuantMLIndexerFactory;

/**
 * Class for reading in whole mzQuantML objects.
 *
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class MzQuantMLUnmarshaller {

    private static final Logger logger = Logger.getLogger(MzQuantMLUnmarshaller.class);
    private final MzQuantMLIndexer index;
    private final MzQuantMLObjectCache cache;
    /**
     * Members.
     */
    private String mzqName = null;
    private String mzqID = null;
    private String mzqVersion = null;
    private static final Pattern ID_PATTERN = Pattern.compile("id\\s*=\\s*[\"']([^\"'>]*)?[\"']", Pattern.CASE_INSENSITIVE);
    private static final Pattern VERSION_PATTERN = Pattern.compile("version\\s*=\\s*[\"']([^\"'>]*)?[\"']", Pattern.CASE_INSENSITIVE);
    private static final Pattern NAME_PATTERN = Pattern.compile("name\\s*=\\s*[\"']([^\"'>]*)?[\"']", Pattern.CASE_INSENSITIVE);
    private static final Pattern XML_ATT_PATTERN = Pattern.compile("\\s+([A-Za-z:]+)\\s*=\\s*[\"']([^\"'>]+?)[\"']", Pattern.DOTALL);
    private Unmarshaller unmarsh = null;
    private Reader fr = null;
    private ArrayList<String> exMsgs = new ArrayList<String>();
    //private final MzQuantMLIndexer index;

    /**
     * Constructor
     *
     * @param fullFileName
     */
    public MzQuantMLUnmarshaller(String fullFileName) {

        //this(MzQuantMLIndexerFactory.getInstance().buildIndex(new File(fullFileName)));
        this.index = null;
        this.cache = null;
        try {
            this.fr = new FileReader(fullFileName);
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{MzQuantML.class});
            this.unmarsh = context.createUnmarshaller();
            this.unmarsh.setEventHandler(new DefaultValidationEventHandler());
            //this.unmarsh.setValidating(true);
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
    }
    /*
     *
     * @param fullFileName, schemaValidating, schemaFn
     */

    public MzQuantMLUnmarshaller(String fullFileName, boolean schemaValidating,
                                 File schemaFile) {

        //this(MzQuantMLIndexerFactory.getInstance().buildIndex(new File(fullFileName)));
        this.index = null;
        this.cache = null;
        try {
            this.fr = new FileReader(fullFileName);
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);


        }

        if (schemaValidating) {
            try {
                JAXBContext context = JAXBContext.newInstance(new Class[]{MzQuantML.class
                        });
                this.unmarsh = context.createUnmarshaller();

                SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
                Schema schema = sf.newSchema(schemaFile);
                this.unmarsh.setSchema(schema);

                ValidationEventHandler veh = new ValidationEventHandler() {

                    @Override
                    public boolean handleEvent(ValidationEvent event) {
                        //ignore warnings
                        if (event.getSeverity() != ValidationEvent.WARNING) {
                            ValidationEventLocator vel = event.getLocator();
//                            System.out.println("Line:Col[" + vel.getLineNumber()
//                                    + ":" + vel.getColumnNumber()
//                                    + "]:" + event.getMessage());
                            exMsgs.add("Line:Col[" + vel.getLineNumber()
                                    + ":" + vel.getColumnNumber()
                                    + "]:" + event.getMessage());
                        }
                        return true;
                    }

                };
                this.unmarsh.setEventHandler(veh);

            }
            catch (JAXBException jaxbex) {
                jaxbex.printStackTrace();
            }
            catch (SAXException ex) {
                System.out.println("Unable to validate due to follow error.");
                ex.printStackTrace();
            }
        }
        else {
            try {
                JAXBContext context = JAXBContext.newInstance(new Class[]{MzQuantML.class
                        });
                this.unmarsh = context.createUnmarshaller();
                this.unmarsh.setEventHandler(new DefaultValidationEventHandler());
                //this.unmarsh.setValidating(true);
            }
            catch (JAXBException jaxbex) {
                jaxbex.printStackTrace(System.err);
            }
        }
    }

    /*
     * Constructor
     */
    public MzQuantMLUnmarshaller(URL mzQuantMLFileURL) {
        this(FileUtils.getFileFromURL(mzQuantMLFileURL));
    }

    public MzQuantMLUnmarshaller(File mzQuantMLFile) {
        this(MzQuantMLIndexerFactory.getInstance().buildIndex(mzQuantMLFile));
    }

    public MzQuantMLUnmarshaller(MzQuantMLIndexer indexer) {
        this.index = indexer;
        this.cache = null;
    }

    /**
     * Unmarshalling of a whole MzQuantML object.
     *
     * @return MzQuantMLType
     */
    public MzQuantML unmarshall() {
        MzQuantML mzQuantML = null;

        try {
            if (this.fr != null) {
                mzQuantML = (MzQuantML) this.unmarsh.unmarshal(this.fr);
                this.fr.close();
            }
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);
        }

        return mzQuantML;
    }


    /*
     * public methods
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

    public String getMzQuantMLId() {
        if (mzqID == null) {
            Matcher match = ID_PATTERN.matcher(index.getMzQuantMLAttributeXMLString());
            if (match.find()) {
                mzqID = match.group(1);
            }
        }
        return mzqID;
    }

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
    public Map<String, String> getElementAttributes(String id, Class clazz) {
        Map<String, String> attributes = new HashMap<String, String>();
        // retrieve the start tag of the correspoinding XML element
        String tag = index.getStartTag(id, clazz);
        if (tag == null) {
            return null;
        }

        // parse the tage for attributes
        Matcher match = XML_ATT_PATTERN.matcher(tag);
        while (match.find()) {
            if (match.groupCount() == 2) {
                // found name - value pair
                String name = match.group(1);
                String value = match.group(2);
                // stick the found attributes in the map
                attributes.put(name, value);
            }
            else {
                // not a name - value pair, something is wrong!
                System.out.println("Unexpected number of groups for XML attribute: " + match.groupCount() + " in tag: " + tag);
            }

        }
        return attributes;
    }

    /**
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
     * @see #unmarshal(uk.ac.liv.jmzqml.MzQuantMLElement)
     * @param clazz the type of Object to sub-class. It has to be a sub-class of
     *              MzQuantMLObject.
     *
     * @return a object of the specified class
     */
    public <T extends MzQuantMLObject> T unmarshal(Class<T> clazz) {
        String xpath = MzQuantMLElement.getType(clazz).getXpath();
        return doUnmarshal(clazz, xpath);
    }

    public <T extends MzQuantMLObject> T unmarshal(String xpath) {
        Class<T> clazz = MzQuantMLElement.getType(xpath).getClazz();
        return doUnmarshal(clazz, xpath);
    }

    /**
     * Unmarshals one element of the type defined by the MzQuantMLElement. Note:
     * In case there are more than one element for the specified
     * MzQuantMLElement, only one found will be returned. This is usually the
     * first such element, but no order is guaranteed! Use appropriate methods
     * to check that there is only one such element or to deal with a collection
     * of elements.
     *
     * @see #unmarshalCollectionFromXpath(uk.ac.liv.jmzqml.MzQuantMLElement)
     * @param element The MzQuantMLElement defining the type of element to
     *                unmarshal.
     *
     * @return A MzQuantMLObject according to the type defined by the
     *         MzQuantMLElement.
     */
    public <T extends MzQuantMLObject> T unmarshal(MzQuantMLElement element) {
        // Class and xpath of the element to unmarshal
        Class<T> clazz = element.getClazz();
        String xpath = element.getXpath();

        // first check if we have an element(s) for this Class in the cache
        return doUnmarshal(clazz, xpath);
    }

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
        return new MzQuantMLObjectIterator<T>(element, index, cache);
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

    public <T extends MzQuantMLObject> T unmarshal(Class<T> clazz, String id)
            throws JAXBException {
        if (!index.isIDmapped(id, clazz)) {
            throw new IllegalArgumentException("No entry found for ID: " + id + " and Class: " + clazz
                    + ". Make sure the element you are looking for has an ID attribute and is id-mapped!");
        }
        String xmlSt = index.getXmlString(id, clazz);
        return generateObject(clazz, xmlSt);
    }

    public ArrayList<String> getExceptionalMessages() {
        return exMsgs;
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
        if (logger.isDebugEnabled()) {
            logger.trace("XML to unmarshal: " + xmlSt);
        }

//        if (cls.equals(MzQuantMLElement.AnalysisSummary.getClazz())) {
//            cls = MzQuantMLElement.ParamList.getClazz();
//        }
        if (cls.equals(MzQuantMLElement.AnalysisSummary.getClazz())) {
            StringReader sr = new StringReader(xmlSt);
            MzQuantMLNamespaceFilter xmlFilter = new MzQuantMLNamespaceFilter();
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, null, xmlFilter);
            JAXBElement<ParamList> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(xmlSt))), ParamList.class);
            ParamList pl = holder.getValue();
            AnalysisSummary as = new AnalysisSummary();
            for (CvParam cp: pl.getCvParam()){
                as.getCvParam().add(cp);
            }
            for (UserParam up: pl.getUserParam()){
                as.getUserParam().add(up);
            }
            return (T) as;    
        }
        else {
        // Create a filter to intercept events -- and patch the missing namespace
        MzQuantMLNamespaceFilter xmlFilter = new MzQuantMLNamespaceFilter();

        //initializeUnmarshaller will assign the proper reader to the xmlFilter
        //Todo: add cache
        Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, null, xmlFilter);
        //unmarshall the desired object
        JAXBElement<T> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(xmlSt))), cls);
        retval = holder.getValue();

        if (logger.isDebugEnabled()) {
            logger.debug("unmarshalled object = " + retval);
        }

        return retval;
    }
    }

}
