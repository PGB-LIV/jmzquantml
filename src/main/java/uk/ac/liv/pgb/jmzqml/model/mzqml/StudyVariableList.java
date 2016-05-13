
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
 * The list of experimental conditions used to group results.
 *
 * <p>
 * Java class for StudyVariableListType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StudyVariableListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StudyVariable" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}StudyVariableType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StudyVariableListType", propOrder = {
    "studyVariable"
})
public class StudyVariableList
        implements Serializable, MzQuantMLObject {

    private final static long serialVersionUID = 100L;
    @XmlElement(name = "StudyVariable", required = true)
    protected List<StudyVariable> studyVariable;

    /**
     * Gets the value of the studyVariable property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studyVariable property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudyVariable().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudyVariable }
     *
     *
     * @return the value of the studyVariable property.
     */
    public List<StudyVariable> getStudyVariable() {
        if (studyVariable == null) {
            studyVariable = new ArrayList<>();
        }
        return this.studyVariable;
    }

}
