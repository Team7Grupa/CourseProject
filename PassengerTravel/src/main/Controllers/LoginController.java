package Controllers;

import DataClasses.DatabaseClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Pane pane;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label label;

    @FXML
    void handlebuttonExit(ActionEvent event)
    {
        System.exit(0);
    }


    @FXML
    void handlebuttonLogin(ActionEvent event) throws SQLException, IOException
    {
        String username1 = username.getText();
        String password1 = password.getText();
        DatabaseClass.getConnection();
        boolean flag = false;
        if (DatabaseClass.validateLogin(username1, password1, label, flag) == true)
        {
            if (DatabaseClass.validateLogin1(username1, password1, flag) == true)
            {
                Parent root = FXMLLoader.load(getClass().getResource("/mainPanel.fxml"));
                pane.getChildren().add(root);
            }
            else
            {
                Parent root = FXMLLoader.load(getClass().getResource("/mainPanel2.fxml"));
                pane.getChildren().add(root);
            }
        }
    }

    @FXML
    void handlebuttonReset(ActionEvent event)
    {
        password.clear();
        username.clear();
    }


}
