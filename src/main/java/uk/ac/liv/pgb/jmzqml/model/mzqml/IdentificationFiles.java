
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * All identification files associated with this quantitation analysis to be
 * referenced elsewhere.
 *
 * <p>
 * Java class for IdentificationFilesType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="IdentificationFilesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IdentificationFile" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}IdentificationFileType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentificationFilesType", propOrder = {
    "identificationFile"
})
public class IdentificationFiles
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "IdentificationFile", required = true)
    protected List<IdentificationFile> identificationFile;

    /**
     * Gets the value of the identificationFile property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the
     * identificationFile property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentificationFile().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationFile }
     *
     *
     * @return the value of the identificationFile property.
     */
    public List<IdentificationFile> getIdentificationFile() {
        if (identificationFile == null) {
            identificationFile = new ArrayList<>();
        }
        return this.identificationFile;
    }

}
