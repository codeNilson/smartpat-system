package io.github.codenilson.smartpat.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertMessage {
    private final AlertType type;
    private final String title;
    private final String message;

    public AlertMessage(AlertType type, String title, String message) {
        this.type = type;
        this.title = title;
        this.message = message;
    }

    public void execute() {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
