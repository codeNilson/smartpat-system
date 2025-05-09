package io.github.codenilson.smartpat.controllers.components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.App;
import io.github.codenilson.smartpat.controllers.scenes.DetailItemController;
import io.github.codenilson.smartpat.persistence.entities.Asset;
import io.github.codenilson.smartpat.utils.Util;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AssetCardController implements Initializable {

    private Asset asset;

    @FXML
    private VBox cardRoot;

    @FXML
    private VBox cardContent;

    @FXML
    private ImageView assetPhoto;

    @FXML
    private Label titleLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label locationLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Util.applyScaleAnimation(cardRoot);
    }

    public void setData(Asset asset) {

        this.asset = asset;

        // Photo
        Image image = new Image("file:/" + asset.getImagePath());
        assetPhoto.setImage(image);

        // Title
        titleLabel.setText(asset.getCategory().getName());

        // Description
        if (asset.getExtraProperties() != null) {
            StringBuilder description = new StringBuilder();
            asset.getExtraProperties().forEach((key, value) -> {
                description.append(key).append(" ").append(" ").append(value).append(", ");
            });
            description.append("com gaveta, cor azul, comprimento 1,20m");
            descriptionLabel.setText(description.toString());
        }

        // Location
        locationLabel
                .setText(asset.getLocationUnit().getAdministrativeUnit().getName() + " - " + asset.getLocationUnit());
    }

    public void onCardRootClicked(Event event) {
        Stage stage = getStageFromEvent(event);
        try {
            openSecondaryWindow(stage, this.asset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Stage getStageFromEvent(Event event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    private void openSecondaryWindow(Stage primaryStage, Asset asset) throws IOException {

        DetailItemController controller = App.injector.getInstance(DetailItemController.class);
        controller.setupDetailView(primaryStage, asset);
    }

}
