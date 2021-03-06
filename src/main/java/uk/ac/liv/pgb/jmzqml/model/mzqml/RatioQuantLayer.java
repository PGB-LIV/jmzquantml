
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * A collection of data relating to the objects within the parent list type
 * (e.g. PeptideConsensus, Protein or ProteinGroup)
 *
 * <p>
 * Java class for RatioQuantLayerType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="RatioQuantLayerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ColumnIndex" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings"/&gt;
 *         &lt;element name="DataMatrix" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}DataMatrixType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
        extends IdOnly {

    private final static long serialVersionUID = 100L;
    @XmlList
    @XmlElement(name = "ColumnIndex", required = true)
    protected List<String> columnIndex;
    @XmlElement(name = "DataMatrix", required = true)
    protected DataMatrix dataMatrix;
    @XmlTransient
    protected List<Ratio> columns;

    /**
     * Gets list of column of the RatioQuantLayer.
     *
     * @return list of column of the RatioQuatnLayer.
     */
    public List<Ratio> getColumns() {
        if (columns == null) {
            columns = new ArrayList<>();
        }
        return columns;
    }

    /**
     * Sets the list of column to the RatioQuantLayer.
     *
     * @param columns a list of column.
     */
    public void setColumnIndex(List<Ratio> columns) {
        if (columns == null) {
            this.columnIndex = null;
        } else {
            for (Ratio column : columns) {
                String refId = column.getId();
                if (refId == null) {
                    throw new IllegalArgumentException(
                            "Referenced object does not have an identifier.");
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
     * This is why there is not a <CODE>set</CODE> method for the columnIndex
     * property.
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
     * @return the value of the columnIndex property.
     */
    public List<String> getColumnIndex() {
        if (columnIndex == null) {
            columnIndex = new ArrayList<>();
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
