
package uk.ac.liv.pgb.jmzqml.xml.xxindex;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import psidev.psi.tools.xxindex.index.IndexElement;

/**
 * @author Rui Wang
 * @version $Id$
 */
public class MemoryMappedXmlElementExtractor {

    private static final int MIN_GRP_NUM = 1;
    private static final Log LOG = LogFactory.getLog(MemoryMappedXmlElementExtractor.class);

    // XML 1.1 specs
    // [3]  S            ::=  (#x20 | #x9 | #xD | #xA)+             /* spaces, carriage returns, line feeds, or tabs */
    // [23] XMLDecl      ::=  '<?xml' VersionInfo EncodingDecl? SDDecl? S? '?>'
    // [24] VersionInfo  ::=  S 'version' Eq ("'" VersionNum "'" | '"' VersionNum '"')
    // [25] Eq           ::=  S? '=' S?
    // [80] EncodingDecl ::=  S 'encoding' Eq ('"' EncName '"' | "'" EncName "'" )
    // [81] EncName      ::=  [A-Za-z] ([A-Za-z0-9._] | '-')*        /* Encoding name contains only Latin characters */
    protected static final Pattern XML_HEADER = Pattern.compile(".*<\\?xml.+\\?>.*", Pattern.DOTALL);
    protected static final Pattern XML_ENC = Pattern.compile(".*encoding\\s*=\\s*[\"']([A-Za-z]([A-Za-z0-9._]|[-])*)[\"'](.*)", Pattern.DOTALL);

    private boolean useSystemDefaultEncoding;
    private Charset encoding;

    ////////////////////
    // Constructor
    /**
     * Default constructor setting the default character encoding to 'ASCII'.
     */
    public MemoryMappedXmlElementExtractor() {
        setUseSystemDefaultEncoding(false);
        setEncoding(Charset.forName("ASCII"));
    }

    /**
     * Constructor overwriting the default character encoding with the specified
     * one.
     *
     * @param encoding The Charset to use to translate the read bytes.
     */
    @SuppressWarnings(value = "unused")
    public MemoryMappedXmlElementExtractor(final Charset encodingp) {
        this();
        setEncoding(encodingp);
    }

    ////////////////////
    // Getter & Setter
    /**
     * @return The currently set encoding.
     */
    public final Charset getEncoding() {
        return encoding;
    }

    /**
     * @param encoding The encoding to use when converting the read byte array
     *                 into a String.
     */
    public final void setEncoding(final Charset encodingp) {
        this.encoding = encodingp;
    }

    /**
     * This method will try to find and set a Charset for the given String.
     *
     * @param encoding The encoding to use when converting the read byte array
     *                 into a String.
     *
     * @return 0 is returned on success, -1 if the specified encoding is not
     *         valid and -2 if the specified encoding is not supported by this virtual
     *         machine.
     */
    public final int setEncoding(final String encodingp) {
        int result;
        try {
            this.encoding = Charset.forName(encodingp);
            result = 0;
        } catch (IllegalCharsetNameException icne) {
            LOG.error("Illegal encoding: " + encodingp, icne);
            result = -1;
        } catch (UnsupportedCharsetException ucne) {
            LOG.error("Unsupported encoding: " + encodingp, ucne);
            result = -2;
        }
        return result;
    }

    /**
     * @return Flag whether the system default encoding is used for decoding.
     */
    public final boolean isUseSystemDefaultEncoding() {
        return useSystemDefaultEncoding;
    }

    /**
     * A boolean flag which defines if the system default character encoding is
     * to be used for decoding the read bytes. Note: If the flag is set any
     * other specified encoding will be ignored!
     *
     * @param useSystemDefaultEncoding A flag whether to use the system default
     *                                 character encoding.
     */
    public final void setUseSystemDefaultEncoding(
            final boolean useSystemDefaultEncodingp) {
        this.useSystemDefaultEncoding = useSystemDefaultEncodingp;
    }

