
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A single entry from an ontology or a controlled vocabulary.
 *
 * <p>
 * Java class for CVParamType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CVParamType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzQuantML/1.0.0}AbstractParamType">
 *       &lt;attribute name="cvRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="accession" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CVParamType")
public class CvParam
        extends AbstractParam {

    private final static long serialVersionUID = 100L;
    /**
     *
     */
    @XmlAttribute(name = "cvRef", required = true)
    protected String cvRef;
    /**
     *
     */
    @XmlAttribute(name = "accession", required = true)
    protected String accession;

    /**
     *
     */
    @XmlTransient
    protected Cv cv;

    /**
     *
     * @return
     */
    public Cv getCv() {
        return cv;
    }

    /**
     *
     * @param cv
     */
    public void setCv(Cv cv) {
        if (cv == null) {
            this.cvRef = null;
        }
        else {
            String refId = cv.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.cvRef = refId;
        }
        this.cv = cv;

    }

    /**
     * Gets the value of the cvRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getCvRef() {
        return cvRef;
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

        CvParam rhs = (CvParam) obj;
        return new EqualsBuilder()
                .append(getCvRef(), rhs.getCvRef())
                .append(getAccession(), rhs.getAccession())
                .append(getName(), rhs.getName())
                .append(getUnitAccession(), rhs.getUnitAccession())
                .append(getUnitCvRef(), rhs.getUnitCvRef())
                .append(getUnitName(), rhs.getUnitName())
                .append(getValue(), rhs.getValue())
                .isEquals();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return new HashCodeBuilder(hash, 37)
                .append(getCvRef())
                .append(getAccession())
                .append(getName())
                .append(getUnitAccession())
                .append(getUnitCvRef())
                .append(getUnitName())
                .append(getValue())
                .hashCode();
    }

}
