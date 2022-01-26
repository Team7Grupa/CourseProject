package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDistributorController {


    @FXML
    private ComboBox<String> comboBoxContract;

    @FXML
    private TextField distributorCity;

    @FXML
    private TextField distributorName;

    @FXML
    void distributorContract(MouseEvent event) {
        ObservableList<String> listDistributor = FXCollections.observableArrayList( "Permanent", "Temporary", "Independent" );
        comboBoxContract.setValue("Choose Contract");
        comboBoxContract.setItems(listDistributor);
    }

    @FXML
    void distributorCreate(ActionEvent event) throws SQLException {
    String city = distributorCity.getText();
    String name = distributorName.getText();

        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        PreparedStatement st = com.prepareStatement("Insert into Distributor (name,city,contract) values(?,?,?)");
        st.setString(1, name);
        st.setString(2, city);
        st.setString(3, comboBoxContract.getValue());
        st.executeQuery();
        JOptionPane.showMessageDialog(null,"Distributor Successfully Created");
    }
}
