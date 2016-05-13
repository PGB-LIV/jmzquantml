/*
 * Date: 09-Apr-2013
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.model.utils.ParamUpdater.java
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

package uk.ac.liv.pgb.jmzqml.model.utils;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 09-Apr-2013 23:59:04
 */
public class ParamUpdater {

    private static void updateAbstractParamProperties(AbstractParam input,
                                                      AbstractParam newParam)
            throws NoSuchFieldException, IllegalAccessException {
        if (input == null || newParam == null) {
            throw new IllegalArgumentException("Neither input or newParam can be null");
        }
        Field unitRefField = input.getClass().getSuperclass().getDeclaredField("unitCvRef");
        unitRefField.setAccessible(true);
        unitRefField.set(newParam, input.getUnitCvRef());
    }

    /**
     * A method to populate the property values of a CvParam to specified sub-class of CvParam.
     *
     * @param <T>             extends {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     * @param input           the instance of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     * @param cvParamSubClass the class type of the sub-class of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     *
     * @return a CvParam with the same property values of input.
     *
     * @throws IllegalAccessException exception
     * @throws InstantiationException exception
     */
    public static <T extends CvParam> T updateCvParamSubclass(CvParam input,
                                                              Class<T> cvParamSubClass)
            throws IllegalAccessException, InstantiationException {
        if (input != null) {
            // create a tmp holder of the new ParamSubclass
            T newParam = cvParamSubClass.newInstance();
            // copy fields
            newParam.setAccession(input.getAccession());
            /**
             * Check for null value as otherwise cvRef will be overwritten and set to null.
             */
            if (input.getCv() != null) {
                newParam.setCv(input.getCv());
            }
            else {
                /**
                 * No set*ref methods is provided so if auto resolving is off there is no way to record the cvParam.
                 * Use reflection to set the value.
                 */
                try {
                    Class<? extends CvParam> cls = input.getClass();
                    final Field cvRefField = cls.getDeclaredField("cvRef");
                    AccessController.doPrivileged(new PrivilegedAction() {

                        @Override
                        public Object run() {
                            cvRefField.setAccessible(true);
                            return null;
                        }

                    });
                    cvRefField.set(newParam, input.getCvRef());
                }
                catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                    throw new InstantiationError("Unable to create new instance of CvParam subclass due to problem updating cvRef.");
                }
                try {
                    ParamUpdater.updateAbstractParamProperties(input, newParam);
                }
                catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new InstantiationError("Unable to create new instance of CvParam subclass due to problem updating superclass properties.");

                }
            }

            if (input.getUnitCv() != null) {
                newParam.setUnitCv(input.getUnitCv());
            }
            else if (input.getUnitCvRef() != null) {
                // no unitCv object reference! might only be a reference string (not auto-resolving)
                /**
                 * No set*ref methods is provided so if auto resolving is off there is no way to record the cvParam.
                 * Use reflection to set the value.
                 */
                try {
                    final Field unitCvRefField = AbstractParam.class.getDeclaredField("unitCvRef");
                    AccessController.doPrivileged(new PrivilegedAction() {

                        @Override
                        public Object run() {
                            unitCvRefField.setAccessible(true);
                            return null;
                        }

                    });
                    unitCvRefField.set(newParam, input.getUnitCvRef());
                }
                catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
                    throw new InstantiationError("Unable to create new instance of CvParam subclass due to problem updating unitCvRef.");
                }
                try {
                    ParamUpdater.updateAbstractParamProperties(input, newParam);
                }
                catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new InstantiationError("Unable to create new instance of CvParam subclass due to problem updating superclass properties.");

                }
            }
//            else {
//                // no unitCV reference given: not updating!
//            }
            newParam.setName(input.getName());
            newParam.setValue(input.getValue());
            newParam.setUnitAccession(input.getUnitAccession());
            newParam.setUnitName(input.getUnitName());

            // replace old with new
            return newParam;
        }
        return null;
    }

    /**
     * A method to populate the property values of a list of CvParam to specified sub-class of CvParam.
     *
     * @param <T>             extends {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     * @param inputs          the list of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     * @param cvParamSubClass the class type of the sub-class of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     *
     *
     * @throws IllegalAccessException exception
     * @throws InstantiationException exception
     */
    public static <T extends CvParam> void updateCvParamSubclassesList(
            List<CvParam> inputs, Class<T> cvParamSubClass)
            throws InstantiationException, IllegalAccessException {
        if (inputs != null && inputs.size() > 0) {
            // create tmp holder
            List<T> newList = new ArrayList<>();

            // copy values to new SubClasses
            for (CvParam cvParam : inputs) {
                newList.add(updateCvParamSubclass(cvParam, cvParamSubClass));
            }

            // switch list content
            inputs.clear();
            //inputs.removeAll(inputs);
            inputs.addAll(newList);
        }
    }

    /**
     * A method to populate the property values of a UserParam to specified sub-class of UserParam.
     *
     * @param <T>               extends {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     * @param input             the instance of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     * @param userParamSubClass the class type of the sub-class of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     *
     * @return a UserParam with the same property values of input.
     *
     * @throws IllegalAccessException exception
     * @throws InstantiationException exception
     */
    public static <T extends UserParam> T updateUserParamSubclass(
            UserParam input, Class<T> userParamSubClass)
            throws InstantiationException, IllegalAccessException {
        if (input != null) {
            // create a tmp holder of the new ParamSubclass
            T newParam = userParamSubClass.newInstance();
            try {
                ParamUpdater.updateAbstractParamProperties(input, newParam);
            }
            catch (IllegalAccessException | NoSuchFieldException e) {
                throw new InstantiationException("Unable to create new instance of UserParam subclass due to problem updating superclass properties.");
            }
            // copy fields
            newParam.setName(input.getName());
            newParam.setValue(input.getValue());
            newParam.setUnitAccession(input.getUnitAccession());
            newParam.setUnitName(input.getUnitName());
            // replace old with new
            return newParam;
        }
        return null;
    }

    /**
     * A method to populate the property values of a list of UserParam to specified sub-class of UserParam.
     *
     * @param <T>               extends {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     * @param inputs            the list of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     * @param userParamSubClass the class type of the sub-class of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     *
     *
     * @throws IllegalAccessException exception
     * @throws InstantiationException exception
     */
    public static <T extends UserParam> void updateUserParamSubclassesList(
            List<UserParam> inputs, Class<T> userParamSubClass)
            throws InstantiationException, IllegalAccessException {
        if (inputs != null && inputs.size() > 0) {
            // create tmp holder
            List<T> newList = new ArrayList<>();

            // copy values to new SubClasses
            for (UserParam userParam : inputs) {
                newList.add(updateUserParamSubclass(userParam, userParamSubClass));
            }

            // switch list content
            inputs.clear();
            //inputs.removeAll(inputs);
            inputs.addAll(newList);
        }
    }

}
