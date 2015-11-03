/*
 * Date: 05-Dec-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.ParamListMappingsTest.java
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

import uk.ac.liv.pgb.jmzqml.ParamListMappings;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Da Qi
 */
public class ParamListMappingsTest {

    static ParamListMappings[] expValues = new ParamListMappings[2];

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* ParamListMappings: setUpClass()");
        expValues = new ParamListMappings[]{ParamListMappings.Ratio, ParamListMappings.MzQuantML};
    }

    /**
     * Test of values method, of class ParamListMappings.
     */
    @Test
    public void testValues() {
        System.out.println("* ParamListMappingsTest: testValues()");
        ParamListMappings[] result = ParamListMappings.values();

        assertArrayEquals("The ParamListMappings.values() returns incorrect elements.", expValues, result);
        assertEquals("The total number of members in ParamListMappings is not 2.", 2, result.length);
    }

    /**
     * Test of valueOf method, of class ParamListMappings.
     */
    @Test(expected = NullPointerException.class)
    public void nullValueOf() {
        System.out.println("* ParamListMappingsTest: nullValueOf()");
        ParamListMappings.valueOf(null);
    }

    /**
     * Test of valueOf method, of class ParamListMappings.
     */
    @Test(expected = IllegalArgumentException.class)
    public void illegalValueOf() {
        System.out.println("* ParamListMappingsTest: illegalValueOf()");
        assertNull(ParamListMappings.valueOf("Cv"));
    }

    /**
     * Test of valueOf method, of class ParamListMappings.
     */
    @Test
    public void testValueOf() {
        System.out.println("* ParamListMappingsTest: testValueOf()");
        assertNotNull(ParamListMappings.valueOf("Ratio"));
        assertEquals(ParamListMappings.Ratio, ParamListMappings.valueOf("Ratio"));
    }

    /**
     * Test of getClassNames method, of class ParamListMappings.
     */
    @Test
    public void testGetClassNames() {
        System.out.println("* ParamListMappingsTest: testGetClassNames()");
        String[] expResult = new String[]{"AnalysisSummary"};
        assertArrayEquals(expResult, ParamListMappings.MzQuantML.getClassNames());
    }

    /**
     * Test of getClazz method, of class ParamListMappings.
     */
    @Test
    public void testGetClazz() {
        System.out.println("* ParamListMappingsTest: testGetClazz()");
        assertEquals(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class, ParamListMappings.Ratio.getClazz());
    }

    /**
     * Test of getType method, of class ParamListMappings.
     */
    @Test
    public void testGetType() {
        System.out.println("* ParamListMappingsTest: testGetType()");
        Class clazz = null;
        ParamListMappings expResult = null;
        ParamListMappings result = ParamListMappings.getType(clazz);
        assertEquals(expResult, result);
        
        expResult = ParamListMappings.Ratio;
        result = ParamListMappings.getType(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class);
        assertEquals(expResult, result);
    }

}
