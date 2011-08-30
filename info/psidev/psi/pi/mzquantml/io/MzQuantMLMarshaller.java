/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package info.psidev.psi.pi.mzquantml.io;

import info.psidev.psi.pi.mzquantml._1_0.MzQuantMLType;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 * Class for writing out whole mzQuantML objects.
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class MzQuantMLMarshaller {

    /**
     * Members.
     */
    private Marshaller marsh = null;
    private Writer fw = null;

    /**
     * Constructor.
     * @param fullFileName
     */
    public MzQuantMLMarshaller(String fullFileName) {
        try {
            this.fw = new FileWriter(fullFileName);
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);            
        }

        try {
            JAXBContext context = JAXBContext.newInstance(MzQuantMLType.class);
            this.marsh = context.createMarshaller();

            this.marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            this.marsh.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // Set JAXB_FRAGMENT_PROPERTY to true for all objects that do not have a @XmlRootElement annotation
            //this.marsh.setProperty(Marshaller.JAXB_FRAGMENT, true);
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
    }

    /**
     * Marshalling of a whole MzQuantML object.
     * @param mzQuantML
     */
    public void marshall(MzQuantMLType mzQuantML) {
        try {
            if (this.fw != null) {
                JAXBElement<MzQuantMLType> jaxbElement = new JAXBElement<MzQuantMLType>(new QName(null, "MzQuantMLType"), MzQuantMLType.class, mzQuantML);
                this.marsh.marshal(jaxbElement, this.fw);
                //this.marsh.marshal(mzQuantML, this.fw);
                this.fw.flush();
                this.fw.close();
            }
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);
        }
    }
}
