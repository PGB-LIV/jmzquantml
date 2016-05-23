
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
 * An element representing a peptide in different assays that may or may not
 * have been identified. If it has been identified, the sequence and
 * modification(s) SHOULD be reported. Within the parent list, it is allowed for
 * there to be multiple instances of the same peptide sequence, for example
 * capturing different charge states or different modifications, if they are
 * differentially quantified. If peptides with different charge states are
 * aggregated, they should be represented by a single PeptideConsensus element.
 *
 * <p>
 * Java class for PeptideConsensusType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="PeptideConsensusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PeptideSequence" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}sequence" minOccurs="0"/&gt;
 *         &lt;element name="Modification" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ModificationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="EvidenceRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}EvidenceRefType" maxOccurs="unbounded"/&gt;
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="charge" use="required" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfIntegers" /&gt;
 *       &lt;attribute name="searchDatabase_ref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeptideConsensusType", propOrder = {
    "peptideSequence",
    "modification",
    "evidenceRef",
    "paramGroup"
})
public class PeptideConsensus
        extends IdOnly
        implements ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "PeptideSequence")
    protected String peptideSequence;
    @XmlElement(name = "Modification")
    protected List<Modification> modification;
    @XmlElement(name = "EvidenceRef", required = true)
    protected List<EvidenceRef> evidenceRef;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlAttribute(name = "charge", required = true)
    protected List<String> charge;
    @XmlAttribute(name = "searchDatabase_ref")
    protected String searchDatabaseRef;
    @XmlTransient
    protected SearchDatabase searchDatabase;

    /**
     * Gets the SearchDatabase of the PeptideConsensus.
     *
     * @return the SearchDatabase of the PeptideConsensus.
     */
    public SearchDatabase getSearchDatabase() {
        return searchDatabase;
    }

    /**
     * Sets the SearchDatabase to the PeptideConsensus.
     *
     * @param searchDatabase a SearchDatabase.
     */
    public void setSearchDatabase(SearchDatabase searchDatabase) {
        if (searchDatabase == null) {
            this.searchDatabaseRef = null;
        } else {
            String refId = searchDatabase.getId();
            if (refId == null) {
                throw new IllegalArgumentException(
                        "Referenced object does not have an identifier.");
            }
            this.searchDatabaseRef = refId;
        }
        this.searchDatabase = searchDatabase;
    }

    /**
     * Gets the value of the peptideSequence property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getPeptideSequence() {
        return peptideSequence;
    }

    /**
     * Sets the value of the peptideSequence property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setPeptideSequence(String value) {
        this.peptideSequence = value;
    }

    /**
     * Gets the value of the modification property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modification
     * property.
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
     * {@link Modification }
     *
     *
     * @return the value of the modification property.
     */
    public List<Modification> getModification() {
        if (modification == null) {
            modification = new ArrayList<>();
        }
        return this.modification;
    }

    /**
     * Gets the value of the evidenceRef property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evidenceRef
     * property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvidenceRef().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvidenceRef }
     *
     *
     * @return the value of the evidenceRef property.
     */
    public List<EvidenceRef> getEvidenceRef() {
        if (evidenceRef == null) {
            evidenceRef = new ArrayList<>();
        }
        return this.evidenceRef;
    }

    /**
     * Additional parameters or values about this peptide.Gets the value of the
     * paramGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paramGroup
     * property.
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
     * Gets the value of the charge property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the charge
     * property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharge().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the charge property.
     */
    public List<String> getCharge() {
        if (charge == null) {
            charge = new ArrayList<>();
        }
        return this.charge;
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
