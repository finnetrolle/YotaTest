package ru.trollsmedjan.yotatest.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trollsmedjan.yotatest.model.PropertyTreeBuilder;
import ru.trollsmedjan.yotatest.model.dao.DocumentRepository;
import ru.trollsmedjan.yotatest.model.dao.PropertyRepository;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.entities.Property;

import java.util.List;

/**
 * Created by finnetrolle on 22.05.2015.
 */
@Service
public class DocumentBuildingService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyTreeBuilder propertyTreeBuilder;

    public Document loadAndBuild(Long id) {
        Document document = documentRepository.findOne(id);
        if (document == null) {
            return null;
        }

        List<Property> roots = propertyRepository.findByDocumentAndParentId(document, 0L);
        List<Property> childs = propertyRepository.findByDocumentAndParentIdNot(document, 0L);
        propertyTreeBuilder.fillRootsWithChilds(roots, childs);
        document.setChilds(roots);

        return document;
    }
}
