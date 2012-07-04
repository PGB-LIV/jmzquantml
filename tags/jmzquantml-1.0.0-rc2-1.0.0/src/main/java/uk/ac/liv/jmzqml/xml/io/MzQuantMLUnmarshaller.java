/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package uk.ac.liv.jmzqml.xml.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import javax.xml.bind.*;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import uk.ac.liv.jmzqml.model.mzqml.MzQuantML;
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
    private static final ArrayList<String> exMsgs = new ArrayList<String>();
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
            JAXBContext context = JAXBContext.newInstance(new Class[]{MzQuantML.class});
            this.unmarsh = context.createUnmarshaller();
            this.unmarsh.setEventHandler(new DefaultValidationEventHandler());
            //this.unmarsh.setValidating(true);
        } catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
    }
    /*
     *
     * @param fullFileName, schemaValidating, schemaFn
     */

    public MzQuantMLUnmarshaller(String fullFileName, boolean schemaValidating, String schemaFn) {

        //this(MzQuantMLIndexerFactory.getInstance().buildIndex(new File(fullFileName)));

        try {
            this.fr = new FileReader(fullFileName);
        } catch (IOException ioex) {
            ioex.printStackTrace(System.err);


        }

        if (schemaValidating) {
            try {
                JAXBContext context = JAXBContext.newInstance(new Class[]{MzQuantML.class
                        });
                this.unmarsh = context.createUnmarshaller();

                SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
                Schema schema = sf.newSchema(new File(schemaFn));
                this.unmarsh.setSchema(schema);

                ValidationEventHandler veh = new ValidationEventHandler() {

                    @Override
                    public boolean handleEvent(ValidationEvent event) {
                        //ignore warnings
                        if (event.getSeverity() != ValidationEvent.WARNING) {
                            ValidationEventLocator vel = event.getLocator();
//                            System.out.println("Line:Col[" + vel.getLineNumber()
//                                    + ":" + vel.getColumnNumber()
//                                    + "]:" + event.getMessage());
                            exMsgs.add("Line:Col[" + vel.getLineNumber()
                                    + ":" + vel.getColumnNumber()
                                    + "]:" + event.getMessage());
                        }
                        return true;
                    }
                };
                this.unmarsh.setEventHandler(veh);

            } catch (JAXBException jaxbex) {
                jaxbex.printStackTrace();
            } catch (SAXException ex) {
                System.out.println("Unable to validate due to follow error.");
                ex.printStackTrace();
            }
        } else {
            try {
                JAXBContext context = JAXBContext.newInstance(new Class[]{MzQuantML.class
                        });
                this.unmarsh = context.createUnmarshaller();
                this.unmarsh.setEventHandler(new DefaultValidationEventHandler());
                //this.unmarsh.setValidating(true);
            } catch (JAXBException jaxbex) {
                jaxbex.printStackTrace(System.err);
            }
        }
    }

    /**
     * Unmarshalling of a whole MzQuantML object.
     *
     * @return MzQuantMLType
     */
    public MzQuantML unmarshall() {
        MzQuantML mzQuantML = null;

        try {
            if (this.fr != null) {
                mzQuantML = (MzQuantML) this.unmarsh.unmarshal(this.fr);
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
    public ArrayList<String> getExceptionalMessages() {
        return exMsgs;
    }
}
