package io.github.codenilson.smartpat;

import java.io.IOException;

import com.google.inject.Guice;
import com.google.inject.Injector;

import io.github.codenilson.smartpat.modules.PersistenceModule;
import io.github.codenilson.smartpat.persistence.base.BaseRepository;
import io.github.codenilson.smartpat.utils.Util;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Injector injector;

    @Override
    public void init() throws Exception {
        injector = Guice.createInjector(new PersistenceModule());
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = Util.loadFXML("/gui/main");

        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(App.class.getResource("/styles/main.css").toExternalForm());
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

    @Override
    public void stop() {
        BaseRepository.shutdown();
    }

}
