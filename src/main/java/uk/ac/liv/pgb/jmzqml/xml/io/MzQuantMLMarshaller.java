
/**
 * JAXB-based Marshaller for a mzQuantML file.
 */
package uk.ac.liv.pgb.jmzqml.xml.io;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.apache.log4j.Logger;
import uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject;
import uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference;
import uk.ac.liv.pgb.jmzqml.model.mzqml.Cv;
import uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam;
import uk.ac.liv.pgb.jmzqml.model.mzqml.MzQuantML;
import uk.ac.liv.pgb.jmzqml.model.utils.ModelConstants;
import uk.ac.liv.pgb.jmzqml.xml.Constants;
import uk.ac.liv.pgb.jmzqml.xml.jaxb.marshaller.MarshallerFactory;
import uk.ac.liv.pgb.jmzqml.xml.util.EscapingXMLStreamWriter;

/**
 * Class for marshalling an mzQuantML file.
 * <p>
 * An mzQuantML file can be marshalled in two different ways.
 * One way is to marshal the whole mzQuantML object into a file;
 * the other way is to use helper methods to stitch together large XML elements.
 *
 * @author Gerhard Mayer, MPC, Ruhr-University of Bochum
 */
public class MzQuantMLMarshaller {

    private static final Logger LOGGER = Logger.getLogger(
            MzQuantMLMarshaller.class);
    /**
     * Constants.
     */
    private static final String ENCODING = System.getProperty("file.encoding",
                                                              "UTF-8");
    private static final String MZQUANTML = "MzQuantML";
    private static final int INI_STRING_LEN = 160;
    /**
     * Members.
     */
    private Marshaller marsh;
    private Writer fw;

