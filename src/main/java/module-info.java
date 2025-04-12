module io.github.codenilson.smartpat {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.databind;

    opens io.github.codenilson.smartpat.controllers to javafx.fxml;
    opens io.github.codenilson.smartpat.entities to org.hibernate.orm.core;

    exports io.github.codenilson.smartpat;
    exports io.github.codenilson.smartpat.persistence.converter;
}
