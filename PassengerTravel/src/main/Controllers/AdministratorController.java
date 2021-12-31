package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministratorController {

    @FXML
    private AnchorPane ap;

    @FXML
    private Pane pane;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Button references;

    @FXML
    private VBox vrBox;

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

    @FXML
    void createCompany(ActionEvent event) throws IOException {
        Stage stageCompany = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/createCompany.fxml"));
        stageCompany.setScene(new Scene(root));
        stageCompany.setTitle("Create Company");
        stageCompany.show();
    }

    @FXML
    void createDistributor(ActionEvent event) throws IOException {
        Stage stageDistributor = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/createDistributor.fxml"));
        stageDistributor.setScene(new Scene(root));
        stageDistributor.setTitle("Create Distributor");
        stageDistributor.show();
    }

}
