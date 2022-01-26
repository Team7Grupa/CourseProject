package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WorkWithTravelController {

    @FXML
    private Button create;

    @FXML
    private Pane travelPane;


    @FXML
    void createTravel(ActionEvent event) {

    }

    @FXML
    void sellTickets(ActionEvent event) throws IOException {
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/buyTickets.fxml"));
        travelPane.getChildren().add(newLoadedPane);
    }
}
