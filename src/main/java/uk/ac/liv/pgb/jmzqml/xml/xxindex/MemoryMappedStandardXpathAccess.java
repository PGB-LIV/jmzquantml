
package uk.ac.liv.pgb.jmzqml.xml.xxindex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import psidev.psi.tools.xxindex.XpathAccess;
import psidev.psi.tools.xxindex.index.ByteBuffer;
import psidev.psi.tools.xxindex.index.IndexElement;
import psidev.psi.tools.xxindex.index.XmlElement;
import psidev.psi.tools.xxindex.index.XmlXpathIndexer;
import psidev.psi.tools.xxindex.index.XpathIndex;

/**
 * @author Rui Wang
 * @version $Id$
 */
public class MemoryMappedStandardXpathAccess implements XpathAccess {

    private static final Log LOG = LogFactory.getLog(
            MemoryMappedStandardXpathAccess.class);

    private byte[] fileBuffer;
    private XpathIndex index;
    private MemoryMappedXmlElementExtractor extractor;
    private boolean ignoreNSPrefix = true;

    ////////////////////
    // Constructors
    /**
     * This constructor creates an xpath index (LineXpathIndex) from the
     * specified XML file,
     * and will include all encountered xpaths in this index.
     * Note: this XpathAccess can handle gz compressed files, but the
     * performance will be impaired!
     *
     * @param fileBufferp File with the XML file to index
     *
     * @throws java.io.IOException when the file could not be accessed
     */
    public MemoryMappedStandardXpathAccess(final byte[] fileBufferp)
            throws IOException {
        this(fileBufferp, null);
    }

    /**
     * This constructor creates an xpath index (XpathIndex) from the specified
     * XML file,
     * and takes a set of xpaths to include in this index.
     * All xpaths that do not correspond to one of the xpaths included
     * in this set will be ignored and therefore omitted from the index!
     *
     * @param fileBufferp        File with the XML file to index.
     * @param aXpathInclusionSet Set with the String representation of the
     *                           xpaths to include in the index.
     * <b>Note</b> that these xpaths should have their trailing '/' removed!
     * <b>Also note</b> that any xpath not included in this list will <b>not</b>
     * be added
     * to the index! Can be 'null' to ensure inclusion of all xpaths.
     *
     * @throws IOException when the file could not be accessed
     */
    public MemoryMappedStandardXpathAccess(final byte[] fileBufferp,
                                           final Set<String> aXpathInclusionSet)
            throws IOException {
        this(fileBufferp, aXpathInclusionSet, true);
    }

    /**
     * This constructor creates an xpath index for the specified XML file,
     * considering the given
     * xpath inclusion list. It will record the line numbers of the XML starting
     * tags according to the
     * specified value of the recordLineNumbers parameter.
     *
     * @param fileBufferp        File with the XML file to index.
     * @param aXpathInclusionSet Set with the String representation of the
     *                           xpaths to include in the index.
     * @param recordLineNumbers  flag whether to record the line numbers of the
     *                           XML starting tags.
     *
     * @throws IOException when the file could not be accessed
     */
    public MemoryMappedStandardXpathAccess(final byte[] fileBufferp,
                                           final Set<String> aXpathInclusionSet,
                                           final boolean recordLineNumbers)
            throws IOException {

        if (fileBufferp == null) {
            throw new IllegalArgumentException(
                    "The input file input stream must not be null!");
        }

        this.fileBuffer = fileBufferp.clone();

        // choosing the Extractor to use
        this.index = XmlXpathIndexer.buildIndex(new ByteArrayInputStream(
                fileBufferp), aXpathInclusionSet, recordLineNumbers);
        this.extractor = new MemoryMappedXmlElementExtractor();

        String enc = extractor.detectFileEncoding(new ByteArrayInputStream(
                fileBufferp));
        if (enc != null) {
            extractor.setEncoding(enc);
        }
    }

