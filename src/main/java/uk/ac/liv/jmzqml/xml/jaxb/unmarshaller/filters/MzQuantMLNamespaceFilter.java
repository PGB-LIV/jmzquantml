/*
 * Date: 25-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.jaxb.unmarshaller.filters.MzQuantMLNamespaceFilter.java
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

package uk.ac.liv.jmzqml.xml.jaxb.unmarshaller.filters;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;
import uk.ac.liv.jmzqml.model.utils.ModelConstants;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 25-Jul-2012 16:34:15
 */
public class MzQuantMLNamespaceFilter extends XMLFilterImpl {

    private static final Logger logger = Logger.getLogger(MzQuantMLNamespaceFilter.class);

    /**
     * Constructor of MzQuantMLNamespaceFilter
     */
    public MzQuantMLNamespaceFilter() {
        logger.debug("MzQuantMLNamespaceFilter created. Remember to call setParent(XMLReader)");
    }

    /**
     * Constructor of MzQuantMLNamespaceFilter
     *
     * @param reader XMLReader
     */
    public MzQuantMLNamespaceFilter(XMLReader reader) {
        super(reader);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes atts)
            throws SAXException {
        // the elements are defined by a qualified schema, but we rip them out of context with the xxindex
        // so the namespace information is lost and we have to add it again here manually       
        logger.trace("Chaning namespace. uri: " + uri + " \tlocalname: " + localName + "\tqName: " + qName + " \tatts: " + atts);
        if (uri.length() == 0) {
            super.startElement(ModelConstants.MZQML_NS, localName, qName, atts);
        }
        else {
            super.startElement(uri, localName, qName, atts);
        }
    }

}
