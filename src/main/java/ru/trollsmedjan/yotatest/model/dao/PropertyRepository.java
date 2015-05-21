package ru.trollsmedjan.yotatest.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.trollsmedjan.yotatest.model.entities.Document;
import ru.trollsmedjan.yotatest.model.entities.Property;

import java.util.List;

/**
 * Created by syachin on 21.05.2015.
 */
@Transactional
public interface PropertyRepository extends CrudRepository<Property, Long> {

    public List<Property> findByDocumentAndParentIdNot(Document document, Long parentId);

    public List<Property> findByDocumentAndParentId(Document document, Long parentId);
}
