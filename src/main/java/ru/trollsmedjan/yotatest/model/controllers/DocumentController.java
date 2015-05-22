package ru.trollsmedjan.yotatest.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.trollsmedjan.yotatest.model.services.PropertyTreeBuilder;
import ru.trollsmedjan.yotatest.model.dao.DocumentRepository;
import ru.trollsmedjan.yotatest.model.dao.PropertyRepository;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.services.DocumentBuildingService;

/**
 * Created by finnetrolle on 21.05.2015.
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyTreeBuilder propertyTreeBuilder;

    @Autowired
    private DocumentBuildingService documentBuildingService;

    @RequestMapping
    public @ResponseBody
    Iterable<Document> getDocuments() {
        return documentRepository.findAll();
    }

    @RequestMapping("/{id}")
    public @ResponseBody
    Document getDocument(@PathVariable Long id) {
        return documentBuildingService.loadAndBuild(id);
    }
}
