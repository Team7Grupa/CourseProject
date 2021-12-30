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
        // pane.getChildren().clear();
        Parent root = FXMLLoader.load(getClass().getResource("/references.fxml"));
        // pane.getChildren().add(root);
        stageRef.setScene(new Scene(root));
        stageRef.setTitle("References");
        stageRef.show();
    }

}