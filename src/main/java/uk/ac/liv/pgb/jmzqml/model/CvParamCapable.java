/*
 * Date: 09-Apr-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.model.CvParamCapable.java
 */

package uk.ac.liv.pgb.jmzqml.model;

import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 09-Apr-2013 16:33:48
 */
public interface CvParamCapable {

    /**
     * Gets a CvParam object.
     *
     * @return a CvParam object.
     */
    CvParam getCvParam();

    /**
     * Sets a CvParam object.
     *
     * @param param a CvParam object.
     */
    void setCvParam(CvParam param);

}
