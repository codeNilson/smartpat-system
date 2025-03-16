package io.github.codenilson.smartpat;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    // private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage = loadFXML("gui/primary");
        stage.show();
    }

    private static Stage loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}