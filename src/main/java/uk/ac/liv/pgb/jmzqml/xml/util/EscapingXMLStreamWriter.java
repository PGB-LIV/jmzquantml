package uk.ac.liv.pgb.jmzqml.xml.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Delegating {@link javax.xml.stream.XMLStreamWriter} that filters out UTF-8 characters that
 * are illegal in XML.
 * 
 * <p>See forum post: http://glassfish.10926.n7.nabble.com/Escaping-illegal-characters-during-marshalling-td59751.html#a20090044
 *
 * @author Erik van Zijst
 */
public class EscapingXMLStreamWriter implements XMLStreamWriter {

    private final XMLStreamWriter writer;
    private String charEncoding;

    public EscapingXMLStreamWriter(final XMLStreamWriter writer) {

        if (null == writer) {
            throw new IllegalArgumentException("null");
        } else {
            this.writer = writer;
        }
        this.charEncoding = "UTF-8";
    }

    public EscapingXMLStreamWriter(final XMLStreamWriter writer, final String encoding) {
        this(writer);
        if (encoding != null) {
            this.charEncoding = encoding;
        }
    }

    @Override
    public void writeStartElement(final String s) throws XMLStreamException {
        writer.writeStartElement(s);
    }

    @Override
    public void writeStartElement(final String s, final String s1) throws XMLStreamException {
        writer.writeStartElement(s, s1);
    }

    @Override
    public void writeStartElement(final String s, final String s1, final String s2)
            throws XMLStreamException {
        writer.writeStartElement(s, s1, s2);
    }

    @Override
    public void writeEmptyElement(final String s, final String s1) throws XMLStreamException {
        writer.writeEmptyElement(s, s1);
    }

    @Override
    public void writeEmptyElement(final String s, final String s1, final String s2)
            throws XMLStreamException {
        writer.writeEmptyElement(s, s1, s2);
    }

    @Override
    public void writeEmptyElement(final String s) throws XMLStreamException {
        writer.writeEmptyElement(s);
    }

    @Override
    public void writeEndElement() throws XMLStreamException {
        writer.writeEndElement();
    }

    @Override
    public void writeEndDocument() throws XMLStreamException {
        writer.writeEndDocument();
    }

    @Override
    public void close() throws XMLStreamException {
        writer.close();
    }

    @Override
    public void flush() throws XMLStreamException {
        writer.flush();
    }

    @Override
    public void writeAttribute(final String localName, final String value) throws XMLStreamException {
        writer.writeAttribute(localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public void writeAttribute(final String prefix, final String namespaceUri, final String localName, final String value)
            throws XMLStreamException {
        writer.writeAttribute(prefix, namespaceUri, localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public void writeAttribute(final String namespaceUri, final String localName, final String value)
            throws XMLStreamException {
        writer.writeAttribute(namespaceUri, localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public void writeNamespace(final String s, final String s1) throws XMLStreamException {
        writer.writeNamespace(s, s1);
    }

    @Override
    public void writeDefaultNamespace(final String s) throws XMLStreamException {
        writer.writeDefaultNamespace(s);
    }

    @Override
    public void writeComment(final String s) throws XMLStreamException {
        writer.writeComment(s);
    }

    @Override
    public void writeProcessingInstruction(final String s) throws XMLStreamException {
        writer.writeProcessingInstruction(s);
    }

    @Override
    public void writeProcessingInstruction(final String s, final String s1)
            throws XMLStreamException {
        writer.writeProcessingInstruction(s, s1);
    }

    @Override
    public void writeCData(final String s) throws XMLStreamException {
        writer.writeCData(EscapingXMLUtilities.escapeCharacters(s));
    }

    @Override
    public void writeDTD(final String s) throws XMLStreamException {
        writer.writeDTD(s);
    }

    @Override
    public void writeEntityRef(final String s) throws XMLStreamException {
        writer.writeEntityRef(s);
    }

    @Override
    public void writeStartDocument() throws XMLStreamException {
        writer.writeStartDocument(this.charEncoding,"1.0");
    }

    @Override
    public void writeStartDocument(final String s) throws XMLStreamException {
        writer.writeStartDocument(s);
    }

    @Override
    public void writeStartDocument(final String s, final String s1)
            throws XMLStreamException {
        writer.writeStartDocument(s, s1);
    }

    @Override
    public void writeCharacters(final String s) throws XMLStreamException {
        writer.writeCharacters(EscapingXMLUtilities.escapeCharacters(s));
    }

    @Override
    public void writeCharacters(final char[] chars, final int start, final int len)
            throws XMLStreamException {
        writer.writeCharacters(EscapingXMLUtilities.escapeCharacters(new String(chars, start, len)));
    }

    @Override
    public String getPrefix(final String s) throws XMLStreamException {
        return writer.getPrefix(s);
    }

    @Override
    public void setPrefix(final String s, final String s1) throws XMLStreamException {
        writer.setPrefix(s, s1);
    }

    @Override
    public void setDefaultNamespace(final String s) throws XMLStreamException {
        writer.setDefaultNamespace(s);
    }

    @Override
    public void setNamespaceContext(final NamespaceContext namespaceContext)
            throws XMLStreamException {
        writer.setNamespaceContext(namespaceContext);
    }

    @Override
    public NamespaceContext getNamespaceContext() {
        return writer.getNamespaceContext();
    }

    @Override
    public Object getProperty(final String s) throws IllegalArgumentException {
        return writer.getProperty(s);
    }
}