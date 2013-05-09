
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 * An element to represent a unique identifier of a small molecule for which quantitative values are reported.
 *
 * <p>Java class for SmallMoleculeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SmallMoleculeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Modification" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}SmallMolModificationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DBIdentificationRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}DBIdentificationRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Feature_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "SmallMoleculeType", propOrder = {
    "modification",
    "dbIdentificationRef",
    "featureRefs",
    "paramGroup"
})
public class SmallMolecule
        extends IdOnly
        implements Serializable, MzQuantMLObject, ParamGroupCapable {

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

    public List<Feature> getFeatures() {
        if (features == null) {
            features = new ArrayList<Feature>();
        }
        return features;
    }

    public void setFeatures(List<Feature> features) {
        if (features == null) {
            this.featureRefs = null;
        }
        else {
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
     * This is why there is not a
     * <CODE>set</CODE> method for the modification property.
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
     *
     */
    public List<SmallMolModification> getModification() {
        if (modification == null) {
            modification = new ArrayList<SmallMolModification>();
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
     * This is why there is not a
     * <CODE>set</CODE> method for the dbIdentificationRef property.
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
     *
     */
    public List<DBIdentificationRef> getDBIdentificationRef() {
        if (dbIdentificationRef == null) {
            dbIdentificationRef = new ArrayList<DBIdentificationRef>();
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
     * This is why there is not a
     * <CODE>set</CODE> method for the featureRefs property.
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
     */
    public List<String> getFeatureRefs() {
        if (featureRefs == null) {
            featureRefs = new ArrayList<String>();
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
     */
    public List<AbstractParam> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<AbstractParam>();
        }
        return this.paramGroup;
    }

    @Override
    public List<CvParam> getCvParam() {
        return new FacadeList<CvParam>(this.getParamGroup(), CvParam.class);
    }

    @Override
    public List<UserParam> getUserParam() {
        return new FacadeList<UserParam>(this.getParamGroup(), UserParam.class);
    }

}
