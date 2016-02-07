/*
 * Date: 06-Nov-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.model.ParamGroupCapable.java
 *
 */

package uk.ac.liv.pgb.jmzqml.model;

import java.util.List;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam;

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
    List<CvParam> getCvParam();

    /**
     *
     * @return A List of UserParam objects.
     */
    List<UserParam> getUserParam();

}
