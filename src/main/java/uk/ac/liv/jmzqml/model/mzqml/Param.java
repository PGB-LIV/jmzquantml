
package uk.ac.liv.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;


/**
 * Helper type to allow either a cvParam or a userParam to be provided for an element.
 * 
 * <p>Java class for ParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParamType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParamType", propOrder = {
    "paramGroup"
})
public class Param
    implements Serializable, MzQuantMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected AbstractParam paramGroup;

    /**
     * Sets the value of the paramGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link CvParam }
     *     {@link UserParam }
     *     
     */
    public void setParam(AbstractParam value) {
        this.paramGroup = value;
    }

    public CvParam getCvParam() {
        if (paramGroup instanceof CvParam) {
            return (CvParam) paramGroup;
        } else {
            return null;
}
    }

    public UserParam getUserParam() {
        if (paramGroup instanceof UserParam) {
            return (UserParam) paramGroup;
        } else {
            return null;
        }
    }
}
