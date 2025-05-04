package io.github.codenilson.smartpat.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.utils.Util;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

    private List<TitledPane> sideBarPanes = new ArrayList<>();

    @FXML
    private BorderPane primaryRootPane;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            changeScene("/gui/scenes/categories.fxml");
        } catch (IOException e) {
            // WIP
            e.printStackTrace();
        }

        configureSidebarPanes();
    }

    private void changeScene(String fxml) throws IOException {
        FXMLLoader loader = Util.loadFXML(fxml);
        Parent root = loader.load();
        primaryRootPane.setCenter(root);
    }

    private void configureSidebarPanes() {
        loadSidebarPanes();
        setupExpansionBehavior();
    }

    private void loadSidebarPanes() {

        if (!sideBarPanes.isEmpty()) {
            return;
        }

        for (Node node : primaryRootPane.lookupAll(".sidebar-pane")) {
            if (node instanceof TitledPane titledPane) {
                sideBarPanes.add(titledPane);
            }
        }
    }

    private void setupExpansionBehavior() {
        for (TitledPane pane : sideBarPanes) {
            pane.expandedProperty().addListener((obs, wasExpanded, isNowExpanded) -> {
                if (isNowExpanded) {
                    collapseOtherPanes(pane);
                }
            });
        }
    }

    private void collapseOtherPanes(TitledPane expandedPane) {
        for (TitledPane pane : sideBarPanes) {
            if (pane != expandedPane) {
                pane.setExpanded(false);
            }
        }
    }

    @FXML
    public void onBtnHomeClicked() throws IOException {
        changeScene("/gui/scenes/categories.fxml");
    }

    @FXML
    public void onBtnSearchClicked() throws IOException {
        changeScene("/gui/scenes/list-assets.fxml");
    }

    @FXML
    public void onBtnQuitClicked() {
        Platform.exit();
    }

    @FXML
    public void onBtnRegisterClicked() throws IOException {
        changeScene("/gui/scenes/register.fxml");
    }

    @FXML
    public void onBtnReportClicked() throws IOException {
        changeScene("/gui/scenes/reports.fxml");
    }

}