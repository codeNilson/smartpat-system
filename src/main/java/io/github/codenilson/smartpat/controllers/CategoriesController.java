package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CategoriesController implements Initializable {

    @FXML
    private Parent root;

    @FXML
    private TilePane categoriesContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        applyScaleToCategories();

        adjustCategoryContainerSize();

    }

    private void applyScaleToCategories() {
        for (Node node : root.lookupAll(".category")) {
            applyScaleAnimation(node);
        }
    }

    private void adjustCategoryContainerSize() {
        Platform.runLater(() -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.widthProperty().addListener((obs, oldVal, newVal) -> {
                if (stage.isMaximized()) {
                    categoriesContainer.setPrefTileWidth(stage.getWidth() / 6);
                    categoriesContainer.setPrefTileHeight(stage.getWidth() / 6);
                } else {
                    categoriesContainer.setPrefTileHeight(200);
                    categoriesContainer.setPrefTileWidth(200);
                }
            });
        });
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

}
