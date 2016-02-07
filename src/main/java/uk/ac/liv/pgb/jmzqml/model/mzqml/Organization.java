
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Organizations are entities like companies, universities, government agencies. Any additional information such as the address, email etc. should be supplied either as CV parameters or as user parameters.
 *
 * <p>
 * Java class for OrganizationType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OrganizationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzQuantML/1.0.0}AbstractContactType">
 *       &lt;sequence>
 *         &lt;element name="ParentOrganization" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParentOrganizationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationType", propOrder = {
    "parentOrganization"
})
public class Organization
        extends AbstractContact {

    private final static long serialVersionUID = 100L;
    /**
     *
     */
    @XmlElement(name = "ParentOrganization")
    protected ParentOrganization parentOrganization;

    /**
     * Gets the value of the parentOrganization property.
     *
     * @return
     *         possible object is
     *         {@link ParentOrganization }
     *
     */
    public ParentOrganization getParentOrganization() {
        return parentOrganization;
    }

    /**
     * Sets the value of the parentOrganization property.
     *
     * @param value
     *              allowed object is
     *              {@link ParentOrganization }
     *
     */
    public void setParentOrganization(ParentOrganization value) {
        this.parentOrganization = value;
    }

}
