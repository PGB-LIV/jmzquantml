
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;

/**
 * Other classes in the model can be specified as sub-classes, inheriting from IdOnly. IdOnly gives classes a unique identifier within the scope.
 *
 * <p>
 * Java class for IdOnlyType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IdOnlyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType>&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdOnlyType")
@XmlSeeAlso({
    ProteinGroupList.class,
    ProteinList.class,
    ProteinGroup.class,
    Protein.class,
    PeptideConsensusList.class,
    SmallMoleculeList.class,
    PeptideConsensus.class,
    SmallMolecule.class,
    QuantLayer.class,
    RatioQuantLayer.class,
    GlobalQuantLayer.class,
    Software.class,
    DataProcessing.class,
    Feature.class,
    FeatureList.class,
    Ratio.class,
    RawFilesGroup.class,
    Assay.class,
    AssayList.class,
    StudyVariable.class,
    Cv.class
})
public abstract class IdOnly
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    /**
     *
     */
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the id property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

}
