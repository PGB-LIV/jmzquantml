/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.liv.jmzqml.xml.xxindex;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.naming.ConfigurationException;
import psidev.psi.tools.xxindex.index.IndexElement;
import uk.ac.liv.jmzqml.MzQuantMLElement;

/**
 *
 * @author ddq
 */
public interface MzQuantMLIndexer {

    public Iterator<String> getXmlStringIterator(String xpathExpression);

    /**
     * @param xpathExpression the xpath defining the XML element.
     *
     * @return the number of XML elements matching the xpath or -1 if no
     * elements were found for the specified xpath.
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
    public String getXmlString(String ID, Class clazz);

    public List<IndexElement> getIndexElements(String xpathExpression);

    /**
     * Retrieves all xpath for which an XML element has been recorded.
     * @return a Set of xpath.
     */
    public Set<String> getXpath();

    /**
     *
     * @param id    the unique ID (from the id attribute) of an XML element.
     * @param clazz the Java Class representing the element.
     *
     * @return the compete start tag for the XML element with the specified
     * attributes.
     */
    public String getStartTag(String id, Class clazz);

    public String getMzQuantMLAttributeXMLString();

    public boolean isIDmapped(String id, Class clazz);

    /**
     * Is dependent on the element being indexed and ID mapped.
     * See configuration of elements (MzQuantMLElement).
     *
     * @param element the element for which to get the IDs.
     *
     * @return a Set of all IDs of the specified element.
     * @throws ConfigurationException
     */
    public Set<String> getIDsForElement(MzQuantMLElement element) throws ConfigurationException;
}
