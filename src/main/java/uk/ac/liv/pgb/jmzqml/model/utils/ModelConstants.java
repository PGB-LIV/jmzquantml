/*
 * Date: 25-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.model.utils.ModelConstants.java
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

package uk.ac.liv.pgb.jmzqml.model.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.namespace.QName;
import uk.ac.liv.pgb.jmzqml.MzQuantMLElement;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 25-Jul-2012 16:41:05
 */
public final class ModelConstants {

    /**
     * Instantiates a new ModelConstants.
     * Private to prevent instantiation
     */
    private ModelConstants() { 
    }

    /**
     * The package name of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML}.
     */
    public static final String PACKAGE = MzQuantML.class.getPackage().getName();
    /**
     * The name space of the mzQuantML schema.
     */
    public static final String MZQML_NS = "http://psidev.info/psi/pi/mzQuantML/1.0.0";
    /**
     * The version of the mzQuantML schema.
     */
    public static final String MZQML_VERSION = "1.0.0";
    /**
     * The file name of the mzQuantML schema.
     */
    //public static final String MZQML_SCHEMA = "http://psidev.info/psi/pi/mzQuantML/mzQuantML_1_0_0.xsd";
    public static final String MZQML_SCHEMA = "http://www.psidev.info/sites/default/files/mzQuantML_1_0_0.xsd";

    /**
     * The location of the mzQuantML schema.
     */
    public static final String MZQML_LOCATION = MZQML_NS + " " + MZQML_SCHEMA;

    private static Map<Class<? extends MzQuantMLObject>, QName> modelQNames = new HashMap<>();
    private static final Map<Class<? extends MzQuantMLObject>, QName> TEMP_MODEL_QNAMES = new HashMap<>();

    static {
        for (MzQuantMLElement element : MzQuantMLElement.values()) {
            if (element.getTagName() != null) {
                TEMP_MODEL_QNAMES.put(element.getClazz(), new QName(MZQML_NS, element.getTagName()));
            }
        }
        //now make set unmodifiable
        modelQNames = Collections.unmodifiableMap(TEMP_MODEL_QNAMES);
    }

    /**
     * This method detects if a given class is registered as a class of mzQuantML model.
     *
     * @param cls a Class parameter.
     *
     * @return true if the class is registered as a class of mzQuantmL model.
     */
    public static boolean isRegisteredClass(
            final Class<? extends MzQuantMLObject> cls) {
        return modelQNames.containsKey(cls);
    }

    /**
     * A method to retrieve the QName of a specified mzQuantML model.
     *
     * @param cls a specified Class parameter.
     *
     * @return the QName of matching Class.
     */
    public static QName getQNameForClass(
            final Class<? extends MzQuantMLObject> cls) {
        if (isRegisteredClass(cls)) {
            return modelQNames.get(cls);
        } else {
            throw new IllegalStateException("No QName registered for class: " + cls);
        }
    }

    /**
     * A method to retrieve the element name of a specified mzQuantML model.
     *
     * @param cls a specified Class parameter.
     *
     * @return the string element name of matching Class.
     */
    public static String getElementNameForClass(final Class<MzQuantMLObject> cls) {
        if (isRegisteredClass(cls)) {
            return modelQNames.get(cls).getLocalPart();
        } else {
            throw new IllegalStateException("No Element Name registered for class: " + cls);
        }
    }

    /**
     * A method to retrieve the Class of a given element name.
     *
     * @param name string element name.
     *
     * @return the Class of matching element name.
     */
    public static Class<? extends MzQuantMLObject> getClassForElementName(
            final String name) {
        for (Entry<Class<? extends MzQuantMLObject>, QName> entry : modelQNames.entrySet()) {
            if (entry.getValue().getLocalPart().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
