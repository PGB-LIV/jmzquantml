
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The list of assays represented by the file, where each assay captures the concept of one sample analysed - this can be one or more raw files.
 *
 * <p>
 * Java class for AssayListType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AssayListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Assay" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}AssayType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "AssayListType", propOrder = {
    "assay"
})
public class AssayList
        extends IdOnly {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Assay", required = true)
    protected List<Assay> assay;

    /**
     * Gets the value of the assay property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assay property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssay().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Assay }
     *
     *
     * @return the value of the assay property.
     */
    public List<Assay> getAssay() {
        if (assay == null) {
            assay = new ArrayList<>();
        }
        return this.assay;
    }

}
