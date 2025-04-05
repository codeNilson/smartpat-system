module io.github.codenilson.smartpat {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.codenilson.smartpat.controllers to javafx.fxml;

    exports io.github.codenilson.smartpat;
    exports io.github.codenilson.smartpat.entities;
}
