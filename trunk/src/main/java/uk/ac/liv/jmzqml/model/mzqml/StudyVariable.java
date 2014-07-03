
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.jmzqml.model.utils.FacadeList;

/**
 * A logical grouping of assays into conditions or user-defined study variables such as wild-type versus disease or time points in a time course.
 *
 * <p>Java class for StudyVariableType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StudyVariableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Assay_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StudyVariableType", propOrder = {
    "paramGroup",
    "assayRefs"
})
public class StudyVariable
        extends IdOnly
        implements Serializable, MzQuantMLObject, ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlList
    @XmlElement(name = "Assay_refs", required = true)
    protected Set<String> assayRefs;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlTransient
    protected List<Assay> assays;

    /**
     * Get the list of assay of the StudyVariable.
     *
     * @return the list of assay of the StudyVariable.
     */
    public List<Assay> getAssays() {
        if (assays == null) {
            assays = new ArrayList<>();
        }
        return assays;
    }

    /**
     * Set the list of assay to the StudyVariable
     *
     * @param assays a list of assay.
     */
    public void setAssays(List<Assay> assays) {
        if (assays == null) {
            this.assayRefs = null;
        }
        else {
            this.assayRefs = new HashSet<>();
            for (Assay assay : assays) {
                String refId = assay.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.assayRefs.add(refId);
            }
        }
        this.assays = assays;
    }

    /**
     * The type of StudyVariable e.g. Phenotypic, biological replicate, technical replicate, time points etc. and references to all the assays that are part of this study variable.Gets the value of the paramGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the paramGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParamGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CvParam }
     * {@link UserParam }
     *
     *
     * @return the value of the paramGroup property.
     */
    public List<AbstractParam> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<>();
        }
        return this.paramGroup;
    }

    /**
     * Gets the value of the assayRefs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the assayRefs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssayRefs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the assayRefs property.
     */
    public Set<String> getAssayRefs() {
        if (assayRefs == null) {
            assayRefs = new HashSet<>();
        }
        return this.assayRefs;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the cvParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<CvParam> getCvParam() {
        return new FacadeList<>(this.getParamGroup(), CvParam.class);
    }

    /**
     * Gets the userParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<UserParam> getUserParam() {
        return new FacadeList<>(this.getParamGroup(), UserParam.class);
    }

}