    ////////////////////
    // Methods
    /**
     * Same as readString(long from, long to, File file), but start and stop
     * wrapped in a ByteRange object.
     *
     * @param br          the ByteRange to read.
     * @param inputStream the file to read from.
     *
     * @return the XML element including start and stop tag in a String.
     *
     * @throws java.io.IOException if an I/O error occurs while reading.
     */
    public final String readString(final IndexElement br,
                                   final InputStream inputStream)
            throws IOException {
        return readString(br.getStart(), br.getStop(), inputStream);
    }

    /**
     * Convenience method that combines the methods: readBytes(),
     * removeZeroBytes() and bytes2String().
     * <p>
     * Read a String representing a XML element from the specified file (which
     * will be opened read-only). It will read from position 'from' for length
     * 'to - from'.
     *
     * @param from        The byte position of the start (incl. beginning of start tag)
     *                    of the XML element.
     * @param to          The byte position of the end (incl. end of closing tag) of the
     *                    XML element.
     * @param inputStream The file input stream to read from.
     *
     * @return The XML element including start and stop tag in a String.
     *
     * @throws java.io.IOException
     */
    public final String readString(final long from, final long to,
                                   final InputStream inputStream)
            throws IOException {
        // retrieve the bytes from the given range in the file
        byte[] bytes = readBytes(from, to, inputStream);

        // remove all zero bytes (Mac filling bytes)
        byte[] newBytes = removeZeroBytes(bytes);

        // create a String from the rest using the given encoding if specified
        return bytes2String(newBytes);
    }

    /**
     * Retrieves bytes from the specified file from position 'from' for a length
     * of 'to - from' bytes.
     *
     * @param from        The position from where to start reading.
     * @param to          The position to which to read.
     * @param inputStream The file input stream to read from.
     *
     * @return The read byte array.
     *
     * @throws IOException              If a I/O Exception during the reading process
     *                                  occurred.
     * @throws IllegalArgumentException If the range specified to read (to -
     *                                  from) is to big (&gt; Integer.MAX_VALUE characters).
     */
    public final byte[] readBytes(final long from, final long to,
                                  final InputStream inputStream)
            throws IOException {
        byte[] bytes;

        Long length = to - from;
        if (length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Can not read more than " + Integer.MAX_VALUE + " bytes!");
        }
        bytes = new byte[length.intValue()];

        // read into buffer
        myskip(inputStream, from);
        //inputStream.skip(from);
        if (inputStream.read(bytes, 0, length.intValue()) > 0) {
            return bytes;
        } else {
            return null;
        }
    }

    /**
     * This method represents the default case of the
     * this#detectFileEncoding(URL, int) method limiting the number of read
     * bytes to 1000.
     *
     * @param inputStream The file input stream to read from.
     *
     * @return A String representing the Charset detected for the provided file
     *         or null if no character encoding could be determined.
     *
     * @throws IOException If the specified location could not be opened for
     *                     reading.
     */
    public final String detectFileEncoding(final InputStream inputStream)
            throws IOException {
        return detectFileEncoding(inputStream, 1000);
    }

