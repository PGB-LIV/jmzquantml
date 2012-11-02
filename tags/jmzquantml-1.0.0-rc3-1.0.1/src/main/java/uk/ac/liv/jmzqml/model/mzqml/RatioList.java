
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
 * The definition of ratios of study variables or assays, referenced elsewhere in the document.
 * 
 * <p>Java class for RatioListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RatioListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Ratio" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0-rc3}RatioType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RatioListType", propOrder = {
    "ratio"
})
public class RatioList
    implements Serializable, MzQuantMLObject
{

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "Ratio", required = true)
    protected List<Ratio> ratio;

    /**
     * Gets the value of the ratio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ratio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRatio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ratio }
     * 
     * 
     */
    public List<Ratio> getRatio() {
        if (ratio == null) {
            ratio = new ArrayList<Ratio>();
        }
        return this.ratio;
    }

}
