package io.github.codenilson.smartpat.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class AlertConfirmation {
    private Alert alert;
    private final String alertMessage;

    public AlertConfirmation(String alertMessage) {
        this.alert = new Alert(AlertType.CONFIRMATION);
        this.alertMessage = alertMessage;
    }

    public void execute() {
        alert.setTitle("Alerta!");
        alert.setHeaderText("Tem certeza que deseja sair?");
        alert.setContentText(alertMessage);

        DialogPane dialogPane = alert.getDialogPane();
        Util.loadStyleSheet(dialogPane, "/styles/main.css");

        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.getStyleClass().add("button-ok");

        Button cancelButton = (Button) dialogPane.lookupButton(ButtonType.CANCEL);
        cancelButton.getStyleClass().add("button-cancel");

        alert.showAndWait();
    }

    public Alert getAlert() {
        return alert;
    }
}