    /**
     * JAXB based marshaller constructor.
     * <p>
     * To marshal a mzQuantML file, an MzQuantMLMarshaller should be created
     * first.
     *
     * @param fullFileName a String type file name.
     *
     */
    public MzQuantMLMarshaller(final String fullFileName) {
        try {
            File file = new File(fullFileName);
            this.fw
                    = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        }
        catch (IOException ioex) {
            ioex.printStackTrace(System.err);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(MzQuantML.class);
            this.marsh = context.createMarshaller();

            this.marsh.setProperty(Marshaller.JAXB_ENCODING, ENCODING);
            this.marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //this.marsh.setProperty(Marshaller.JAXB_FRAGMENT, true);
            this.marsh.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                                   ModelConstants.MZQML_LOCATION);
        }
        catch (JAXBException jaxbex) {
            jaxbex.printStackTrace(System.err);
        }
    }

    /**
     * Constructor of an empty marshaller.
     * <p>
     * The empty marshaller MUST NOT call method
     * {@code marshall(MzQuantML mzQuantML)}.
     *
     */
    public MzQuantMLMarshaller() {
    }

    /**
     * Marshalling of a whole MzQuantML object.
     * <p>
     * This method marshals an whole mzQuantML object to the file whose name is
     * used to create the MzQuantMLMarshaller.
     *
     * @param mzQuantML the MzQuantML object to be marshalled.
     */
    public final void marshall(final MzQuantML mzQuantML) {
        try {
            if (this.fw != null) {

                if (mzQuantML.getVersion().isEmpty()) {
                    mzQuantML.setVersion(ModelConstants.MZQML_VERSION);
                }

                JAXBElement<MzQuantML> jaxbElement = new JAXBElement<>(
                        new QName(ModelConstants.MZQML_NS, MZQUANTML),
                        MzQuantML.class, mzQuantML);

                this.marsh.marshal(jaxbElement, this.fw);
                this.fw.flush();
                this.fw.close();
            }
        }
        catch (JAXBException | IOException ex) {
            LOGGER.error(ex);
        }
    }

    /**
     * Marshalling of an {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}.
     * <p>
     * An {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject} will be marshalled
     * to an mzQuantML string.
     *
     * @param <T>    extends {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}
     * @param object a subclass of
     *               {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}
     *
     * @return the mzQuantML string of the object
     */
    public final <T extends MzQuantMLObject> String marshall(final T object) {
        StringWriter sw = new StringWriter();
        this.marshall(object, sw);
        return sw.toString();
    }

    /**
     *
     * @param <T>    MzQuantMLObject
     * @param object object
     * @param os     output stream
     */
    public final <T extends MzQuantMLObject> void marshall(final T object,
                                                           final OutputStream os) {
        this.marshall(object, os, "UTF-8");
    }

    /**
     *
     * @param <T>      MzQuantMLObject
     * @param object   object
     * @param os       output stream
     * @param encoding char encoding
     */
    public final <T extends MzQuantMLObject> void marshall(final T object,
                                                           final OutputStream os,
                                                           final String encoding) {
        try {
            this.
                    marshall(object, new OutputStreamWriter(os, encoding),
                             encoding);
        }
        catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not set character encoding!");
        }
    }

    /**
     *
     * @param <T>    MzQuantMLObject
     * @param object ojbect
     * @param out    out writer
     */
    @SuppressWarnings("unchecked")
    public final <T extends MzQuantMLObject> void marshall(final T object,
                                                           final Writer out) {
        this.marshall(object, out, "UTF-8");
    }

    /**
     * An {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject} is marshalled to a
     * specific writer.
     *
     * @param <T>      extends
     *                 {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}
     * @param object   a subclass of
     *                 {@link uk.ac.liv.pgb.jmzqml.model.MzQuantMLObject}
     * @param out      the writer to which the {@code object} is written.
     * @param encoding character encoding
     */
    public final <T extends MzQuantMLObject> void marshall(final T object,
                                                           final Writer out,
                                                           final String encoding) {

        if (object == null) {
            throw new IllegalArgumentException("Cannot marshall a NULL object.");
        }
        try {
            Marshaller marshaller = MarshallerFactory.getInstance().
                    initializeMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                                   Boolean.TRUE);

            if (!(object instanceof MzQuantML)) {
                marshaller.setProperty(Constants.JAXB_FRAGMENT_PROPERTY, true);
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug(
                            "Object '" + object.getClass().getName()
                            + "' will be treated as root element.");
                }
            }
            else if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(
                        "Object '" + object.getClass().getName()
                        + "' will be treated as fragment.");
            }

            QName aQName = ModelConstants.getQNameForClass(object.getClass());
            JAXBElement jaxbElement = new JAXBElement(aQName, object.getClass(),
                                                      object);

            // before marshalling out, wrap in a Custom XMLStreamWriter
            // to fix a JAXB bug: http://java.net/jira/browse/JAXB-614
            // also wrapping in IndentingXMLStreamWriter to generate formatted XML
            System.setProperty("javax.xml.stream.XMLOutputFactory",
                               "com.sun.xml.internal.stream.XMLOutputFactoryImpl");

            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter xmlStreamWriter = factory.createXMLStreamWriter(out);

            // Note: the EscapingXMLStreamWriter should default to "UTF-8" as 
            // character encoding, but does not on all platforms.
            // Therefore the encoding is hard coded for the default case
            // see EscapingXMLStreamWriter.writeStartDocument()
            IndentingXMLStreamWriter writer = new IndentingXMLStreamWriter(
                    new EscapingXMLStreamWriter(xmlStreamWriter, encoding));

            marshaller.marshal(jaxbElement, writer);
        }
        catch (JAXBException ex) {
            LOGGER.error("MzQuantMLMarshaller.marshall", ex);
            throw new IllegalStateException(
                    "Error while marshalling object: " + object.toString());
        }
        catch (XMLStreamException ex) {
            LOGGER.error("MzQuantMLMarshaller.marshall", ex);
            throw new IllegalStateException(
                    "Error while marshalling ojbect: " + object.toString());
        }

    }

    ///// ///// ///// ///// ///// ///// ///// ///// ///// /////
    // helper methods to 'stitch' together large XML elements
    ///// ///// ///// ///// ///// /////
    /**
     * The helper method creates an mzQuantML header string.
     *
     * @return a string of an mzQuantML header.
     */
    public static String createXmlHeader() {
        return "<?xml version=\"1.0\" encoding=\"" + "UTF-8" + "\"?>";
    }

    /**
     * The helper method creates a start tag with ID of mzQuantML file.
     *
     * @param id the ID of mzQuantML file.
     *
     * @return a start tag of mzQuantML file.
     */
    public static String createMzQuantMLStartTag(final String id) {
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<MzQuantML id=\"").append(id).append("\"");
        // further attributes
        sb.append(" version=\"").append(ModelConstants.MZQML_VERSION).append(
                '\"');
        sb.append(" xmlns=\"").append(ModelConstants.MZQML_NS).append('\"');
        sb.append(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
        sb.append(" xsi:schemaLocation=\"").
                append(ModelConstants.MZQML_LOCATION).append('\"');
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sb.append(" creationDate=\"").append(dfm.format(new Date())).
                append('\"');
        // finally close the tag
        sb.append('>');

        return sb.toString();
    }

    /**
     * The helper method creates a closing tag of mzQuantML file.
     *
     * @return a closing tag of mzQuantML file.
     */
    public static String createMzQuantMLClosingTag() {
        return "</MzQuantML>";
    }

    /*
     * mzQuantML element start and closing tags in alphabetical order
     */
    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary}.
     */
    public static String createAnalysisSummaryStartTag() {
        return "<AnalysisSummary>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AnalysisSummary}.
     */
    public static String createAnalysisSummaryClosingTag() {
        return "</AnalysisSummary>";
    }

    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection}.
     */
    public static String createAuditCollectionStartTag() {
        return "<AuditCollection>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AuditCollection}.
     */
    public static String createAuditCollectionClosingTag() {
        return "</AuditCollection>";
    }

    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvList}.
     *
     * @return a start tag of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvList}.
     */
    public static String createCvListStartTag() {
        return "<CvList>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvList}.
     *
     * @return a closing tag of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvList}.
     */
    public static String createCvListClosingTag() {
        return "</CvList>";
    }

    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList}.
     */
    public static String createDataProcessingListStartTag() {
        return "<DataProcessingList>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.DataProcessingList}.
     */
    public static String createDataProcessingListClosingTag() {
        return "</DataProcessingList>";
    }

    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles}.
     */
    public static String createInputFilesStartTag() {
        return "<InputFiles>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.InputFiles}.
     */
    public static String createInputFilesClosingTag() {
        return "</InputFiles>";
    }

    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList}.
     */
    public static String createRatioListStartTag() {
        return "<RatioList>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.RatioList}.
     */
    public static String createRatioListClosingTag() {
        return "</RatioList>";
    }

    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList}.
     */
    public static String createSoftwareListStartTag() {
        return "<SoftwareList>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SoftwareList}.
     */
    public static String createSoftwareListClosingTag() {
        return "</SoftwareList>";
    }

    /**
     * The helper method creates a start tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList}.
     */
    public static String createStudyVariableListStartTag() {
        return "<StudyVariableList>";
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.StudyVariableList}.
     */
    public static String createStudyVariableListClosingTag() {
        return "</StudyVariableList>";
    }

    /*
     *
     * mzQuantML element (with 'id') start and closing tags
     *
     */
    /**
     * The helper method creates a start tag with ID of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList}.
     *
     * @param id the ID of AssayList.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList}.
     */
    public static String createAssayListStartTag(final String id) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        //required attribute: 'id'
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<AssayList id=\"").append(id).append('\"');

        // finally close the tag
        sb.append('>');

        return sb.toString();
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.AssayList}.
     */
    public static String createAssayListClosingTag() {
        return "</AssayList>";
    }

    /**
     * @deprecated
     * The helper method creates a tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference} with all
     * the attributes.
     * The id attribute of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference} is
     * mandatorily required.
     * The other attributes are optional.
     *
     * @param id          (required) An identifier is an unambiguous string that
     *                    is unique within the scope (i.e. a document, a set of
     *                    related documents, or a repository) of its use.
     * @param name        (optional) The potentially ambiguous common
     *                    identifier, such as a human-readable name for the
     *                    instance.
     * @param authors     (optional) The names of the authors of the reference.
     * @param publication (optional) The name of the journal, book etc.
     * @param publisher   (optional) The publisher of the publication.
     * @param editor      (optional) The editor(s) of the reference.
     * @param year        (optional) The year of publication.
     * @param volume      (optional) The volume name or number.
     * @param issue       (optional) The issue name or number.
     * @param pages       (optional) The page numbers.
     * @param title       (optional) The title of the BibliographicReference.
     * @param doi         (optional) The DOI of the referenced publication.
     *
     * @return a {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference}
     *         string tag, representing bibliographic references.
     */
    @Deprecated
    public static String createBibliographicReferenceTag(final String id,
                                                         final String name,
                                                         final String authors,
                                                         final String publication,
                                                         final String publisher,
                                                         final String editor,
                                                         final Integer year,
                                                         final String volume,
                                                         final String issue,
                                                         final String pages,
                                                         final String title,
                                                         final String doi) {

        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<BibliographicReference id=\"").append(id).append('\"');

        // the attributes, if provided
        if (name != null && !name.isEmpty()) {
            sb.append(" name=\"").append(name).append('\"');
        }

        if (authors != null && !authors.isEmpty()) {
            sb.append(" authors=\"").append(authors).append('\"');
        }

        if (publication != null && !publication.isEmpty()) {
            sb.append(" publication=\"").append(publication).append('\"');
        }

        if (publisher != null && !publisher.isEmpty()) {
            sb.append(" publisher=\"").append(publisher).append('\"');
        }

        if (editor != null && !editor.isEmpty()) {
            sb.append(" editor=\"").append(editor).append('\"');
        }

        if (year != null) {
            sb.append(" year=\"").append(year).append('\"');
        }

        if (volume != null && !volume.isEmpty()) {
            sb.append(" volume=\"").append(volume).append('\"');
        }

        if (issue != null && !issue.isEmpty()) {
            sb.append(" issue=\"").append(issue).append('\"');
        }

        if (pages != null && !pages.isEmpty()) {
            sb.append(" pages=\"").append(pages).append('\"');
        }

        if (title != null && !title.isEmpty()) {
            sb.append(" title=\"").append(title).append('\"');
        }

        if (doi != null && !doi.isEmpty()) {
            sb.append(" doi=\"").append(doi).append('\"');
        }

        // finally close the tag
        sb.append("/>");

        return sb.toString();
    }

    /**
     * The helper method creates a start tag with ID and rawFilesGroupRef of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList}.
     *
     * @param id               (required) the ID of
     *                         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList}.
     * @param rawFilesGroupRef (required) the reference to rawFilesGroup.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList}.
     */
    public static String createFeatureListStartTag(final String id,
                                                   final String rawFilesGroupRef) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        if (rawFilesGroupRef == null) {
            throw new IllegalArgumentException(
                    "The 'rawFilesGroup_ref' attribute must not be null!");
        }

        //required attribute: 'id', 'rawFilesGroup_ref'
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<FeatureList id=\"").append(id).append('\"');

        // rawFilesGroup_ref attribute
        sb.append(" rawFilesGroup_ref=\"").append(rawFilesGroupRef).append('\"');

        // finally close the tag
        sb.append('>');

        return sb.toString();
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.FeatureList}.
     */
    public static String createFeatureListClosingTag() {
        return "</FeatureList>";
    }

    /**
     * The helper method creates a start tag with ID and finalResult of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensuList}.
     *
     * @param id          (required) the ID of
     *                    {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList}.
     * @param finalResult (required) the boolean value of finalResult attribute.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList}.
     */
    public static String createPeptideConsensusListStartTag(final String id,
                                                            final Boolean finalResult) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        if (finalResult == null) {
            throw new IllegalArgumentException(
                    "The 'finalResult' attribute must not be null!");
        }

        //required attribute: 'id', 'rawFilesGroup_ref'
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<PeptideConsensusList id=\"").append(id).append('\"');

        // rawFilesGroup_ref attribute
        sb.append(" finalResult=\"").append(finalResult.toString()).append('\"');

        // finally close the tag
        sb.append(" >");

        return sb.toString();
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.PeptideConsensusList}.
     */
    public static String createPeptideConsensusListClosingTag() {
        return "</PeptideConsensusList>";
    }

    /**
     * The helper method creates a start tag with ID of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList}.
     *
     * @param id the ID of
     *           {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList}.
     */
    public static String createProteinGroupListStartTag(final String id) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        //required attribute: 'id'
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<ProteinGroupList id=\"").append(id).append('\"');

        // finally close the tag
        sb.append(" >");

        return sb.toString();
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinGroupList}.
     */
    public static String createProteinGroupListClosingTag() {
        return "</ProteinGroupList>";
    }

    /**
     * The helper method creates a start tag with ID of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList}.
     *
     * @param id the ID of {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList}.
     */
    public static String createProteinListStartTag(final String id) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        //required attribute: 'id'
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<ProteinList id=\"").append(id).append('\"');

        // finally close the tag
        sb.append(" >");

        return sb.toString();
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.ProteinList}.
     */
    public static String createProteinListClosingTag() {
        return "</ProteinList>";
    }

    /**
     * The helper method creates a start tag with ID of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList}.
     *
     * @param id the ID of
     *           {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList}.
     *
     * @return a start tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList}.
     */
    public static String createSmallMoleculeListStartTag(final String id) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        //required attribute: 'id'
        StringBuilder sb = new StringBuilder(INI_STRING_LEN);

        // tag opening plus id attribute
        sb.append("<SmallMoleculeList id=\"").append(id).append('\"');

        // finally close the tag
        sb.append(" >");

        return sb.toString();
    }

    /**
     * The helper method creates a closing tag of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList}.
     *
     * @return a closing tag of
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.SmallMoleculeList}.
     */
    public static String createSmallMoleculeListClosingTag() {
        return "</SmallMoleculeList>";
    }

    ///// ///// ///// ///// /////
    // mzQuantML element object
    ///// ///// ///// ///// /////
    /**
     * @deprecated
     * The helper method creates a
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference} object
     * with all the attributes.
     * The id attribute of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference} is
     * mandatorily required.
     * The other attributes are optional.
     *
     * @param id          (required) An identifier is an unambiguous string that
     *                    is unique within the scope (i.e. a document, a set of
     *                    related documents, or a repository) of its use.
     * @param name        (optional) The potentially ambiguous common
     *                    identifier, such as a human-readable name for the
     *                    instance.
     * @param authors     (optional) The names of the authors of the reference.
     * @param publication (optional) The name of the journal, book etc.
     * @param publisher   (optional) The publisher of the publication.
     * @param editor      (optional) The editor(s) of the reference.
     * @param year        (optional) The year of publication.
     * @param volume      (optional) The volume name or number.
     * @param issue       (optional) The issue name or number.
     * @param pages       (optional) The page numbers.
     * @param title       (optional) The title of the BibliographicReference.
     * @param doi         (optional) The DOI of the referenced publication.
     *
     * @return the
     *         {@link uk.ac.liv.pgb.jmzqml.model.mzqml.BibliographicReference}
     *         object, representing bibliographic references.
     */
    @Deprecated
    public static BibliographicReference createBibliographicReference(
            final String id,
            final String name,
            final String authors,
            final String publication,
            final String publisher,
            final String editor,
            final Integer year,
            final String volume,
            final String issue,
            final String pages,
            final String title,
            final String doi) {

        BibliographicReference br = new BibliographicReference();
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        br.setId(id);

        if (name != null && !name.isEmpty()) {
            br.setName(name);
        }
        if (authors != null && !authors.isEmpty()) {
            br.setAuthors(authors);
        }
        if (publication != null && !publication.isEmpty()) {
            br.setPublication(publication);
        }
        if (publisher != null && !publisher.isEmpty()) {
            br.setPublisher(publisher);
        }
        if (editor != null && !editor.isEmpty()) {
            br.setEditor(editor);
        }
        if (year != null) {
            br.setYear(year);
        }
        if (volume != null && !volume.isEmpty()) {
            br.setVolume(volume);
        }
        if (issue != null && !issue.isEmpty()) {
            br.setId(issue);
        }
        if (pages != null && !pages.isEmpty()) {
            br.setPages(pages);
        }
        if (title != null && !title.isEmpty()) {
            br.setTitle(title);
        }
        if (doi != null && !doi.isEmpty()) {
            br.setDoi(doi);
        }
        return br;
    }

    /**
     * The helper method creates a {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Cv}
     * object with all the attributes.
     * The id, fullName and URI attributes of
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Cv} are mandatorily required.
     * The version attributes is optional.
     *
     * @param id       (required) The unique identifier of this cv within the
     *                 document to be referenced by cvParam elements.
     * @param fullName (required) The full name of the CV.
     * @param uri      (required) The URI of the source CV.
     * @param version  (optional) The version of the CV.
     *
     * @return the {@link uk.ac.liv.pgb.jmzqml.model.mzqml.Cv} object, a source
     *         controlled vocabulary from which cvParams will be obtained.
     */
    public static Cv createCv(final String id,
                              final String fullName,
                              final String uri,
                              final String version) {
        Cv cv = new Cv();
        if (id == null) {
            throw new IllegalArgumentException(
                    "The 'id' attribute must not be null!");
        }

        cv.setId(id);

        if (fullName != null && !fullName.isEmpty()) {
            cv.setFullName(fullName);
        }
        if (version != null && !version.isEmpty()) {
            cv.setVersion(version);
        }
        if (uri != null && !uri.isEmpty()) {
            cv.setUri(uri);
        }
        return cv;
    }

    /**
     * The helper method creates a
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object with all the
     * attributes.
     * The name, cvRef (String type) and accession attributes of CvParam are
     * mandatorily required.
     * The other attributes are optional.
     *
     * @param name          (required) The name of the parameter.
     * @param cvRef         (required) A string reference to the CV element from
     *                      which this term originates.
     * @param accession     (required) The accession or ID number of this CV
     *                      term in the source CV.
     * @param value         (optional) The user-entered value of the parameter.
     * @param unitAccession (optional) An accession number identifying the unit
     *                      within the OBO foundry Unit CV.
     * @param unitName      (optional) The name of the unit.
     * @param unitCvRef     (optional) If a unit term is referenced, this
     *                      attribute MUST refer to the CV 'id' attribute
     *                      defined in the cvList in this file.
     *
     * @return the {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object, a
     *         single entry from an ontology or a controlled vocabulary.
     */
    public static CvParam createCvParam(final String name,
                                        final String cvRef,
                                        final String accession,
                                        final String value,
                                        final String unitAccession,
                                        final String unitName,
                                        final String unitCvRef) {
        CvParam cp = new CvParam();

        if (name == null) {
            throw new IllegalArgumentException(
                    "The 'name' attribute must not be null!");
        }

        if (cvRef == null || cvRef.isEmpty()) {
            throw new IllegalArgumentException(
                    "The 'cvRef' attribute must not be null or empty!");
        }

        cp.setName(name);

        Cv cv = createCv(cvRef, null, null, null);
        cp.setCv(cv);

        if (accession != null && !accession.isEmpty()) {
            cp.setAccession(accession);
        }
        if (value != null && !value.isEmpty()) {
            cp.setValue(value);
        }
        if (unitAccession != null && !unitAccession.isEmpty()) {
            cp.setUnitAccession(unitAccession);
        }
        if (unitName != null && !unitName.isEmpty()) {
            cp.setUnitName(unitName);
        }
        if (unitCvRef != null && !unitCvRef.isEmpty()) {
            Cv unitCv = createCv(unitCvRef, null, null, null);
            cp.setUnitCv(unitCv);
        }

        return cp;
    }

    /**
     * The helper method creates a
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object with all the
     * attributes.
     * The name, cvRef (Cv type) and accession attributes of CvParam are
     * mandatorily required.
     * The other attributes are optional.
     *
     * @param name          (required) The name of the parameter.
     * @param cvRef         (required) An object reference to the CV element
     *                      from which this term originates.
     * @param accession     (required) The accession or ID number of this CV
     *                      term in the source CV.
     * @param value         (optional) The user-entered value of the parameter.
     * @param unitAccession (optional) An accession number identifying the unit
     *                      within the OBO foundry Unit CV.
     * @param unitName      (optional) The name of the unit.
     * @param unitCvRef     (optional) If a unit term is referenced, this
     *                      attribute MUST refer to the CV 'id' attribute
     *                      defined in the cvList in this file.
     *
     * @return the {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object, a
     *         single entry from an ontology or a controlled vocabulary.
     */
    public static CvParam createCvParam(final String name,
                                        final Cv cvRef,
                                        final String accession,
                                        final String value,
                                        final String unitAccession,
                                        final String unitName,
                                        final String unitCvRef) {

        String id = cvRef.getId();
        return createCvParam(name, id, accession, value, unitAccession, unitName,
                             unitCvRef);
    }

    /**
     * The helper method creates a
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object with required
     * attributes only.
     * The name, cvRef (String type) and accession attributes of CvParam are
     * mandatorily required.
     *
     *
     * @param name      (required) The name of the parameter.
     * @param cvRef     (required) A reference to the CV element from which this
     *                  term originates.
     * @param accession (required) The accession or ID number of this CV term in
     *                  the source CV.
     *
     * @return the {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object, a
     *         single entry from an ontology or a controlled vocabulary.
     */
    public static CvParam createCvParam(final String name,
                                        final String cvRef,
                                        final String accession) {
        return createCvParam(name, cvRef, accession, null, null, null, null);
    }

    /**
     * The helper method creates a
     * {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object with required
     * attributes only.
     * The name, cvRef (Cv type) and accession attributes of CvParam are
     * mandatorily required.
     *
     *
     * @param name      (required) The name of the parameter.
     * @param cvRef     (required) A reference to the CV element from which this
     *                  term originates.
     * @param accession (required) The accession or ID number of this CV term in
     *                  the source CV.
     *
     * @return the {@link uk.ac.liv.pgb.jmzqml.model.mzqml.CvParam} object, a
     *         single entry from an ontology or a controlled vocabulary.
     */
    public static CvParam createCvParam(final String name,
                                        final Cv cvRef,
                                        final String accession) {
        return createCvParam(name, cvRef, accession, null, null, null, null);

    }

}
