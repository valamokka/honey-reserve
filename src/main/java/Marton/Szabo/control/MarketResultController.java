package Marton.Szabo.control;

import Marton.Szabo.model.entity.Honey;
import Marton.Szabo.model.jdbc.MarketResultJDBCdao;
import Marton.Szabo.model.utility.Calculate;
import Marton.Szabo.model.utility.Print;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MarketResultController {

    private final MarketResultJDBCdao RESULT = new MarketResultJDBCdao();
    private List<Honey> honeys = RESULT.getAllHoneys();
    public ChoiceBox<String> kindBox;
    public ChoiceBox<Integer> weightBox;
    public TextField quantityField;
    public Label totalIncome;
    public Label totalProfit;
    public Label marciShare;
    public Label apuShare;

    @FXML
    private void populateWeightFieldAccordingToKind() {
        weightBox.getItems().clear();
        weightBox.getItems().addAll(honeys.stream().
                filter(honey -> honey.getKIND_OF_HONEY().equals(kindBox.getValue())).distinct().
                mapToInt(Honey::getWEIGHT).
                sorted().boxed().collect(Collectors.toList()));
    }

    @FXML
    private void updateBack() {
        RESULT.updateQuantityBack(kindBox.getValue(), weightBox.getValue(), Integer.parseInt(quantityField.getText()));
        honeys.removeIf(honey -> honey.getKIND_OF_HONEY().equals(kindBox.getValue()) && honey.getWEIGHT() == weightBox.getValue());
        initialize();
    }

    @FXML
    private void resetQuantities() {
        RESULT.resetAllQuantities();
    }

    @FXML
    private void showResults() {
        honeys = RESULT.getAllHoneys();
        totalIncome.setText(Calculate.totalIncome(honeys));
        totalProfit.setText(Calculate.totalProfit(honeys));
        marciShare.setText(Calculate.marciShare(honeys));
        apuShare.setText(Calculate.apuShare(honeys));
    }

    @FXML
    private void switchToWelcome() throws IOException {
        App.setRoot("welcome");
    }

    @FXML
    private void export() {
        Print.writeToFile(honeys, totalIncome.getText(), totalProfit.getText());
    }

    public void initialize() {
        kindBox.getItems().clear();
        kindBox.getItems().addAll(honeys.stream().
                map(Honey::getKIND_OF_HONEY).
                distinct().sorted().
                collect(Collectors.toList()));
    }
}
