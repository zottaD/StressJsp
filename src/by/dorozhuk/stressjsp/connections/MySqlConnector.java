package by.dorozhuk.stressjsp.connections;

// imports should be without *, every class in package should present in imports (configure IDE)
import java.sql.*;
import java.sql.DriverManager;

public class MySqlConnector {

    private static final String URL = "jdbc:mysql://localhost:3360/StressJsp?useSSL=false";
    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
