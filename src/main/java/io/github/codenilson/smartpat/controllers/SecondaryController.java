package io.github.codenilson.smartpat.controllers;

import java.io.IOException;

import io.github.codenilson.smartpat.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("gui/primary");
    }
}