    ////////////////////
    // Getter & Setter
    /**
     * This method gives access to the XpathIndex that is used internally in
     * this XpathAccess implementation.
     * Note: the used index is a StandardXpathIndex and the returned Object can
     * therefore be cased to
     * StandardXpathIndex to get access to more specific functionality.
     *
     * @return the created index.
     *
     * @see psidev.psi.tools.xxindex.index.StandardXpathIndex
     */
    @Override
    public final XpathIndex getIndex() {
        return index;
    }

    /**
     *
     * @return true if is ignore NS prefix
     */
    public final boolean isIgnoreNSPrefix() {
        return ignoreNSPrefix;
    }

    /**
     *
     * @param ignoreNSPrefixp ignore NS prefix
     */
    public final void setIgnoreNSPrefix(final boolean ignoreNSPrefixp) {
        this.ignoreNSPrefix = ignoreNSPrefixp;
    }

    /**
     *
     * @return memory mapped XML element extractor
     */
    public final MemoryMappedXmlElementExtractor getExtractor() {
        return extractor;
    }

    ////////////////////
    // Method
    /**
     * This method will retrieve XML snippets for the specified xpath. The xpath
     * defines the path from
     * the root element to the XML element to extract.
     *
     * @param xpath a xpath expression valid for the XML file.
     *
     * @return a List of Strings representing the XML elements specified with
     *         the xpath.
     *
     * @throws IOException when IO Error while reading from the XML file.
     */
    @Override
    public final List<String> getXmlSnippets(final String xpath)
            throws IOException {
        return getXmlSnippets(xpath, null, null);
    }

    /**
     * This method will retrieve XML snippets for the specified xpath. The xpath
     * defines the path from
     * the root element to the XML element to extract.
     * Only elements that are located <b>between</b> the specified start and
     * stop byte positions
     * will be returned.
     * <pre>
     * Requirement for a XML element to be returned:
     *     element.getStart() &gt;= start &amp;&amp; element.getStop() &lt;= stop
     * Note: the start and stop parameters can be null, in which case snippets for <b>all</b> the XML elements
     *     for the specified xpath will be returned.
     * </pre>
     *
     * @param xpath a xpath expression valid for the XML file.
     * @param start the start byte position, before which no elements will be
     *              returned.
     * @param stop  the stop byte position, after which no elements will be
     *              returned.
     *
     * @return a List of Strings representing the XML elements specified with
     *         the xpath and within the specified range.
     *
     * @throws IOException when IO Error while reading from the XML file.
     *
     */
    public final List<String> getXmlSnippets(final String xpath,
                                             final Long start,
                                             final Long stop)
            throws IOException {
        List<String> results = new ArrayList<>();
        // check xpath
        // check if xpath in index
        if (index.containsXpath(xpath)) {
            // retrieve ByteRange from index
            List<IndexElement> ranges = index.getElements(xpath);
            // get String for ByteRange
            for (IndexElement range : ranges) {
                if ((start == null || range.getStart() >= start) && (stop
                        == null || range.
                        getStop() <= stop)) {
                    results.add(extractor.readString(range.getStart(), range.
                                                     getStop(),
                                                     new ByteArrayInputStream(
                                                             fileBuffer)));
                }
            }
        } else {
            // Error message
            LOG.info(
                    "The index does not contain any entry for the requested xpath: "
                    + xpath);
        }
        return results;
    }

    /**
     * This method can be used whenever the expected list of XML snippets is
     * very long. The snippets
     * are not read all at once, but rather every call of next() will read
     * another XML snippet.
     *
     * @param xpath a xpath expression valid for the XML file.
     *
     * @return a Iterator over the Strings representing the XML elements
     *         specified with the xpath.
     */
    @Override
    public final Iterator<String> getXmlSnippetIterator(final String xpath) {
        return getXmlSnippetIterator(xpath, null, null);
    }

