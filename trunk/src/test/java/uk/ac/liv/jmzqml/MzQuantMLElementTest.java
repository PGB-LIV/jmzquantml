/*
 * Date: 04-Dec-2013
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.MzQuantMLElementTest.java
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

import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Da Qi
 */
public class MzQuantMLElementTest {

    static MzQuantMLElement[] expValues = new MzQuantMLElement[69];

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* MzQuantMLElementTest: setUpClass()");
        expValues = new MzQuantMLElement[]{MzQuantMLElement.SetupMzQuanttMLElement, MzQuantMLElement.AbstractContact, MzQuantMLElement.AbstractParam,
            MzQuantMLElement.Affiliation, MzQuantMLElement.AnalysisSummary, MzQuantMLElement.AssayList, MzQuantMLElement.Assay,
            MzQuantMLElement.AuditCollection, MzQuantMLElement.BibliographicReference, MzQuantMLElement.ColumnDefinition, MzQuantMLElement.Column,
            MzQuantMLElement.ContactRole, MzQuantMLElement.Cv, MzQuantMLElement.CvList, MzQuantMLElement.CvParamRef, MzQuantMLElement.CvParam,
            MzQuantMLElement.DBIdentificationRef, MzQuantMLElement.DataMatrix, MzQuantMLElement.DataProcessingList, MzQuantMLElement.DataProcessing,
            MzQuantMLElement.EvidenceRef, MzQuantMLElement.ExternalData, MzQuantMLElement.FeatureList, MzQuantMLElement.Feature,
            MzQuantMLElement.FileFormat, MzQuantMLElement.GlobalQuantLayer, MzQuantMLElement.Identifiable, MzQuantMLElement.IdentificationFile,
            MzQuantMLElement.IdentificationFiles, MzQuantMLElement.IdentificationRef, MzQuantMLElement.InputFiles, MzQuantMLElement.Label,
            MzQuantMLElement.MethodFiles, MzQuantMLElement.MethodFile, MzQuantMLElement.ModParam, MzQuantMLElement.Modification,
            MzQuantMLElement.MzQuantML, MzQuantMLElement.Organization, MzQuantMLElement.ParamList, MzQuantMLElement.Param,
            MzQuantMLElement.ParentOrganization, MzQuantMLElement.PeptideConsensusList, MzQuantMLElement.PeptideConsensus, MzQuantMLElement.Person,
            MzQuantMLElement.ProcessingMethod, MzQuantMLElement.ProteinGroupList, MzQuantMLElement.ProteinGroup, MzQuantMLElement.ProteinList,
            MzQuantMLElement.ProteinRef, MzQuantMLElement.Protein, MzQuantMLElement.Provider, MzQuantMLElement.QuantLayer, MzQuantMLElement.RatioList,
            MzQuantMLElement.RatioQuantLayer, MzQuantMLElement.Ratio, MzQuantMLElement.RawFile, MzQuantMLElement.RawFilesGroup, MzQuantMLElement.Role,
            MzQuantMLElement.Row, MzQuantMLElement.SearchDatabase, MzQuantMLElement.SmallMoleculeList, MzQuantMLElement.SmallMolecule,
            MzQuantMLElement.SmallMolModification, MzQuantMLElement.SoftwareList, MzQuantMLElement.Software, MzQuantMLElement.SourceFile,
            MzQuantMLElement.StudyVariableList, MzQuantMLElement.StudyVariable, MzQuantMLElement.UserParam};


    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("* MzQuantMLElementTest: tearDownClass()");
    }

    /**
     * Test of values method, of class MzQuantMLElement.
     */
    @Test
    public void testValues() {
        System.out.println("* MzQuantMLElementTest: testValues()");
        MzQuantMLElement[] result = MzQuantMLElement.values();

        assertArrayEquals("The MzQuantMLElement.values() returns incorrect elements.", expValues, result);
        assertEquals("The total number of members in MzQuantMLElement is not 69.", 69, result.length);
    }

    /**
     * Test of valueOf method, of class MzQuantMLElement.
     */
    @Test
    public void validValueOf() {
        System.out.println("* MzQuantMLElementTest: validValueOf()");
        assertEquals("Expect Cv element.", MzQuantMLElement.Cv, MzQuantMLElement.valueOf("Cv"));
    }

    /**
     * Test of valueOf method, with expected exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void invalidValueOf() {
        System.out.println("* MzQuantMLElementTest: invalidValueOf()");
        MzQuantMLElement.valueOf("CVs");
    }

    /**
     * Test of getTagName method, of class MzQuantMLElement.
     */
    @Test
    public void testGetTagName() {
        System.out.println("* MzQuantMLElementTest: testGetTagName()");
        String asTagName1 = MzQuantMLElement.AnalysisSummary.getTagName();
        assertEquals("The tagName is not \"AnalysisSummary\".", "AnalysisSummary", asTagName1);
    }

    /**
     * Test of isIndexed method, of class MzQuantMLElement.
     */
    @Test
    public void testIsIndexed() {
        System.out.println("* MzQuantMLElementTest: testIsIndexed()");
        assertFalse("\"Param\" element is indexed.", MzQuantMLElement.Param.isIndexed());
        assertTrue("\"Assay\" element is not indexed.", MzQuantMLElement.Assay.isIndexed());
    }

    /**
     * Test of isCached method, of class MzQuantMLElement.
     */
    @Test
    public void testIsCached() {
        System.out.println("* MzQuantMLElementTest: testIsCached()");
        assertFalse("\"BibliographicReference\" is cached.", MzQuantMLElement.BibliographicReference.isCached());
    }

    /**
     * Test of isIdMapped method, of class MzQuantMLElement.
     */
    @Test
    public void testIsIdMapped() {
        System.out.println("* MzQuantMLElementTest: testIsIdMapped()");
        assertFalse("\"AbstractContact\" element is idMapped.", MzQuantMLElement.AbstractContact.isIdMapped());
        assertTrue("\"Person\" element is not idMapped.", MzQuantMLElement.Person.isIdMapped());
    }

    /**
     * Test of isAutoRefResolving method, of class MzQuantMLElement.
     */
    @Test
    public void testIsAutoRefResolving() {
        System.out.println("* MzQuantMLElementTest: testIsAutoRefResolving()");
        assertTrue("\"Protein\" element is not autoRefResolving.", MzQuantMLElement.Protein.isAutoRefResolving());
        assertFalse("\"QuantLayer\" element is autoRefResolving.", MzQuantMLElement.QuantLayer.isAutoRefResolving());
    }

    /**
     * Test of getXpath method, of class MzQuantMLElement.
     */
    @Test
    public void testGetXpath() {
        System.out.println("* MzQuantMLElementTest: testGetXpath()");
        String svXpath = MzQuantMLElement.StudyVariable.getXpath();
        assertEquals("The xpath of \"StudyVariable\" element is not \"/MzQuantML/StudyVariableList/StudyVariable\".", "/MzQuantML/StudyVariableList/StudyVariable", svXpath);
        assertNull("The xpaht of \"Column\" elment is not Null.", MzQuantMLElement.Column.getXpath());
    }

    /**
     * Test of getClazz method, of class MzQuantMLElement.
     */
    @Test
    public void testGetClazz() {
        System.out.println("* MzQuantMLElementTest: testGetClazz()");
        Class crClazz = MzQuantMLElement.ContactRole.getClazz();
        assertEquals("The class of \"ContactRole\" element is not uk.ac.liv.jmzqml.model.mzqml.ContactRole.", uk.ac.liv.jmzqml.model.mzqml.ContactRole.class, crClazz);
        assertNotSame("The class of \"ContactRole\" element is same as uk.ac.liv.jmzqml.model.mzqml.Assay.", uk.ac.liv.jmzqml.model.mzqml.Assay.class, crClazz);
    }

    /**
     * Test of getCvParamClass method, of class MzQuantMLElement.
     */
    @Test
    public void testGetCvParamClass() {
        System.out.println("* MzQuantMLElementTest: testGetCvParamClass()");
        assertNull("\"CvList\" element has a CvParamClass.", MzQuantMLElement.CvList.getCvParamClass());
        assertNotNull("\"Feature\" element does not have a CvParamClass.", MzQuantMLElement.Feature.getCvParamClass());
        assertSame("The CvParam of \"SearchDatabase\" element is not uk.ac.liv.jmzqml.model.mzqml.params.SearchDatabaseCvParam",
                   uk.ac.liv.jmzqml.model.mzqml.params.SearchDatabaseCvParam.class, MzQuantMLElement.SearchDatabase.getCvParamClass());
    }

    /**
     * Test of getUserParamClass method, of class MzQuantMLElement.
     */
    @Test
    public void testGetUserParamClass() {
        System.out.println("* MzQuantMLElementTest: testGetUserParamClass()");
        assertNull("\"DataMatrix\" element has a UserParamClass.", MzQuantMLElement.DataMatrix.getUserParamClass());
        assertNotNull("\"Software\" element does not have a UserParamClass.", MzQuantMLElement.Software.getUserParamClass());
        assertSame("The UserParam of \"SmallMolecule\" element is not uk.ac.liv.jmzqml.model.mzqml.params.SmallMoleculeUserParam",
                   uk.ac.liv.jmzqml.model.mzqml.params.SmallMoleculeUserParam.class, MzQuantMLElement.SmallMolecule.getUserParamClass());
    }

    /**
     * Test of getRefResolverClass method, of class MzQuantMLElement.
     */
    @Test
    public void testGetRefResolverClass() {
        System.out.println("* MzQuantMLElementTest: testGetRefResolverClass()");
        assertNotNull("\"Affiliation\" element does not have a RefResolverClass.", MzQuantMLElement.Affiliation.getRefResolverClass());
        assertNull("\"AuditCollection\" element has a RefResolverClass.", MzQuantMLElement.AuditCollection.getRefResolverClass());
    }

    /**
     * Test of getType method, of class MzQuantMLElement.
     */
    @Test
    public void testGetType_Class() {
        System.out.println("* MzQuantMLElementTest: testGetType_Class()");
        Class c = null;
        assertNotNull(MzQuantMLElement.getType(c));
        assertNull(MzQuantMLElement.getType(uk.ac.liv.jmzqml.ParamListMappings.class));
    }

    /**
     * Test of getType method, of class MzQuantMLElement.
     */
    @Test
    public void testGetType_String() {
        System.out.println("* MzQuantMLElementTest: testGetType()");
        String xpath = "";
        MzQuantMLElement expResult = null;
        MzQuantMLElement result = MzQuantMLElement.getType(xpath);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class MzQuantMLElement.
     */
    @Test
    public void testToString() {
        System.out.println("* MzQuantMLElementTest: testToString()");
        String roleToString = "MzQuantMLElement{"
                + "indexed=" + "true"
                + ", xpath='" + "/MzQuantML/Provider/ContactRole/Role" + '\''
                + ", cached=" + "false"
                + ", clazz=" + uk.ac.liv.jmzqml.model.mzqml.Role.class
                + '}';
        assertEquals(roleToString, MzQuantMLElement.Role.toString());

        String paramToString = "MzQuantMLElement{"
                + "indexed=" + "false"
                + ", xpath='" + null + '\''
                + ", cached=" + "false"
                + ", clazz=" + uk.ac.liv.jmzqml.model.mzqml.Param.class
                + '}';
        assertEquals(paramToString, MzQuantMLElement.Param.toString());
    }

}
