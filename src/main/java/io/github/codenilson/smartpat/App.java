package io.github.codenilson.smartpat;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    // private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = loadFXML("gui/primary");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(App.class.getResource("styles/style.css").toExternalForm());
        stage.setScene(scene);

        Platform.runLater(() -> {
            stage.sizeToScene();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight()); 
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
