package io.github.codenilson.smartpat.utils;

import java.io.IOException;

import io.github.codenilson.smartpat.App;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.util.Duration;

public class Util {
    public static String cleanString(String str) {
        if (str == null)
            return null;
        return str.trim().toLowerCase();
    }

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        loader.setControllerFactory(App.injector::getInstance);
        return loader;
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
