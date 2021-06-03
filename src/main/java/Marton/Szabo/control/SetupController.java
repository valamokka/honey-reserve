package Marton.Szabo.control;


import Marton.Szabo.model.jdbc.SetupJDBCdao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

// This class will create the lines of the database using the user's input
public class SetupController {

    private final SetupJDBCdao SETUP = new SetupJDBCdao();
    public TextField kindField;
    public TextField weightField;
    public TextField flatCostField;
    public TextField sellingPriceField;

    @FXML
    private void createHoney() {
        SETUP.registerHoney(kindField.getText().toUpperCase(), Integer.parseInt(weightField.getText()),
                Integer.parseInt(sellingPriceField.getText()), Integer.parseInt(flatCostField.getText()));

    }
    @FXML
    private void updateSellingPrice() {
        SETUP.updateSellingPrice(kindField.getText().toUpperCase(), Integer.parseInt(weightField.getText()),
                Integer.parseInt(sellingPriceField.getText()));
    }

    @FXML
    private void updateFlatCost() {
        SETUP.updateFlatCost(kindField.getText().toUpperCase(), Integer.parseInt(weightField.getText()),
                Integer.parseInt(flatCostField.getText()));
    }


    @FXML
    private void deleteHoney() {
        SETUP.deleteHoney(kindField.getText().toUpperCase(), Integer.parseInt(weightField.getText()));
    }

    @FXML
    private void deleteAllHoneys() {
        SETUP.deleteAllHoneys();
    }

    @FXML
    private void switchToWelcome() throws IOException {
        App.setRoot("welcome");
    }
}
