package Marton.Szabo.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Marton.Szabo.control.App;
import Marton.Szabo.model.entity.Honey;
import Marton.Szabo.model.jdbc.PackSellJDBCdao;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PackSellController {

    private final PackSellJDBCdao PACK_AND_SELL = new PackSellJDBCdao();
    List<Honey> honeys = PACK_AND_SELL.getAllHoneys();
    public ChoiceBox<String> kindBox;
    public ChoiceBox<Integer> weightBox;
    public TextField quantityField;
    public ListView<String> listOfHoneys;
    // TODO these fields should be used to display the statuses of the honeys
    private Stage stage;
    private Scene scene;

    @FXML
    private void addHoney() {
        PACK_AND_SELL.packHoney(kindBox.getValue().toUpperCase(), weightBox.getValue(), Integer.parseInt(quantityField.getText()));
        populateListViewOfAllhoneys();
    }

    @FXML
    private void deleteHoney() {
        PACK_AND_SELL.unpackHoney(kindBox.getValue().toUpperCase(), weightBox.getValue(), Integer.parseInt(quantityField.getText()));
        populateListViewOfAllhoneys();
    }


    @FXML
    private void sellHoney() {
        //TODO live-selling option, should be implemented later
    }

    @FXML
    private void switchToWelcome() throws IOException {
        App.setRoot("welcome");
    }

    public void initialize() {
        List<Integer> weights = honeys.
                stream().
                map(Honey::getWEIGHT).
                distinct().sorted().
                collect(Collectors.toList());
        weightBox.getItems().addAll(weights);

        List<String> kinds = honeys.
                stream().
                map(Honey::getKIND_OF_HONEY).
                distinct().sorted().
                collect(Collectors.toList());
        kindBox.getItems().addAll(kinds);
        populateListViewOfAllhoneys();
    }

    private void populateListViewOfAllhoneys() {
        listOfHoneys.getItems().clear();
        listOfHoneys.getItems().addAll(PACK_AND_SELL.getAllHoneys().stream().map(Honey::toStringForDisplayingPackedHoneys).collect(Collectors.toList()));
    }

}