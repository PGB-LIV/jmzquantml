/*
 * Date: 10-Apr-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.ParamListMappings.java
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

package uk.ac.liv.pgb.jmzqml;

import java.util.Arrays;
import uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 10-Apr-2013 00:47:03
 */
public enum ParamListMappings {

    /**
     * Ratio member
     */
    Ratio(new String[]{"RatioCalculation"}, Ratio.class),
    /**
     * MzQuantML member
     */
    MzQuantML(new String[]{"AnalysisSummary"}, MzQuantML.class);
    private Class clazz;
    private String[] classNames;

    private ParamListMappings(final String[] classNames, final Class clazz) {
        this.classNames = classNames;
        this.clazz = clazz;
    }

    /**
     * Gets the value of classNames property.
     *
     * @return a string array of classNames.
     */
    public String[] getClassNames() {
        return Arrays.copyOf(classNames, classNames.length);
    }

    /**
     * Gets the value of clazz property.
     *
     * @return the value of clazz property.
     */
    public Class getClazz() {
        return this.clazz;
    }

    /**
     * Gets a member of ParamListMappings according to the value of clazz property.
     *
     * @param clazz the value of clazz property.
     *
     * @return a member of ParamListMappings.
     */
    public static ParamListMappings getType(final Class clazz) {
        for (ParamListMappings type : ParamListMappings.values()) {
            if (type.getClazz() == clazz) {
                return type;
            }
        }
        return null;
    }

}
