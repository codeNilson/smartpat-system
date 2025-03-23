package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PrimaryController implements Initializable {

    @FXML
    private Button btnQuit;

    @FXML
    public void onBtnQuitClicked() {
       Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
