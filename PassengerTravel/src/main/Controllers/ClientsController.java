package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientsController {

    @FXML
    private AnchorPane ap;

    @FXML
    private Pane pane;

    @FXML
    private Button reference;

    @FXML
    void Exit(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML
    void openRef(ActionEvent event) throws IOException {
        Stage stageRef = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/references.fxml"));
        stageRef.setScene(new Scene(root));
        stageRef.setTitle("References");
        stageRef.show();
    }

    @FXML
    void workWithTravel(ActionEvent event) throws IOException {
        Stage stagewwTravel = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/workWithTravel.fxml"));
        stagewwTravel.setScene(new Scene(root));
        stagewwTravel.setTitle("Work With Travel");
        stagewwTravel.show();
    }

    @FXML
    void ProfilesAndRating(ActionEvent event) throws IOException {
        Stage stageProfiles = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/ProfilesAndRating.fxml"));
        stageProfiles.setScene(new Scene(root));
        stageProfiles.setTitle("Profiles and Rating");
        stageProfiles.show();
    }

    @FXML
    void createCashier(ActionEvent event) throws IOException {
        Stage stageCashier = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/createCashier.fxml"));
        stageCashier.setScene(new Scene(root));
        stageCashier.setTitle("Create Cashier");
        stageCashier.show();
    }



}