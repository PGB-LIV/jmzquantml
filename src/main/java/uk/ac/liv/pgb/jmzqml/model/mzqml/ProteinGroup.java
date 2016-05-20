
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.pgb.jmzqml.model.utils.FacadeList;

/**
 * A grouping of quantified proteins based on ambiguous assignment of peptide evidence to protein identification. The semantics of elements within the group, such as a leading protein or those sharing equal evidence can be reported using cvParams.
 *
 * <p>
 * Java class for ProteinGroupType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProteinGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdentificationRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}IdentificationRefType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ProteinRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ProteinRefType" maxOccurs="unbounded"/&gt;
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="searchDatabase_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
        extends IdOnly
        implements ParamGroupCapable {

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
    @XmlAttribute(name = "searchDatabase_ref", required = true)
    protected String searchDatabaseRef;
    @XmlTransient
    protected SearchDatabase searchDatabase;

    /**
     * Gets the SearchDatabase of the ProteinGroup.
     *
     * @return the SearchDatabase of the ProteinGroup.
     */
    public SearchDatabase getSearchDatabase() {
        return searchDatabase;
    }

    /**
     * Sets the SearchDatabase to the ProteinGroup.
     *
     * @param searchDatabase a SearchDatabase.
     */
    public void setSearchDatabase(SearchDatabase searchDatabase) {
        if (searchDatabase == null) {
            this.searchDatabaseRef = null;
        } else {
            String refId = searchDatabase.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.searchDatabaseRef = refId;
        }
        this.searchDatabase = searchDatabase;
    }

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
     * @return the value of the identificationRef property.
     */
    public List<IdentificationRef> getIdentificationRef() {
        if (identificationRef == null) {
            identificationRef = new ArrayList<>();
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
     * @return the value of the proteinRef property.
     */
    public List<ProteinRef> getProteinRef() {
        if (proteinRef == null) {
            proteinRef = new ArrayList<>();
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
     * @return the value of the paramGroup property.
     */
    public List<AbstractParam> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<>();
        }
        return this.paramGroup;
    }

    /**
     * Gets the value of the searchDatabaseRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getSearchDatabaseRef() {
        return searchDatabaseRef;
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
