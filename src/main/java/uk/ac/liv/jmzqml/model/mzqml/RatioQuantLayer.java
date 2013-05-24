
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;

/**
 * A collection of data relating to the objects within the parent list type (e.g. PeptideConsensus, Protein or ProteinGroup)
 *
 * <p>Java class for RatioQuantLayerType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RatioQuantLayerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ColumnIndex" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings"/>
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
@XmlType(name = "RatioQuantLayerType", propOrder = {
    "columnIndex",
    "dataMatrix"
})
public class RatioQuantLayer
        extends IdOnly
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlList
    @XmlElement(name = "ColumnIndex", required = true)
    protected List<String> columnIndex;
    @XmlElement(name = "DataMatrix", required = true)
    protected DataMatrix dataMatrix;
    @XmlTransient
    protected List<Ratio> columns;

    public List<Ratio> getColumns() {
        if (columns == null) {
            columns = new ArrayList<Ratio>();
        }
        return columns;
    }

    public void setColumnIndex(List<Ratio> columns) {
        if (columns == null) {
            this.columnIndex = null;
        }
        else {
            for (Ratio column : columns) {
                String refId = column.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.columnIndex.add(refId);
            }
        }
        this.columns = columns;
    }

    /**
     * Gets the value of the columnIndex property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the columnIndex property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnIndex().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getColumnIndex() {
        if (columnIndex == null) {
            columnIndex = new ArrayList<String>();
        }
        return this.columnIndex;
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
