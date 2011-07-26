//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.26 at 01:45:50 PM BST 
//


package info.psidev.psi.pi.mzquantml._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AssayType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssayType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="raw_files_group_ref" type="{http://www.w3.org/2001/XMLSchema}IDREFS" minOccurs="0"/>
 *         &lt;element name="Label" type="{http://psidev.info/psi/pi/mzQuantML/0.1}LabelType" minOccurs="0"/>
 *         &lt;element name="IdentificationFiles" type="{http://psidev.info/psi/pi/mzQuantML/0.1}IdentificationFilesType" minOccurs="0"/>
 *         &lt;element name="DataProcessingOrder" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DataProcessingOrderElement">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="rank" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                           &lt;attribute name="dataProcessing_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="cvParam" type="{http://psidev.info/psi/pi/mzQuantML/0.1}CVParamType" minOccurs="0"/>
 *       &lt;/sequence>
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
@XmlType(name = "AssayType", propOrder = {
    "rawFilesGroupRef",
    "label",
    "identificationFiles",
    "dataProcessingOrder",
    "cvParam"
})
public class AssayType {

    @XmlList
    @XmlElement(name = "raw_files_group_ref")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> rawFilesGroupRef;
    @XmlElement(name = "Label")
    protected LabelType label;
    @XmlElement(name = "IdentificationFiles")
    protected IdentificationFilesType identificationFiles;
    @XmlElement(name = "DataProcessingOrder")
    protected AssayType.DataProcessingOrder dataProcessingOrder;
    protected CVParamType cvParam;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute
    protected String name;

    /**
     * Gets the value of the rawFilesGroupRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rawFilesGroupRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRawFilesGroupRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRawFilesGroupRef() {
        if (rawFilesGroupRef == null) {
            rawFilesGroupRef = new ArrayList<Object>();
        }
        return this.rawFilesGroupRef;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link LabelType }
     *     
     */
    public LabelType getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelType }
     *     
     */
    public void setLabel(LabelType value) {
        this.label = value;
    }

    /**
     * Gets the value of the identificationFiles property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationFilesType }
     *     
     */
    public IdentificationFilesType getIdentificationFiles() {
        return identificationFiles;
    }

    /**
     * Sets the value of the identificationFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationFilesType }
     *     
     */
    public void setIdentificationFiles(IdentificationFilesType value) {
        this.identificationFiles = value;
    }

    /**
     * Gets the value of the dataProcessingOrder property.
     * 
     * @return
     *     possible object is
     *     {@link AssayType.DataProcessingOrder }
     *     
     */
    public AssayType.DataProcessingOrder getDataProcessingOrder() {
        return dataProcessingOrder;
    }

    /**
     * Sets the value of the dataProcessingOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssayType.DataProcessingOrder }
     *     
     */
    public void setDataProcessingOrder(AssayType.DataProcessingOrder value) {
        this.dataProcessingOrder = value;
    }

    /**
     * Gets the value of the cvParam property.
     * 
     * @return
     *     possible object is
     *     {@link CVParamType }
     *     
     */
    public CVParamType getCvParam() {
        return cvParam;
    }

    /**
     * Sets the value of the cvParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link CVParamType }
     *     
     */
    public void setCvParam(CVParamType value) {
        this.cvParam = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DataProcessingOrderElement">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="rank" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *                 &lt;attribute name="dataProcessing_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dataProcessingOrderElement"
    })
    public static class DataProcessingOrder {

        @XmlElement(name = "DataProcessingOrderElement", required = true)
        protected AssayType.DataProcessingOrder.DataProcessingOrderElement dataProcessingOrderElement;

        /**
         * Gets the value of the dataProcessingOrderElement property.
         * 
         * @return
         *     possible object is
         *     {@link AssayType.DataProcessingOrder.DataProcessingOrderElement }
         *     
         */
        public AssayType.DataProcessingOrder.DataProcessingOrderElement getDataProcessingOrderElement() {
            return dataProcessingOrderElement;
        }

        /**
         * Sets the value of the dataProcessingOrderElement property.
         * 
         * @param value
         *     allowed object is
         *     {@link AssayType.DataProcessingOrder.DataProcessingOrderElement }
         *     
         */
        public void setDataProcessingOrderElement(AssayType.DataProcessingOrder.DataProcessingOrderElement value) {
            this.dataProcessingOrderElement = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="rank" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
         *       &lt;attribute name="dataProcessing_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class DataProcessingOrderElement {

            @XmlAttribute(required = true)
            @XmlSchemaType(name = "anySimpleType")
            protected String rank;
            @XmlAttribute(name = "dataProcessing_ref", required = true)
            @XmlIDREF
            @XmlSchemaType(name = "IDREF")
            protected Object dataProcessingRef;

            /**
             * Gets the value of the rank property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRank() {
                return rank;
            }

            /**
             * Sets the value of the rank property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRank(String value) {
                this.rank = value;
            }

            /**
             * Gets the value of the dataProcessingRef property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getDataProcessingRef() {
                return dataProcessingRef;
            }

            /**
             * Sets the value of the dataProcessingRef property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setDataProcessingRef(Object value) {
                this.dataProcessingRef = value;
            }

        }

    }

}
