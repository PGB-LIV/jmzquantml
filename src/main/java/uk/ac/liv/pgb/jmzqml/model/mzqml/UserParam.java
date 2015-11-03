
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A single user-defined parameter.
 *
 * <p>
 * Java class for UserParamType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UserParamType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzQuantML/1.0.0}AbstractParamType">
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserParamType")
public class UserParam
        extends AbstractParam
        implements Serializable {

    private final static long serialVersionUID = 100L;
    /**
     *
     */
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the type property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        UserParam rhs = (UserParam) obj;
        return new EqualsBuilder()
                .append(getName(), rhs.getName())
                .append(getType(), rhs.getType())
                .append(getUnitAccession(), rhs.getUnitAccession())
                .append(getUnitCvRef(), rhs.getUnitCvRef())
                .append(getUnitName(), rhs.getUnitName())
                .append(getValue(), rhs.getValue())
                .isEquals();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return new HashCodeBuilder(hash, 61)
                .append(getName())
                .append(getType())
                .append(getUnitAccession())
                .append(getUnitCvRef())
                .append(getUnitName())
                .append(getValue())
                .hashCode();
    }

}
