
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import uk.ac.liv.pgb.jmzqml.model.CvParamListCapable;
import uk.ac.liv.pgb.jmzqml.model.ParamCapable;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.adapter.CalendarAdapter;

/**
 * A database used for searching mass spectra. Examples include a set of amino acid sequence entries, or annotated spectra libraries.
 *
 * <p>
 * Java class for SearchDatabaseType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SearchDatabaseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ExternalDataType">
 *       &lt;sequence>
 *         &lt;element name="DatabaseName" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ParamType"/>
 *         &lt;element name="cvParam" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}CVParamType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="numDatabaseEntries" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchDatabaseType", propOrder = {
    "databaseName",
    "cvParam"
})
public class SearchDatabase
        extends ExternalData
        implements ParamCapable, CvParamListCapable {

    private final static long serialVersionUID = 100L;
    /**
     *
     */
    @XmlElement(name = "DatabaseName", required = true)
    protected Param databaseName;
    /**
     *
     */
    protected List<CvParam> cvParam;
    /**
     *
     */
    @XmlAttribute(name = "version")
    protected String version;
    /**
     *
     */
    @XmlAttribute(name = "releaseDate")
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar releaseDate;
    /**
     *
     */
    @XmlAttribute(name = "numDatabaseEntries")
    protected Long numDatabaseEntries;

    /**
     * Gets the value of the databaseName property.
     *
     * @return
     *         possible object is
     *         {@link Param }
     *
     */
    public Param getDatabaseName() {
        return databaseName;
    }

    /**
     * Sets the value of the databaseName property.
     *
     * @param value
     *              allowed object is
     *              {@link Param }
     *
     */
    public void setDatabaseName(Param value) {
        this.databaseName = value;
    }

    /**
     * Gets the value of the cvParam property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cvParam property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCvParam().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CvParam }
     *
     *
     */
    @Override
    public List<CvParam> getCvParam() {
        if (cvParam == null) {
            cvParam = new ArrayList<>();
        }
        return this.cvParam;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the releaseDate property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public Calendar getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the value of the releaseDate property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setReleaseDate(Calendar value) {
        this.releaseDate = value;
    }

    /**
     * Gets the value of the numDatabaseEntries property.
     *
     * @return
     *         possible object is
     *         {@link Long }
     *
     */
    public Long getNumDatabaseEntries() {
        return numDatabaseEntries;
    }

    /**
     * Sets the value of the numDatabaseEntries property.
     *
     * @param value
     *              allowed object is
     *              {@link Long }
     *
     */
    public void setNumDatabaseEntries(Long value) {
        this.numDatabaseEntries = value;
    }

}
