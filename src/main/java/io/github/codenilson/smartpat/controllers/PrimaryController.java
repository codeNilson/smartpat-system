package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class PrimaryController implements Initializable {

    @FXML
    private Node primaryRootPane;

    @FXML
    private Button btnQuit;

    @FXML
    public void onBtnQuitClicked() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Node node : primaryRootPane.lookupAll(".grid-button")) {
            if (node instanceof Button) {
                Button button = (Button) node;
                applyScaleAnimation(button);
            }
        }
    }

    public static void applyScaleAnimation(Button button) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
        st.setToX(1.1);
        st.setToY(1.1);

        ScaleTransition stReverse = new ScaleTransition(Duration.millis(200), button);
        stReverse.setToX(1);
        stReverse.setToY(1);

        button.setOnMouseEntered(e -> st.playFromStart());
        button.setOnMouseExited(e -> stReverse.playFromStart());
    }
}
