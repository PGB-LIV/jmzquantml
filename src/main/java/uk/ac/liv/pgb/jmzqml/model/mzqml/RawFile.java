
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.ParamGroupCapable;
import uk.ac.liv.pgb.jmzqml.model.utils.FacadeList;

/**
 * A raw mass spectrometry output file that has been analysed e.g. in mzML
 * format. The same raw file can be referenced in multiple assays, for example
 * if it contains multiple samples differentially labelled or tagged. Note, the
 * name raw file does not necessarily imply that the file has not been
 * processed, since in some quant methods, processed peak list formats such as
 * MGF or DTA can be used, which could be referenced here.
 *
 * <p>
 * Java class for RawFileType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="RawFileType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ExternalDataType"&gt;
 *       &lt;group ref="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;attribute name="methodFile_ref" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RawFileType", propOrder = {
    "paramGroup"
})
public class RawFile
        extends ExternalData
        implements ParamGroupCapable {

    private final static long serialVersionUID = 100L;
    @XmlElements({
        @XmlElement(name = "cvParam", type = CvParam.class),
        @XmlElement(name = "userParam", type = UserParam.class)
    })
    protected List<AbstractParam> paramGroup;
    @XmlAttribute(name = "methodFile_ref")
    protected String methodFileRef;
    @XmlTransient
    protected MethodFile methodFile;

    /**
     * Gets the value of methodFile of RawFile.
     *
     * @return the value of methodFile of RawFile.
     */
    public MethodFile getMethodFile() {
        return methodFile;
    }

    /**
     * Sets the value of methodFile to RawFile.
     *
     * @param methodFile the value of methodFile.
     */
    public void setMethodFile(MethodFile methodFile) {
        if (methodFile == null) {
            this.methodFileRef = null;
        } else {
            String refId = methodFile.getId();
            if (refId == null) {
                throw new IllegalArgumentException(
                        "Referenced object does not have an identifier.");
            }
            this.methodFileRef = refId;
        }
        this.methodFile = methodFile;
    }

    /**
     * Additional parameters about the raw file.Gets the value of the paramGroup
     * property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paramGroup
     * property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParamGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CvParam }
     * {@link UserParam }
     *
     *
     * @return the value of the paramGroup property.
     */
    public List<AbstractParam> getParamGroup() {
        if (paramGroup == null) {
            paramGroup = new ArrayList<>();
        }
        return this.paramGroup;
    }

    /**
     * Gets the value of the methodFileRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getMethodFileRef() {
        return methodFileRef;
    }

    /**
     * Gets the cvParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.pgb.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<CvParam> getCvParam() {
        return new FacadeList<>(this.getParamGroup(), CvParam.class);
    }

    /**
     * Gets the userParams
     *
     * @return possible object is
     *         {@link uk.ac.liv.pgb.jmzqml.model.utils.FacadeList }
     */
    @Override
    public List<UserParam> getUserParam() {
        return new FacadeList<>(this.getParamGroup(), UserParam.class);
    }

}
