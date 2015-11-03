
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.pgb.jmzqml.model.ParamListCapable;

/**
 * The setup of a ratio of study variables or assays that is referenced elsewhere in the file. It is expected that the numerator and denominator MUST both be Assays or MUST both be StudyVariables. However, StudyVariables MAY contain 1 to many Assays, thus allowing more complex ratios to be constructed if needed via use of StudyVariables with unbalanced numbers of Assays.
 *
 * <p>Java class for RatioType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RatioType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RatioCalculation" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamListType" minOccurs="0"/>
 *         &lt;element name="NumeratorDataType" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}cvParamRefType"/>
 *         &lt;element name="DenominatorDataType" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}cvParamRefType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="numerator_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="denominator_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RatioType", propOrder = {
    "ratioCalculation",
    "numeratorDataType",
    "denominatorDataType"
})
public class Ratio
extends IdOnly
        implements Serializable, MzQuantMLObject, ParamListCapable {

    private final static long serialVersionUID = 100L;
    /**
     *
     */
    @XmlElement(name = "RatioCalculation")
    protected ParamList ratioCalculation;
    /**
     *
     */
    @XmlElement(name = "NumeratorDataType", required = true)
    protected CvParamRef numeratorDataType;
    /**
     *
     */
    @XmlElement(name = "DenominatorDataType", required = true)
    protected CvParamRef denominatorDataType;
    /**
     *
     */
    @XmlAttribute(name = "numerator_ref", required = true)
    protected String numeratorRef;
    /**
     *
     */
    @XmlAttribute(name = "denominator_ref", required = true)
    protected String denominatorRef;
    /**
     *
     */
    @XmlAttribute(name = "name")
    protected String name;
    /**
     *
     */
    @XmlTransient
    protected IdOnly numerator;
    /**
     *
     */
    @XmlTransient
    protected IdOnly denominator;

    /**
     *
     * @return
     */
    public IdOnly getNumerator() {
        return numerator;
    }

    /**
     *
     * @param numerator
     */
    public void setNumerator(IdOnly numerator) {
        if (numerator == null) {
            this.numeratorRef = null;
        }
        else {
            String refId = numerator.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.numeratorRef = refId;
        }
        this.numerator = numerator;
    }

    /**
     *
     * @return
     */
    public IdOnly getDenominator() {
        return denominator;
    }

    /**
     *
     * @param denominator
     */
    public void setDenominator(IdOnly denominator) {
        if (denominator == null) {
            this.denominatorRef = null;
        }
        else {
            String refId = denominator.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.denominatorRef = refId;
        }
        this.denominator = denominator;
    }

    /**
     * Gets the value of the ratioCalculation property.
     *
     * @return
     *         possible object is
     *         {@link ParamList }
     *
     */
    public ParamList getRatioCalculation() {
        return ratioCalculation;
    }

    /**
     * Sets the value of the ratioCalculation property.
     *
     * @param value
     *              allowed object is
     *              {@link ParamList }
     *
     */
    public void setRatioCalculation(ParamList value) {
        this.ratioCalculation = value;
    }

    /**
     * Gets the value of the numeratorDataType property.
     *
     * @return
     *         possible object is
     *         {@link CvParamRef }
     *
     */
    public CvParamRef getNumeratorDataType() {
        return numeratorDataType;
    }

    /**
     * Sets the value of the numeratorDataType property.
     *
     * @param value
     *              allowed object is
     *              {@link CvParamRef }
     *
     */
    public void setNumeratorDataType(CvParamRef value) {
        this.numeratorDataType = value;
    }

    /**
     * Gets the value of the denominatorDataType property.
     *
     * @return
     *         possible object is
     *         {@link CvParamRef }
     *
     */
    public CvParamRef getDenominatorDataType() {
        return denominatorDataType;
    }

    /**
     * Sets the value of the denominatorDataType property.
     *
     * @param value
     *              allowed object is
     *              {@link CvParamRef }
     *
     */
    public void setDenominatorDataType(CvParamRef value) {
        this.denominatorDataType = value;
    }

    /**
     * Gets the value of the numeratorRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getNumeratorRef() {
        return numeratorRef;
    }

    /**
     * Gets the value of the denominatorRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getDenominatorRef() {
        return denominatorRef;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

}
