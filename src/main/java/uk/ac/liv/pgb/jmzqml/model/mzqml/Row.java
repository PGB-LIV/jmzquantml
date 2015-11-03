
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * One row of data in a data matrix.
 *
 * <p>Java class for RowType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RowType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://psidev.info/psi/pi/mzQuantML/1.0.0>listOfDoublesOrNulls">
 *       &lt;attribute name="object_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RowType", propOrder = {
    "value"
})
public class Row
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlValue
    protected List<String> value;
    @XmlAttribute(name = "object_ref", required = true)
    protected String objectRef;
    @XmlTransient
    protected IdOnly object;

    /**
     * Gets the object of the Row.
     *
     * @return the object of the Row.
     */
    public IdOnly getObject() {
        return object;
    }

    /**
     * Sets the object to the Row.
     *
     * @param object possible object is
     *               {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Protein},
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensus},
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroup},
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMolecule},
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Feature}.
     *
     */
    public void setObject(IdOnly object) {
        if (object == null) {
            this.objectRef = null;
        }
        else {
            String refId = object.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.objectRef = refId;
        }
        this.object = object;
    }

    /**
     * Gets the value of the value property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the value property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the value property.
     */
    public List<String> getValue() {
        if (value == null) {
            value = new ArrayList<>();
        }
        return this.value;
    }

    /**
     * Gets the value of the objectRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getObjectRef() {
        return objectRef;
    }

    /**
     * Sets the value of the objectRef property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setObjectRef(String value) {
        this.objectRef = value;
    }

}
