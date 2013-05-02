
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.ParamListCapable;
import uk.ac.liv.jmzqml.xml.jaxb.adapter.CalendarAdapter;


/**
 * Root element of the instance document.
 * 
 * <p>Java class for MzQuantMLType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MzQuantMLType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CvList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}CvListType"/>
 *         &lt;element name="Provider" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ProviderType" minOccurs="0"/>
 *         &lt;element name="AuditCollection" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}AuditCollectionType" minOccurs="0"/>
 *         &lt;element name="AnalysisSummary" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamListType"/>
 *         &lt;element name="InputFiles" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}InputFilesType"/>
 *         &lt;element name="SoftwareList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}SoftwareListType"/>
 *         &lt;element name="DataProcessingList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}DataProcessingListType"/>
 *         &lt;element name="BibliographicReference" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}BibliographicReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AssayList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}AssayListType"/>
 *         &lt;element name="StudyVariableList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}StudyVariableListType" minOccurs="0"/>
 *         &lt;element name="RatioList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}RatioListType" minOccurs="0"/>
 *         &lt;element name="ProteinGroupList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ProteinGroupListType" minOccurs="0"/>
 *         &lt;element name="ProteinList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ProteinListType" minOccurs="0"/>
 *         &lt;element name="PeptideConsensusList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}PeptideConsensusListType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SmallMoleculeList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}SmallMoleculeListType" minOccurs="0"/>
 *         &lt;element name="FeatureList" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}FeatureListType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="creationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="version" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}versionRegex" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MzQuantMLType", propOrder = {
    "cvList",
    "provider",
    "auditCollection",
    "analysisSummary",
    "inputFiles",
    "softwareList",
    "dataProcessingList",
    "bibliographicReference",
    "assayList",
    "studyVariableList",
    "ratioList",
    "proteinGroupList",
    "proteinList",
    "peptideConsensusList",
    "smallMoleculeList",
    "featureList"
})
@XmlRootElement(name = "MzQuantML")
public class MzQuantML extends Identifiable
        implements Serializable, MzQuantMLObject, ParamListCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "CvList", required = true)
    protected CvList cvList;
    @XmlElement(name = "Provider")
    protected Provider provider;
    @XmlElement(name = "AuditCollection")
    protected AuditCollection auditCollection;
    @XmlElement(name = "AnalysisSummary", required = true)
    protected AnalysisSummary analysisSummary;
    @XmlElement(name = "InputFiles", required = true)
    protected InputFiles inputFiles;
    @XmlElement(name = "SoftwareList", required = true)
    protected SoftwareList softwareList;
    @XmlElement(name = "DataProcessingList", required = true)
    protected DataProcessingList dataProcessingList;
    @XmlElement(name = "BibliographicReference")
    protected List<BibliographicReference> bibliographicReference;
    @XmlElement(name = "AssayList", required = true)
    protected AssayList assayList;
    @XmlElement(name = "StudyVariableList")
    protected StudyVariableList studyVariableList;
    @XmlElement(name = "RatioList")
    protected RatioList ratioList;
    @XmlElement(name = "ProteinGroupList")
    protected ProteinGroupList proteinGroupList;
    @XmlElement(name = "ProteinList")
    protected ProteinList proteinList;
    @XmlElement(name = "PeptideConsensusList")
    protected List<PeptideConsensusList> peptideConsensusList;
    @XmlElement(name = "SmallMoleculeList")
    protected SmallMoleculeList smallMoleculeList;
    @XmlElement(name = "FeatureList")
    protected List<FeatureList> featureList;
    @XmlAttribute(name = "creationDate")
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar creationDate;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * Gets the value of the cvList property.
     * 
     * @return
     *     possible object is
     *     {@link CvList }
     *     
     */
    public CvList getCvList() {
        return cvList;
    }

    /**
     * Sets the value of the cvList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CvList }
     *     
     */
    public void setCvList(CvList value) {
        this.cvList = value;
    }

    /**
     * Gets the value of the provider property.
     * 
     * @return
     *     possible object is
     *     {@link Provider }
     *     
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *     allowed object is
     *     {@link Provider }
     *     
     */
    public void setProvider(Provider value) {
        this.provider = value;
    }

    /**
     * Gets the value of the auditCollection property.
     * 
     * @return
     *     possible object is
     *     {@link AuditCollection }
     *     
     */
    public AuditCollection getAuditCollection() {
        return auditCollection;
    }

    /**
     * Sets the value of the auditCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditCollection }
     *     
     */
    public void setAuditCollection(AuditCollection value) {
        this.auditCollection = value;
    }

    /**
     * Gets the value of the analysisSummary property.
     * 
     * @return
     *     possible object is
     *     {@link ParamList }
     *     
     */
    public AnalysisSummary getAnalysisSummary() {
        return analysisSummary;
    }

    /**
     * Sets the value of the analysisSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamList }
     *     
     */
    public void setAnalysisSummary(AnalysisSummary value) {
        this.analysisSummary = value;
    }

    /**
     * Gets the value of the inputFiles property.
     * 
     * @return
     *     possible object is
     *     {@link InputFiles }
     *     
     */
    public InputFiles getInputFiles() {
        return inputFiles;
    }

    /**
     * Sets the value of the inputFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputFiles }
     *     
     */
    public void setInputFiles(InputFiles value) {
        this.inputFiles = value;
    }

    /**
     * Gets the value of the softwareList property.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareList }
     *     
     */
    public SoftwareList getSoftwareList() {
        return softwareList;
    }

    /**
     * Sets the value of the softwareList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareList }
     *     
     */
    public void setSoftwareList(SoftwareList value) {
        this.softwareList = value;
    }

    /**
     * Gets the value of the dataProcessingList property.
     * 
     * @return
     *     possible object is
     *     {@link DataProcessingList }
     *     
     */
    public DataProcessingList getDataProcessingList() {
        return dataProcessingList;
    }

    /**
     * Sets the value of the dataProcessingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataProcessingList }
     *     
     */
    public void setDataProcessingList(DataProcessingList value) {
        this.dataProcessingList = value;
    }

    /**
     * Gets the value of the bibliographicReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bibliographicReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBibliographicReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BibliographicReference }
     * 
     * 
     */
    public List<BibliographicReference> getBibliographicReference() {
        if (bibliographicReference == null) {
            bibliographicReference = new ArrayList<BibliographicReference>();
        }
        return this.bibliographicReference;
    }

    /**
     * Gets the value of the assayList property.
     * 
     * @return
     *     possible object is
     *     {@link AssayList }
     *     
     */
    public AssayList getAssayList() {
        return assayList;
    }

    /**
     * Sets the value of the assayList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssayList }
     *     
     */
    public void setAssayList(AssayList value) {
        this.assayList = value;
    }

    /**
     * Gets the value of the studyVariableList property.
     * 
     * @return
     *     possible object is
     *     {@link StudyVariableList }
     *     
     */
    public StudyVariableList getStudyVariableList() {
        return studyVariableList;
    }

    /**
     * Sets the value of the studyVariableList property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudyVariableList }
     *     
     */
    public void setStudyVariableList(StudyVariableList value) {
        this.studyVariableList = value;
    }

    /**
     * Gets the value of the ratioList property.
     * 
     * @return
     *     possible object is
     *     {@link RatioList }
     *     
     */
    public RatioList getRatioList() {
        return ratioList;
    }

    /**
     * Sets the value of the ratioList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RatioList }
     *     
     */
    public void setRatioList(RatioList value) {
        this.ratioList = value;
    }

    /**
     * Gets the value of the proteinGroupList property.
     * 
     * @return
     *     possible object is
     *     {@link ProteinGroupList }
     *     
     */
    public ProteinGroupList getProteinGroupList() {
        return proteinGroupList;
    }

    /**
     * Sets the value of the proteinGroupList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProteinGroupList }
     *     
     */
    public void setProteinGroupList(ProteinGroupList value) {
        this.proteinGroupList = value;
    }

    /**
     * Gets the value of the proteinList property.
     * 
     * @return
     *     possible object is
     *     {@link ProteinList }
     *     
     */
    public ProteinList getProteinList() {
        return proteinList;
    }

    /**
     * Sets the value of the proteinList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProteinList }
     *     
     */
    public void setProteinList(ProteinList value) {
        this.proteinList = value;
    }

    /**
     * Gets the value of the peptideConsensusList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peptideConsensusList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeptideConsensusList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeptideConsensusList }
     * 
     * 
     */
    public List<PeptideConsensusList> getPeptideConsensusList() {
        if (peptideConsensusList == null) {
            peptideConsensusList = new ArrayList<PeptideConsensusList>();
        }
        return this.peptideConsensusList;
    }

    /**
     * Gets the value of the smallMoleculeList property.
     * 
     * @return
     *     possible object is
     *     {@link SmallMoleculeList }
     *     
     */
    public SmallMoleculeList getSmallMoleculeList() {
        return smallMoleculeList;
    }

    /**
     * Sets the value of the smallMoleculeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmallMoleculeList }
     *     
     */
    public void setSmallMoleculeList(SmallMoleculeList value) {
        this.smallMoleculeList = value;
    }

    /**
     * Gets the value of the featureList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeatureList }
     * 
     * 
     */
    public List<FeatureList> getFeatureList() {
        if (featureList == null) {
            featureList = new ArrayList<FeatureList>();
        }
        return this.featureList;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(Calendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }
}
