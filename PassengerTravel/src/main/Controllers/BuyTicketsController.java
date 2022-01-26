package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.*;

public class BuyTicketsController {

    private int travelID;

    @FXML
    private ComboBox<String> comboBoxDest;
    @FXML
    private ComboBox<String> comboBoxSpace;
    @FXML
    private TextField price;
    @FXML
    private Pane ticketPane;

    @FXML
    void goBack(ActionEvent event) throws IOException {

       Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/workWithTravel.fxml"));
       ticketPane.getChildren().add(newLoadedPane);

    }

    @FXML
    void saveTicket(ActionEvent event) throws SQLException {
        ObservableList<String> list = comboBoxSpace.getItems();
        String newFreeSpace = "";
        String space = comboBoxSpace.getValue();

        for (int i=0; i<list.size();i++)
        {
            if(list.get(i) != space)
            {
                newFreeSpace = newFreeSpace + list.get(i) + ",";
            }
        }

        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        Statement st = com.createStatement();
        ResultSet rs = st.executeQuery("SELECT BusySpace FROM Travels where id = " + travelID);
        String strbusySpace = "";

        if (rs.next())
        {
            strbusySpace = rs.getString("BusySpace");
        }

        comboBoxDest.setItems(list);

        PreparedStatement st2 = com.prepareStatement("UPDATE Travels set FREESPACE = ?, BusySpace = ? where ID = ?");
        st2.setString(1, newFreeSpace);
        st2.setString(2, strbusySpace + "," + space);
        st2.setInt(3, travelID);
        st2.executeQuery();

    }

    @FXML
    void destinationsLoad(MouseEvent event) throws SQLException {

        ObservableList<String> list = FXCollections.observableArrayList();
        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        Statement st = com.createStatement();
        ResultSet rs = st.executeQuery("SELECT Description FROM Destinations");
        while (rs.next())
        {
            list.add(rs.getString("Description"));
        }
        comboBoxDest.setItems(list);
    }

    @FXML
    void spaceLoad(MouseEvent event) throws SQLException {
        String dest = comboBoxDest.getValue();
        ObservableList<String> list = FXCollections.observableArrayList();
        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        Statement st = com.createStatement();
        ResultSet rs = st.executeQuery("SELECT a.Id, Price, FreeSpace FROM Travels a join destinations b on b.id = a.destination where b.description = '" +dest+"'");
        String freespace = "";
        String strprice = "";

        if (rs.next())
        {
            strprice= rs.getString("Price");
            freespace = rs.getString("FreeSpace");
            travelID = rs.getInt("Id");
        }
        String[] res = freespace.split("[,]", 0);
        for(String myStr: res)
        {
            list.add(myStr);
        }
        comboBoxSpace.setItems(list);
        price.setText(strprice + " lv.");

    }
}
