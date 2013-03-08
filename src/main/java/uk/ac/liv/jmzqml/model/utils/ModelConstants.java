/*
 * Date: 25-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.model.utils.ModelConstants.java
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
package uk.ac.liv.jmzqml.model.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import uk.ac.liv.jmzqml.MzQuantMLElement;
import uk.ac.liv.jmzqml.model.mzqml.MzQuantML;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 25-Jul-2012 16:41:05
 */
public class ModelConstants {

    public static final String PACKAGE = MzQuantML.class.getPackage().getName();
    public static final String MZQML_NS = "http://psidev.info/psi/pi/mzQuantML/1.0.0";
    public static final String MZQML_VERSION = "1.0.0";
    //Todo: public static final String MZQML_SCHEMA = ""
    private static Map<Class, QName> modelQNames = new HashMap<Class, QName>();

    static {
        for (MzQuantMLElement element : MzQuantMLElement.values()) {
            if (element.getTagName() != null) {
                modelQNames.put(element.getClazz(), new QName(MZQML_NS, element.getTagName()));
            }
        }
        //now make set unmodifiable
        modelQNames = Collections.unmodifiableMap(modelQNames);
    }

    public static boolean isRegisteredClass(Class cls) {
        return modelQNames.containsKey(cls);
    }

    public static QName getQNameForClass(Class cls) {
        if (isRegisteredClass(cls)) {
            return modelQNames.get(cls);
        } else {
            throw new IllegalStateException("No QName registered for class: " + cls);
        }
    }

    public static String getElementNameForClass(Class cls) {
        if (isRegisteredClass(cls)) {
            return modelQNames.get(cls).getLocalPart();
        } else {
            throw new IllegalStateException("No Element Name registered for class: " + cls);
        }
    }

    public static Class getClassForElementName(String name) {
        for (Map.Entry<Class, QName> entry : modelQNames.entrySet()) {
            if (entry.getValue().getLocalPart().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
