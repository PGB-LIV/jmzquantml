package uk.ac.liv.jmzqml.xml.util;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Delegating {@link javax.xml.stream.XMLStreamWriter} that filters out UTF-8 characters that
 * are illegal in XML.
 * <p>
 * See forum post: http://glassfish.10926.n7.nabble.com/Escaping-illegal-characters-during-marshalling-td59751.html#a20090044
 *
 * @author Erik van Zijst
 */
public class EscapingXMLStreamWriter implements XMLStreamWriter {

    private final XMLStreamWriter writer;
    private String charEncoding;

    public EscapingXMLStreamWriter(XMLStreamWriter writer) {

        if (null == writer) {
            throw new IllegalArgumentException("null");
        } else {
            this.writer = writer;
        }
        this.charEncoding = "UTF-8";
    }

    public EscapingXMLStreamWriter(XMLStreamWriter writer, String encoding) {
        this(writer);
        if (encoding != null) {
            this.charEncoding = encoding;
        }
    }

    @Override
    public void writeStartElement(String s) throws XMLStreamException {
        writer.writeStartElement(s);
    }

    @Override
    public void writeStartElement(String s, String s1) throws XMLStreamException {
        writer.writeStartElement(s, s1);
    }

    @Override
    public void writeStartElement(String s, String s1, String s2)
            throws XMLStreamException {
        writer.writeStartElement(s, s1, s2);
    }

    @Override
    public void writeEmptyElement(String s, String s1) throws XMLStreamException {
        writer.writeEmptyElement(s, s1);
    }

    @Override
    public void writeEmptyElement(String s, String s1, String s2)
            throws XMLStreamException {
        writer.writeEmptyElement(s, s1, s2);
    }

    @Override
    public void writeEmptyElement(String s) throws XMLStreamException {
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
    public void writeAttribute(String localName, String value) throws XMLStreamException {
        writer.writeAttribute(localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public void writeAttribute(String prefix, String namespaceUri, String localName, String value)
            throws XMLStreamException {
        writer.writeAttribute(prefix, namespaceUri, localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public void writeAttribute(String namespaceUri, String localName, String value)
            throws XMLStreamException {
        writer.writeAttribute(namespaceUri, localName, EscapingXMLUtilities.escapeCharacters(value));
    }

    @Override
    public void writeNamespace(String s, String s1) throws XMLStreamException {
        writer.writeNamespace(s, s1);
    }

    @Override
    public void writeDefaultNamespace(String s) throws XMLStreamException {
        writer.writeDefaultNamespace(s);
    }

    @Override
    public void writeComment(String s) throws XMLStreamException {
        writer.writeComment(s);
    }

    @Override
    public void writeProcessingInstruction(String s) throws XMLStreamException {
        writer.writeProcessingInstruction(s);
    }

    @Override
    public void writeProcessingInstruction(String s, String s1)
            throws XMLStreamException {
        writer.writeProcessingInstruction(s, s1);
    }

    @Override
    public void writeCData(String s) throws XMLStreamException {
        writer.writeCData(EscapingXMLUtilities.escapeCharacters(s));
    }

    @Override
    public void writeDTD(String s) throws XMLStreamException {
        writer.writeDTD(s);
    }

    @Override
    public void writeEntityRef(String s) throws XMLStreamException {
        writer.writeEntityRef(s);
    }

    @Override
    public void writeStartDocument() throws XMLStreamException {
        writer.writeStartDocument(this.charEncoding,"1.0");
    }

    @Override
    public void writeStartDocument(String s) throws XMLStreamException {
        writer.writeStartDocument(s);
    }

    @Override
    public void writeStartDocument(String s, String s1)
            throws XMLStreamException {
        writer.writeStartDocument(s, s1);
    }

    @Override
    public void writeCharacters(String s) throws XMLStreamException {
        writer.writeCharacters(EscapingXMLUtilities.escapeCharacters(s));
    }

    @Override
    public void writeCharacters(char[] chars, int start, int len)
            throws XMLStreamException {
        writer.writeCharacters(EscapingXMLUtilities.escapeCharacters(new String(chars, start, len)));
    }

    @Override
    public String getPrefix(String s) throws XMLStreamException {
        return writer.getPrefix(s);
    }

    @Override
    public void setPrefix(String s, String s1) throws XMLStreamException {
        writer.setPrefix(s, s1);
    }

    @Override
    public void setDefaultNamespace(String s) throws XMLStreamException {
        writer.setDefaultNamespace(s);
    }

    @Override
    public void setNamespaceContext(NamespaceContext namespaceContext)
            throws XMLStreamException {
        writer.setNamespaceContext(namespaceContext);
    }

    @Override
    public NamespaceContext getNamespaceContext() {
        return writer.getNamespaceContext();
    }

    @Override
    public Object getProperty(String s) throws IllegalArgumentException {
        return writer.getProperty(s);
    }
}