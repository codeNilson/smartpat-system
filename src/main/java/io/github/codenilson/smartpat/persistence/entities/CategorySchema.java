package io.github.codenilson.smartpat.persistence.entities;

import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories_schemas")
public class CategorySchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private Map<String, Object> fieldName;

    public CategorySchema() {
    }

    public CategorySchema(Category category, Map<String, Object> fieldName) {
        this.category = category;
        this.fieldName = fieldName;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Map<String, Object> getFieldName() {
        return fieldName;
    }

    public void setFieldName(Map<String, Object> fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "CategorySchema{" +
                "id=" + id +
                ", category=" + category +
                ", fieldName=" + fieldName +
                '}';
    }

}
