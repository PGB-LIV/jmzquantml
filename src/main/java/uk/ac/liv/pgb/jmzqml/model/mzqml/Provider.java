
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * The provider of the document in terms of the Contact and the software the produced the document instance.
 *
 * <p>
 * Java class for ProviderType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProviderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://psidev.info/psi/pi/mzQuantML/1.0.0}IdentifiableType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ContactRole" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ContactRoleType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="analysisSoftware_ref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderType", propOrder = {
    "contactRole"
})
public class Provider
        extends Identifiable {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "ContactRole")
    protected ContactRole contactRole;
    @XmlAttribute(name = "analysisSoftware_ref")
    protected String analysisSoftwareRef;
    /**
     *
     */
    @XmlTransient
    protected Software software;

    /**
     *
     * @return software
     */
    public Software getSoftware() {
        return software;
    }

    /**
     *
     * @param software software
     */
    public void setSoftware(Software software) {
        if (software == null) {
            this.analysisSoftwareRef = null;
        } else {
            String refId = software.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.analysisSoftwareRef = refId;
        }
        this.software = software;
    }

    /**
     * Gets the value of the contactRole property.
     *
     * @return
     *         possible object is
     *         {@link ContactRole }
     *
     */
    public ContactRole getContactRole() {
        return contactRole;
    }

    /**
     * Sets the value of the contactRole property.
     *
     * @param value
     *              allowed object is
     *              {@link ContactRole }
     *
     */
    public void setContactRole(ContactRole value) {
        this.contactRole = value;
    }

    /**
     * Gets the value of the analysisSoftwareRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getSoftwareRef() {
        return analysisSoftwareRef;
    }

}
