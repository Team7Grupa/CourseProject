package Controllers;

import DataClasses.DatabaseClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.*;

public class CreateCashierController {

    @FXML
    private TableColumn<?,?> c1;

    @FXML
    private TableColumn<?,?> c2;

    @FXML
    private TableColumn<?,?> c3;

    @FXML
    private TextField cashierCity;

    @FXML
    private TextField cashierName;

    @FXML
    private ComboBox<String> comboBoxCashier;

    @FXML
    private Label label;

    @FXML
    void cashierOffice(MouseEvent event) throws SQLException {

        if(cashierCity.getText().equals("Varna")) {
            comboBoxCashier.setValue("Choose Office");
            ObservableList<String> list = FXCollections.observableArrayList();
            ResultSet rs = DatabaseClass.CashierOfficeVarnaStatement();
            while (rs.next())
            {
                list.add(rs.getString("Kvartal"));
            }
            comboBoxCashier.setItems(list);
        }
        else if(cashierCity.getText().equals("Dobrich"))
        {
            comboBoxCashier.setValue("Choose Office");
            ObservableList<String> list = FXCollections.observableArrayList();
            ResultSet rs = DatabaseClass.CashierOfficeDobrichStatement();

            while (rs.next())
            {
                list.add(rs.getString("Kvartal"));
            }
            comboBoxCashier.setItems(list);
        }
        else if(cashierCity.getText().equals("Sofia"))
        {
            comboBoxCashier.setValue("Choose Office");
            ObservableList<String> list = FXCollections.observableArrayList();
            ResultSet rs = DatabaseClass.CashierOfficeSofiaStatement();

            while (rs.next())
            {
                list.add(rs.getString("Kvartal"));
            }
            comboBoxCashier.setItems(list);
        }
        else {
            label.setText("Please Insert Available City (Varna, Sofia, Dobrich)");
        }
    }


    @FXML
    void cashierCreate(ActionEvent event) throws SQLException {

        String city = cashierCity.getText();
        String name = cashierName.getText();
        PreparedStatement st = DatabaseClass.CashierCreateStatement();
        st.setString(1, name);
        st.setString(2, city);
        st.setString(3, comboBoxCashier.getValue());
        st.executeQuery();
        DatabaseClass.infoBox("Cashier Successfully Created", "Created Cashier");
    }



    @FXML
    void tableClickFillData(MouseEvent event) throws SQLException {

        ResultSetMetaData rsmd = DatabaseClass.TableFillNamesDataStatement();
        String name1 = rsmd.getColumnName(1);
        String name2 = rsmd.getColumnName(2);
        String name3 = rsmd.getColumnName(3);
        c1.setText(name1);
        c2.setText(name2);
        c3.setText(name3);
    }

}
