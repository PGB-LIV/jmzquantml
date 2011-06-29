//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.29 at 02:00:54 PM BST 
//


package info.psidev.psi.pi.mzquantml._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProteinListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProteinListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QuantLayerRef" type="{http://psidev.info/psi/pi/mzQuantML/0.1}QuantLayerRefType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Protein" type="{http://psidev.info/psi/pi/mzQuantML/0.1}ProteinType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProteinListType", propOrder = {
    "quantLayerRef",
    "protein"
})
public class ProteinListType {

    @XmlElement(name = "QuantLayerRef")
    protected List<QuantLayerRefType> quantLayerRef;
    @XmlElement(name = "Protein")
    protected List<ProteinType> protein;

    /**
     * Gets the value of the quantLayerRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the quantLayerRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuantLayerRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QuantLayerRefType }
     * 
     * 
     */
    public List<QuantLayerRefType> getQuantLayerRef() {
        if (quantLayerRef == null) {
            quantLayerRef = new ArrayList<QuantLayerRefType>();
        }
        return this.quantLayerRef;
    }

    /**
     * Gets the value of the protein property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the protein property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProtein().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProteinType }
     * 
     * 
     */
    public List<ProteinType> getProtein() {
        if (protein == null) {
            protein = new ArrayList<ProteinType>();
        }
        return this.protein;
    }

}
