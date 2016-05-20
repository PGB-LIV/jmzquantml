
/**
 * Date: 04-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.pgb.jmzqml.MzQuantMLElement.java
 *
 * jmzquantml is Copyright 2012 University of Liverpool.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.liv.pgb.jmzqml;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXB;
import org.apache.log4j.Logger;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam;
import uk.ac.liv.pgb.jmzqml.model.utils.MzQuantMLElementConfig;
import uk.ac.liv.pgb.jmzqml.model.utils.MzQuantMLElementProperties;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.AbstractReferenceResolver;

/**
 * An Enum type that each member constant wraps a value of the corresponding
 * subclass of {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
 * <p>
 * For performance reasons (Memory Overflow), all the reference auto-resolving have been switched off.
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 04-Jul-2012 16:44:12
 */
public enum MzQuantMLElement {

    /**
     * Order is important - SetupMzQuantMLElement must appear first so that initialisation of cfgMap happens before it is used in
     * remaining constructors.
     */
    SetupMzQuanttMLElement(),
    /**
     * The AbstractContact constant wraps a value of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact} in a configuration file.
     */
    AbstractContact(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).getTagName(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).isIndexed(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).getXpath(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).isCached(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).isIdMapped(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).getClazz(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).getCvParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).getUserParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).isAutoRefResolving(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractContact.class.getName()).getRefResolverClass()),
    /**
     * The AbstractParam constant wraps a value of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam} in a configuration file.
     */
    AbstractParam(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).getTagName(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).isIndexed(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).getXpath(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).isCached(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).isIdMapped(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).getClazz(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).getCvParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).getUserParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).isAutoRefResolving(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AbstractParam.class.getName()).getRefResolverClass()),
    /**
     * The Affiliation constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation} in a configuration file.
     */
    Affiliation(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).getTagName(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).isIndexed(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).getXpath(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).isCached(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).isIdMapped(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).getClazz(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).getCvParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).getUserParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).isAutoRefResolving(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Affiliation.class.getName()).getRefResolverClass()),
    /**
     * The AnalysisSummary constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary} in a configuration file.
     */
    AnalysisSummary(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).getTagName(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).isIndexed(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).getXpath(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).isCached(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).isIdMapped(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).getClazz(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).getCvParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).getUserParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).isAutoRefResolving(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary.class.getName()).getRefResolverClass()),
    /**
     * The AssayList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList} in a configuration file.
     */
    AssayList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).getTagName(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).isIndexed(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).getXpath(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).isCached(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).isIdMapped(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).getClazz(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).getCvParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).getUserParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).isAutoRefResolving(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList.class.getName()).getRefResolverClass()),
    /**
     * The Assay constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Assay} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Assay} in a configuration file.
     */
    Assay(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).getTagName(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).isIndexed(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).getXpath(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).isCached(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).isIdMapped(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).getClazz(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).getCvParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).getUserParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).isAutoRefResolving(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Assay.class.getName()).getRefResolverClass()),
    /**
     * The AuditCollection constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection} in a configuration file.
     */
    AuditCollection(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).getTagName(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).isIndexed(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).getXpath(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).isCached(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).isIdMapped(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).getClazz(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).getCvParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).getUserParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).isAutoRefResolving(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection.class.getName()).getRefResolverClass()),
    /**
     * The BibliographicReference constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference} in a configuration file.
     */
    BibliographicReference(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).getTagName(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).isIndexed(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).getXpath(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).isCached(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).isIdMapped(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).getClazz(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).getCvParamClass(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).getUserParamClass(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).isAutoRefResolving(),
                           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference.class.getName()).getRefResolverClass()),
    /**
     * The ColumnDefinition constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition} in a configuration file.
     */
    ColumnDefinition(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getTagName(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isIndexed(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getXpath(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isCached(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isIdMapped(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getClazz(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getCvParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getUserParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isAutoRefResolving(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getRefResolverClass()),
    /**
     * The Column constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Column} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Column} in a configuration file.
     */
    Column(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).getTagName(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).isIndexed(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).getXpath(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).isCached(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).isIdMapped(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).getClazz(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).getCvParamClass(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).getUserParamClass(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).isAutoRefResolving(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Column.class.getName()).getRefResolverClass()),
    /**
     * The ContactRole constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole} in a configuration file.
     */
    ContactRole(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).getTagName(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).isIndexed(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).getXpath(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).isCached(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).isIdMapped(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).getClazz(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).getCvParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).getUserParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).isAutoRefResolving(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ContactRole.class.getName()).getRefResolverClass()),
    /**
     * The Cv constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Cv} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Cv} in a configuration file.
     */
    Cv(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).getTagName(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).isIndexed(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).getXpath(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).isCached(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).isIdMapped(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).getClazz(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).getCvParamClass(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).getUserParamClass(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).isAutoRefResolving(),
       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Cv.class.getName()).getRefResolverClass()),
    /**
     * The CvList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvList} in a configuration file.
     */
    CvList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).getTagName(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).isIndexed(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).getXpath(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).isCached(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).isIdMapped(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).getClazz(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).getCvParamClass(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).getUserParamClass(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).isAutoRefResolving(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvList.class.getName()).getRefResolverClass()),
    /**
     * The CvParamRef constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef} in a configuration file.
     */
    CvParamRef(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.CvParamRef.class.getName()).getRefResolverClass()),
    /**
     * The CvParam constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} in a configuration file.
     */
    CvParam(getCfg().get(CvParam.class.getName()).getTagName(),
            getCfg().get(CvParam.class.getName()).isIndexed(),
            getCfg().get(CvParam.class.getName()).getXpath(),
            getCfg().get(CvParam.class.getName()).isCached(),
            getCfg().get(CvParam.class.getName()).isIdMapped(),
            getCfg().get(CvParam.class.getName()).getClazz(),
            getCfg().get(CvParam.class.getName()).getCvParamClass(),
            getCfg().get(CvParam.class.getName()).getUserParamClass(),
            getCfg().get(CvParam.class.getName()).isAutoRefResolving(),
            getCfg().get(CvParam.class.getName()).getRefResolverClass()),
    /**
     * The DBIdentificationRef constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef} in a configuration file.
     */
    DBIdentificationRef(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getTagName(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isIndexed(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getXpath(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isCached(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isIdMapped(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getClazz(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getCvParamClass(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getUserParamClass(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isAutoRefResolving(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getRefResolverClass()),
    /**
     * The DataMatrix constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix} in a configuration file.
     */
    DataMatrix(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataMatrix.class.getName()).getRefResolverClass()),
    /**
     * The DataProcessingList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList} in a configuration file.
     */
    DataProcessingList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).getTagName(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).isIndexed(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).getXpath(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).isCached(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).isIdMapped(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).getClazz(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).getCvParamClass(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).getUserParamClass(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).isAutoRefResolving(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList.class.getName()).getRefResolverClass()),
    /**
     * The DataProcessing constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing} in a configuration file.
     */
    DataProcessing(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).getTagName(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).isIndexed(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).getXpath(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).isCached(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).isIdMapped(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).getClazz(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).getCvParamClass(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).getUserParamClass(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).isAutoRefResolving(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessing.class.getName()).getRefResolverClass()),
    /**
     * The EvidenceRef constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef} in a configuration file.
     */
    EvidenceRef(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).getTagName(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).isIndexed(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).getXpath(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).isCached(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).isIdMapped(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).getClazz(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).getCvParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).getUserParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).isAutoRefResolving(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.EvidenceRef.class.getName()).getRefResolverClass()),
    /**
     * The ExternalData constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData} in a configuration file.
     */
    ExternalData(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).getTagName(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).isIndexed(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).getXpath(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).isCached(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).isIdMapped(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).getClazz(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).getCvParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).getUserParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).isAutoRefResolving(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ExternalData.class.getName()).getRefResolverClass()),
    /**
     * The FeatureList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList} in a configuration file.
     */
    FeatureList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).getTagName(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).isIndexed(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).getXpath(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).isCached(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).isIdMapped(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).getClazz(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).getCvParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).getUserParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).isAutoRefResolving(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList.class.getName()).getRefResolverClass()),
    /**
     * The Feature constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Feature} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Feature} in a configuration file.
     */
    Feature(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).getTagName(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).isIndexed(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).getXpath(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).isCached(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).isIdMapped(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).getClazz(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).getCvParamClass(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).getUserParamClass(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).isAutoRefResolving(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Feature.class.getName()).getRefResolverClass()),
    /**
     * The FileFormat constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat} in a configuration file.
     */
    FileFormat(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.FileFormat.class.getName()).getRefResolverClass()),
    /**
     * The GlobalQuantLayer constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer} in a configuration file.
     */
    GlobalQuantLayer(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getTagName(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isIndexed(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getXpath(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isCached(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isIdMapped(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getClazz(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getCvParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getUserParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isAutoRefResolving(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getRefResolverClass()),
    /**
     * The Identifiable constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable} in a configuration file.
     */
    Identifiable(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).getTagName(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).isIndexed(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).getXpath(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).isCached(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).isIdMapped(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).getClazz(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).getCvParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).getUserParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).isAutoRefResolving(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Identifiable.class.getName()).getRefResolverClass()),
    /**
     * The IdentificationFile constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile} in a configuration file.
     */
    IdentificationFile(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).getTagName(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).isIndexed(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).getXpath(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).isCached(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).isIdMapped(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).getClazz(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).getCvParamClass(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).getUserParamClass(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).isAutoRefResolving(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFile.class.getName()).getRefResolverClass()),
    /**
     * The IdentificationFiles constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles} in a configuration file.
     */
    IdentificationFiles(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getTagName(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isIndexed(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getXpath(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isCached(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isIdMapped(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getClazz(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getCvParamClass(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getUserParamClass(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isAutoRefResolving(),
                        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getRefResolverClass()),
    /**
     * The IdentificationRef constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef} in a configuration file.
     */
    IdentificationRef(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).getTagName(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).isIndexed(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).getXpath(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).isCached(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).isIdMapped(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).getClazz(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).getCvParamClass(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).getUserParamClass(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).isAutoRefResolving(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.IdentificationRef.class.getName()).getRefResolverClass()),
    /**
     * The InputFiles constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles} in a configuration file.
     */
    InputFiles(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles.class.getName()).getRefResolverClass()),
    /**
     * The Label constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Label} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Label} in a configuration file.
     */
    Label(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).getTagName(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).isIndexed(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).getXpath(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).isCached(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).isIdMapped(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).getClazz(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).getCvParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).getUserParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).isAutoRefResolving(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Label.class.getName()).getRefResolverClass()),
    /**
     * The MethodFiles constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles} in a configuration file.
     */
    MethodFiles(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).getTagName(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).isIndexed(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).getXpath(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).isCached(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).isIdMapped(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).getClazz(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).getCvParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).getUserParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).isAutoRefResolving(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFiles.class.getName()).getRefResolverClass()),
    /**
     * The MethodFile constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile} in a configuration file.
     */
    MethodFile(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MethodFile.class.getName()).getRefResolverClass()),
    /**
     * The ModParam constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam} in a configuration file.
     */
    ModParam(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).getTagName(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).isIndexed(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).getXpath(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).isCached(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).isIdMapped(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).getClazz(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).getCvParamClass(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).getUserParamClass(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).isAutoRefResolving(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ModParam.class.getName()).getRefResolverClass()),
    /**
     * The Modification constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Modification} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Modification} in a configuration file.
     */
    Modification(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).getTagName(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).isIndexed(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).getXpath(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).isCached(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).isIdMapped(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).getClazz(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).getCvParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).getUserParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).isAutoRefResolving(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Modification.class.getName()).getRefResolverClass()),
    /**
     * The MzQuantML constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML} in a configuration file.
     */
    MzQuantML(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).getTagName(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).isIndexed(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).getXpath(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).isCached(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).isIdMapped(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).getClazz(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).getCvParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).getUserParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).isAutoRefResolving(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML.class.getName()).getRefResolverClass()),
    /**
     * The Organization constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Organization} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Organization} in a configuration file.
     */
    Organization(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).getTagName(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).isIndexed(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).getXpath(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).isCached(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).isIdMapped(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).getClazz(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).getCvParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).getUserParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).isAutoRefResolving(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Organization.class.getName()).getRefResolverClass()),
    /**
     * The ParamList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList} in a configuration file.
     */
    ParamList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).getTagName(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).isIndexed(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).getXpath(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).isCached(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).isIdMapped(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).getClazz(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).getCvParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).getUserParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).isAutoRefResolving(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParamList.class.getName()).getRefResolverClass()),
    /**
     * The Param constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Param} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Param} in a configuration file.
     */
    Param(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).getTagName(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).isIndexed(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).getXpath(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).isCached(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).isIdMapped(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).getClazz(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).getCvParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).getUserParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).isAutoRefResolving(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Param.class.getName()).getRefResolverClass()),
    /**
     * The ParentOrganization constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization} in a configuration file.
     */
    ParentOrganization(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).getTagName(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).isIndexed(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).getXpath(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).isCached(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).isIdMapped(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).getClazz(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).getCvParamClass(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).getUserParamClass(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).isAutoRefResolving(),
                       getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ParentOrganization.class.getName()).getRefResolverClass()),
    /**
     * The PeptideConsensusList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList} in a configuration file.
     */
    PeptideConsensusList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getTagName(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isIndexed(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getXpath(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isCached(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isIdMapped(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getClazz(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getCvParamClass(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getUserParamClass(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isAutoRefResolving(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getRefResolverClass()),
    /**
     * The PeptideConsensus constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus} in a configuration file.
     */
    PeptideConsensus(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getTagName(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isIndexed(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getXpath(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isCached(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isIdMapped(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getClazz(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getCvParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getUserParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isAutoRefResolving(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getRefResolverClass()),
    /**
     * The Person constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Person} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Person} in a configuration file.
     */
    Person(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).getTagName(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).isIndexed(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).getXpath(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).isCached(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).isIdMapped(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).getClazz(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).getCvParamClass(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).getUserParamClass(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).isAutoRefResolving(),
           getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Person.class.getName()).getRefResolverClass()),
    /**
     * The ProcessingMethod constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod} in a configuration file.
     */
    ProcessingMethod(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getTagName(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isIndexed(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getXpath(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isCached(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isIdMapped(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getClazz(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getCvParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getUserParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isAutoRefResolving(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getRefResolverClass()),
    /**
     * The ProteinGroupList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList} in a configuration file.
     */
    ProteinGroupList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getTagName(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isIndexed(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getXpath(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isCached(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isIdMapped(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getClazz(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getCvParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getUserParamClass(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isAutoRefResolving(),
                     getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getRefResolverClass()),
    /**
     * The ProteinGroup constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup} in a configuration file.
     */
    ProteinGroup(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).getTagName(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).isIndexed(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).getXpath(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).isCached(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).isIdMapped(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).getClazz(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).getCvParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).getUserParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).isAutoRefResolving(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup.class.getName()).getRefResolverClass()),
    /**
     * The ProteinList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList} in a configuration file.
     */
    ProteinList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).getTagName(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).isIndexed(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).getXpath(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).isCached(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).isIdMapped(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).getClazz(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).getCvParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).getUserParamClass(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).isAutoRefResolving(),
                getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList.class.getName()).getRefResolverClass()),
    /**
     * The ProteinRef constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef} in a configuration file.
     */
    ProteinRef(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinRef.class.getName()).getRefResolverClass()),
    /**
     * The Protein constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Protein} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Protein} in a configuration file.
     */
    Protein(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).getTagName(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).isIndexed(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).getXpath(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).isCached(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).isIdMapped(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).getClazz(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).getCvParamClass(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).getUserParamClass(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).isAutoRefResolving(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Protein.class.getName()).getRefResolverClass()),
    /**
     * The Provider constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Provider} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Provider} in a configuration file.
     */
    Provider(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).getTagName(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).isIndexed(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).getXpath(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).isCached(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).isIdMapped(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).getClazz(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).getCvParamClass(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).getUserParamClass(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).isAutoRefResolving(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Provider.class.getName()).getRefResolverClass()),
    /**
     * The QuantLayer constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer} in a configuration file.
     */
    QuantLayer(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.QuantLayer.class.getName()).getRefResolverClass()),
    /**
     * The RatioList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList} in a configuration file.
     */
    RatioList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).getTagName(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).isIndexed(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).getXpath(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).isCached(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).isIdMapped(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).getClazz(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).getCvParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).getUserParamClass(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).isAutoRefResolving(),
              getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList.class.getName()).getRefResolverClass()),
    /**
     * The RatioQuantLayer constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer} in a configuration file.
     */
    RatioQuantLayer(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).getTagName(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).isIndexed(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).getXpath(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).isCached(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).isIdMapped(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).getClazz(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).getCvParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).getUserParamClass(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).isAutoRefResolving(),
                    getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RatioQuantLayer.class.getName()).getRefResolverClass()),
    /**
     * The Ratio constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio} in a configuration file.
     */
    Ratio(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).getTagName(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).isIndexed(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).getXpath(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).isCached(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).isIdMapped(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).getClazz(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).getCvParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).getUserParamClass(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).isAutoRefResolving(),
          getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Ratio.class.getName()).getRefResolverClass()),
    /**
     * The RawFile constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile} in a configuration file.
     */
    RawFile(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).getTagName(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).isIndexed(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).getXpath(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).isCached(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).isIdMapped(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).getClazz(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).getCvParamClass(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).getUserParamClass(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).isAutoRefResolving(),
            getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFile.class.getName()).getRefResolverClass()),
    /**
     * The RawFilesGroup constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup} in a configuration file.
     */
    RawFilesGroup(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getTagName(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isIndexed(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getXpath(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isCached(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isIdMapped(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getClazz(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getCvParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getUserParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isAutoRefResolving(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getRefResolverClass()),
    /**
     * The Role constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Role} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Role} in a configuration file.
     */
    Role(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).getTagName(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).isIndexed(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).getXpath(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).isCached(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).isIdMapped(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).getClazz(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).getCvParamClass(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).getUserParamClass(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).isAutoRefResolving(),
         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Role.class.getName()).getRefResolverClass()),
    /**
     * The Row constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Row} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Row} in a configuration file.
     */
    Row(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).getTagName(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).isIndexed(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).getXpath(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).isCached(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).isIdMapped(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).getClazz(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).getCvParamClass(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).getUserParamClass(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).isAutoRefResolving(),
        getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Row.class.getName()).getRefResolverClass()),
    /**
     * The SearchDatabase constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase} in a configuration file.
     */
    SearchDatabase(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).getTagName(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).isIndexed(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).getXpath(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).isCached(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).isIdMapped(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).getClazz(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).getCvParamClass(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).getUserParamClass(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).isAutoRefResolving(),
                   getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SearchDatabase.class.getName()).getRefResolverClass()),
    /**
     * The SmallMoleculeList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList} in a configuration file.
     */
    SmallMoleculeList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getTagName(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isIndexed(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getXpath(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isCached(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isIdMapped(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getClazz(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getCvParamClass(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getUserParamClass(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isAutoRefResolving(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getRefResolverClass()),
    /**
     * The SmallMolecule constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule} in a configuration file.
     */
    SmallMolecule(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).getTagName(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).isIndexed(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).getXpath(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).isCached(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).isIdMapped(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).getClazz(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).getCvParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).getUserParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).isAutoRefResolving(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule.class.getName()).getRefResolverClass()),
    /**
     * The SmallMolModification constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification} in a configuration file.
     */
    SmallMolModification(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).getTagName(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).isIndexed(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).getXpath(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).isCached(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).isIdMapped(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).getClazz(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).getCvParamClass(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).getUserParamClass(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).isAutoRefResolving(),
                         getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolModification.class.getName()).getRefResolverClass()),
    /**
     * The SoftwareList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList} in a configuration file.
     */
    SoftwareList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).getTagName(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).isIndexed(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).getXpath(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).isCached(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).isIdMapped(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).getClazz(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).getCvParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).getUserParamClass(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).isAutoRefResolving(),
                 getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList.class.getName()).getRefResolverClass()),
    /**
     * The Software constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Software} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Software} in a configuration file.
     */
    Software(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).getTagName(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).isIndexed(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).getXpath(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).isCached(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).isIdMapped(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).getClazz(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).getCvParamClass(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).getUserParamClass(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).isAutoRefResolving(),
             getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.Software.class.getName()).getRefResolverClass()),
    /**
     * The SourceFile constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile} in a configuration file.
     */
    SourceFile(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).getTagName(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).isIndexed(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).getXpath(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).isCached(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).isIdMapped(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).getClazz(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).getCvParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).getUserParamClass(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).isAutoRefResolving(),
               getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.SourceFile.class.getName()).getRefResolverClass()),
    /**
     * The StudyVariableList constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList} in a configuration file.
     */
    StudyVariableList(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).getTagName(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).isIndexed(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).getXpath(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).isCached(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).isIdMapped(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).getClazz(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).getCvParamClass(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).getUserParamClass(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).isAutoRefResolving(),
                      getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList.class.getName()).getRefResolverClass()),
    /**
     * The StudyVariable constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable} in a configuration file.
     */
    StudyVariable(getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).getTagName(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).isIndexed(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).getXpath(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).isCached(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).isIdMapped(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).getClazz(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).getCvParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).getUserParamClass(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).isAutoRefResolving(),
                  getCfg().get(uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariable.class.getName()).getRefResolverClass()),
    /**
     * The UserParam constant wraps a value of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam} class in an object.
     * <p>
     * The object contains a set of pre-defined values for {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam} in a configuration file.
     */
    UserParam(getCfg().get(UserParam.class.getName()).getTagName(),
              getCfg().get(UserParam.class.getName()).isIndexed(),
              getCfg().get(UserParam.class.getName()).getXpath(),
              getCfg().get(UserParam.class.getName()).isCached(),
              getCfg().get(UserParam.class.getName()).isIdMapped(),
              getCfg().get(UserParam.class.getName()).getClazz(),
              getCfg().get(UserParam.class.getName()).getCvParamClass(),
              getCfg().get(UserParam.class.getName()).getUserParamClass(),
              getCfg().get(UserParam.class.getName()).isAutoRefResolving(),
              getCfg().get(UserParam.class.getName()).getRefResolverClass());
    // variables 
    private String tagName;
    private boolean indexed;
    private String xpath;
    private boolean cached;
    private boolean idMapped;
    private Class clazz;
    private Class cvParamClass;
    private Class userParamClass;
    private boolean autoRefResolving;
    private Class refResolverClass;
    private static Map<String, MzQuantMLElementConfig> cfgMap;

    /**
     * Returns the value of {@code tagName} property defined in configuration file. If no {@code tagName} property is defined, returns {@code NULL}.
     *
     * @return the value of {@code tagName} property defined in configuration file.
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Gets the {@code indexed} property. The property is defined in a configuration file.
     *
     * @return the {@code indexed} property.
     */
    public boolean isIndexed() {
        return indexed;
    }

    /**
     * Gets the {@code cached} property. The property is defined in a configuration file.
     *
     * @return the {@code cached} property.
     */
    public boolean isCached() {
        return cached;
    }

    /**
     * Gets the {@code idMapped} property. The property is defined in a configuration file.
     *
     * @return the {@code idMapped} property.
     */
    public boolean isIdMapped() {
        return idMapped;
    }

    /**
     * Gets the {@code autoRefResolving} property. The property is defined in a configuration file.
     *
     * @return the {@code autoRefResolving} property.
     */
    public boolean isAutoRefResolving() {
        return autoRefResolving;
    }

    /**
     * Returns the value of {@code xpath} property defined in configuration file. If no {@code xpath} property is defined, returns {@code NULL}.
     *
     * @return the value of {@code xpath} property defined in configuration file.
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * Returns a subclass of {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     *
     * @param <T> The type of the returned Class.
     *
     * @return a subclass of {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     */
    public <T extends MzQuantMLObject> Class<T> getClazz() {
        return clazz;
    }

    /**
     * Returns a subclass of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     *
     * @param <C> The type of the returned Class.
     *
     * @return a subclass of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam}.
     */
    @SuppressWarnings("unchecked")
    public <C extends CvParam> Class<C> getCvParamClass() {
        return cvParamClass;
    }

    /**
     * Returns a subclass of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     *
     * @param <U> The type of the returned Class.
     *
     * @return a subclass of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.UserParam}.
     */
    @SuppressWarnings("unchecked")
    public <U extends UserParam> Class<U> getUserParamClass() {
        return userParamClass;
    }

    /**
     * Returns a subclass of {@link uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.AbstractReferenceResolver}.
     *
     * @param <R> The type of the returned Class.
     *
     * @return a subclass of {@link uk.ac.liv.pgb.jmzqml.xml.jaxb.resolver.AbstractReferenceResolver}.
     */
    public <R extends AbstractReferenceResolver<?>> Class<R> getRefResolverClass() {
        return refResolverClass;
    }

    /**
     *
     * Returns a {@link uk.ac.liv.pgb.jmzqml.MzQuantMLElement} constant specified by {@code clazz}.
     *
     * @param clazz The class defined in the configuration file.
     *
     * @return a {@link uk.ac.liv.pgb.jmzqml.MzQuantMLElement} constant.
     */
    public static MzQuantMLElement getType(final Class clazz) {
        for (MzQuantMLElement type : MzQuantMLElement.values()) {
            if (type.getClazz() == clazz) {
                return type;
            }
        }
        return null;
    }

    /**
     * Returns a {@link uk.ac.liv.pgb.jmzqml.MzQuantMLElement} constant specified by {@code xpath}.
     *
     * @param xpath The xpath defined in the configuration file.
     *
     * @return a {@link uk.ac.liv.pgb.jmzqml.MzQuantMLElement} constant.
     */
    public static MzQuantMLElement getType(final String xpath) {
        for (MzQuantMLElement type : MzQuantMLElement.values()) {
            if (type.getXpath() != null && type.getXpath().equals(xpath)) {
                return type;
            }
        }
        return null;
    }

    /**
     * This should be called first in order to retrieve configuration from a
     * file and populate cfgMap.
     *
     * @param <T>
     */
    private <T extends MzQuantMLObject> MzQuantMLElement() {
        loadProperties();
    }

    private <T extends MzQuantMLObject> MzQuantMLElement(final String tagNamep,
                                                         final boolean indexedp,
                                                         final String xpathp,
                                                         final boolean cachedp,
                                                         final boolean idMappedp,
                                                         final Class<T> clazzp,
                                                         final Class cvParamClassp,
                                                         final Class userParamClassp,
                                                         final boolean autoRefResolvingp,
                                                         final Class refResolverClassp) {
        this.tagName = tagNamep;
        this.indexed = indexedp;
        this.cached = cachedp;
        this.xpath = xpathp;
        this.idMapped = idMappedp;
        this.clazz = clazzp;
        this.cvParamClass = cvParamClassp;
        this.userParamClass = userParamClassp;
        this.autoRefResolving = autoRefResolvingp;
        this.refResolverClass = refResolverClassp;
    }

    /**
     * Returns a String contains details of the MzQuantMLElement constant.
     * <p>
     * For example, {@code AnalysisSummary.toString()} returns
     * "MzQuantMLElement{indexed=true, xpath='/MzQuantML/AnalysisSummary', cached=null, clazz=uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary}".
     *
     * @return a String contains details of the MzQuantMLElement constant.
     *
     *
     */
    @Override
    public String toString() {
        return "MzQuantMLElement{"
                + "indexed=" + indexed
                + ", xpath='" + xpath + '\''
                + ", cached=" + cached
                + ", clazz=" + clazz
                + '}';
    }

    private synchronized static Map<String, MzQuantMLElementConfig> getCfg() {
        if (cfgMap == null) {
            cfgMap = new HashMap<>();
        }
        return cfgMap;
    }

    /**
     * Read the configuration info from the properties file. Note: this simply
     * loads the information into a hashmap. Actual setting of values is done
     * through the constructors.
     */
    private static void loadProperties() {

        Logger logger = Logger.getLogger(MzQuantMLElement.class);

        //check to see if we have a project-specific configruation file
        URL xmlFileURL = MzQuantMLElement.class.getClassLoader().getResource("MzQuantMLElement.cfg.xml");
        //if not, use default config
        if (xmlFileURL == null) {
            xmlFileURL = MzQuantMLElement.class.getClassLoader().getResource("defaultMzQuantMLElement.cfg.xml");
        }
        logger.warn("MzQuantML Configuration file: " + xmlFileURL.toString());

        MzQuantMLElementProperties props = JAXB.unmarshal(xmlFileURL, MzQuantMLElementProperties.class);
        Map<String, MzQuantMLElementConfig> localCfg = getCfg();
        for (MzQuantMLElementConfig cfg : props.getConfigurations()) {
            Class clazz = cfg.getClazz();
            if (clazz != null) {
                localCfg.put(clazz.getName(), cfg);
            }
        }
    }

}
