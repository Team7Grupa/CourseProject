package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.net.URL;


public class LoginStart extends Application {

    private Logger log = Logger.getLogger(LoginStart.class);

    public static void main(String args[])
    {
         launch(args);
    }

    public void start (Stage primaryStage) throws Exception {

        PropertyConfigurator.configure(getClass().getResource(Constants.Configurations.LOG4J_PROPERTIES));
        URL path = getClass().getResource(Constants.View.Login);

        if (path != null)
        {
            Parent root = FXMLLoader.load(path);
            Scene scene = new Scene(root);
            primaryStage.setTitle("Passenger Travel");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        else
        {
            log.error("Sorry the main fxml was not found");
            System.exit(-1);
        }

    }
}
