package io.github.codenilson.smartpat.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.App;
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

    @FXML
    private BorderPane primaryRootPane;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnSearch;

    private List<TitledPane> sideBarPanes = new ArrayList<>();
    

    @FXML
    public void onBtnHomeClicked() {
        changeScene("/gui/scenes/categories");
    }

    @FXML
    public void onBtnSearchClicked() {
        changeScene("/gui/scenes/categories");
    }

    @FXML
    public void onBtnQuitClicked() {
        Platform.exit();
    }


    @FXML
    public void onBtnRegisterClicked() {
        changeScene("/gui/scenes/register");
    }

    @FXML
    public void onBtnReportClicked() {
        changeScene("/gui/scenes/reports");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        changeScene("/gui/scenes/categories");

        setupSidebarPanes();
    }

    private void changeScene(String fxml) {
        try {
            FXMLLoader loader = App.loadFXML(fxml);
            Parent root = loader.load();
            primaryRootPane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupSidebarPanes() {
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
}