    /**
     * This method can be used whenever the expected list of XML snippets is
     * very long. The snippets
     * are not read all at once, but rather every call of next() will read
     * another XML snippet.
     * Only elements that are located <b>between</b> the specified start and
     * stop byte positions
     * will be returned.
     *
     * @param xpath a xpath expression valid for the XML file.
     * @param start the start byte position, before which no elements will be
     *              returned.
     * @param stop  the stop byte position, after which no elements will be
     *              returned.
     *
     * @return a Iterator over the Strings representing the XML elements
     *         specified with the xpath.
     */
    @Override
    public final Iterator<String> getXmlSnippetIterator(final String xpath,
                                                        final Long start,
                                                        final Long stop) {
        Iterator<String> iter;
        if (index.containsXpath(xpath)) {
            // retrieve ByteRange from index
            List<IndexElement> ranges = index.getElements(xpath);

            iter = new XmlSnippetIterator(ranges, extractor, fileBuffer, start,
                                          stop);
        } else {
            LOG.info(
                    "The index does not contain any entry for the requested xpath: "
                    + xpath);
            // return iterator over empty list
            List<String> s = Collections.emptyList();
            iter = s.iterator();
        }
        return iter;
    }

    /**
     * @param xpath the xpath expression of the XML element of interest.
     *
     * @return the number of elements that correspond to the specified xpath or
     *         -1 if the xpath is not recognized.
     */
    public final int getXmlElementCount(final String xpath) {
        return index.getElementCount(xpath);
    }

    /**
     * A method to extract the start tag only of a XML element.
     * Note: that the start tag includes all the XML element attributes.
     * This method provides therefore access to the XML element attributes
     * without the need of reading the whole element (start tag to stop tag).
     *
     * @param element the IndexElement defining the XML element.
     *
     * @return a String of the full start tag.
     *
     * @throws java.io.IOException in case of reading errors from the underlying
     *                             XML file.
     */
    public final String getStartTag(final IndexElement element)
            throws IOException {
        String startTag = null;
        // start reading (byte by byte) from the start position, until we find
        // the end of the start tag (">"). Then return the complete start tag
        // (including all the attributes)

        InputStream inputStream = new ByteArrayInputStream(fileBuffer);
        long start = element.getStart();
        long skipped = inputStream.skip(start);
        if (skipped != start) {
            throw new IllegalStateException(
                    "Could not position at requested location, reading compromised! Location: "
                    + start);
        }

        // check whether we are dealing with a gzip'ed file
        boolean stopFound = false;
        ByteBuffer bb = new ByteBuffer();
        byte[] buffer = new byte[1];
        byte read;
        int count = 0;
        while (!stopFound) {
            count = inputStream.read(buffer);
            if (count > 0) {
                read = buffer[0];
                bb.append(read);
                if (read == '>') {
                    stopFound = true;
                }
            }
        }
        startTag = bb.toString("ASCII");

        return startTag;
    }

    /**
     * + Private Iterator implementation that allows the iteration over XML
     * snippets as Strings.
     */
    private static class XmlSnippetIterator implements Iterator<String> {

        private Iterator<IndexElement> iterator;
        private MemoryMappedXmlElementExtractor extractor;
//        private InputStream inputStream;
        private byte[] fileBuffer;

        /**
         *
         * @param ranges      element ranges
         * @param extractorp  memory mapped XML element extractor
         * @param fileBufferp file buffer
         */
        XmlSnippetIterator(final List<IndexElement> ranges,
                           final MemoryMappedXmlElementExtractor extractorp,
                           final byte[] fileBufferp) {
            this.iterator = ranges.iterator();
            this.extractor = extractorp;
//            this.inputStream = inputStream;
            this.fileBuffer = fileBufferp;
        }

