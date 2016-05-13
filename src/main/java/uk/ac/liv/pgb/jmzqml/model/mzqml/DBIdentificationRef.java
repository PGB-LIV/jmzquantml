
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * A reference to an object identified in the SearchDatabase object defined in this file.
 *
 * <p>
 * Java class for DBIdentificationRefType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DBIdentificationRefType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="id_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="searchDatabase_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DBIdentificationRefType")
public class DBIdentificationRef
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlAttribute(name = "id_ref", required = true)
    protected String idRef;
    @XmlAttribute(name = "searchDatabase_ref", required = true)
    protected String searchDatabaseRef;
    /**
     *
     */
    @XmlTransient
    protected ExternalData id;
    /**
     *
     */
    @XmlTransient
    protected SearchDatabase searchDatabase;

    /**
     *
     * @return external data
     */
    public ExternalData getId() {
        return id;
    }

    /**
     *
     * @param id external data
     */
    public void setId(ExternalData id) {
        if (id == null) {
            this.idRef = null;
        }
        else {
            String refId = id.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.idRef = refId;
        }
        this.id = id;
    }

    /**
     *
     * @return search database
     */
    public SearchDatabase getSearchDatabase() {
        return searchDatabase;
    }

    /**
     *
     * @param searchDatabase search database
     */
    public void setSearchDatabase(SearchDatabase searchDatabase) {
        if (searchDatabase == null) {
            this.searchDatabaseRef = null;
        }
        else {
            String refId = searchDatabase.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.searchDatabaseRef = refId;
        }
        this.searchDatabase = searchDatabase;
    }

    /**
     * Gets the value of the idRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getIdRef() {
        return idRef;
    }

    /**
     * Gets the value of the searchDatabaseRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getSearchDatabaseRef() {
        return searchDatabaseRef;
    }

}
