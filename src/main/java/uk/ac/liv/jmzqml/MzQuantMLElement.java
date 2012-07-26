/*
 * Date: 04-Jul-2012
 * Author: Da Qi
 * File: uk.ac.liv.jmzqml.MzQuantMLElement.java
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
package uk.ac.liv.jmzqml;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXB;
import org.apache.log4j.Logger;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.utils.MzQuantMLElementConfig;
import uk.ac.liv.jmzqml.model.utils.MzQuantMLElementProperties;
import uk.ac.liv.jmzqml.xml.jaxb.resolver.AbstractReferenceResolver;

/**
 *
 * @author Da Qi
 * @institute University of Liverpool
 * @time 04-Jul-2012 16:44:12
 */
public enum MzQuantMLElement {

    SetupMzIdentMLElement(),
    //Todo
    AbstractContact(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractContact.class.getName()).getRefResolverClass()),
    //Todo
    AbstractParam(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AbstractParam.class.getName()).getRefResolverClass()),
    //
    Affiliation(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Affiliation.class.getName()).getRefResolverClass()),
    //
    AssayList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AssayList.class.getName()).getRefResolverClass()),
    //
    Assay(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Assay.class.getName()).getRefResolverClass()),
    //
    AuditCollection(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.AuditCollection.class.getName()).getRefResolverClass()),
    //
    BibliographicReference(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.BibliographicReference.class.getName()).getRefResolverClass()),
    //
    ColumnDefinition(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ColumnDefinition.class.getName()).getRefResolverClass()),
    //
    Column(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Column.class.getName()).getRefResolverClass()),
    //
    ContactRole(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ContactRole.class.getName()).getRefResolverClass()),
    //
    Cv(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Cv.class.getName()).getRefResolverClass()),
    //
    CvList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvList.class.getName()).getRefResolverClass()),
    //
    CvParamRef(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParamRef.class.getName()).getRefResolverClass()),
    //
    CvParam(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.CvParam.class.getName()).getRefResolverClass()),
    //
    DBIdentificationRef(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DBIdentificationRef.class.getName()).getRefResolverClass()),
    //
    DataMatrix(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataMatrix.class.getName()).getRefResolverClass()),
    //
    DataProcessingList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessingList.class.getName()).getRefResolverClass()),
    //
    DataProcessing(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.DataProcessing.class.getName()).getRefResolverClass()),
    //
    EvidenceRef(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.EvidenceRef.class.getName()).getRefResolverClass()),
    //
    ExternalData(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ExternalData.class.getName()).getRefResolverClass()),
    //
    FeatureList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FeatureList.class.getName()).getRefResolverClass()),
    //
    Feature(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Feature.class.getName()).getRefResolverClass()),
    //
    FileFormat(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.FileFormat.class.getName()).getRefResolverClass()),
    //
    GlobalQuantLayer(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.GlobalQuantLayer.class.getName()).getRefResolverClass()),
    //
    Identifiable(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Identifiable.class.getName()).getRefResolverClass()),
    //
    IdentificationFile(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFile.class.getName()).getRefResolverClass()),
    //
    IdentificationFiles(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationFiles.class.getName()).getRefResolverClass()),
    //
    IdentificationRef(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.IdentificationRef.class.getName()).getRefResolverClass()),
    //
    InputFiles(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.InputFiles.class.getName()).getRefResolverClass()),
    //
    Label(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Label.class.getName()).getRefResolverClass()),
    //
    MethodFiles(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFiles.class.getName()).getRefResolverClass()),
    //
    MethodFile(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MethodFile.class.getName()).getRefResolverClass()),
    //
    ModParam(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ModParam.class.getName()).getRefResolverClass()),
    //
    Modification(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Modification.class.getName()).getRefResolverClass()),
    //
    MzQuantML(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.MzQuantML.class.getName()).getRefResolverClass()),
    //
    Organization(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Organization.class.getName()).getRefResolverClass()),
    //
    ParamList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParamList.class.getName()).getRefResolverClass()),
    //
    Param(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Param.class.getName()).getRefResolverClass()),
    //
    ParentOrganization(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ParentOrganization.class.getName()).getRefResolverClass()),
    //
    PeptideConsensusList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensusList.class.getName()).getRefResolverClass()),
    //
    PeptideConsensus(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.PeptideConsensus.class.getName()).getRefResolverClass()),
    //
    Person(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Person.class.getName()).getRefResolverClass()),
    //
    ProcessingMethod(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProcessingMethod.class.getName()).getRefResolverClass()),
    //
    ProteinGroupList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroupList.class.getName()).getRefResolverClass()),
    //
    ProteinGroup(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinGroup.class.getName()).getRefResolverClass()),
    //
    ProteinList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.ProteinList.class.getName()).getRefResolverClass()),
    //
    Protein(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Protein.class.getName()).getRefResolverClass()),
    //
    Provider(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Provider.class.getName()).getRefResolverClass()),
    //
    QuantLayer(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.QuantLayer.class.getName()).getRefResolverClass()),
    //
    RatioList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RatioList.class.getName()).getRefResolverClass()),
    //
    Ratio(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Ratio.class.getName()).getRefResolverClass()),
    //
    RawFile(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFile.class.getName()).getRefResolverClass()),
    //
    RawFilesGroup(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.RawFilesGroup.class.getName()).getRefResolverClass()),
    //
    Role(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Role.class.getName()).getRefResolverClass()),
    //
    Row(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Row.class.getName()).getRefResolverClass()),
    //
    SearchDatabase(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SearchDatabase.class.getName()).getRefResolverClass()),
    //
    SmallMoleculeList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMoleculeList.class.getName()).getRefResolverClass()),
    //
    SmallMolecule(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolecule.class.getName()).getRefResolverClass()),
    //
    SmallMolModification(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SmallMolModification.class.getName()).getRefResolverClass()),
    //
    SoftwareList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SoftwareList.class.getName()).getRefResolverClass()),
    //
    Software(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.Software.class.getName()).getRefResolverClass()),
    //
    SourceFile(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.SourceFile.class.getName()).getRefResolverClass()),
    //
    StudyVariableList(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariableList.class.getName()).getRefResolverClass()),
    //
    StudyVariable(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.StudyVariable.class.getName()).getRefResolverClass()),
    //
    UserParam(getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).getTagName(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).isIndexed(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).getXpath(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).isCached(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).isIdMapped(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).getClazz(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).isAutoRefResolving(),
    getCfg().get(uk.ac.liv.jmzqml.model.mzqml.UserParam.class.getName()).getRefResolverClass());
    //
    private String tagName;
    private boolean indexed;
    private String xpath;
    private boolean cached;
    private boolean idMapped;
    private Class clazz;
    private boolean autoRefResolving;
    private Class refResolverClass;

    /**
     * This should be called first in order to retrieve configuration from a
     * file and populate cfgMap.
     *
     * @param <T>
     */
    private <T extends MzQuantMLObject> MzQuantMLElement() {
        loadProperties();
    }

    private <T extends MzQuantMLObject> MzQuantMLElement(String tagName,
                                                         boolean indexed,
                                                         String xpath,
                                                         boolean cached,
                                                         boolean idMapped,
                                                         Class<T> clazz,
                                                         boolean autoRefResolving,
                                                         Class refResolverClass) {
        this.tagName = tagName;
        this.indexed = indexed;
        this.cached = cached;
        this.xpath = xpath;
        this.idMapped = idMapped;
        this.clazz = clazz;
        this.autoRefResolving = autoRefResolving;
        this.refResolverClass = refResolverClass;
    }

    public String getTagName() {
        return tagName;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public boolean isCached() {
        return cached;
    }

    public boolean isIdMapped() {
        return idMapped;
    }

    public boolean isAutoRefResolving() {
        return autoRefResolving;
    }

    public String getXpath() {
        return xpath;
    }

    public <T extends MzQuantMLObject> Class<T> getClazz() {
        return clazz;
    }

    public <R extends AbstractReferenceResolver> Class<R> getRefResolverClass() {
        return refResolverClass;
    }

    public static MzQuantMLElement getType(Class clazz) {
        for (MzQuantMLElement type : MzQuantMLElement.values()) {
            if (type.getClazz() == clazz) {
                return type;
            }
        }
        return null;
    }

    public static MzQuantMLElement getType(String xpath) {
        for (MzQuantMLElement type : MzQuantMLElement.values()) {
            if (type.getXpath() != null && type.getXpath().equals(xpath)) {
                return type;
            }
        }
        return null;
    }
    private static Map<String, MzQuantMLElementConfig> cfgMap;

    private static Map<String, MzQuantMLElementConfig> getCfg() {
        if (cfgMap == null) {
            cfgMap = new HashMap<String, MzQuantMLElementConfig>();
        }
        return cfgMap;
    }

    /**
     * Read the configuration info from the properties file. Note: this simply
     * loads the information into a hashmap.
     * Actual setting of values is done through the constructors.
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

    @Override
    public String toString() {
        return "MzQuantMLElement{"
                + "indexed=" + indexed
                + ", xpath='" + xpath + '\''
                + ", cached=" + cached
                + ", clazz=" + clazz
                + '}';
    }
}
