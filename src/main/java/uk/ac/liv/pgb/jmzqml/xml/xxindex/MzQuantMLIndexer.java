
package uk.ac.liv.pgb.jmzqml.xml.xxindex;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.naming.ConfigurationException;
import psidev.psi.tools.xxindex.index.IndexElement;
import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 *
 * @author Da Qi
 */
public interface MzQuantMLIndexer {

    /**
     * A method to retrieve a collection of XML elements from the specific xpath.
     *
     * @param xpathExpression the xpath defining the XML element.
     *
     * @return the Iterator of the collection of XML elements matching the xpath.
     */
    public Iterator<String> getXmlStringIterator(String xpathExpression);

    /**
     * A method to get the number of the XML elements matching the xpath.
     *
     * @param xpathExpression the xpath defining the XML element.
     *
     * @return the number of XML elements matching the xpath or -1 if no
     *         elements were found for the specified xpath.
     */
    public int getCount(String xpathExpression);

    /**
     * A method to retrieve the XML String of a specific XML element,
     * providing the unique ID of the element and the Java mapped Class.
     *
     * @param ID    the unique ID from the id attribute of a XML element.
     * @param clazz the Java Class representing the XML element.
     *
     * @return the XML String representation of the requested element.
     */
    public String getXmlString(String ID, Class<? extends MzQuantMLObject> clazz);

    /**
     * Read XML string using a byte range
     *
     * @param byteRange byte range
     *
     * @return xml string
     */
    public String getXmlString(IndexElement byteRange);

    /**
     * A method to retrieve the list of {@link psidev.psi.tools.xxindex.index.IndexElement} matching the xpath.
     *
     * @param xpathExpression the xpath defining the XML element.
     *
     * @return list of {@link psidev.psi.tools.xxindex.index.IndexElement}.
     */
    public List<IndexElement> getIndexElements(String xpathExpression);

    /**
     * Get a map of id to byte range mappings
     *
     *
     * @param clazz class type
     *
     * @return a map of id to byte range mappings
     */
    public Map<String, IndexElement> getIndexElements(
            Class<? extends MzQuantMLObject> clazz);

    /**
     * Retrieves all xpath for which an XML element has been recorded.
     *
     * @return a Set of xpath.
     */
    public Set<String> getXpath();

    /**
     *
     * @param id    the unique ID (from the id attribute) of an XML element.
     * @param clazz the Java Class representing the element.
     *
     * @return the compete start tag for the XML element with the specified
     *         attributes.
     */
    public String getStartTag(String id, Class<? extends MzQuantMLObject> clazz);

    /**
     * Get the attribute XML string of the mzQuantML file.
     *
     * @return the attribute XML string of the mzQuantML file.
     */
    public String getMzQuantMLAttributeXMLString();

    /**
     *
     * @param id    the value of id attribute of XML element.
     * @param clazz the type of class corresponding to XML element.
     *
     * @return true if the element being ID mapped. See configuration of elements (MzQuantMLElement).
     */
    public boolean isIDmapped(String id, Class<? extends MzQuantMLObject> clazz);

    /**
     * Is dependent on the element being indexed and ID mapped.
     * See configuration of elements (MzQuantMLElement).
     *
     * @param element the element for which to get the IDs.
     *
     * @return a Set of all IDs of the specified element.
     *
     * @throws ConfigurationException
     */
    public Set<String> getIDsForElement(MzQuantMLElement element)
            throws ConfigurationException;

}
