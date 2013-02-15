
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;


/**
 * Evidence associated with the PeptideConsensus, including mandatory associations to features and optional references to identifications that have been assigned to the feature.
 * 
 * <p>Java class for EvidenceRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EvidenceRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="assay_refs" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREFS" />
 *       &lt;attribute name="id_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" />
 *       &lt;attribute name="identificationFile_ref" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="feature_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceRefType")
public class EvidenceRef
    implements Serializable, MzQuantMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "assay_refs", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> assayRefs;
    @XmlAttribute(name = "id_refs")
    protected List<String> idRefs;
    @XmlAttribute(name = "identificationFile_ref")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object identificationFileRef;
    @XmlAttribute(name = "feature_ref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object featureRef;

    /**
     * Gets the value of the assayRefs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assayRefs property.
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
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAssayRefs() {
        if (assayRefs == null) {
            assayRefs = new ArrayList<Object>();
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
     * This is why there is not a <CODE>set</CODE> method for the idRefs property.
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
     */
    public List<String> getIdRefs() {
        if (idRefs == null) {
            idRefs = new ArrayList<String>();
        }
        return this.idRefs;
    }

    /**
     * Gets the value of the identificationFileRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getIdentificationFileRef() {
        return identificationFileRef;
    }

    /**
     * Sets the value of the identificationFileRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIdentificationFileRef(Object value) {
        this.identificationFileRef = value;
    }

    /**
     * Gets the value of the featureRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFeatureRef() {
        return featureRef;
    }

    /**
     * Sets the value of the featureRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFeatureRef(Object value) {
        this.featureRef = value;
    }

}
