package io.github.codenilson.smartpat;

import java.io.IOException;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.repository.AssetRepository;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = loadFXML("gui/main");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(App.class.getResource("styles/style.css").toExternalForm());
        stage.setScene(scene);

        Platform.runLater(() -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


}
