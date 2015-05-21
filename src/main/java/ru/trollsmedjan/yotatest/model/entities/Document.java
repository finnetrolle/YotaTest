package ru.trollsmedjan.yotatest.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syachin on 21.05.2015.
 */

@Entity
@Table(name="documents")
public class Document {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Transient
    private List<Property> childs = new ArrayList<>();

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childs.size=" + childs.size() +
                '}';
    }

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

    public List<Property> getChilds() {
        return childs;
    }

    public void setChilds(List<Property> childs) {
        this.childs = childs;
    }
}
