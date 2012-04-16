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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The list of all groups of proteins with conflicting evidence for which quantitation values are being reported along with quantitative values about those protein groups. If quantitation is done on individual proteins only, ProteinGroupsList should not be included.
 * 
 * <p>Java class for ProteinGroupListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProteinGroupListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProteinGroup" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}ProteinGroupType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GlobalQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}GlobalQuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AssayQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StudyVariableQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RatioQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinGroupListType", propOrder = {
    "proteinGroup",
    "globalQuantLayer",
    "assayQuantLayer",
    "studyVariableQuantLayer",
    "ratioQuantLayer",
    "paramGroup"
})
public class ProteinGroupListType {

    @XmlElement(name = "ProteinGroup")
    protected List<ProteinGroupType> proteinGroup;
    @XmlElement(name = "GlobalQuantLayer")
    protected List<GlobalQuantLayerType> globalQuantLayer;
    @XmlElement(name = "AssayQuantLayer")
    protected List<QuantLayerType> assayQuantLayer;
    @XmlElement(name = "StudyVariableQuantLayer")
    protected List<QuantLayerType> studyVariableQuantLayer;
    @XmlElement(name = "RatioQuantLayer")
    protected List<QuantLayerType> ratioQuantLayer;
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

    /**
     * Gets the value of the proteinGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proteinGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProteinGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProteinGroupType }
     * 
     * 
     */
    public List<ProteinGroupType> getProteinGroup() {
        if (proteinGroup == null) {
            proteinGroup = new ArrayList<ProteinGroupType>();
        }
        return this.proteinGroup;
    }

    /**
     * Gets the value of the globalQuantLayer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the globalQuantLayer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlobalQuantLayer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlobalQuantLayerType }
     * 
     * 
     */
    public List<GlobalQuantLayerType> getGlobalQuantLayer() {
        if (globalQuantLayer == null) {
            globalQuantLayer = new ArrayList<GlobalQuantLayerType>();
        }
        return this.globalQuantLayer;
    }

    /**
     * Gets the value of the assayQuantLayer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assayQuantLayer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssayQuantLayer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayerType }
     * 
     * 
     */
    public List<QuantLayerType> getAssayQuantLayer() {
        if (assayQuantLayer == null) {
            assayQuantLayer = new ArrayList<QuantLayerType>();
        }
        return this.assayQuantLayer;
    }

    /**
     * Gets the value of the studyVariableQuantLayer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studyVariableQuantLayer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudyVariableQuantLayer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayerType }
     * 
     * 
     */
    public List<QuantLayerType> getStudyVariableQuantLayer() {
        if (studyVariableQuantLayer == null) {
            studyVariableQuantLayer = new ArrayList<QuantLayerType>();
        }
        return this.studyVariableQuantLayer;
    }

    /**
     * Gets the value of the ratioQuantLayer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ratioQuantLayer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRatioQuantLayer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayerType }
     * 
     * 
     */
    public List<QuantLayerType> getRatioQuantLayer() {
        if (ratioQuantLayer == null) {
            ratioQuantLayer = new ArrayList<QuantLayerType>();
        }
        return this.ratioQuantLayer;
    }

    /**
     * CV terms for the entire list.Gets the value of the paramGroup property.
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

}
