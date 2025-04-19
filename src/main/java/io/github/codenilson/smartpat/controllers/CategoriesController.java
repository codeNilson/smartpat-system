package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.utils.Util;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CategoriesController implements Initializable {

    @FXML
    private Parent root;

    @FXML
    private TilePane categoriesContainer;

    private Stage stage;

    private List<ImageView> categoriesImages = new ArrayList<>();
    private List<Button> categoryButtons = new ArrayList<>();

    private static final double MIN_TILE_WIDTH = 200;
    private static final double MIN_IMAGE_WIDTH = 150;
    private static final double TILE_WIDTH_RATIO = 6;
    private static final double IMAGE_WIDTH_RATIO = 7;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {

            stage = (Stage) root.getScene().getWindow();

            adjustContainerSize(stage);
            adjustImageSize(stage);
            loadCategoryImageViews();
            applyCategoriesAnimations();
            setupStageMaximizedListener(stage);
        });
    }

    private void applyCategoriesAnimations() {
        applyScaleAnimationToCategories();
        applyAnimation();
    }

    private void loadCategoryImageViews() {
        for (Node node : root.lookupAll(".category-image")) {
            if (node instanceof ImageView) {
                categoriesImages.add((ImageView) node);
            }
        }
    }

    private void applyScaleAnimationToCategories() {
        for (Node node : root.lookupAll(".category")) {
            if (node instanceof Button) {
                categoryButtons.add((Button) node);
            }
            Util.applyScaleAnimation(node);
        }
    }

    private void applyAnimation() {
        ParallelTransition pt = new ParallelTransition();

        for (Button button : categoryButtons) {
            SequentialTransition st = new SequentialTransition();

            ScaleTransition scaleUp = new ScaleTransition(Duration.millis(200));
            scaleUp.setFromX(0.8);
            scaleUp.setFromY(0.8);
            scaleUp.setToX(1.05);
            scaleUp.setToY(1.05);

            ScaleTransition scaleDown = new ScaleTransition(Duration.millis(200));
            scaleDown.setFromX(1.05);
            scaleDown.setFromY(1.05);

            scaleDown.setToX(1);
            scaleDown.setToY(1);

            scaleUp.setNode(button);
            scaleDown.setNode(button);

            st.getChildren().addAll(scaleUp, scaleDown);
            pt.getChildren().add(st);
        }
        pt.play();
    }

    private void setupStageMaximizedListener(Stage stage) {

        stage.maximizedProperty().addListener((obs, oldVal, newVal) -> {
            adjustContainerSize(stage);
            adjustImageSize(stage);
        });
    }

    private void adjustImageSize(Stage stage) {
        Platform.runLater(() -> {
            Double maxImageWidth = stage.getWidth() / IMAGE_WIDTH_RATIO;
            Double newImageWidth = Math.max(MIN_IMAGE_WIDTH, maxImageWidth);

            for (ImageView imageView : categoriesImages) {
                imageView.setFitWidth(newImageWidth);
                imageView.setFitHeight(newImageWidth);
            }
        });
    }

    private void adjustContainerSize(Stage stage) {
        Platform.runLater(() -> {
            double maxWidth = stage.getWidth() / TILE_WIDTH_RATIO;
            double newWidth = Math.max(MIN_TILE_WIDTH, maxWidth);

            categoriesContainer.setPrefTileWidth(newWidth);
            categoriesContainer.setPrefTileHeight(newWidth);
        });
    }



}
