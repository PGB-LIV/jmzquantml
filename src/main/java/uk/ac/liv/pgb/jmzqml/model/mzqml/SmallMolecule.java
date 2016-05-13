
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.pgb.jmzqml.model.utils.FacadeList;

/**
 * An element to represent a unique identifier of a small molecule for which quantitative values are reported.
 *
 * <p>
 * Java class for SmallMoleculeType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SmallMoleculeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Modification" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}SmallMolModificationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DBIdentificationRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}DBIdentificationRefType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Feature_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" minOccurs="0"/&gt;
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SmallMoleculeType", propOrder = {
    "modification",
    "dbIdentificationRef",
    "featureRefs",
    "paramGroup"
})
public class SmallMolecule
        extends IdOnly
        implements ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Modification")
    protected List<SmallMolModification> modification;
    @XmlElement(name = "DBIdentificationRef")
    protected List<DBIdentificationRef> dbIdentificationRef;
    @XmlList
    @XmlElement(name = "Feature_refs")
    protected List<String> featureRefs;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlTransient
    protected List<Feature> features;

    /**
     * Gets the list of features of the SmallMolecule element.
     *
     * @return a list of features of the SmallMolecule element.
     */
    public List<Feature> getFeatures() {
        if (features == null) {
            features = new ArrayList<>();
        }
        return features;
    }

    /**
     * Gets the list of features of the SmallMolecule element.
     *
     * @param features a list of features of the SmallMolecule element.
     */
    public void setFeatures(List<Feature> features) {
        if (features == null) {
            this.featureRefs = null;
        }
        else {
            this.featureRefs = new ArrayList<>();
            for (Feature feature : features) {
                String refId = feature.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.featureRefs.add(refId);
            }
        }
        this.features = features;
    }

    /**
     * Gets the value of the modification property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modification property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModification().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SmallMolModification }
     *
     * @return the value of the modification property.
     */
    public List<SmallMolModification> getModification() {
        if (modification == null) {
            modification = new ArrayList<>();
        }
        return this.modification;
    }

    /**
     * Gets the value of the dbIdentificationRef property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbIdentificationRef property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDBIdentificationRef().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DBIdentificationRef }
     *
     * @return the value of the dbIdentificationRef property.
     */
    public List<DBIdentificationRef> getDBIdentificationRef() {
        if (dbIdentificationRef == null) {
            dbIdentificationRef = new ArrayList<>();
        }
        return this.dbIdentificationRef;
    }

    /**
     * Gets the value of the featureRefs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureRefs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureRefs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the featureRefs property.
     */
    public List<String> getFeatureRefs() {
        if (featureRefs == null) {
            featureRefs = new ArrayList<>();
        }
        return this.featureRefs;
    }

    /**
     * Additional parameters or values about this small molecule.Gets the value of the paramGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paramGroup property.
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
     * Gets the cvParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.pgb.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<CvParam> getCvParam() {
        return new FacadeList<>(this.getParamGroup(), CvParam.class);
    }

    /**
     * Gets the userParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.pgb.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<UserParam> getUserParam() {
        return new FacadeList<>(this.getParamGroup(), UserParam.class);
    }

}
