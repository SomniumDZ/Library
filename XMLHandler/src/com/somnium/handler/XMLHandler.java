package com.somnium.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler extends DefaultHandler {
    private Element parent;
    private Element root;
    private Element current;

    //    Parsing
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println(qName);

        current = new Element();
        for (int i = 0; i < attributes.getLength(); i++) {
            current.getAttributes().put(attributes.getQName(i), attributes.getValue(i));
        }

        if (parent == null){
            root = current;
            parent = root;
            return;
        }
        parent.getChildElements().add(current);
        current.setName(qName);
        current.setParent(parent);
        parent = current;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (!current.equals(root)) {
            current = parent;
            parent = current.getParent();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        value = value.replace("\n", "").trim();
        if (!value.isEmpty())current.setValue(value);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        super.ignorableWhitespace(ch, start, length);
    }

    public Element getRoot() {
        return root;
    }
}
