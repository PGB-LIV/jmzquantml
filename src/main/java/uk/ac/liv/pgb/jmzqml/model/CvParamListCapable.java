/*
 * Date: 06-Nov-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.model.CvParamListCapable.java
 *
 */

package uk.ac.liv.pgb.jmzqml.model;

import java.util.List;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 06-Nov-2012 12:29:53
 */
public interface CvParamListCapable {

    /**
     *
     * @return A List of CvParam objects.
     */
    List<CvParam> getCvParam();

}
