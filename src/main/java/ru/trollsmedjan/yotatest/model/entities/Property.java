package ru.trollsmedjan.yotatest.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syachin on 21.05.2015.
 */
@Entity
@Table(name="properties")
public class Property {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @JsonIgnore
    private long parentId;

    @JsonIgnore
    @ManyToOne
    private Document document;

    @Transient
    private List<Property> childs = new ArrayList<>();



    ///////////////////////////////////////////////////////////////////////////
    //                          GENERATED CODE                               //
    ///////////////////////////////////////////////////////////////////////////


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Property> getChilds() {
        return childs;
    }

    public void setChilds(List<Property> childs) {
        this.childs = childs;
    }
}
