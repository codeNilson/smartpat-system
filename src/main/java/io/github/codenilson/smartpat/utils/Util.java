package io.github.codenilson.smartpat.utils;

import java.io.IOException;

import io.github.codenilson.smartpat.App;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

public class Util {

    public static Parent loadFXML(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
            loader.setControllerFactory(App.injector::getInstance);
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            AlertMessage alert = new AlertMessage(AlertType.ERROR, "Error", "Failed to load FXML: " + fxml);
            alert.execute();
            return null;
        }
    }

    public static void loadStyleSheet(Scene scene, String cssPath) {
        try {
            scene.getStylesheets().add(App.class.getResource(cssPath).toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
            AlertMessage alert = new AlertMessage(AlertType.ERROR, "Error", "Failed to load CSS: " + cssPath);
            alert.execute();
        }
    }

    public static void applyScaleAnimation(Node node) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), node);
        st.setToX(1.05);
        st.setToY(1.05);

        ScaleTransition stReverse = new ScaleTransition(Duration.millis(200), node);
        stReverse.setToX(1);
        stReverse.setToY(1);

        node.setOnMouseEntered(e -> st.playFromStart());
        node.setOnMouseExited(e -> stReverse.playFromStart());
    }
}
