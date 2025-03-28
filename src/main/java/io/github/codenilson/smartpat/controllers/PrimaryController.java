package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrimaryController implements Initializable {

    @FXML
    private BorderPane primaryRootPane;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnReport;

    @FXML
    private TilePane categoriesPane;

    @FXML
    public void onBtnQuitClicked() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Node node : primaryRootPane.lookupAll(".category")) {
            applyScaleAnimation(node);
        }


        // testing
        btnSearch.setOnAction(e -> changeItems("search"));

    }

    public static void applyScaleAnimation(Node node) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), node);
        st.setToX(1.1);
        st.setToY(1.1);

        ScaleTransition stReverse = new ScaleTransition(Duration.millis(200), node);
        stReverse.setToX(1);
        stReverse.setToY(1);

        node.setOnMouseEntered(e -> st.playFromStart());
        node.setOnMouseExited(e -> stReverse.playFromStart());
    }

    public void changeItems(String category) {
        try {
            Pane itemsPane = ItemsController.loadView(category);
            primaryRootPane.setCenter(itemsPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
