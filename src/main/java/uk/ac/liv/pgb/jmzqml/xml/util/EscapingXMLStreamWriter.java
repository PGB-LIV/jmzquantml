
package uk.ac.liv.pgb.jmzqml.xml.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Delegating {@link javax.xml.stream.XMLStreamWriter} that filters out UTF-8 characters that
 * are illegal in XML.
 *
 * <p>
 * See forum post: http://glassfish.10926.n7.nabble.com/Escaping-illegal-characters-during-marshalling-td59751.html#a20090044
 *
 * @author Erik van Zijst
 */
public class EscapingXMLStreamWriter implements XMLStreamWriter {

    private final XMLStreamWriter writer;
    private String charEncoding;

    public EscapingXMLStreamWriter(final XMLStreamWriter writerp) {

        if (null == writerp) {
            throw new IllegalArgumentException("null");
        } else {
            this.writer = writerp;
        }
        this.charEncoding = "UTF-8";
    }

    public EscapingXMLStreamWriter(final XMLStreamWriter writerp,
                                   final String encoding) {
        this(writerp);
        if (encoding != null) {
            this.charEncoding = encoding;
        }
    }

    @Override
    public final void writeStartElement(final String s)
            throws XMLStreamException {
        writer.writeStartElement(s);
    }

    @Override
    public final void writeStartElement(final String s, final String s1)
            throws XMLStreamException {
        writer.writeStartElement(s, s1);
    }

    @Override
    public final void writeStartElement(final String s, final String s1,
                                        final String s2)
            throws XMLStreamException {
        writer.writeStartElement(s, s1, s2);
    }

    @Override
    public final void writeEmptyElement(final String s, final String s1)
            throws XMLStreamException {
        writer.writeEmptyElement(s, s1);
    }

    @Override
    public final void writeEmptyElement(final String s, final String s1,
                                        final String s2)
            throws XMLStreamException {
        writer.writeEmptyElement(s, s1, s2);
    }

    @Override
    public final void writeEmptyElement(final String s)
            throws XMLStreamException {
        writer.writeEmptyElement(s);
    }

    @Override
    public final void writeEndElement()
            throws XMLStreamException {
        writer.writeEndElement();
    }

    @Override
    public final void writeEndDocument()
            throws XMLStreamException {
        writer.writeEndDocument();
    }

    @Override
    public final void close()
            throws XMLStreamException {
        writer.close();
    }

    @Override
    public final void flush()
            throws XMLStreamException {
        writer.flush();
    }

    @Override
    public final void writeAttribute(final String localName, final String value)
            throws XMLStreamException {
        writer.writeAttribute(localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public final void writeAttribute(final String prefix,
                                     final String namespaceUri,
                                     final String localName, final String value)
            throws XMLStreamException {
        writer.writeAttribute(prefix, namespaceUri, localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public final void writeAttribute(final String namespaceUri,
                                     final String localName, final String value)
            throws XMLStreamException {
        writer.writeAttribute(namespaceUri, localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public final void writeNamespace(final String s, final String s1)
            throws XMLStreamException {
        writer.writeNamespace(s, s1);
    }

    @Override
    public final void writeDefaultNamespace(final String s)
            throws XMLStreamException {
        writer.writeDefaultNamespace(s);
    }

    @Override
    public final void writeComment(final String s)
            throws XMLStreamException {
        writer.writeComment(s);
    }

    @Override
    public final void writeProcessingInstruction(final String s)
            throws XMLStreamException {
        writer.writeProcessingInstruction(s);
    }

    @Override
    public final void writeProcessingInstruction(final String s, final String s1)
            throws XMLStreamException {
        writer.writeProcessingInstruction(s, s1);
    }

    @Override
    public final void writeCData(final String s)
            throws XMLStreamException {
        writer.writeCData(EscapingXMLUtilities.escapeCharacters(s));
    }

    @Override
    public final void writeDTD(final String s)
            throws XMLStreamException {
        writer.writeDTD(s);
    }

    @Override
    public final void writeEntityRef(final String s)
            throws XMLStreamException {
        writer.writeEntityRef(s);
    }

    @Override
    public final void writeStartDocument()
            throws XMLStreamException {
        writer.writeStartDocument(this.charEncoding, "1.0");
    }

    @Override
    public final void writeStartDocument(final String s)
            throws XMLStreamException {
        writer.writeStartDocument(s);
    }

    @Override
    public final void writeStartDocument(final String s, final String s1)
            throws XMLStreamException {
        writer.writeStartDocument(s, s1);
    }

    @Override
    public final void writeCharacters(final String s)
            throws XMLStreamException {
        writer.writeCharacters(EscapingXMLUtilities.escapeCharacters(s));
    }

    @Override
    public final void writeCharacters(final char[] chars, final int start,
                                      final int len)
            throws XMLStreamException {
        writer.writeCharacters(EscapingXMLUtilities.escapeCharacters(new String(chars, start, len)));
    }

    @Override
    public final String getPrefix(final String s)
            throws XMLStreamException {
        return writer.getPrefix(s);
    }

    @Override
    public final void setPrefix(final String s, final String s1)
            throws XMLStreamException {
        writer.setPrefix(s, s1);
    }

    @Override
    public final void setDefaultNamespace(final String s)
            throws XMLStreamException {
        writer.setDefaultNamespace(s);
    }

    @Override
    public final void setNamespaceContext(
            final NamespaceContext namespaceContext)
            throws XMLStreamException {
        writer.setNamespaceContext(namespaceContext);
    }

    @Override
    public final NamespaceContext getNamespaceContext() {
        return writer.getNamespaceContext();
    }

    @Override
    public final Object getProperty(final String s)
            throws IllegalArgumentException {
        return writer.getProperty(s);
    }

}
