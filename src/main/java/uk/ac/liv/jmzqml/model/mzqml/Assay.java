
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
 * Describes a single analysis of a sample (e.g. with the channel mapping in iTRAQ), which could constitute multiple raw files e.g. if pre-separation steps have occurred.
 *
 * <p>Java class for AssayType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AssayType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Label" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}LabelType"/>
 *         &lt;element name="IdentificationFile_refs" type="{http://www.w3.org/2001/XMLSchema}IDREFS" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rawFilesGroup_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssayType", propOrder = {
    "label",
    "identificationFileRefs",
    "paramGroup"
})
public class Assay
        extends IdOnly
        implements Serializable, MzQuantMLObject, ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Label", required = true)
    protected Label label;
    @XmlList
    @XmlElement(name = "IdentificationFile_refs")
    protected Set<String> identificationFileRefs;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "rawFilesGroup_ref")
    protected String rawFilesGroupRef;
    @XmlTransient
    protected RawFilesGroup rawFilesGroup;
    @XmlTransient
    protected List<IdentificationFile> identificationFiles;

    /**
     * Gets the RawFileGroup of the Assay.
     *
     * @return the RawFileGroup of the Assay.
     */
    public RawFilesGroup getRawFilesGroup() {
        return rawFilesGroup;
    }

    /**
     * Sets the RawFileGroup to the Assay.
     *
     * @param rawFilesGroup a RawFileGroup.
     */
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
     * Gets the list of IdentificationFile of the Assay.
     *
     * @return the list of IdentificationFile of the Assay.
     */
    public List<IdentificationFile> getIdentificationFiles() {
        if (identificationFiles == null) {
            identificationFiles = new ArrayList<IdentificationFile>();
        }
        return identificationFiles;
    }

    /**
     * Sets the list of IdentificationFile to the Assay.
     *
     * @param identificationFiles a list of IdentificationFile.
     */
    public void setIdentificationFiles(
            List<IdentificationFile> identificationFiles) {
        if (identificationFiles == null) {
            this.identificationFileRefs = null;
        }
        else {
            this.identificationFileRefs = new HashSet<>();
            for (IdentificationFile identificationFile : identificationFiles) {
                String refId = identificationFile.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.identificationFileRefs.add(refId);
            }
        }
        this.identificationFiles = identificationFiles;
    }

    /**
     * Gets the value of the label property.
     *
     * @return
     *         possible object is
     *         {@link Label }
     *
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     *
     * @param value
     *              allowed object is
     *              {@link Label }
     *
     */
    public void setLabel(Label value) {
        this.label = value;
    }

    /**
     * Gets the value of the identificationFileRefs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the identificationFileRefs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentificationFileRefs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     *
     *
     * @return the value of the identificationFileRefs property.
     */
    public Set<String> getIdentificationFileRefs() {
        if (identificationFileRefs == null) {
            identificationFileRefs = new HashSet<>();
        }
        return this.identificationFileRefs;
    }

    /**
     * Additional parameters about the Assay.Gets the value of the paramGroup property.
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
            paramGroup = new ArrayList<AbstractParam>();
        }
        return this.paramGroup;
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

    /**
     * Gets the cvParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<CvParam> getCvParam() {
        return new FacadeList<CvParam>(this.getParamGroup(), CvParam.class);
    }

    /**
     * Gets the userParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<UserParam> getUserParam() {
        return new FacadeList<UserParam>(this.getParamGroup(), UserParam.class);
    }

}
