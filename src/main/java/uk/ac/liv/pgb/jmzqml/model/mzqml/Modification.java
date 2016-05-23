
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.CvParamListCapable;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * A molecule modification specification. If n modifications have been found on
 * a peptide, there should be n instances of Modification. If multiple
 * modifications are provided as cvParams, it is assumed that the modification
 * is ambiguous i.e. one modification or another. A cvParam must be provided
 * with the identification of the modification sourced from a suitable CV e.g.
 * UNIMOD. If the modification is not present in the CV (and this will be
 * checked by the semantic validator within a given tolerance window), there is
 * an _unknown modification_CV term that must be used instead. A neutral loss
 * should be defined as an additional CVParam within Modification.
 *
 * <p>
 * Java class for ModificationType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="ModificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cvParam" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}CVParamType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="location" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="residues" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfChars" /&gt;
 *       &lt;attribute name="avgMassDelta" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="monoisotopicMassDelta" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModificationType", propOrder = {
    "cvParam"
})
public class Modification
        implements Serializable, MzQuantMLObject, CvParamListCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected List<CvParam> cvParam;
    @XmlAttribute(name = "location")
    protected Integer location;
    @XmlAttribute(name = "residues")
    protected List<String> residues;
    @XmlAttribute(name = "avgMassDelta")
    protected Double avgMassDelta;
    @XmlAttribute(name = "monoisotopicMassDelta")
    protected Double monoisotopicMassDelta;

    /**
     * Gets the value of the cvParam property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cvParam
     * property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCvParam().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CvParam }
     *
     * @return the value of the cvParam property.
     *
     */
    @Override
    public List<CvParam> getCvParam() {
        if (cvParam == null) {
            cvParam = new ArrayList<>();
        }
        return this.cvParam;
    }

    /**
     * Gets the value of the location property.
     *
     * @return
     *         possible object is
     *         {@link Integer }
     *
     */
    public Integer getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value
     *              allowed object is
     *              {@link Integer }
     *
     */
    public void setLocation(Integer value) {
        this.location = value;
    }

    /**
     * Gets the value of the residues property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the residues
     * property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResidues().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the residues property.
     */
    public List<String> getResidues() {
        if (residues == null) {
            residues = new ArrayList<>();
        }
        return this.residues;
    }

    /**
     * Gets the value of the avgMassDelta property.
     *
     * @return
     *         possible object is
     *         {@link Double }
     *
     */
    public Double getAvgMassDelta() {
        return avgMassDelta;
    }

    /**
     * Sets the value of the avgMassDelta property.
     *
     * @param value
     *              allowed object is
     *              {@link Double }
     *
     */
    public void setAvgMassDelta(Double value) {
        this.avgMassDelta = value;
    }

    /**
     * Gets the value of the monoisotopicMassDelta property.
     *
     * @return
     *         possible object is
     *         {@link Double }
     *
     */
    public Double getMonoisotopicMassDelta() {
        return monoisotopicMassDelta;
    }

    /**
     * Sets the value of the monoisotopicMassDelta property.
     *
     * @param value
     *              allowed object is
     *              {@link Double }
     *
     */
    public void setMonoisotopicMassDelta(Double value) {
        this.monoisotopicMassDelta = value;
    }

}
