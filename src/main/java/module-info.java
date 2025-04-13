module io.github.codenilson.smartpat {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.databind;
    requires com.google.guice;

    opens io.github.codenilson.smartpat.controllers to javafx.fxml, com.google.guice;
    opens io.github.codenilson.smartpat.persistence.repositories to com.google.guice;
    opens io.github.codenilson.smartpat.usecase.category to com.google.guice;
    opens io.github.codenilson.smartpat.usecase.asset to com.google.guice;
    opens io.github.codenilson.smartpat.usecase.categoryschema to com.google.guice;

    opens io.github.codenilson.smartpat.persistence.entities to org.hibernate.orm.core;

    exports io.github.codenilson.smartpat;
    exports io.github.codenilson.smartpat.persistence.converters;
}
