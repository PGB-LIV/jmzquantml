/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package info.psidev.psi.pi.mzquantml.io;

import info.psidev.psi.pi.mzquantml._0.MzQuantML;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

/**
 * Class for reading in whole mzQuantML objects.
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class MzQuantMLUnmarshaller {

    /**
     * Members.
     */
    private Unmarshaller unmarsh = null;
    private Reader fr = null;

    /**
     * Constructor
     * @param fullFileName
     */
    public MzQuantMLUnmarshaller(String fullFileName) {
        try {
            this.fr = new FileReader(fullFileName);
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);            
        }

        try {
            JAXBContext context = JAXBContext.newInstance(new Class[] { MzQuantML.class});
            this.unmarsh = context.createUnmarshaller();
            this.unmarsh.setEventHandler(new DefaultValidationEventHandler());
            //this.unmarsh.setValidating(true);
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
    }

    /**
     * Unmarshalling of a whole MzQuantML object.
     * @return MzQuantML
     */
    public MzQuantML unmarshall() {
        MzQuantML mzQuantML = null;

        try {
            if (this.fr != null) {
                mzQuantML = (MzQuantML) this.unmarsh.unmarshal(this.fr);
                this.fr.close();
            }
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);
        }

        return mzQuantML;
    }
}
