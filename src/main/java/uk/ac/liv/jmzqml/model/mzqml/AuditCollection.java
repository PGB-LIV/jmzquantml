
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;


/**
 * The complete set of Contacts (people and organisations) for this file. 
 * 
 * <p>Java class for AuditCollectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuditCollectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Person" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}PersonType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Organization" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}OrganizationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
    implements Serializable, MzQuantMLObject
{

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
     */
    public List<Person> getPerson() {
        if (person == null) {
            person = new ArrayList<Person>();
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
     */
    public List<Organization> getOrganization() {
        if (organization == null) {
            organization = new ArrayList<Organization>();
        }
        return this.organization;
    }

}
