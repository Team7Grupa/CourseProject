package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ClientsController {

    @FXML
    private AnchorPane ap;

    @FXML
    private Pane pane;

    @FXML
    void Exit(ActionEvent event)
    {
        System.exit(0);
    }

}