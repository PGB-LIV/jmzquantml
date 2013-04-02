
/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package uk.ac.liv.jmzqml.xml.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.namespace.QName;
import org.apache.log4j.Logger;
import uk.ac.liv.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.jmzqml.model.mzqml.MzQuantML;
import uk.ac.liv.jmzqml.model.utils.ModelConstants;
import uk.ac.liv.jmzqml.xml.Constants;
import uk.ac.liv.jmzqml.xml.jaxb.marshaller.MarshallerFactory;

/**
 * Class for marshalling a MzQuantMLFile.
 *
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class MzQuantMLMarshaller {

    private static final Logger logger = Logger.getLogger(MzQuantMLMarshaller.class);
    /**
     * Constants.
     */
    private static final String ENCODING = "UTF-8";
    private static final String MZQUANTML = "MzQuantML";
    private static final String MZQUANTML_NS = "http://psidev.info/psi/pi/mzQuantML/1.0.0";
    private static final String MZQUANTML_REL_PATH = " ../../../schema/mzQuantML_1_0_0.xsd";
    private static final String MZQUANTML_SCHEMA_LOCATION = MZQUANTML_NS + MZQUANTML_REL_PATH;
    /**
     * Members.
     */
    private Marshaller marsh = null;
    private Writer fw = null;

    /**
     * Constructor.
     *
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
            JAXBContext context = JAXBContext.newInstance(MzQuantML.class);
            this.marsh = context.createMarshaller();

            this.marsh.setProperty(Marshaller.JAXB_ENCODING, ENCODING);
            this.marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            this.marsh.setProperty(Marshaller.JAXB_FRAGMENT, true);
            this.marsh.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, MZQUANTML_SCHEMA_LOCATION);
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
    }

    public MzQuantMLMarshaller() {
    }

    /**
     * Marshalling of a whole MzQuantML object.
     *
     * @param mzQuantML
     */
    public void marshall(MzQuantML mzQuantML) {
        try {
            if (this.fw != null) {
                JAXBElement<MzQuantML> jaxbElement = new JAXBElement<MzQuantML>(new QName(MZQUANTML_NS, MZQUANTML), MzQuantML.class, mzQuantML);
                this.marsh.marshal(jaxbElement, this.fw);
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

    public <T extends MzQuantMLObject> String marshall(T object) {
        StringWriter sw = new StringWriter();
        this.marshall(object, sw);
        return sw.toString();
    }

    @SuppressWarnings("unchecked")
    public <T extends MzQuantMLObject> void marshall(T object, Writer out) {

        if (object == null) {
            throw new IllegalArgumentException("Cannot marshall a NULL object.");
        }
        try {
            Marshaller marshaller = MarshallerFactory.getInstance().initializeMarshaller();

            if (!(object instanceof MzQuantML)) {
                marshaller.setProperty(Constants.JAXB_FRAGMENT_PROPERTY, true);
                if (logger.isDebugEnabled()) {
                    logger.debug("Object '" + object.getClass().getName() + "' will be treated as root element.");
                }
            }
            else {
                if (logger.isDebugEnabled()) {
                    logger.debug("Object '" + object.getClass().getName() + "' will be treated as fragment.");
                }
            }

            QName aQName = ModelConstants.getQNameForClass(object.getClass());
            JAXBElement jaxbElement = new JAXBElement(aQName, object.getClass(), object);

            marshaller.marshal(jaxbElement, out);
        }
        catch (JAXBException ex) {
            logger.error("MzQuantMLMarshaller.marshall", ex);
            throw new IllegalStateException("Error while marshalling object: " + object.toString());
        }

    }

    ///// ///// ///// ///// ///// ///// ///// ///// ///// /////
    // helper methods to 'stitch' together large XML elements
    ///// ///// ///// ///// ///// /////
    public String createXmlHeader() {
        String encoding = System.getProperty("file.encoding");
        return "<?xml verion=\"1.0\" encoding=\"" + encoding + "\"?>";
    }

    public String createMzQuantMLStartTag(String id) {
        StringBuffer sb = new StringBuffer();

        // tag opening plus id attribute
        sb.append("<MzQuantML id=\"").append(id).append("\"");
        // further attributes
        sb.append(" version=\"").append(ModelConstants.MZQML_VERSION).append("\"");
        sb.append(" xmlns=\"").append(ModelConstants.MZQML_NS).append("\"");
        sb.append(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
        sb.append(" xsi:schemaLocation=\"").append(ModelConstants.MZQML_NS).append(" ").append(ModelConstants.MZQML_SCHEMA).append("\"");
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sb.append(" creationDate=\"").append(dfm.format(new Date())).append("\"");
        // finally close the tag
        sb.append(" >");

        return sb.toString();
    }

    public String createMzQuantMLClosingTag() {
        return "</MzQuantML>";
    }

    public String createAuditCollectionStartTag() {
        return "<AuditCollection>";
    }

    public String createAuditCollectionClosingTag() {
        return "</AuditCollection>";
    }

    public String createAnalysisSummaryStartTag() {
        return "<AnalysisSummary>";
    }

    public String createAnalysisSummaryClosingTag() {
        return "</AnalysisSummary>";
    }

}
