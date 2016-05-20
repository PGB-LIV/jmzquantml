
package uk.ac.liv.pgb.jmzqml.model.mzqml;

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
import uk.ac.liv.pgb.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.pgb.jmzqml.model.utils.FacadeList;

/**
 * A region on a (potentially) two-dimensional map of MS1 scans, defined by the retention time, mass over charge and optionally a mass trace. Quantitative values about features can be added in the associated QuantLayers. For techniques that analyse data from single scans e.g. MS2 tagging approaches, a Feature corresponds with the mz of the parent ions only.
 *
 * <p>
 * Java class for FeatureType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FeatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MassTrace" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfDoubles" minOccurs="0"/&gt;
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rt" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}doubleOrNullType" /&gt;
 *       &lt;attribute name="mz" use="required" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="charge" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}integerOrNullType" /&gt;
 *       &lt;attribute name="chromatogram_refs" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="spectrum_refs" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="rawFile_ref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureType", propOrder = {
    "massTrace",
    "paramGroup"
})
public class Feature
        extends IdOnly
        implements ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlList
    @XmlElement(name = "MassTrace", type = Double.class)
    protected List<Double> massTrace;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlAttribute(name = "rt", required = true)
    protected String rt;
    @XmlAttribute(name = "mz", required = true)
    protected double mz;
    @XmlAttribute(name = "charge", required = true)
    protected String charge;
    @XmlAttribute(name = "chromatogram_refs")
    protected String chromatogramRefs;
    @XmlAttribute(name = "spectrum_refs")
    protected String spectrumRefs;
    @XmlAttribute(name = "rawFile_ref")
    protected String rawFileRef;
    @XmlTransient
    protected RawFile rawFile;

    /**
     * Gets the RawFile of the Feature.
     *
     * @return the RawFile of the Feature.
     */
    public RawFile getRawFile() {
        return rawFile;
    }

    /**
     * Sets the RawFile to the Feature.
     *
     * @param rawFile a RawFile.
     */
    public void setRawFile(RawFile rawFile) {
        if (rawFile == null) {
            this.rawFileRef = null;
        } else {
            String refId = rawFile.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.rawFileRef = refId;
        }
        this.rawFile = rawFile;
    }

    /**
     * Gets the value of the massTrace property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the massTrace property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMassTrace().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     *
     *
     * @return the value of the massTrace property.
     */
    public List<Double> getMassTrace() {
        if (massTrace == null) {
            massTrace = new ArrayList<>();
        }
        return this.massTrace;
    }

    /**
     * Additional parameters or values about this feature.Gets the value of the paramGroup property.
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
     * Gets the value of the rt property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getRt() {
        return rt;
    }

    /**
     * Sets the value of the rt property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setRt(String value) {
        this.rt = value;
    }

    /**
     * Gets the value of the mz property.
     *
     * @return the value of the mz property.
     */
    public double getMz() {
        return mz;
    }

    /**
     * Sets the value of the mz property.
     *
     * @param value the value of the mz property.
     */
    public void setMz(double value) {
        this.mz = value;
    }

    /**
     * Gets the value of the charge property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setCharge(String value) {
        this.charge = value;
    }

    /**
     * Gets the value of the chromatogramRefs property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getChromatogramRefs() {
        return chromatogramRefs;
    }

    /**
     * Sets the value of the chromatogramRefs property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setChromatogramRefs(String value) {
        this.chromatogramRefs = value;
    }

    /**
     * Gets the value of the spectrumRefs property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getSpectrumRefs() {
        return spectrumRefs;
    }

    /**
     * Sets the value of the spectrumRefs property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setSpectrumRefs(String value) {
        this.spectrumRefs = value;
    }

    /**
     * Gets the value of the rawFileRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getRawFileRef() {
        return rawFileRef;
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
