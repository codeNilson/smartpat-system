module com.smartpat {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.smartpat.controllers to javafx.fxml;

    exports com.smartpat;
}
