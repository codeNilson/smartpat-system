package io.github.codenilson.smartpat.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DetailItemController {
    @FXML
    private Button closeButton;

    public void onCloseButtonAction() {
        closeButton.getScene().getWindow().hide();
    }
}
