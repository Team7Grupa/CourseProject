package DataClasses;

import javafx.scene.control.Label;

import javax.swing.*;
import java.sql.*;

public class DatabaseClass
{
    public static Statement CashierStatement() throws SQLException {
        Statement st = getConnection().createStatement();
        return st;
    }

    public static Connection getConnection() throws SQLException
    {
        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        return com;
    }

    public static PreparedStatement DistributorStatement() throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("Insert into Distributor (name,city,contract) values(?,?,?)");
        return st;
    }

    public static PreparedStatement CompanyStatement() throws SQLException{
        PreparedStatement st = getConnection().prepareStatement("Insert into COMPANY(name,city,transport) values(?,?,?)");
        return st;
    }

    public static ResultSet CashierOfficeVarnaStatement() throws SQLException {
        ResultSet rs = CashierStatement().executeQuery("SELECT Kvartal FROM OFFICEVARNA");
        return rs;
    }

    public static ResultSet CashierOfficeDobrichStatement() throws SQLException{
        ResultSet rs = CashierStatement().executeQuery("SELECT Kvartal FROM OFFICEDOBRICH");
        return rs;
    }
    public static ResultSet CashierOfficeSofiaStatement() throws SQLException{
        ResultSet rs = CashierStatement().executeQuery("SELECT Kvartal FROM OFFICESOFIA");
        return rs;
    }

    public static PreparedStatement CashierCreateStatement() throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("Insert into Cashier (name,city,office) values(?,?,?)");
        return st;
    }

    public static PreparedStatement TableFillNamesStatement() throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("SELECT * FROM CASHIER");
        return st;
    }

    public static ResultSetMetaData TableFillNamesDataStatement() throws SQLException {
        ResultSetMetaData rsmd = TableFillNamesStatement().getMetaData();
        return rsmd;
    }

    public static ResultSet saveTicket(int travelID) throws SQLException {
        ResultSet rs = CashierStatement().executeQuery("SELECT BusySpace FROM Travels where id = " + travelID);
        return rs;
    }
    public static PreparedStatement saveTicketUpdateData() throws SQLException {
        PreparedStatement st = getConnection().prepareStatement("UPDATE Travels set FREESPACE = ?, BusySpace = ? where ID = ?");
        return st;
    }
    public static ResultSet destinationStatementLoad() throws SQLException {
        ResultSet rs = CashierStatement().executeQuery("SELECT Description FROM Destinations");
        return rs;
    }
    public static ResultSet spaceLoadStatement(String dest) throws SQLException {
        ResultSet rs = CashierStatement().executeQuery("SELECT a.Id, Price, FreeSpace FROM Travels a join destinations b on b.id = a.destination where b.description = '" +dest+"'");
        return rs;
    }

    public static boolean validateLogin(String username1, String password1, Label label, boolean flag) throws SQLException
    {
            Connection com = getConnection();
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM user1 WHERE username1='"+username1+"' AND password1='"+password1+"'");
            if (rs.next())
            {
                flag=true;
            }
            else
            {
                label.setText("Check username and password!");
                infoBox("Invalid Credentials", "Warning");
                flag=false;
            }
        return flag;
    }

    public static boolean validateLogin1(String username1, String password1, boolean flag) {
        if(username1.equals("Admin") && password1.equals("admin"))
        {
            infoBox("Welcome! You logged in as: Administrator", "Valid Credentials");
            flag = true;
        }
        else
        {
            infoBox("Welcome! You logged in as: User", "Valid Credentials");
            flag = false;
        }
        return flag;
    }


    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}

