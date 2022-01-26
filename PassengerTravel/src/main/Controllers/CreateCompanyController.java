package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.sql.*;

public class CreateCompanyController {

    @FXML
    private ComboBox<String> comboBoxTransport;
    @FXML
    private TextField companyCity;
    @FXML
    private TextField companyName;

    @FXML
    void companyCreate(ActionEvent event) throws SQLException {
        String name = companyName.getText();
        String city = companyCity.getText();

        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");

        PreparedStatement st = com.prepareStatement("Insert into COMPANY(name,city,transport) values(?,?,?)");
        st.setString(1, name);
        st.setString(2, city);
        st.setString(3, comboBoxTransport.getValue());
        st.executeQuery();
        JOptionPane.showMessageDialog(null,"Company Successfully Created");
    }


    @FXML
    void companyTransport(MouseEvent event) {
        ObservableList<String> listTransport = FXCollections.observableArrayList( "Airplane", "Bus", "Train" );
        comboBoxTransport.setValue("Choose Transport");
        comboBoxTransport.setItems(listTransport);
    }

}
