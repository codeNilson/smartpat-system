package io.github.codenilson.smartpat.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class AlertError {
    private final String message;

    public AlertError(String message) {
        this.message = message;
    }

    public void execute() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error occurred");
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.lookupButton(ButtonType.OK).getStyleClass().add("button-ok");
        Util.loadStyleSheet(dialogPane, "/styles/main.css");

        alert.showAndWait();
    }

}
