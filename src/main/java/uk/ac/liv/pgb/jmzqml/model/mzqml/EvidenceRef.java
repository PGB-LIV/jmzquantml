
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * Evidence associated with the PeptideConsensus, including mandatory
 * associations to features and optional references to identifications that have
 * been assigned to the feature.
 *
 * <p>
 * Java class for EvidenceRefType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="EvidenceRefType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="assay_refs" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" /&gt;
 *       &lt;attribute name="id_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" /&gt;
 *       &lt;attribute name="identificationFile_ref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="feature_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceRefType")
public class EvidenceRef
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "assay_refs", required = true)
    protected List<String> assayRefs;
    @XmlAttribute(name = "id_refs")
    protected List<String> idRefs;
    @XmlAttribute(name = "identificationFile_ref")
    protected String identificationFileRef;
    @XmlAttribute(name = "feature_ref", required = true)
    protected String featureRef;
    @XmlTransient
    protected List<Assay> assays;
    @XmlTransient
    protected IdentificationFile identificationFile;
    @XmlTransient
    protected Feature feature;

    /**
     * Gets the list of assay of the EvidenceRef.
     *
     * @return the list of assay of the EvidenceRef.
     */
    public List<Assay> getAssays() {
        if (assays == null) {
            assays = new ArrayList<>();
        }
        return assays;
    }

    /**
     * Sets the list of assay to the EvidenceRef.
     *
     * @param assays a list of assay.
     */
    public void setAssays(List<Assay> assays) {
        if (assays == null) {
            this.assayRefs = null;
        } else {
            this.assayRefs = new ArrayList<>();
            for (Assay assay : assays) {
                String refId = assay.getId();
                if (refId == null) {
                    throw new IllegalArgumentException(
                            "Referenced object does not have an identifier.");
                }
                this.assayRefs.add(refId);
            }
        }
        this.assays = assays;
    }

    /**
     * Gets the IdentificationFile of EvidenceRef.
     *
     * @return the IdentificationFile of EvidenceRef.
     */
    public IdentificationFile getIdentificationFile() {
        return identificationFile;
    }

    /**
     * Sets the IdentificationFile to EvidenceRef.
     *
     * @param identificationFile an IdentificationFile.
     */
    public void setIdentificationFile(IdentificationFile identificationFile) {
        if (identificationFile == null) {
            this.identificationFileRef = null;
        } else {
            String refId = identificationFile.getId();
            if (refId == null) {
                throw new IllegalArgumentException(
                        "Referenced object does not have an identifier.");
            }
            this.identificationFileRef = refId;
        }
        this.identificationFile = identificationFile;
    }

    /**
     * Gets the Feature of EvidenceRef.
     *
     * @return the Feature of EvidenceRef.
     */
    public Feature getFeature() {
        return feature;
    }

    /**
     * Sets the Feature to EvidenceRef.
     *
     * @param feature a Feature.
     */
    public void setFeature(Feature feature) {
        if (feature == null) {
            this.featureRef = null;
        } else {
            String refId = feature.getId();
            if (refId == null) {
                throw new IllegalArgumentException(
                        "Referenced object does not have an identifier.");
            }
            this.featureRef = refId;
        }
        this.feature = feature;
    }

    /**
     * Gets the value of the assayRefs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assayRefs
     * property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssayRefs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the assayRefs property.
     */
    public List<String> getAssayRefs() {
        if (assayRefs == null) {
            assayRefs = new ArrayList<>();
        }
        return this.assayRefs;
    }

    /**
     * Gets the value of the idRefs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idRefs
     * property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdRefs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the idRefs property.
     */
    public List<String> getIdRefs() {
        if (idRefs == null) {
            idRefs = new ArrayList<>();
        }
        return this.idRefs;
    }

    public void setIdRefs(List<String> idRefs) {
        this.idRefs = idRefs;
    }

    /**
     * Gets the value of the identificationFileRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getIdentificationFileRef() {
        return identificationFileRef;
    }

    /**
     * Gets the value of the featureRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getFeatureRef() {
        return featureRef;
    }

}
