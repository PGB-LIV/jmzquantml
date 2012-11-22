
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;


/**
 * The datatype and index position of one column of data in the DataMatrix.
 * 
 * <p>Java class for ColumnType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColumnType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataType" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}cvParamRefType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnType", propOrder = {
    "dataType"
})
public class Column
    implements Serializable, MzQuantMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "DataType", required = true)
    protected CvParamRef dataType;
    @XmlAttribute(name = "index", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger index;

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link CvParamRef }
     *     
     */
    public CvParamRef getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CvParamRef }
     *     
     */
    public void setDataType(CvParamRef value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIndex(BigInteger value) {
        this.index = value;
    }

}
