package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    String user = "root";
    String password = "210520";
    String connectionURL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    Connection connection;

    public Connection getConnection() {
        try{
            connection = DriverManager.getConnection(connectionURL, user, password);
            System.out.println("Связь устоновлена");
        }catch (SQLException s){
            s.printStackTrace();
        }
        return connection;
    }
}
