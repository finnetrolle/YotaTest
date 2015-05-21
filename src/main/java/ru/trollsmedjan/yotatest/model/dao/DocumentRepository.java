package ru.trollsmedjan.yotatest.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.trollsmedjan.yotatest.model.entities.Document;

/**
 * Created by syachin on 21.05.2015.
 */
@Transactional
public interface DocumentRepository extends CrudRepository<Document, Long> {

}
