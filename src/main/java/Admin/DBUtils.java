package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
    private static String url = "jdbc:postgresql://localhost:5432/your_database";
    private static String username = "baz";
    private static String password = " ";
    public static Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
