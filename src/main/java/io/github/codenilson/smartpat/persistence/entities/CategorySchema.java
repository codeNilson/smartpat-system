package io.github.codenilson.smartpat.persistence.entities;

import io.github.codenilson.smartpat.persistence.entities.CategorySchema;
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

    private String fieldName;

    private String fieldType;

    public CategorySchema() {
    }

    public CategorySchema(Category category, String fieldName, String fieldType) {
        this.category = category;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
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

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public String toString() {
        return "CategorySchema [id=" + id + ", category=" + category + ", fieldName=" + fieldName + ", fieldType="
                + fieldType + "]";
    }

}
