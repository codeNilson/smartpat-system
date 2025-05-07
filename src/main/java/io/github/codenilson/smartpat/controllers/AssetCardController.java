package io.github.codenilson.smartpat.controllers;

import io.github.codenilson.smartpat.persistence.entities.Asset;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class AssetCardController {

    @FXML
    private VBox cardRoot;

    @FXML
    private VBox cardContent;

    @FXML
    private Label titleLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label locationLabel;

    public void setData(Asset asset) {

        // Photo
        Image image = new Image("file:/" + asset.getImagePath());
        ImageView imageView = new ImageView(image);

        // Title
        titleLabel.setText(asset.getCategory().getName());
    }
}
