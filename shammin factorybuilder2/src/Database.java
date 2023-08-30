import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static void main(String[] args) {
        try {
            // Establish a connection to the SQLite database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\database\\Grocery.db");

            // Create a statement object for executing SQL queries
            Statement statement = conn.createStatement();

            // Create the 'alcool' table
            statement.execute("CREATE TABLE IF NOT EXISTS alcool (iditem INTEGER PRIMARY KEY AUTOINCREMENT, articlename STRING, quantity INTEGER, price DOUBLE, type STRING, expirationDate STRING)");

            // Close the statement and connection
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
