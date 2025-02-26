package com.smartpat.controllers;

import java.io.IOException;

import com.smartpat.App;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("gui/primary");
    }
}