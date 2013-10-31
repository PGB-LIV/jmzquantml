/*
 * Date: 06-Nov-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.model.ParamGroupCapable.java
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

package uk.ac.liv.jmzqml.model;

import java.util.List;
import uk.ac.liv.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.jmzqml.model.mzqml.UserParam;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 06-Nov-2012 12:31:25
 */
public interface ParamGroupCapable extends CvParamListCapable {

    /**
     *
     * @return A List of CvParam objects.
     */
    @Override
    public List<CvParam> getCvParam();

    /**
     *
     * @return A List of UserParam objects.
     */
    public List<UserParam> getUserParam();

}
