
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.jmzqml.model.utils.FacadeList;


/**
 * The list of all groups of proteins with conflicting evidence for which quantitation values are being reported along with quantitative values about those protein groups. If quantitation is done on individual proteins only, ProteinGroupsList should not be included.
 * 
 * <p>Java class for ProteinGroupListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProteinGroupListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProteinGroup" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}ProteinGroupType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GlobalQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}GlobalQuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AssayQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StudyVariableQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}QuantLayerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RatioQuantLayer" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}QuantLayerType" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
    implements Serializable, MzQuantMLObject, ParamGroupCapable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ProteinGroup")
    protected List<ProteinGroup> proteinGroup;
    @XmlElement(name = "GlobalQuantLayer")
    protected List<GlobalQuantLayer> globalQuantLayer;
    @XmlElement(name = "AssayQuantLayer")
    protected List<QuantLayer> assayQuantLayer;
    @XmlElement(name = "StudyVariableQuantLayer")
    protected List<QuantLayer> studyVariableQuantLayer;
    @XmlElement(name = "RatioQuantLayer")
    protected QuantLayer ratioQuantLayer;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

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
     */
    public List<ProteinGroup> getProteinGroup() {
        if (proteinGroup == null) {
            proteinGroup = new ArrayList<ProteinGroup>();
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
     */
    public List<GlobalQuantLayer> getGlobalQuantLayer() {
        if (globalQuantLayer == null) {
            globalQuantLayer = new ArrayList<GlobalQuantLayer>();
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
     */
    public List<QuantLayer> getAssayQuantLayer() {
        if (assayQuantLayer == null) {
            assayQuantLayer = new ArrayList<QuantLayer>();
        }
        return this.assayQuantLayer;
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
     */
    public List<QuantLayer> getStudyVariableQuantLayer() {
        if (studyVariableQuantLayer == null) {
            studyVariableQuantLayer = new ArrayList<QuantLayer>();
        }
        return this.studyVariableQuantLayer;
    }

    /**
     * Gets the value of the ratioQuantLayer property.
     * 
     * @return
     *     possible object is
     *     {@link QuantLayer }
     *     
     */
    public QuantLayer getRatioQuantLayer() {
        return ratioQuantLayer;
    }

    /**
     * Sets the value of the ratioQuantLayer property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantLayer }
     *     
     */
    public void setRatioQuantLayer(QuantLayer value) {
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
     */
    public List<AbstractParam> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<AbstractParam>();
        }
        return this.paramGroup;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
