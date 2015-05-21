package ru.trollsmedjan.yotatest.model.helpers;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;


/**
 * Created by syachin on 21.05.2015.
 */

public class ExtendedSAXParser extends DefaultHandler {

    private String offset = "";


    @Override
    public void startDocument() throws SAXException {
        offset = "D";
        System.out.println(offset + " document started");
    }

    @Override
    public void endDocument() throws SAXException {
        offset = "D\\";
        System.out.println(offset + " document ends");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        offset += " ";
        System.out.println(offset + " start element: " + qName);
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        System.out.println(offset + " end element: " + qName);
        offset = offset.substring(0, offset.length()-1);
    }
}
