
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
 * One protein that has been quantified in the file, including references to peptides on which the quantification is based.
 *
 * <p>
 * Java class for ProteinType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProteinType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdentificationRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}IdentificationRefType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PeptideConsensus_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" minOccurs="0"/&gt;
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="accession" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="searchDatabase_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinType", propOrder = {
    "identificationRef",
    "peptideConsensusRefs",
    "paramGroup"
})
public class Protein
        extends IdOnly
        implements ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "IdentificationRef")
    protected List<IdentificationRef> identificationRef;
    @XmlList
    @XmlElement(name = "PeptideConsensus_refs")
    protected List<String> peptideConsensusRefs;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlAttribute(name = "accession", required = true)
    protected String accession;
    @XmlAttribute(name = "searchDatabase_ref", required = true)
    protected String searchDatabaseRef;
    @XmlTransient
    protected List<PeptideConsensus> peptideConsensuses;
    @XmlTransient
    protected SearchDatabase searchDatabase;

    /**
     * Gets the list of PeptideConsensus of the Protein.
     *
     * @return the list of PeptideConsensus of the Protein.
     */
    public List<PeptideConsensus> getPeptideConsensuses() {
        if (peptideConsensuses == null) {
            peptideConsensuses = new ArrayList<>();
        }
        return peptideConsensuses;
    }

    /**
     * Sets the list of PeptideConsensus to the Protein.
     *
     * @param peptideConsensuses a list of PeptideConsensus.
     */
    public void setPeptideConsensuses(List<PeptideConsensus> peptideConsensuses) {
        if (peptideConsensuses == null) {
            this.peptideConsensusRefs = null;
        }
        else {
            this.peptideConsensusRefs = new ArrayList<>();
            for (PeptideConsensus peptideConsensus : peptideConsensuses) {
                String refId = peptideConsensus.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.peptideConsensusRefs.add(refId);
            }
        }
        this.peptideConsensuses = peptideConsensuses;
    }

    /**
     * Gets the searchDatabase of the Protein.
     *
     * @return the searchDatabase of the Protein.
     */
    public SearchDatabase getSearchDatabase() {
        return searchDatabase;
    }

    /**
     * Sets the searchDatabase to the Protein.
     *
     * @param searchDatabase a searchDatabase.
     */
    public void setSearchDatabase(SearchDatabase searchDatabase) {
        if (searchDatabase == null) {
            this.searchDatabaseRef = null;
        }
        else {
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
     * Gets the value of the peptideConsensusRefs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the peptideConsensusRefs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeptideConsensusRefs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the peptideConsensusRefs property.
     */
    public List<String> getPeptideConsensusRefs() {
        if (peptideConsensusRefs == null) {
            peptideConsensusRefs = new ArrayList<>();
        }
        return this.peptideConsensusRefs;
    }

    /**
     * Additional parameters or values about this protein.Gets the value of the paramGroup property.
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
     * Gets the value of the accession property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getAccession() {
        return accession;
    }

    /**
     * Sets the value of the accession property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setAccession(String value) {
        this.accession = value;
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
