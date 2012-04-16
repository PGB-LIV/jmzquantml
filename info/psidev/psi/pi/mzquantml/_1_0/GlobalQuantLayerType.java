//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.16 at 01:42:41 PM CEST 
//


package de.mpc.MzQuantMLWrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A QuantLayer in which different data types are allowed in each column.
 * 
 * <p>Java class for GlobalQuantLayerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GlobalQuantLayerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ColumnDefinition" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}ColumnDefinitionType"/>
 *         &lt;element name="DataMatrix" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc1}DataMatrixType"/>
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
@XmlType(name = "GlobalQuantLayerType", propOrder = {
    "columnDefinition",
    "dataMatrix"
})
public class GlobalQuantLayerType {

    @XmlElement(name = "ColumnDefinition", required = true)
    protected ColumnDefinitionType columnDefinition;
    @XmlElement(name = "DataMatrix", required = true)
    protected DataMatrixType dataMatrix;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the columnDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnDefinitionType }
     *     
     */
    public ColumnDefinitionType getColumnDefinition() {
        return columnDefinition;
    }

    /**
     * Sets the value of the columnDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnDefinitionType }
     *     
     */
    public void setColumnDefinition(ColumnDefinitionType value) {
        this.columnDefinition = value;
    }

    /**
     * Gets the value of the dataMatrix property.
     * 
     * @return
     *     possible object is
     *     {@link DataMatrixType }
     *     
     */
    public DataMatrixType getDataMatrix() {
        return dataMatrix;
    }

    /**
     * Sets the value of the dataMatrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataMatrixType }
     *     
     */
    public void setDataMatrix(DataMatrixType value) {
        this.dataMatrix = value;
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
