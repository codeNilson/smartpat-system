package com.smartpat.controllers;

import java.io.IOException;

import com.smartpat.App;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("gui/secondary");
    }
}
