package DataClasses;

import javafx.scene.control.Label;

import javax.swing.*;
import java.sql.*;

public class DatabaseClass {
    public static Connection getConnection() throws SQLException
    {
        Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ASD","1234");
        return com;
    }

    public static boolean validateLogin(String username1, String password1, Label label, boolean flag) throws SQLException
    {
            Connection com= getConnection();
            Statement st=com.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM user1 WHERE username1='"+username1+"' AND password1='"+password1+"'");
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
        if(username1.equals("Admin") && password1.contentEquals("admin"))
        {
            infoBox("Welcome! You logged in as: Administrator", "Valid Credentials");
            flag=true;
        }
        else {
            infoBox("Welcome! You logged in as: User", "Valid Credentials");
            flag=false;
        }
        return flag;
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

}

