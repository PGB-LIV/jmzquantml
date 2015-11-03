/*
 * Date: 12-Sep-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.xml.io.MzQuantMLObjectIterator.java
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
package uk.ac.liv.pgb.jmzqml.xml.io;

import java.io.StringReader;
import java.util.Iterator;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.unmarshaller.UnmarshallerFactory;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.unmarshaller.filters.MzQuantMLNamespaceFilter;
import uk.ac.liv.pgb.jmzqml.xml.util.EscapingXMLUtilities;
import uk.ac.liv.pgb.jmzqml.xml.xxindex.MzQuantMLIndexer;

/**
 *
 * @param <T> extends {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 12-Sep-2012 16:20:59
 */
public class MzQuantMLObjectIterator<T extends MzQuantMLObject> implements
        Iterator<T> {

    private static Logger logger = Logger.getLogger(MzQuantMLObjectIterator.class);
    private Iterator<String> innerXpathIterator;
    private String xpath;
    private Class<T> cls;
    private MzQuantMLIndexer index;
    private MzQuantMLObjectCache cache;

    MzQuantMLObjectIterator(MzQuantMLElement element, MzQuantMLIndexer index,
                            MzQuantMLObjectCache cache) {
        innerXpathIterator = index.getXmlStringIterator(element.getXpath());
        this.xpath = element.getXpath();
        this.cls = element.getClazz();
        this.index = index;
        this.cache = cache;
    }

    @Override
    public boolean hasNext() {
        return innerXpathIterator != null && innerXpathIterator.hasNext();
    }

    @Override
    public T next() {
        T retval;

        try {
            String xmlSt = innerXpathIterator.next();

            //need to clean up XML to ensure that there are no weird control characters
            String cleanXML = EscapingXMLUtilities.escapeCharacters(xmlSt);

            if (logger.isDebugEnabled()) {
                logger.trace("XML to unmarshal: " + cleanXML);
            }

            //required for the addition of namespaces to top-level objects
            MzQuantMLNamespaceFilter xmlFilter = new MzQuantMLNamespaceFilter();
            //initializeUnmarshaller will assign the proper reader to the xmlFilter
            Unmarshaller unmarshaller = UnmarshallerFactory.getInstance().initializeUnmarshaller(index, cache, xmlFilter);
            //unmarshall the desired object
            JAXBElement<T> holder = unmarshaller.unmarshal(new SAXSource(xmlFilter, new InputSource(new StringReader(cleanXML))), cls);

            retval = holder.getValue();

            if (logger.isDebugEnabled()) {
                logger.debug("unmarshalled object = " + retval);
            }
        }
        catch (JAXBException e) {
            logger.error("MzQuantMLObjectIterator.next", e);
            throw new IllegalStateException("Could not unmarshal object at xpath: " + xpath);
        }
        return retval;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(MzQuantMLObjectIterator.class.getName() + " can't be used to remove object while iterating");
    }

}
