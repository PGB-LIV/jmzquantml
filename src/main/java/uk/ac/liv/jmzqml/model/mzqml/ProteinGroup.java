
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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.jmzqml.model.utils.FacadeList;


/**
 * A grouping of quantified proteins based on ambiguous assignment of peptide evidence to protein identification. The semantics of elements within the group, such as a leading protein or those sharing equal evidence can be reported using cvParams.
 * 
 * <p>Java class for ProteinGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProteinGroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentificationRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}IdentificationRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProteinRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ProteinRefType" maxOccurs="unbounded"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="searchDatabase_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinGroupType", propOrder = {
    "identificationRef",
    "proteinRef",
    "paramGroup"
})
public class ProteinGroup
    implements Serializable, MzQuantMLObject, ParamGroupCapable
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "IdentificationRef")
    protected List<IdentificationRef> identificationRef;
    @XmlElement(name = "ProteinRef", required = true)
    protected List<ProteinRef> proteinRef;
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
    @XmlAttribute(name = "searchDatabase_ref", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object searchDatabaseRef;

    /**
     * Gets the value of the identificationRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identificationRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentificationRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationRef }
     * 
     * 
     */
    public List<IdentificationRef> getIdentificationRef() {
        if (identificationRef == null) {
            identificationRef = new ArrayList<IdentificationRef>();
        }
        return this.identificationRef;
    }

    /**
     * Gets the value of the proteinRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proteinRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProteinRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProteinRef }
     * 
     * 
     */
    public List<ProteinRef> getProteinRef() {
        if (proteinRef == null) {
            proteinRef = new ArrayList<ProteinRef>();
        }
        return this.proteinRef;
    }

    /**
     * Additional parameters or values about this protein group.Gets the value of the paramGroup property.
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

    /**
     * Gets the value of the searchDatabaseRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSearchDatabaseRef() {
        return searchDatabaseRef;
    }

    /**
     * Sets the value of the searchDatabaseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSearchDatabaseRef(Object value) {
        this.searchDatabaseRef = value;
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
