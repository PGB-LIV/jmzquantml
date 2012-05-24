//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.24 at 10:55:39 AM BST 
//


package info.psidev.psi.pi.mzquantml._1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


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
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Person" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc2}PersonType"/>
 *         &lt;element name="Organization" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc2}OrganizationType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuditCollectionType", propOrder = {
    "personOrOrganization"
})
public class AuditCollectionType {

    @XmlElements({
        @XmlElement(name = "Organization", type = OrganizationType.class),
        @XmlElement(name = "Person", type = PersonType.class)
    })
    protected List<AbstractContactType> personOrOrganization;

    /**
     * Gets the value of the personOrOrganization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personOrOrganization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonOrOrganization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationType }
     * {@link PersonType }
     * 
     * 
     */
    public List<AbstractContactType> getPersonOrOrganization() {
        if (personOrOrganization == null) {
            personOrOrganization = new ArrayList<AbstractContactType>();
        }
        return this.personOrOrganization;
    }

}
