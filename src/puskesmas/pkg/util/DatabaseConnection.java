package puskesmas.pkg.util;

/**
 * @author Achmad Raihan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            final String URL = "jdbc:postgresql://localhost:5432/puskesmas";
            final String USER = "postgres";
            final String PASSWORD = "967832";
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established");
        } catch (SQLException exception) {
            System.out.println("Failed to connect to the database...");
            System.out.println(exception.getMessage());
        }
        return connection;
    }

    private DatabaseConnection() {}
}
