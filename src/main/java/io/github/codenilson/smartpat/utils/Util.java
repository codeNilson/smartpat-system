package io.github.codenilson.smartpat.utils;

import io.github.codenilson.smartpat.App;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Util {

    public static FXMLLoader loadFXML(String fxml) {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        loader.setControllerFactory(App.injector::getInstance);
        return loader;
    }

    public static void loadStyleSheet(Scene scene, String cssPath) {
        try {
            scene.getStylesheets().add(App.class.getResource(cssPath).toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
            AlertError alert = new AlertError("Failed to load CSS: " + cssPath);
            alert.execute();
        }
    }

    public static void loadStyleSheet(Pane pane, String cssPath) {
        try {
            pane.getStylesheets().add(App.class.getResource(cssPath).toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
            AlertError alert = new AlertError("Failed to load CSS: " + cssPath);
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
