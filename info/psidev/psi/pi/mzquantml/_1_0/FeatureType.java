//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.16 at 01:42:41 PM CEST 
//


package de.mpc.MzQuantMLWrapper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A region on an MS1 mass spectrum, defined by the RT, MZ and optionally a mass trace. Quantitative values about features can be added in the associated QuantLayers.
 * 
 * <p>Java class for FeatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeatureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Masstrace" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}listOfDoubles" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="rt" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}doubleOrNullType" />
 *       &lt;attribute name="mz" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="charge" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}integerOrNullType" />
 *       &lt;attribute name="chromatogram_refs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="spectrum_refs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureType", propOrder = {
    "masstrace",
    "paramGroup"
})
public class FeatureType {

    @XmlList
    @XmlElement(name = "Masstrace", type = Double.class)
    protected List<Double> masstrace;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CVParamType.class),
        @XmlElement(name = "userParam", type = UserParamType.class)
    })
    protected List<AbstractParamType> paramGroup;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "rt", required = true)
    protected String rt;
    @XmlAttribute(name = "mz", required = true)
    protected double mz;
    @XmlAttribute(name = "charge")
    protected String charge;
    @XmlAttribute(name = "chromatogram_refs")
    protected String chromatogramRefs;
    @XmlAttribute(name = "spectrum_refs")
    protected String spectrumRefs;

    /**
     * Gets the value of the masstrace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the masstrace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMasstrace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getMasstrace() {
        if (masstrace == null) {
            masstrace = new ArrayList<Double>();
        }
        return this.masstrace;
    }

    /**
     * Additional parameters or values about this feature.Gets the value of the paramGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paramGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParamGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CVParamType }
     * {@link UserParamType }
     * 
     * 
     */
    public List<AbstractParamType> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<AbstractParamType>();
        }
        return this.paramGroup;
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
     * Gets the value of the rt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRt() {
        return rt;
    }

    /**
     * Sets the value of the rt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRt(String value) {
        this.rt = value;
    }

    /**
     * Gets the value of the mz property.
     * 
     */
    public double getMz() {
        return mz;
    }

    /**
     * Sets the value of the mz property.
     * 
     */
    public void setMz(double value) {
        this.mz = value;
    }

    /**
     * Gets the value of the charge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharge(String value) {
        this.charge = value;
    }

    /**
     * Gets the value of the chromatogramRefs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChromatogramRefs() {
        return chromatogramRefs;
    }

    /**
     * Sets the value of the chromatogramRefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChromatogramRefs(String value) {
        this.chromatogramRefs = value;
    }

    /**
     * Gets the value of the spectrumRefs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpectrumRefs() {
        return spectrumRefs;
    }

    /**
     * Sets the value of the spectrumRefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectrumRefs(String value) {
        this.spectrumRefs = value;
    }

}
