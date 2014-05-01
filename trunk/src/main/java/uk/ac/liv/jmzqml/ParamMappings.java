/*
 * Date: 09-Apr-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.ParamMappings.java
 *
 * jmzquantml is Copyright 2013 University of Liverpool.
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

package uk.ac.liv.jmzqml;

import uk.ac.liv.jmzqml.model.mzqml.SearchDatabase;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 09-Apr-2013 16:44:07
 */
public enum ParamMappings {

    /**
     * SearchDatabase member
     */
    SearchDatabase("DatabaseName", SearchDatabase.class);
    private Class clazz;
    private String className;

    private ParamMappings(String className, Class clazz) {
        this.className = className;
        this.clazz = clazz;
    }

    /**
     * Gets the value of className property.
     *
     * @return the value of className property.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Gets the value of clazz property.
     *
     * @return the value of clazz property.
     */
    public Class getClazz() {
        return clazz;
    }

    /**
     * Gets a member of ParamMappings according to the value of clazz property.
     *
     * @param clazz the value of clazz property.
     *
     * @return a member of ParamMappings.
     */
    public static ParamMappings getType(Class clazz) {
        for (ParamMappings type : ParamMappings.values()) {
            if (type.getClazz() == clazz) {
                return type;
            }
        }
        return null;
    }

}
