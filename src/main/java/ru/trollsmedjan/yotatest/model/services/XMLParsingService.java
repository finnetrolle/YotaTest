package ru.trollsmedjan.yotatest.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;
import ru.trollsmedjan.yotatest.model.dao.DocumentRepository;
import ru.trollsmedjan.yotatest.model.dao.PropertyRepository;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.entities.Property;
import ru.trollsmedjan.yotatest.model.helpers.ExtendedSAXParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by finnetrolle on 21.05.2015.
 */
@Service
public class XMLParsingService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public void processUploadedFile(MultipartFile multipartFile) throws IOException, ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ExtendedSAXParser extendedSAXParser = new ExtendedSAXParser();

        parser.parse(new ByteArrayInputStream(multipartFile.getBytes()), extendedSAXParser);

        Document document = extendedSAXParser.getDocument();
        document.setName(multipartFile.getOriginalFilename());

        documentRepository.save(document);

        document.getChilds().forEach(this::saveProperties);
    }

    private void saveProperties(Property property) {
        propertyRepository.save(property);
        for (Property child : property.getChilds()) {
            child.setParentId(property.getId());
            saveProperties(child);
        }
    }



}