    /**
     * This method reads up to maxReadLength bytes from the file specified by
     * fileLocation and will try to detect the character encoding. This simple
     * detection is assuming a file according to XML 1.1 specs, where the
     * encoding should be provided in the XML header/prolog. It will only try to
     * parse this information from the read bytes.
     *
     * @param inputStream   The file input stream to read from.
     * @param maxReadLength The maximum number of bytes to read from the file.
     *
     * @return A String representing the Charset detected for the provided file
     *         or null if no character encoding could be determined.
     *
     * @throws IOException If the specified location could not be opened for
     *                     reading.
     */
    public final String detectFileEncoding(final InputStream inputStream,
                                           final int maxReadLength)
            throws IOException {

        // read a bit of the input file and check if it contains a XML header
        int length = inputStream.available();

        // read a maximum of maxReadLength bytes
        byte[] bytes;
        if (length > maxReadLength) {
            bytes = new byte[maxReadLength];
        } else {
            bytes = new byte[length];
        }
        // fill the byte buffer
        inputStream.read(bytes);

        // convert the bytes to String using ASCII
        String fileStart = new String(bytes, "ASCII");

        // first check if there is a XML header
        Matcher mHead = MemoryMappedXmlElementExtractor.XML_HEADER.matcher(fileStart);
        if (!mHead.matches()) {
            // no XML header not found
            LOG.debug("No XML header found for input");
            return null;
        }

        Matcher mEnc = MemoryMappedXmlElementExtractor.XML_ENC.matcher(fileStart);
        if (!mEnc.matches()) {
            return null;
        }
        if (mEnc.groupCount() < MIN_GRP_NUM) {
            return null;
        }

        String charsetName = mEnc.group(1);
        LOG.debug("Detected charset " + charsetName + " for input");
        return charsetName;
    }

    /**
     * Convenience method to strip the byte array of zero bytes (such as filling
     * bytes used on some Mac OSX versions).
     *
     * @param bytes byte array that may contain zero bytes (\u0000)
     *
     * @return byte array free of zero bytes.
     */
    public final byte[] removeZeroBytes(final byte[] bytes) {
        // This code is pretty low-level and may seem peculiar.
        // The reason for coding it this way is performance. If a
        // collection is used here rather than a staging array,
        // the performance drops immensely.
        byte[] temp = new byte[bytes.length];
        int count = 0;
        for (byte aByte : bytes) {
            if (aByte != (byte) 0) {
                temp[count] = aByte;
                count++;
            }
        }

        // Now we know how many bytes we retrieved,
        // so create a smaller array for the final result
        // if necessary.
        byte[] result;
        if (count != bytes.length) {
            result = new byte[count];
            System.arraycopy(temp, 0, result, 0, count);
        } else {
            result = temp;
        }

        return result;
    }

    /**
     * Converts the specified byte array into a String, using the encoding
     * defined for this StandardXmlElementExtractor.
     *
     * @param bytes The byte array to convert into a String.
     *
     * @return The String representation of the byte array.
     *
     * @throws IllegalStateException                If no character encoding is available.
     * @throws java.io.UnsupportedEncodingException if the set character
     *                                              encoding is not supported.
     * @see setUseSystemDefaultEncoding(boolean)
     * @see setEncoding(String)
     */
    public final String bytes2String(final byte[] bytes)
            throws UnsupportedEncodingException {

        // if the user prefers the system default character encoding our life is easy
        if (isUseSystemDefaultEncoding()) {
            if (LOG.isDebugEnabled()) {
                LOG.info("Using system default for encoding.");
            }
            return new String(bytes, "UTF-8");
        }
        // if not we use the set encoding

        // quick check that there is one
        if (getEncoding() == null) {
            throw new IllegalStateException("No character encoding available to convert the byte array!");
        }

        // use the encoding to translate the byte array into a String
        return new String(bytes, getEncoding().name());
    }

    /**
     * Skips n bytes. Codes are from
     * http://stackoverflow.com/questions/14057720/robust-skipping-of-data-in-a-java-io-inputstream-and-its-subtypes
     *
     * @param is inputStream
     * @param n  number of bytes to skip
     *
     * @throws IOException IOException
     */
    private void myskip(final InputStream is, final long n)
            throws IOException {
        long m = n;
        while (m > 0) {
            long n1 = is.skip(m);
            if (n1 > 0) {
                m -= n1;
            } else if (n1 == 0) { // should we retry? lets read one byte
                if (is.read() == -1) { // EOF
                    break;
                } else {
                    m--;
                }
            } else { // negative? this should never happen but...
                throw new IOException("skip() returned a negative value - this should never happen");
            }
        }
    }

}
