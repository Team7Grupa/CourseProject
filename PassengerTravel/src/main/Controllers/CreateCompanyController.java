package Controllers;

import DataClasses.DatabaseClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        PreparedStatement st = DatabaseClass.CompanyStatement();
        st.setString(1, name);
        st.setString(2, city);
        st.setString(3, comboBoxTransport.getValue());
        st.executeQuery();

        DatabaseClass.infoBox("Company Successfully Created", "Created Company");
    }


    @FXML
    void companyTransport(MouseEvent event) {
        ObservableList<String> listTransport = FXCollections.observableArrayList( "Airplane", "Bus", "Train" );
        comboBoxTransport.setValue("Choose Transport");
        comboBoxTransport.setItems(listTransport);
    }

}
