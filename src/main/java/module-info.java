module io.github.codenilson.smartpat {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.databind;
    requires com.google.guice;

    opens io.github.codenilson.smartpat.controllers to javafx.fxml, com.google.guice;
    opens io.github.codenilson.smartpat.controllers.scenes to javafx.fxml, com.google.guice;
    opens io.github.codenilson.smartpat.controllers.components to javafx.fxml, com.google.guice;
    opens io.github.codenilson.smartpat.persistence.repositories to com.google.guice;
    opens io.github.codenilson.smartpat.application.usecase.category to com.google.guice;
    opens io.github.codenilson.smartpat.application.usecase.asset to com.google.guice;
    opens io.github.codenilson.smartpat.application.usecase.categoryschema to com.google.guice;
    opens io.github.codenilson.smartpat.application.usecase.administrativeunit to com.google.guice;
    opens io.github.codenilson.smartpat.application.usecase.locationunit to com.google.guice;

    opens io.github.codenilson.smartpat.persistence.entities to org.hibernate.orm.core;

    exports io.github.codenilson.smartpat;
    exports io.github.codenilson.smartpat.persistence.converters;
}
