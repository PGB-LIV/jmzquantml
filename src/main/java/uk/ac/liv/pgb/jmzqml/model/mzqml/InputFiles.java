
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
 * All the raw files, identification files and databases used in the quantitation.
 *
 * <p>Java class for InputFilesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="InputFilesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RawFilesGroup" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}RawFilesGroupType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MethodFiles" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}MethodFilesType" minOccurs="0"/>
 *         &lt;element name="IdentificationFiles" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}IdentificationFilesType" minOccurs="0"/>
 *         &lt;element name="SearchDatabase" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}SearchDatabaseType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SourceFile" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}SourceFileType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputFilesType", propOrder = {
    "rawFilesGroup",
    "methodFiles",
    "identificationFiles",
    "searchDatabase",
    "sourceFile"
})
public class InputFiles
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "RawFilesGroup")
    protected List<RawFilesGroup> rawFilesGroup;
    @XmlElement(name = "MethodFiles")
    protected MethodFiles methodFiles;
    @XmlElement(name = "IdentificationFiles")
    protected IdentificationFiles identificationFiles;
    @XmlElement(name = "SearchDatabase")
    protected List<SearchDatabase> searchDatabase;
    @XmlElement(name = "SourceFile")
    protected List<SourceFile> sourceFile;

    /**
     * Gets the value of the rawFilesGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the rawFilesGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRawFilesGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RawFilesGroup }
     *
     *
     * @return the value of the rawFilesGroup property.
     */
    public List<RawFilesGroup> getRawFilesGroup() {
        if (rawFilesGroup == null) {
            rawFilesGroup = new ArrayList<>();
        }
        return this.rawFilesGroup;
    }

    /**
     * Gets the value of the methodFiles property.
     *
     * @return
     *         possible object is
     *         {@link MethodFiles }
     *
     */
    public MethodFiles getMethodFiles() {
        return methodFiles;
    }

    /**
     * Sets the value of the methodFiles property.
     *
     * @param value
     *              allowed object is
     *              {@link MethodFiles }
     *
     */
    public void setMethodFiles(MethodFiles value) {
        this.methodFiles = value;
    }

    /**
     * Gets the value of the identificationFiles property.
     *
     * @return
     *         possible object is
     *         {@link IdentificationFiles }
     *
     */
    public IdentificationFiles getIdentificationFiles() {
        return identificationFiles;
    }

    /**
     * Sets the value of the identificationFiles property.
     *
     * @param value
     *              allowed object is
     *              {@link IdentificationFiles }
     *
     */
    public void setIdentificationFiles(IdentificationFiles value) {
        this.identificationFiles = value;
    }

    /**
     * Gets the value of the searchDatabase property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the searchDatabase property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchDatabase().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchDatabase }
     *
     *
     * @return the value of the searchDatabase property.
     */
    public List<SearchDatabase> getSearchDatabase() {
        if (searchDatabase == null) {
            searchDatabase = new ArrayList<>();
        }
        return this.searchDatabase;
    }

    /**
     * Gets the value of the sourceFile property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the sourceFile property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceFile().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceFile }
     *
     *
     * @return the value of the sourceFile property.
     */
    public List<SourceFile> getSourceFile() {
        if (sourceFile == null) {
            sourceFile = new ArrayList<>();
        }
        return this.sourceFile;
    }

}
