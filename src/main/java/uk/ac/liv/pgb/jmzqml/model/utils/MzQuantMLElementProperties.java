/*
 * Date: 05-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.model.utils.MzQuantMLElementProperties.java
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

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 05-Jul-2012 15:20:07
 */
@XmlRootElement
public class MzQuantMLElementProperties {

    private List<MzQuantMLElementConfig> configurations;

    /**
     * Get list of MzQuantMLElementConfig.
     *
     * @return a list of MzQuantMLElementConfig.
     */
    public final List<MzQuantMLElementConfig> getConfigurations() {
        return configurations;
    }

    /**
     * Set the list of MzQuantMLElementConfig.
     *
     * @param configurations list of MzQuantMLElementConfig.
     */
    public final void setConfigurations(
            final List<MzQuantMLElementConfig> configurations) {
        this.configurations = configurations;
    }

}
