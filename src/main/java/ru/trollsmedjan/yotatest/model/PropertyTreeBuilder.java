package ru.trollsmedjan.yotatest.model;

import org.springframework.stereotype.Service;
import ru.trollsmedjan.yotatest.model.entities.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syachin on 21.05.2015.
 */
@Service
public class PropertyTreeBuilder {

    private Map<Long, List<Property>> buildMapByParentId(List<Property> properties) {
        Map<Long, List<Property>> result = new HashMap<>();
        for (Property property : properties) {
            if (!result.containsKey(property.getParentId())) {
                result.put(property.getParentId(), new ArrayList<>());
            }
            List<Property> list = result.get(property.getParentId());
            list.add(property);
        }
        return result;
    }

    public void fillRootsWithChilds(List<Property> rootProperties, List<Property> childProperties) {
        Map<Long, List<Property>> childs = buildMapByParentId(childProperties);

        for (Property root : rootProperties) {
            fillPropertyWithChilds(root, childs);
        }
    }

    private void fillPropertyWithChilds(Property property, Map<Long, List<Property>> childs) {
        if (childs.containsKey(property.getId())) {
            property.setChilds(childs.get(property.getId()));
            for (Property child : property.getChilds()) {
                fillPropertyWithChilds(child, childs);
            }
        }
    }

}
