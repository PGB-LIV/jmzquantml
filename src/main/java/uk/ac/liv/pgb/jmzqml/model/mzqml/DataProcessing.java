
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Description of the way in which a particular software package was used to analyse data and for example produce different quant layers or lists in the file.
 *
 * <p>Java class for DataProcessingType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DataProcessingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InputObject_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" minOccurs="0"/>
 *         &lt;element name="OutputObject_refs" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}listOfStrings" minOccurs="0"/>
 *         &lt;element name="ProcessingMethod" type="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ProcessingMethodType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="software_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="order" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataProcessingType", propOrder = {
    "inputObjectRefs",
    "outputObjectRefs",
    "processingMethod"
})
public class DataProcessing
        extends IdOnly {

    private final static long serialVersionUID = 100L;
    @XmlList
    @XmlElement(name = "InputObject_refs")
    protected List<String> inputObjectRefs;
    @XmlList
    @XmlElement(name = "OutputObject_refs")
    protected List<String> outputObjectRefs;
    @XmlElement(name = "ProcessingMethod", required = true)
    protected List<ProcessingMethod> processingMethod;
    @XmlAttribute(name = "software_ref", required = true)
    protected String softwareRef;
    @XmlAttribute(name = "order", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger order;
    @XmlTransient
    protected List<IdOnly> inputObjects;
    @XmlTransient
    protected List<IdOnly> outputObjects;
    @XmlTransient
    protected Software software;

    /**
     * Gets the list of input objects of the DataProcessing.
     *
     * @return the list of input objects of the DataProcessing.
     */
    public List<IdOnly> getInputObjects() {
        if (inputObjects == null) {
            inputObjects = new ArrayList<>();
        }
        return inputObjects;
    }

    /**
     * Sets the list of input objects to the DataProcessing.
     *
     * @param inputObjects a list of input objects.
     */
    public void setInputObjects(List<IdOnly> inputObjects) {
        if (inputObjects == null) {
            this.inputObjectRefs = null;
        }
        else {
            this.inputObjectRefs = new ArrayList<>();
            for (IdOnly inObj : inputObjects) {
                String refId = inObj.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.inputObjectRefs.add(refId);
            }
        }
        this.inputObjects = inputObjects;
    }

    /**
     * Gets the list of output objects of the DataProcessing.
     *
     * @return the list of output objects of the DataProcessing.
     */
    public List<IdOnly> getOutputObjects() {
        if (outputObjects == null) {
            outputObjects = new ArrayList<>();
        }
        return outputObjects;
    }

    /**
     * Sets the list of output objects to the DataProcessing.
     *
     * @param outputObjects a list of output objects.
     */
    public void setOutputObjects(List<IdOnly> outputObjects) {
        if (outputObjects == null) {
            this.outputObjectRefs = null;
        }
        else {
            this.outputObjectRefs = new ArrayList<>();
            for (IdOnly outObj : outputObjects) {
                String refId = outObj.getId();
                if (refId == null) {
                    throw new IllegalArgumentException("Referenced object does not have an identifier.");
                }
                this.outputObjectRefs.add(refId);
            }
        }
        this.outputObjects = outputObjects;
    }

    /**
     * Gets the Software of the DataProcessing.
     *
     * @return the Software of the DataProcessing.
     */
    public Software getSoftware() {
        return software;
    }

    /**
     * Sets the Software to the DataProcessing.
     *
     * @param software a Software.
     */
    public void setSoftware(Software software) {
        if (software == null) {
            this.softwareRef = null;
        }
        else {
            String refId = software.getId();
            if (refId == null) {
                throw new IllegalArgumentException("Referenced object does not have an identifier.");
            }
            this.softwareRef = refId;
        }
        this.software = software;
    }

    /**
     * Gets the value of the inputObjectRefs property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the inputObjectRefs property.
     *
     * <p>For example, to add a new item, do as follows:
     * <pre>
     *    getInputObjectRefs().add(newItem);
     * </pre>
     *
     *
     * <p>Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the inputObjectRefs property.
     */
    public List<String> getInputObjectRefs() {
        if (inputObjectRefs == null) {
            inputObjectRefs = new ArrayList<>();
        }
        return this.inputObjectRefs;
    }

    /**
     * Gets the value of the outputObjectRefs property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the outputObjectRefs property.
     *
     * <p>For example, to add a new item, do as follows:
     * <pre>
     *    getOutputObjectRefs().add(newItem);
     * </pre>
     *
     *
     * <p>Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     * @return the value of the outputObjectRefs property.
     */
    public List<String> getOutputObjectRefs() {
        if (outputObjectRefs == null) {
            outputObjectRefs = new ArrayList<>();
        }
        return this.outputObjectRefs;
    }

    /**
     * Gets the value of the processingMethod property.
     *
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a
     * <CODE>set</CODE> method for the processingMethod property.
     *
     * <p>For example, to add a new item, do as follows:
     * <pre>
     *    getProcessingMethod().add(newItem);
     * </pre>
     *
     *
     * <p>Objects of the following type(s) are allowed in the list
     * {@link ProcessingMethod }
     *
     *
     * @return the value of the processingMethod property.
     */
    public List<ProcessingMethod> getProcessingMethod() {
        if (processingMethod == null) {
            processingMethod = new ArrayList<>();
        }
        return this.processingMethod;
    }

    /**
     * Gets the value of the softwareRef property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getSoftwareRef() {
        return softwareRef;
    }

    /**
     * Gets the value of the order property.
     *
     * @return
     *         possible object is
     *         {@link BigInteger }
     *
     */
    public BigInteger getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     *
     * @param value
     *              allowed object is
     *              {@link BigInteger }
     *
     */
    public void setOrder(BigInteger value) {
        this.order = value;
    }

}