        /**
         *
         * @param elements    elements
         * @param extractorp  memory mapped XML element extractor
         * @param fileBufferp file buffer
         * @param start       start position
         * @param stop        stop position
         */
        XmlSnippetIterator(final List<IndexElement> elements,
                           final MemoryMappedXmlElementExtractor extractorp,
                           final byte[] fileBufferp, final Long start,
                           final Long stop) {
            List<IndexElement> validElements; // the list of elements we will iterate over

            // if both borders are unspecified, use all elements (initial list)
            if (start == null && stop == null) {
                validElements = elements;
            } else { // if at least one border is specified, we need a new list containing only valid elements
                validElements = new ArrayList<>();
                // iterate over the initial list and add only the valid elements to the new list
                for (IndexElement element : elements) {
                    if ((start == null || element.getStart() >= start) && (stop
                            == null || element.
                            getStop() <= stop)) {
                        validElements.add(element);
                    }
                }
            }
            // only use the IndexElements that are in the valid range
            this.iterator = validElements.iterator();
            this.extractor = extractorp;
//            this.inputStream = inputStream;
            this.fileBuffer = fileBufferp;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * This will throw a runtime exception if an IOException occurs during
         * reading from the file.
         *
         * @return the String represetation of the XML snippet.
         */
        @Override
        public String next() {
            String result;
            IndexElement range = iterator.next();
            try {
                result = extractor.readString(range.getStart(), range.getStop(),
                                              new ByteArrayInputStream(
                                                      fileBuffer));
            } catch (IOException e) {
                throw new IllegalStateException(
                        "Caught IOException while reading from file", e);
            }
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    /**
     * This mehtod will retrieve XML snippets for the specified xpath bundeled
     * with the
     * line number in which the xml snippet started. The xpath defines the path
     * from
     * the root element to the XML element to extract.
     *
     * @param xpath a xpath expression valid for the XML file.
     *
     * @return a List of LineXmlElement representing the XML elements specified
     *         with
     *         the xpath and their starting line number.
     *
     * @throws IOException when IO Error while reading from the XML file.
     */
    public final List<XmlElement> getXmlElements(final String xpath)
            throws IOException {
        return getXmlElements(xpath, null, null);
    }

    /**
     * This mehtod will retrieve XML snippets for the specified xpath bundeled
     * with the
     * line number in which the XML snippet started. The xpath defines the path
     * from
     * the root element to the XML element to extract.
     * Only elements that are located <b>between</b> the specified start and
     * stop byte positions
     * will be returned.
     *
     * @param xpath a xpath expression valid for the XML file.
     * @param start the start byte position, before which no elements will be
     *              returned.
     * @param stop  the stop byte position, after which no elements will be
     *              returned.
     *
     * @return a List of LineXmlElement representing the XML elements specified
     *         with
     *         the xpath and their starting line number.
     *
     * @throws IOException when IO Error while reading from the XML file.
     */
    public final List<XmlElement> getXmlElements(final String xpath,
                                                 final Long start,
                                                 final Long stop)
            throws IOException {
        List<XmlElement> results = new ArrayList<>();
        // check xpath
        // check if xpath in index
        // if yes, transform (range + line number) into (xml snippet + line number)
        if (index.containsXpath(xpath)) {
            // retrieve the xml element (range + line number) from index
            List<IndexElement> elements = index.getElements(xpath);
            // get String for ByteRange and get the line number for the range
            for (IndexElement element : elements) {
                if ((start == null || element.getStart() >= start) && (stop
                        == null || element.
                        getStop() <= stop)) {
                    String tmp = extractor.readString(element.getStart(),
                                                      element.getStop(),
                                                      new ByteArrayInputStream(
                                                              fileBuffer));
                    long posTmp = element.getLineNumber();
                    results.add(new XmlElement(tmp, posTmp));
                }
            }
        } else {
            // Error message
            LOG.info(
                    "The index does not contain any entry for the requested xpath: "
                    + xpath);
        }
        return results;
    }

    /**
     * This method can be used whenever the expected list of XmlElements is very
     * long. The elements
     * are not produced all at once, but rather every call of next() will create
     * another XmlElement.
     *
     * @param xpath a xpath expression valid for the XML file.
     *
     * @return a Iterator over the LineXmlElement representing the XML elements
     *         specified with
     *         the xpath and their starting line number.
     */
    public final Iterator<XmlElement> getXmlElementIterator(final String xpath) {
        return getXmlElementIterator(xpath, null, null);
    }

    /**
     * This method can be used whenever the expected list of XmlElements is very
     * long. The elements
     * are not produced all at once, but rather every call of next() will create
     * another XmlElement.
     * Only elements that are located <b>between</b> the specified start and
     * stop byte positions
     * will be returned.
     *
     * @param xpath a xpath expression valid for the XML file.
     * @param start the start byte position, before which no elements will be
     *              returned.
     * @param stop  the stop byte position, after which no elements will be
     *              returned.
     *
     * @return a Iterator over the LineXmlElement representing the XML elements
     *         specified with
     *         the xpath and their starting line number.
     */
    public final Iterator<XmlElement> getXmlElementIterator(final String xpath,
                                                            final Long start,
                                                            final Long stop) {
        Iterator<XmlElement> iter;
        if (index.containsXpath(xpath)) {
            // retrieve ByteRange from index
            List<IndexElement> elements = index.getElements(xpath);

            iter = new XmlElementIterator(elements, extractor,
                                          new ByteArrayInputStream(fileBuffer),
                                          start, stop);
        } else {
            // Error message
            LOG.info(
                    "The index does not contain any entry for the requested xpath: "
                    + xpath);
            // return iterator over empty list
            List<XmlElement> s = Collections.emptyList();
            iter = s.iterator();
        }
        return iter;
    }

    /**
     * Private Iterator implementation that allows the iteration over
     * IndexElement Objects.
     */
    private static class XmlElementIterator implements Iterator<XmlElement> {

        private Iterator<IndexElement> iterator;
        private MemoryMappedXmlElementExtractor extractor;
        private InputStream inputStream;

        /**
         *
         * @param elements     elements
         * @param extractorp   memory mapped XML element extractor
         * @param inputStreamp input stream
         */
        XmlElementIterator(final List<IndexElement> elements,
                           final MemoryMappedXmlElementExtractor extractorp,
                           final InputStream inputStreamp) {
            this.iterator = elements.iterator();
            this.extractor = extractorp;
            this.inputStream = inputStreamp;
        }

        /**
         *
         * @param elements     elements
         * @param extractorp   memory mapped XML element extractor
         * @param inputStreamp input stream
         * @param start        start position
         * @param stop         stop position
         */
        XmlElementIterator(final List<IndexElement> elements,
                           final MemoryMappedXmlElementExtractor extractorp,
                           final InputStream inputStreamp,
                           final Long start, final Long stop) {
            List<IndexElement> validElements; // the list of elements we will iterate over
            // if both borders are unspecified, iterate over all elements (initial list)
            if (start == null && stop == null) {
                validElements = elements;
            } else { // if at least one borders is specified, we need a new list containing only valid elements
                validElements = new ArrayList<>();
                // iterate over the initial list and only add the valid elements to the new list
                for (IndexElement element : elements) {
                    if ((start == null || element.getStart() >= start) && (stop
                            == null || element.
                            getStop() <= stop)) {
                        validElements.add(element);
                    }
                }
            }

            // only use the IndexElements that are in the valid range
            this.iterator = validElements.iterator();
            this.extractor = extractorp;
            this.inputStream = inputStreamp;
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * This will throw a runtime exception if an IOException occurs during
         * reading from the file.
         *
         * @return the LineXmlElement represetating of the XML snippet and line
         *         number it started..
         */
        @Override
        public XmlElement next() {
            XmlElement result;
            IndexElement element = iterator.next();
            try {
                String xmlSnippet = extractor.readString(element.getStart(),
                                                         element.getStop(),
                                                         inputStream);
                long position = element.getLineNumber();
                result = new XmlElement(xmlSnippet, position);
            } catch (IOException e) {
                throw new IllegalStateException(
                        "Caught IOException while reading from file");
            }
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}
