
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.jmzqml.model.utils.FacadeList;

/**
 * All the features identified on a single raw file or raw file group.
 *
 * <p>Java class for FeatureListType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FeatureListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Feature" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}FeatureType" maxOccurs="unbounded"/>
 *         &lt;element name="FeatureQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}GlobalQuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MS2AssayQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MS2StudyVariableQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MS2RatioQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}RatioQuantLayerType" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rawFilesGroup_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureListType", propOrder = {
    "feature",
    "featureQuantLayer",
    "ms2AssayQuantLayer",
    "ms2StudyVariableQuantLayer",
    "ms2RatioQuantLayer",
    "paramGroup"
})
public class FeatureList
        extends IdOnly
        implements Serializable, MzQuantMLObject, ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Feature", required = true)
    protected List<Feature> feature;
    @XmlElement(name = "FeatureQuantLayer")
    protected List<GlobalQuantLayer> featureQuantLayer;
    @XmlElement(name = "MS2AssayQuantLayer")
    protected List<QuantLayer> ms2AssayQuantLayer;
    @XmlElement(name = "MS2StudyVariableQuantLayer")
    protected List<QuantLayer> ms2StudyVariableQuantLayer;
    @XmlElement(name = "MS2RatioQuantLayer")
    protected RatioQuantLayer ms2RatioQuantLayer;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlAttribute(name = "rawFilesGroup_ref", required = true)
    protected String rawFilesGroupRef;
    @XmlTransient
    protected RawFilesGroup rawFilesGroup;

    public RawFilesGroup getRawFilesGroup() {
        return rawFilesGroup;
    }

    public void setRawFilesGroup(RawFilesGroup rawFilesGroup) {
        if (rawFilesGroup == null) {
            this.rawFilesGroupRef = null;
        }
        else {
            String refId = rawFilesGroup.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.rawFilesGroupRef = refId;
        }
        this.rawFilesGroup = rawFilesGroup;
    }

    /**
     * Gets the value of the feature property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the feature property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeature().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Feature }
     *
     *
     */
    public List<Feature> getFeature() {
        if (feature == null) {
            feature = new ArrayList<Feature>();
        }
        return this.feature;
    }

    /**
     * Gets the value of the featureQuantLayer property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the featureQuantLayer property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureQuantLayer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlobalQuantLayer }
     *
     *
     */
    public List<GlobalQuantLayer> getFeatureQuantLayer() {
        if (featureQuantLayer == null) {
            featureQuantLayer = new ArrayList<GlobalQuantLayer>();
        }
        return this.featureQuantLayer;
    }

    /**
     * Gets the value of the ms2AssayQuantLayer property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the ms2AssayQuantLayer property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMS2AssayQuantLayer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayer }
     *
     *
     */
    public List<QuantLayer> getMS2AssayQuantLayer() {
        if (ms2AssayQuantLayer == null) {
            ms2AssayQuantLayer = new ArrayList<QuantLayer>();
        }
        return this.ms2AssayQuantLayer;
    }

    /**
     * Gets the value of the ms2StudyVariableQuantLayer property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the ms2StudyVariableQuantLayer property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMS2StudyVariableQuantLayer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayer }
     *
     *
     */
    public List<QuantLayer> getMS2StudyVariableQuantLayer() {
        if (ms2StudyVariableQuantLayer == null) {
            ms2StudyVariableQuantLayer = new ArrayList<QuantLayer>();
        }
        return this.ms2StudyVariableQuantLayer;
    }

    /**
     * Gets the value of the ms2RatioQuantLayer property.
     *
     * @return
     *         possible object is
     *         {@link RatioQuantLayer }
     *
     */
    public RatioQuantLayer getMS2RatioQuantLayer() {
        return ms2RatioQuantLayer;
    }

    /**
     * Sets the value of the ms2RatioQuantLayer property.
     *
     * @param value
     *              allowed object is
     *              {@link RatioQuantLayer }
     *
     */
    public void setMS2RatioQuantLayer(RatioQuantLayer value) {
        this.ms2RatioQuantLayer = value;
    }

    /**
     * CV terms for the FeatureList, such as the MassTrace encoding scheme.Gets the value of the paramGroup property.
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

    /**
     * Gets the value of the rawFilesGroupRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getRawFilesGroupRef() {
        return rawFilesGroupRef;
    }

//    /**
//     * Sets the value of the rawFilesGroupRef property.
//     *
//     * @param value
//     *              allowed object is
//     *              {@link String }
//     *
//     */
//    public void setRawFilesGroupRef(String value) {
//        this.rawFilesGroupRef = value;
//    }

    @Override
    public List<CvParam> getCvParam() {
        return new FacadeList<CvParam>(this.getParamGroup(), CvParam.class);
    }

    @Override
    public List<UserParam> getUserParam() {
        return new FacadeList<UserParam>(this.getParamGroup(), UserParam.class);
    }

}
