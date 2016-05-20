
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
 * A reference to an external identification file defined in the document, plus a unique identifier for the object in that file, such as an ID of a SpectrumIdentificationItem, ProteinDetectionHypothesis or ProteinAmbiguityGroup in mzIdentML.
 *
 * <p>
 * Java class for IdentificationRefType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IdentificationRefType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="id_refs" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" /&gt;
 *       &lt;attribute name="identificationFile_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationRefType")
public class IdentificationRef
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "id_refs", required = true)
    protected List<String> idRefs;
    @XmlAttribute(name = "identificationFile_ref", required = true)
    protected String identificationFileRef;
    @XmlTransient
    protected IdentificationFile identificationFile;

    /**
     * Gets the IdentificationFile of IdentificationRef.
     *
     * @return the IdentificationFile of IdentificationRef.
     */
    public IdentificationFile getIdentificationFile() {
        return identificationFile;
    }

    /**
     * Sets the IdentificationFile to IdentificationRef.
     *
     * @param identificationFile an IdentificationFile.
     */
    public void setIdentificationFile(IdentificationFile identificationFile) {
        if (identificationFile == null) {
            this.identificationFileRef = null;
        } else {
            String refId = identificationFile.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.identificationFileRef = refId;
        }
        this.identificationFile = identificationFile;
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
     * @return the value of the idRefs property.
     */
    public List<String> getIdRefs() {
        if (idRefs == null) {
            idRefs = new ArrayList<>();
        }
        return this.idRefs;
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

}
