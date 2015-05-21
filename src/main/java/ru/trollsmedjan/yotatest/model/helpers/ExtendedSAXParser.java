package ru.trollsmedjan.yotatest.model.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import ru.trollsmedjan.yotatest.model.dao.DocumentRepository;
import ru.trollsmedjan.yotatest.model.dao.PropertyRepository;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.entities.Property;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by syachin on 21.05.2015.
 */

public class ExtendedSAXParser extends DefaultHandler {

    private Document document = null;

    private Property currentProperty = null;

    @Override
    public void startDocument() throws SAXException {
        document = new Document();
        currentProperty = null;
        document.setName("some name here");
        System.out.println(document);
    }

    @Override
    public void endDocument() throws SAXException {
        document.setChilds(currentProperty.getChilds());
        System.out.println(document);
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        Property property = new Property();
        property.setDocument(document);
        property.setName(atts.getValue("name"));
        property.setParent(currentProperty);
        currentProperty = property;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        Property parent = currentProperty.getParent();
        if (parent != null) {
            parent.getChilds().add(currentProperty);
            currentProperty = parent;
        }
    }

    public Document getDocument() {
        return document;
    }
}

















