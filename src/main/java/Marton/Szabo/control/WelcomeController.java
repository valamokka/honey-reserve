package Marton.Szabo.control;

import java.io.IOException;
import java.time.LocalDate;

import Marton.Szabo.control.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeController {

    @FXML
    private Label dateLabel;


    @FXML
    public void initialize() {
        dateLabel.setText("Today it is: "+ LocalDate.now());
    }

    @FXML
    private void switchToPackSell() throws IOException {
        App.setRoot("packsell");
    }

    @FXML
    private void switchToMarketResults() throws IOException {
        App.setRoot("marketresult");
    }

    @FXML
    private void switchToSetup() throws IOException {
        App.setRoot("setup");
    }





}
