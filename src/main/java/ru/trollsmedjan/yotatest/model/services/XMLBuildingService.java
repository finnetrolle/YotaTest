package ru.trollsmedjan.yotatest.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.entities.Property;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

/**
 * Created by finnetrolle on 22.05.2015.
 */
@Service
public class XMLBuildingService {

    @Autowired
    private DocumentBuildingService documentBuildingService;

    public void createXML(Long id, OutputStream outputStream) throws ParserConfigurationException, TransformerException{
        Document doc = documentBuildingService.loadAndBuild(id);

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        org.w3c.dom.Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("document");
        document.appendChild(rootElement);

        for (Property child : doc.getChilds()) {
            appendChild(child, rootElement, document);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(outputStream);

        transformer.transform(source, result);

    }

    private void appendChild(Property property, Element parentElement, org.w3c.dom.Document document) {
        Element element = document.createElement("property");
        element.setAttribute("name", property.getName());
        parentElement.appendChild(element);
        for (Property child : property.getChilds()) {
            appendChild(child, element, document);
        }
    }
}
