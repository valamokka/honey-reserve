package Marton.Szabo.model.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USR = System.getenv("DB_USER");
    private static final String DB_PASS = System.getenv("DB_PASS");

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USR, DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
