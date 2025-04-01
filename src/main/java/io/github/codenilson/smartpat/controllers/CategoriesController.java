package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CategoriesController implements Initializable {

    @FXML
    private Parent root;

    @FXML
    private TilePane categoriesContainer;

    private List<ImageView> categoriesImages = new ArrayList<>();

    private static final double MIN_TILE_WIDTH = 200;
    private static final double MIN_IMAGE_WIDTH = 150;
    private static final double TILE_WIDTH_RATIO = 6;
    private static final double IMAGE_WIDTH_RATIO = 7;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {

            loadCategoryImageViews();
            applyScaleToCategories();
            adjustCategoryContainerDimensions();
        });
    }

    private void loadCategoryImageViews() {
        for (Node node : root.lookupAll(".category-image")) {
            if (node instanceof ImageView) {
                categoriesImages.add((ImageView) node);
            }
        }
    }

    private void applyScaleToCategories() {
        for (Node node : root.lookupAll(".category")) {
            applyScaleAnimation(node);

        }
    }

    private void adjustCategoryContainerDimensions() {

        Stage stage = (Stage) root.getScene().getWindow();

        stage.maximizedProperty().addListener((obs, oldVal, newVal) -> {
            Platform.runLater(() -> {
                adjustContainerSize(stage);
                adjustImageSize(stage);
            });
        });
    }

    private void adjustImageSize(Stage stage) {
        Double maxImageWidth = stage.getWidth() / IMAGE_WIDTH_RATIO;
        Double newImageWidth = Math.max(MIN_IMAGE_WIDTH, maxImageWidth);

        for (ImageView imageView : categoriesImages) {
            imageView.setFitWidth(newImageWidth);
            imageView.setFitHeight(newImageWidth);
        }
    }

    private void adjustContainerSize(Stage stage) {
        double maxWidth = stage.getWidth() / TILE_WIDTH_RATIO;
        double newWidth = Math.max(MIN_TILE_WIDTH, maxWidth);

        categoriesContainer.setPrefTileWidth(newWidth);
        categoriesContainer.setPrefTileHeight(newWidth);
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
