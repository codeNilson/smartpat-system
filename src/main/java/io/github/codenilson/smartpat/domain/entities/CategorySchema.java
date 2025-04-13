package io.github.codenilson.smartpat.domain.entities;

public class CategorySchema {

    private Long id;
    private Category category;
    private String fieldName;
    private String fieldType;

    public CategorySchema() {
    }

    public CategorySchema(Long id, Category category, String fieldName, String fieldType) {
        this.id = id;
        this.category = category;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
