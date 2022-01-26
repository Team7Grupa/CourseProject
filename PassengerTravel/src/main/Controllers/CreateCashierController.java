package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
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
            Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery("SELECT Kvartal FROM OFFICEVARNA");
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
            Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery("SELECT Kvartal FROM OFFICEDOBRICH");
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
            Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery("SELECT Kvartal FROM OFFICESOFIA");
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

        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        PreparedStatement st = com.prepareStatement("Insert into Cashier (name,city,office) values(?,?,?)");
        st.setString(1, name);
        st.setString(2, city);
        st.setString(3, comboBoxCashier.getValue());
        st.executeQuery();
        JOptionPane.showMessageDialog(null,"Cashier Successfully Created");
    }



    @FXML
    void tableClickFillData(MouseEvent event) throws SQLException {

        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        PreparedStatement st = com.prepareStatement("SELECT * FROM CASHIER");
        ResultSetMetaData rsmd = st.getMetaData();
        String name1 = rsmd.getColumnName(1);
        String name2 = rsmd.getColumnName(2);
        String name3 = rsmd.getColumnName(3);
        c1.setText(name1);
        c2.setText(name2);
        c3.setText(name3);
        st.executeQuery();

    }

}
