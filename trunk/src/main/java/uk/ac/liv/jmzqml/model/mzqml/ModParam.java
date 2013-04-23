
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.CvParamCapable;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;


/**
 * The modification searched for or used to define the label or tag for quantification. It SHOULD be sourced from UniMod, PSI-MS or PSI-MOD.
 * 
 * <p>Java class for ModParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModParamType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cvParam" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}CVParamType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="massDelta" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="residues" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfChars" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModParamType", propOrder = {
    "cvParam"
})
public class ModParam
    implements Serializable, MzQuantMLObject, CvParamCapable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected CvParam cvParam;
    @XmlAttribute(name = "massDelta")
    protected Float massDelta;
    @XmlAttribute(name = "residues")
    protected List<String> residues;

    /**
     * Gets the value of the cvParam property.
     * 
     * @return
     *     possible object is
     *     {@link CvParam }
     *     
     */
    public CvParam getCvParam() {
        return cvParam;
    }

    /**
     * Sets the value of the cvParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link CvParam }
     *     
     */
    public void setCvParam(CvParam value) {
        this.cvParam = value;
    }

    /**
     * Gets the value of the massDelta property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMassDelta() {
        return massDelta;
    }

    /**
     * Sets the value of the massDelta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMassDelta(Float value) {
        this.massDelta = value;
    }

    /**
     * Gets the value of the residues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the residues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResidues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getResidues() {
        if (residues == null) {
            residues = new ArrayList<String>();
        }
        return this.residues;
    }

}
