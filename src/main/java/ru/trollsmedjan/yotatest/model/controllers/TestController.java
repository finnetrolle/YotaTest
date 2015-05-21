package ru.trollsmedjan.yotatest.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.trollsmedjan.yotatest.model.PropertyTreeBuilder;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.entities.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syachin on 21.05.2015.
 */
@RestController
@RequestMapping("/rest")
public class TestController {

    @Autowired
    private PropertyTreeBuilder propertyTreeBuilder;

    @RequestMapping
    public @ResponseBody
    Document get() {
        Document document = new Document();
        document.setName("test document");
        document.setId(1);

        Property property = null;
        List<Property> roots = new ArrayList<>();
        List<Property> childs = new ArrayList<>();

        // roots
        property = new Property();
        property.setId(1);
        property.setName("root 1");
        property.setDocument(document);
        property.setParentId(0);
        roots.add(property);

        property = new Property();
        property.setId(2);
        property.setName("root 2");
        property.setDocument(document);
        property.setParentId(0);
        roots.add(property);

        // childs for 1st root
        property = new Property();
        property.setId(3);
        property.setName("child 1-1");
        property.setDocument(document);
        property.setParentId(1);
        childs.add(property);

        property = new Property();
        property.setId(4);
        property.setName("child 1-2");
        property.setDocument(document);
        property.setParentId(1);
        childs.add(property);

        property = new Property();
        property.setId(5);
        property.setName("child 1-3");
        property.setDocument(document);
        property.setParentId(1);
        childs.add(property);

        property = new Property();
        property.setId(6);
        property.setName("child 1-2-1");
        property.setDocument(document);
        property.setParentId(4);
        childs.add(property);

        //childs for 2nd root
        property = new Property();
        property.setId(7);
        property.setName("child 2-1");
        property.setDocument(document);
        property.setParentId(2);
        childs.add(property);

        property = new Property();
        property.setId(8);
        property.setName("child 2-1-1");
        property.setDocument(document);
        property.setParentId(7);
        childs.add(property);

        property = new Property();
        property.setId(9);
        property.setName("child 2-1-1-1");
        property.setDocument(document);
        property.setParentId(8);
        childs.add(property);

        property = new Property();
        property.setId(10);
        property.setName("child 2-1-1-2");
        property.setDocument(document);
        property.setParentId(8);
        childs.add(property);

        propertyTreeBuilder.fillRootsWithChilds(roots, childs);

        document.setChilds(roots);
        return document;
    }
}
