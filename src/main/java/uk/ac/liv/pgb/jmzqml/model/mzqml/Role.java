
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.CvParamCapable;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * The roles (lab equipment sales, contractor, etc.) the Contact fills.
 *
 *
 * <p>
 * Java class for RoleType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="RoleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cvParam" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}CVParamType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleType", propOrder = {
    "cvParam"
})
public class Role
        implements Serializable, MzQuantMLObject, CvParamCapable {

    private final static long serialVersionUID = 100L;
    @XmlElement(required = true)
    protected CvParam cvParam;

    /**
     * Gets the value of the cvParam property.
     *
     * @return
     *         possible object is
     *         {@link CvParam }
     *
     */
    @Override
    public CvParam getCvParam() {
        return cvParam;
    }

    /**
     * Sets the value of the cvParam property.
     *
     * @param value
     *              allowed object is
     *              {@link CvParam }
     *
     */
    @Override
    public void setCvParam(CvParam value) {
        this.cvParam = value;
    }

}
