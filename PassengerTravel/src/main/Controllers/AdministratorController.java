package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AdministratorController {

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
