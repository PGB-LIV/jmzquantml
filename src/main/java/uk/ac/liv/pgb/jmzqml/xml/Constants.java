/*
 * Date: 06-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.xml.Constants.java
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

package uk.ac.liv.pgb.jmzqml.xml;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 06-Jul-2012 11:26:26
 */
public final class Constants {

    /**
     * Instantiates a new Constants.
     * Private to prevent instantiation
     */
    private Constants() {

    }

    /**
     * The name of the property used to specify the output encoding in the
     * marshalled XML data.
     */
    public static String JAXB_ENCODING_PROPERTY = "jaxb.encoding";
    /**
     * The name of the property used to specify whether or not the marshalled
     * XML data is formatted with linefeeds and indentation.
     */
    public static String JAXB_FORMATTING_PROPERTY
            = "jaxb.formatted.output";
    /**
     * The name of the property used to specify the xsi:schemaLocation attribute
     * value to place in the marshalled XML output.
     */
    public static String JAXB_SCHEMALOCATION_PROPERTY
            = "jaxb.schemaLocation";
    /**
     * The name of the property used to specify whether or not the marshaller
     * will generate document level events (ie calling startDocument or
     * endDocument).
     */
    public static String JAXB_FRAGMENT_PROPERTY = "jaxb.fragment";  
    
    /**
     * The set of indexed xpath.
     */
    public static Set<String> XML_INDEXED_XPATHS;

    static {
        Set<String> TEMP_XPATHS_TO_INDEX = new HashSet<>();
        for (MzQuantMLElement element : MzQuantMLElement.values()) {
            if (element.isIndexed()) {
                TEMP_XPATHS_TO_INDEX.add(element.getXpath());
            }
        }
        //finally make the set unmordifiable
        XML_INDEXED_XPATHS = Collections.unmodifiableSet(TEMP_XPATHS_TO_INDEX);
    }    
}
