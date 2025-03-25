package io.github.codenilson.smartpat.controllers;

import java.io.IOException;

import io.github.codenilson.smartpat.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class ItemsController {

    @FXML
    private TilePane tilePane;

    public void loadItems(String category) {
        for (int i = 0; i < 6; i++) {
            Button btn = new Button("Item " + category + " " + i);
            btn.getStyleClass().add("item-button");
            btn.setPrefSize(200, 200);
            tilePane.getChildren().add(btn);
        }
    }

    public static Pane loadView(String category) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("gui/utils/items.fxml"));
        Pane categoryPane = loader.load();

        ItemsController itemsController = loader.getController();
        itemsController.loadItems(category);

        return categoryPane;
    }

}
