package io.github.codenilson.smartpat;

import java.io.IOException;

import com.google.inject.Guice;
import com.google.inject.Injector;

import io.github.codenilson.smartpat.modules.PersistenceModule;
import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Injector injector;

    @Override
    public void start(Stage stage) throws IOException {

        injector = Guice.createInjector(new PersistenceModule());

        FXMLLoader loader = loadFXML("/gui/main");

        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(App.class.getResource("/styles/style.css").toExternalForm());
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

    public static FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(injector::getInstance);
        return fxmlLoader;
    }

    @Override
    public void stop() {
        BaseRepository.shutdown();
    }

}
