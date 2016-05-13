
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.pgb.jmzqml.model.utils.FacadeList;

/**
 * The list of all groups of proteins with conflicting evidence for which quantitation values are being reported along with quantitative values about those protein groups. If quantitation is done on individual proteins only, ProteinGroupsList should not be included.
 *
 * <p>
 * Java class for ProteinGroupListType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProteinGroupListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProteinGroup" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ProteinGroupType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="GlobalQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}GlobalQuantLayerType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AssayQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="StudyVariableQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RatioQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}RatioQuantLayerType" minOccurs="0"/&gt;
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ProteinGroupListType", propOrder = {
    "proteinGroup",
    "globalQuantLayer",
    "assayQuantLayer",
    "studyVariableQuantLayer",
    "ratioQuantLayer",
    "paramGroup"
})
public class ProteinGroupList
        extends IdOnly
        implements ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ProteinGroup", required = true)
    protected List<ProteinGroup> proteinGroup;
    @XmlElement(name = "GlobalQuantLayer")
    protected List<GlobalQuantLayer> globalQuantLayer;
    @XmlElement(name = "AssayQuantLayer")
    protected List<QuantLayer<IdOnly>> assayQuantLayer;
    @XmlElement(name = "StudyVariableQuantLayer")
    protected List<QuantLayer<IdOnly>> studyVariableQuantLayer;
    @XmlElement(name = "RatioQuantLayer")
    protected RatioQuantLayer ratioQuantLayer;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;

    /**
     * Gets the value of the proteinGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proteinGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProteinGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProteinGroup }
     *
     *
     * @return the value of the proteinGroup property.
     */
    public List<ProteinGroup> getProteinGroup() {
        if (proteinGroup == null) {
            proteinGroup = new ArrayList<>();
        }
        return this.proteinGroup;
    }

    /**
     * Gets the value of the globalQuantLayer property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the globalQuantLayer property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGlobalQuantLayer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GlobalQuantLayer }
     *
     *
     * @return the value of the globalQuantLayer property.
     */
    public List<GlobalQuantLayer> getGlobalQuantLayer() {
        if (globalQuantLayer == null) {
            globalQuantLayer = new ArrayList<>();
        }
        return this.globalQuantLayer;
    }

    /**
     * Gets the value of the assayQuantLayer property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assayQuantLayer property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssayQuantLayer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayer }
     *
     *
     * @return the value of the assayQuantLayer property.
     */
    public List<QuantLayer<IdOnly>> getAssayQuantLayer() {
        if (assayQuantLayer == null) {
            assayQuantLayer = new ArrayList<>();
        }
        return assayQuantLayer;
    }

    /**
     * Gets the value of the studyVariableQuantLayer property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studyVariableQuantLayer property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudyVariableQuantLayer().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayer }
     *
     *
     * @return the value of studyVariableQuantLayer property.
     */
    public List<QuantLayer<IdOnly>> getStudyVariableQuantLayer() {
        if (studyVariableQuantLayer == null) {
            studyVariableQuantLayer = new ArrayList<>();
        }
        return studyVariableQuantLayer;
    }

    /**
     * Gets the value of the ratioQuantLayer property.
     *
     * @return
     *         possible object is
     *         {@link RatioQuantLayer }
     *
     */
    public RatioQuantLayer getRatioQuantLayer() {
        return ratioQuantLayer;
    }

    /**
     * Sets the value of the ratioQuantLayer property.
     *
     * @param value
     *              allowed object is
     *              {@link RatioQuantLayer }
     *
     */
    public void setRatioQuantLayer(RatioQuantLayer value) {
        this.ratioQuantLayer = value;
    }

    /**
     * CV terms for the entire list.Gets the value of the paramGroup property.
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
