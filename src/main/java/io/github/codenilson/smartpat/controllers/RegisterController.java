package io.github.codenilson.smartpat.controllers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import io.github.codenilson.smartpat.entities.Asset;
import io.github.codenilson.smartpat.repositories.AssetRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RegisterController implements Initializable {

    @FXML
    private TableView<Asset> tableView;

    @FXML
    private TableColumn<Asset, String> tombamentoColumn;

    @FXML
    private TableColumn<Asset, String> categoryColumn;

    @FXML
    private TableColumn<Asset, String> unidadeAdministrativaColumn;

    @FXML
    private TableColumn<Asset, String> unidadeDeLocalizacaoColumn;

    @FXML
    private TableColumn<Asset, String> propertyColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeTableColumns();

        loadDataBaseData();

    }

    private void initializeTableColumns() {
        // tombamentoColumn.setCellValueFactory(new
        // PropertyValueFactory<>("tombamento"));
        // categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        // unidadeAdministrativaColumn.setCellValueFactory(new
        // PropertyValueFactory<>("unidadeAdministrativa"));
        // unidadeDeLocalizacaoColumn.setCellValueFactory(new
        // PropertyValueFactory<>("unidadeDeLocalizacao"));
        // propertyColumn.setCellValueFactory(new PropertyValueFactory<>("attributes"));

        // // Dados de exemplo
        // ObservableList<Asset> lista = FXCollections.observableArrayList(new
        // Asset(6700004588L, "Computador", "COPROJ", "Sala 101", "Proprio"),
        // new Asset(6700004558L, "Mesa", "COPROJ", "Sala 101", "Proprio"),
        // new Asset(6700004528L, "Computador", "COPROJ", "Sala 101", "Proprio"),
        // new Asset(6700004538L, "Cadeira", "COPROJ", "Sala 101", "Proprio"),
        // new Asset(6700007588L, "Computador", "COPROJ", "Sala 101", "Proprio"),
        // new Asset(6700008805L, "Mesa", "COAFI", "CEGEA", "Terceiros"));

        // tableView.setItems(lista);
    }

    public void loadDataBaseData() {
        AssetRepository repository = new AssetRepository();

        Map<String, Object> map = new HashMap<>();
        map.put("propriedade", "proprio");
        map.put("tem_gaveta", false);
        map.put("comprimento", 0.8);
        map.put("cor", "amarelo");

        repository.save(new Asset(6700004588L, "table", "TI", "Sala 101", map));

        repository.close();

        AssetRepository repository2 = new AssetRepository();

        Asset asset = repository2.findById(1);
        asset.getAttributes().forEach((key, value) -> {
            System.out.println(key + " = " + value + " (" + value.getClass().getSimpleName() + ")");
        });

        repository2.close();
    }

}
