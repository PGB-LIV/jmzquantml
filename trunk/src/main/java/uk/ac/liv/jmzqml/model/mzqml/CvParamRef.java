
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;

/**
 * Helper complexType to include one cvParam as a sub-element
 *
 * <p>Java class for cvParamRefType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="cvParamRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cvParam" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}CVParamType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cvParamRefType", propOrder = {
    "cvParam"
})
public class CvParamRef
        implements Serializable, MzQuantMLObject {

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
    public void setCvParam(CvParam value) {
        this.cvParam = value;
    }

}
