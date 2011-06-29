//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.29 at 02:00:54 PM BST 
//


package info.psidev.psi.pi.mzquantml._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A reference to a cell in another QuantLayer
 * 
 * <p>Java class for QLCellRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QLCellRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="quantLayer_Ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="col" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="row" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QLCellRefType")
public class QLCellRefType {

    @XmlAttribute(name = "quantLayer_Ref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object quantLayerRef;
    @XmlAttribute(required = true)
    protected int col;
    @XmlAttribute(required = true)
    protected int row;

    /**
     * Gets the value of the quantLayerRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getQuantLayerRef() {
        return quantLayerRef;
    }

    /**
     * Sets the value of the quantLayerRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setQuantLayerRef(Object value) {
        this.quantLayerRef = value;
    }

    /**
     * Gets the value of the col property.
     * 
     */
    public int getCol() {
        return col;
    }

    /**
     * Sets the value of the col property.
     * 
     */
    public void setCol(int value) {
        this.col = value;
    }

    /**
     * Gets the value of the row property.
     * 
     */
    public int getRow() {
        return row;
    }

    /**
     * Sets the value of the row property.
     * 
     */
    public void setRow(int value) {
        this.row = value;
    }

}
