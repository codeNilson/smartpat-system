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

    private Stage stage;
    private List<ImageView> categoriesImages = new ArrayList<>();
    private List<Button> categoryButtons = new ArrayList<>();

    @FXML
    private Parent sceneRoot;

    @FXML
    private TilePane categoriesContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {

            if (stage == null) {
                stage = (Stage) sceneRoot.getScene().getWindow();
            }

            // Modify this
            adjustContainerSize(stage);
            adjustImageSize(stage);
            // Modify this

            loadCategoryImageViews();

            loadCategoryButtons();

            applyCategoriesAnimations();

            configureStageMaximizedListener(stage);
        });
    }

    private void loadCategoryImageViews() {

        if (!categoriesImages.isEmpty())
            return;

        for (Node node : sceneRoot.lookupAll(".category-image")) {
            if (node instanceof ImageView imageView) {
                categoriesImages.add(imageView);
            }
        }
    }

    private void loadCategoryButtons() {

        if (!categoryButtons.isEmpty())
            return;

        for (Node node : sceneRoot.lookupAll(".category")) {
            if (node instanceof Button button) {
                categoryButtons.add(button);
            }
        }
    }

    private void applyCategoriesAnimations() {
        applyScaleAnimationToCategories();
        applyAnimation();
    }

    private void applyScaleAnimationToCategories() {

        for (Button categoryButton : categoryButtons) {
            Util.applyScaleAnimation(categoryButton);
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

    private void configureStageMaximizedListener(Stage stage) {

        stage.maximizedProperty().addListener((obs, oldVal, newVal) -> {
            adjustContainerSize(stage);
            adjustImageSize(stage);
        });
    }

    private void adjustContainerSize(Stage stage) {
        Platform.runLater(() -> {
            double maxWidth = stage.getWidth() / 6;
            double newWidth = Math.max(200, maxWidth);

            categoriesContainer.setPrefTileWidth(newWidth);
            categoriesContainer.setPrefTileHeight(newWidth);
        });
    }

    private void adjustImageSize(Stage stage) {
        Platform.runLater(() -> {
            Double maxImageWidth = stage.getWidth() / 7;
            Double newImageWidth = Math.max(150, maxImageWidth);

            for (ImageView imageView : categoriesImages) {
                imageView.setFitWidth(newImageWidth);
                imageView.setFitHeight(newImageWidth);
            }
        });
    }

}
