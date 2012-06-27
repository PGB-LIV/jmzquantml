/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.liv.jmzqml.xml.xxindex;

/**
 *
 * @author ddq
 */
public interface MzQuantMLIndexer {

    /**
     * @param xpathExpression the xpath defining the XML element.
     * @return the number of XML elements matching the xpath or -1 if no
     * elements were found for the specified xpath.
     */
    public int getCount(String xpathExpression);
}
