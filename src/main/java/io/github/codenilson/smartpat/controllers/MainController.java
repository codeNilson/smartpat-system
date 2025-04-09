package io.github.codenilson.smartpat.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

    @FXML
    private BorderPane primaryRootPane;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnReport;

    @FXML
    public void onBtnQuitClicked() {
        Platform.exit();
    }

    @FXML
    public void onBtnHomeClicked() {
        changeScene("gui/scenes/categories");
    }

    @FXML
    public void onBtnRegisterClicked() {
        changeScene("gui/scenes/register");
    }

    @FXML
    public void onBtnReportClicked() {
        changeScene("gui/scenes/reports");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        changeScene("gui/scenes/categories");

    }

    private void changeScene(String fxml) {
        try {
            Parent newScene = App.loadFXML(fxml);
            primaryRootPane.setCenter(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
