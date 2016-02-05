
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * A QuantLayer in which different data types are allowed in each column.
 *
 * <p>
 * Java class for GlobalQuantLayerType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GlobalQuantLayerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ColumnDefinition" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ColumnDefinitionType"/>
 *         &lt;element name="DataMatrix" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}DataMatrixType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
public class GlobalQuantLayer
        extends IdOnly {

    private final static long serialVersionUID = 100L;
    /**
     *
     */
    @XmlElement(name = "ColumnDefinition", required = true)
    protected ColumnDefinition columnDefinition;
    /**
     *
     */
    @XmlElement(name = "DataMatrix", required = true)
    protected DataMatrix dataMatrix;

    /**
     * Gets the value of the columnDefinition property.
     *
     * @return
     *         possible object is
     *         {@link ColumnDefinition }
     *
     */
    public ColumnDefinition getColumnDefinition() {
        return columnDefinition;
    }

    /**
     * Sets the value of the columnDefinition property.
     *
     * @param value
     *              allowed object is
     *              {@link ColumnDefinition }
     *
     */
    public void setColumnDefinition(ColumnDefinition value) {
        this.columnDefinition = value;
    }

    /**
     * Gets the value of the dataMatrix property.
     *
     * @return
     *         possible object is
     *         {@link DataMatrix }
     *
     */
    public DataMatrix getDataMatrix() {
        return dataMatrix;
    }

    /**
     * Sets the value of the dataMatrix property.
     *
     * @param value
     *              allowed object is
     *              {@link DataMatrix }
     *
     */
    public void setDataMatrix(DataMatrix value) {
        this.dataMatrix = value;
    }

}
