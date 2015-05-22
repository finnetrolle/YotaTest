package ru.trollsmedjan.yotatest.tests;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.trollsmedjan.yotatest.services.PropertyTreeBuilder;
import ru.trollsmedjan.yotatest.YotaTest;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.entities.Property;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = YotaTest.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class PropertyTreeBuilderTest extends TestCase {

    @Autowired
    private PropertyTreeBuilder propertyTreeBuilder;

    @Test
    public void testFillRootsWithChilds() throws Exception {
        Document document = new Document();
        document.setName("test document");
        document.setId(1);

        Property property;
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

        assertEquals(roots.get(1).getChilds().get(0).getChilds().get(0).getChilds().get(1).getName(), "child 2-1-1-2");

    }
}