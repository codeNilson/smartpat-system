module io.github.codenilson.smartpat {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.databind;
    requires com.google.guice;

    opens io.github.codenilson.smartpat.controllers to javafx.fxml, com.google.guice;
    opens io.github.codenilson.smartpat.entities to org.hibernate.orm.core;
    opens io.github.codenilson.smartpat.services to com.google.guice;

    exports io.github.codenilson.smartpat;
    exports io.github.codenilson.smartpat.persistence.converters;
}
