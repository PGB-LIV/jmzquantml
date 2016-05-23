
package uk.ac.liv.pgb.jmzqml.model.mzqml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * A file from which this MzQuantML instance was created, including potentially
 * MzQuantML files for earlier stages in a workflow.
 *
 * <p>
 * Java class for SourceFileType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="SourceFileType"&gt;
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
@XmlType(name = "SourceFileType")
public class SourceFile
        extends ExternalData {

    private final static long serialVersionUID = 100L;

}
