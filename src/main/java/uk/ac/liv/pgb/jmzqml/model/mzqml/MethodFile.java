
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * A single methods file associated with this analysis e.g. a TraML file used
 * for SRM analysis.
 *
 * <p>
 * Java class for MethodFileType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="MethodFileType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://psidev.info/psi/pi/mzQuantML/1.0.0}ExternalDataType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodFileType")
public class MethodFile
        extends ExternalData {

    private final static long serialVersionUID = 100L;

}
