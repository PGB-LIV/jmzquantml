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
import uk.ac.liv.jmzqml.model.mzqml.Software;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 09-Apr-2013 16:44:07
 */
public enum ParamMappings {

    SearchDatabase                 ("DatabaseName" , SearchDatabase.class),
    Software                       ("SoftwareName", Software.class);
    
    private Class clazz;
    private String className;

    private ParamMappings(String className, Class clazz){
        this.className = className;
        this.clazz = clazz;
    }

    public String getClassName(){
        return className;
    }

    public Class getClazz(){
        return this.clazz;
    }

    public static ParamMappings getType(Class clazz){
        for (ParamMappings type : ParamMappings.values()) {
            if (type.getClazz() == clazz) {
                return type;
            }
        }
        return null;
    }    
}
