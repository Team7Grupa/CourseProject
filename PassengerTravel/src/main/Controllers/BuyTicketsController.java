package Controllers;

import DataClasses.DatabaseClass;
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
    private TextField username;
    @FXML
    void goBack(ActionEvent event) throws IOException {

       Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/workWithTravel.fxml"));
       ticketPane.getChildren().add(newLoadedPane);
    }

    @FXML
    void saveTicket(ActionEvent event) throws SQLException {
        ObservableList<String> list = comboBoxSpace.getItems();
        String newFreeSpace = "";
        String name = username.getText();
        String space = comboBoxSpace.getValue();

        for (int i=0; i<list.size();i++)
        {
            if(list.get(i) != space)
            {
                newFreeSpace = newFreeSpace + list.get(i) + ",";
            }
        }

        ResultSet rs = DatabaseClass.saveTicket(travelID);
        String strbusySpace = "";

        if (rs.next())
        {
            strbusySpace = rs.getString("BusySpace");
        }

        comboBoxDest.setItems(list);

        PreparedStatement st2 = DatabaseClass.saveTicketUpdateData();
        st2.setString(1, newFreeSpace);
        st2.setString(2, strbusySpace + "," + space);
        st2.setInt(3, travelID);
        st2.executeQuery();
        DatabaseClass.infoBox("Hello, " + name+ "\n You Successfully Bought a Ticket", "Buy Ticket");

    }

    @FXML
    void destinationsLoad(MouseEvent event) throws SQLException {

        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs = DatabaseClass.destinationStatementLoad();
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

        ResultSet rs = DatabaseClass.spaceLoadStatement(dest);
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
