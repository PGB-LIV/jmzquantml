
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
 * All methods files associated with this quantitation analysis to be referenced elsewhere, for example used to describe TraML files used in SRM analysis.
 *
 * <p>Java class for MethodFilesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MethodFilesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MethodFile" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}MethodFileType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodFilesType", propOrder = {
    "methodFile"
})
public class MethodFiles
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "MethodFile", required = true)
    protected List<MethodFile> methodFile;

    /**
     * Gets the value of the methodFile property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the methodFile property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodFile().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MethodFile }
     *
     *
     * @return the value of the methodFile property.
     */
    public List<MethodFile> getMethodFile() {
        if (methodFile == null) {
            methodFile = new ArrayList<>();
        }
        return this.methodFile;
    }

}
