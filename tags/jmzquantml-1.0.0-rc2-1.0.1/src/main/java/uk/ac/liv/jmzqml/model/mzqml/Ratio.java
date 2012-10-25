
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;


/**
 * The setup of a ratio of study variables or assays that is referenced elsewhere in the file.
 * 
 * <p>Java class for RatioType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RatioType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RatioCalculation" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc2}ParamListType" minOccurs="0"/>
 *         &lt;element name="NumeratorDataType" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc2}cvParamRefType"/>
 *         &lt;element name="DenominatorDataType" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc2}cvParamRefType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numerator_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="denominator_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RatioType", propOrder = {
    "ratioCalculation",
    "numeratorDataType",
    "denominatorDataType"
})
public class Ratio
    implements Serializable, MzQuantMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "RatioCalculation")
    protected ParamList ratioCalculation;
    @XmlElement(name = "NumeratorDataType", required = true)
    protected CvParamRef numeratorDataType;
    @XmlElement(name = "DenominatorDataType", required = true)
    protected CvParamRef denominatorDataType;
    @XmlAttribute(name = "numerator_ref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object numeratorRef;
    @XmlAttribute(name = "denominator_ref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object denominatorRef;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the ratioCalculation property.
     * 
     * @return
     *     possible object is
     *     {@link ParamList }
     *     
     */
    public ParamList getRatioCalculation() {
        return ratioCalculation;
    }

    /**
     * Sets the value of the ratioCalculation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamList }
     *     
     */
    public void setRatioCalculation(ParamList value) {
        this.ratioCalculation = value;
    }

    /**
     * Gets the value of the numeratorDataType property.
     * 
     * @return
     *     possible object is
     *     {@link CvParamRef }
     *     
     */
    public CvParamRef getNumeratorDataType() {
        return numeratorDataType;
    }

    /**
     * Sets the value of the numeratorDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CvParamRef }
     *     
     */
    public void setNumeratorDataType(CvParamRef value) {
        this.numeratorDataType = value;
    }

    /**
     * Gets the value of the denominatorDataType property.
     * 
     * @return
     *     possible object is
     *     {@link CvParamRef }
     *     
     */
    public CvParamRef getDenominatorDataType() {
        return denominatorDataType;
    }

    /**
     * Sets the value of the denominatorDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CvParamRef }
     *     
     */
    public void setDenominatorDataType(CvParamRef value) {
        this.denominatorDataType = value;
    }

    /**
     * Gets the value of the numeratorRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getNumeratorRef() {
        return numeratorRef;
    }

    /**
     * Sets the value of the numeratorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setNumeratorRef(Object value) {
        this.numeratorRef = value;
    }

    /**
     * Gets the value of the denominatorRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDenominatorRef() {
        return denominatorRef;
    }

    /**
     * Sets the value of the denominatorRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDenominatorRef(Object value) {
        this.denominatorRef = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
