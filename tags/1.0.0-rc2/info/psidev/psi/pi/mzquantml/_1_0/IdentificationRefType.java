//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.07 at 05:05:23 PM BST 
//


package info.psidev.psi.pi.mzquantml._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A reference to an external identification file defined in the document, plus a unique identifier for the object in that file, such as an ID of a SpectrumIdentificationItem, ProteinDetectionHypothesis or ProteinAmbiguityGroup in mzIdentML. 
 * 
 * <p>Java class for IdentificationRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificationRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="id_refs" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc2}listOfStrings" />
 *       &lt;attribute name="identificationFile_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationRefType")
public class IdentificationRefType {

    @XmlAttribute(name = "id_refs", required = true)
    protected List<String> idRefs;
    @XmlAttribute(name = "identificationFile_ref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object identificationFileRef;

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

}