
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
 * One protein that has been quantified in the file, including references to peptides on which the quantification is based.
 *
 * <p>Java class for ProteinType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProteinType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentificationRef" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}IdentificationRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PeptideConsensus_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" minOccurs="0"/>
 *         &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="accession" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="searchDatabase_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
        implements Serializable, MzQuantMLObject, ParamGroupCapable {

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

    public List<PeptideConsensus> getPeptideConsensuses() {
        if (peptideConsensuses == null) {
            peptideConsensuses = new ArrayList<PeptideConsensus>();
        }
        return peptideConsensuses;
    }

    public void setPeptideConsensuses(List<PeptideConsensus> peptideConsensuses) {
        if (peptideConsensuses == null) {
            this.peptideConsensusRefs = null;
        }
        else {
            for (PeptideConsensus peptideConsensus : peptideConsensuses) {
                String refId = peptideConsensus.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.peptideConsensusRefs.add(refId);
            }
            this.peptideConsensuses = peptideConsensuses;
        }
    }

    public SearchDatabase getSearchDatabase() {
        return searchDatabase;
    }

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
     * This is why there is not a
     * <CODE>set</CODE> method for the identificationRef property.
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
     * Gets the value of the peptideConsensusRefs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the peptideConsensusRefs property.
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
     */
    public List<String> getPeptideConsensusRefs() {
        if (peptideConsensusRefs == null) {
            peptideConsensusRefs = new ArrayList<String>();
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

    @Override
    public List<CvParam> getCvParam() {
        return new FacadeList<CvParam>(this.getParamGroup(), CvParam.class);
    }

    @Override
    public List<UserParam> getUserParam() {
        return new FacadeList<UserParam>(this.getParamGroup(), UserParam.class);
    }

}
