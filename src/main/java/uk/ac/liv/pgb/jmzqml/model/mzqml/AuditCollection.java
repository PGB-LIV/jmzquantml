
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * The complete set of Contacts (people and organisations) for this file.
 *
 * <p>
 * Java class for AuditCollectionType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AuditCollectionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Person" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}PersonType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Organization" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}OrganizationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditCollectionType", propOrder = {
    "person",
    "organization"
})
public class AuditCollection
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Person")
    protected List<Person> person;
    @XmlElement(name = "Organization")
    protected List<Organization> organization;

    /**
     * Gets the value of the person property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the person property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerson().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Person }
     *
     *
     * @return the value of the person property.
     */
    public List<Person> getPerson() {
        if (person == null) {
            person = new ArrayList<>();
        }
        return this.person;
    }

    /**
     * Gets the value of the organization property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organization property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganization().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Organization }
     *
     *
     * @return the value of the organization property.
     */
    public List<Organization> getOrganization() {
        if (organization == null) {
            organization = new ArrayList<>();
        }
        return this.organization;
    }

}
