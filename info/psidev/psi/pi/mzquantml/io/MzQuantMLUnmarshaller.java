/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package info.psidev.psi.pi.mzquantml.io;

import info.psidev.psi.pi.mzquantml._1_0.MzQuantMLType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
//import uk.ac.liv.jmzquantml.xml.xxindex.MzQuantMLIndexer;
//import uk.ac.liv.jmzquantml.xml.xxindex.MzQuantMLIndexerFactory;

/**
 * Class for reading in whole mzQuantML objects.
 *
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class MzQuantMLUnmarshaller {

    /**
     * Members.
     */
    private Unmarshaller unmarsh = null;
    private Reader fr = null;
    //private final MzQuantMLIndexer index;

    /**
     * Constructor
     *
     * @param fullFileName
     */
    public MzQuantMLUnmarshaller(String fullFileName) {

        //this(MzQuantMLIndexerFactory.getInstance().buildIndex(new File(fullFileName)));

        try {
            this.fr = new FileReader(fullFileName);
        } catch (IOException ioex) {
            ioex.printStackTrace(System.err);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(new Class[]{MzQuantMLType.class});
            this.unmarsh = context.createUnmarshaller();
            this.unmarsh.setEventHandler(new DefaultValidationEventHandler());
            //this.unmarsh.setValidating(true);
        } catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
    }

    /**
     * Unmarshalling of a whole MzQuantML object.
     *
     * @return MzQuantMLType
     */
    public MzQuantMLType unmarshall() {
        MzQuantMLType mzQuantML = null;

        try {
            if (this.fr != null) {
                mzQuantML = (MzQuantMLType) this.unmarsh.unmarshal(this.fr);
                this.fr.close();
            }
        } catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        } catch (IOException ioex) {
            ioex.printStackTrace(System.err);
        }

        return mzQuantML;
    }

    /*
     * Constructor
     */
//    public MzQuantMLUnmarshaller(File mzQuantMLFile) {
//        this(MzQuantMLIndexerFactory.getInstance().buildIndex(mzQuantMLFile));
//    }
//
//    public MzQuantMLUnmarshaller(MzQuantMLIndexer indexer) {
//        this.index = indexer;
//    }
    /*
     * public methods
     */

    /**
     * @param xpath the xpath defining the XML element.
     * @return the number of XML elements matching the xpath or -1 if no
     * elements were found for the specified xpath.
     */
//    public int getObjectCountForXpath(String xpath) {
//        if (xpath != null) {
//            return index.getCount(xpath);
//        } else {
//            return -1;
//        }
//    }
}
