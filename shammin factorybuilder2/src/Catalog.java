import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog {
    public static void main(String[] args) {
        // Establish a connection to the SQLite database
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\database\\Grocery.db")) {
            // Prompt the user to choose a category
            String category = promptCategory();

            // Retrieve data from the chosen category
            List<Element> elements = retrieveElements(conn, category);

            // Display elements in the catalog
            displayCatalog(elements);
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static String promptCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a category:");
        System.out.println("1. Alcool");
        System.out.println("2. Bread");
        // Add more category options if needed

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return "alcool";
            case 2:
                return "bread";
            // Add more cases for each category option
            default:
                System.out.println("Invalid choice. Defaulting to Alcool.");
                return "alcool";
        }
    }

    private static List<Element> retrieveElements(Connection conn, String category) throws SQLException {
        List<Element> elements = new ArrayList<>();

        // Create a statement object for executing SQL queries
        Statement statement = conn.createStatement();

        // Execute the query to retrieve elements from the chosen category
        ResultSet resultSet = statement.executeQuery("SELECT articlename, quantity, price, type, expirationDate FROM " + category);

        // Process the result set
        while (resultSet.next()) {
            String articlename = resultSet.getString("articlename");
            int quantity = resultSet.getInt("quantity");
            double price = resultSet.getDouble("price");
            String type = resultSet.getString("type");
            String expirationDate = resultSet.getString("expirationDate");

            // Create an Element object and add it to the list
            Element element = new Element(articlename, quantity, price, type, expirationDate);
            elements.add(element);
        }

        // Close the statement and result set
        resultSet.close();
        statement.close();

        return elements;
    }

    private static void displayCatalog(List<Element> elements) {
        int pageSize = 6; // Number of elements to display per page
        int totalPages = (int) Math.ceil((double) elements.size() / pageSize);

        Scanner scanner = new Scanner(System.in);
        int currentPage = 1;

        while (true) {
            System.out.println("Catalog - Page " + currentPage + "/" + totalPages);
            System.out.println("---------------------------");

            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, elements.size());

            for (int i = startIndex; i < endIndex; i++) {
                Element element = elements.get(i);
                System.out.println("Name: " + element.getArticlename());
                System.out.println("Quantity: " + element.getQuantity());
                System.out.println("Price: " + element.getPrice());
                System.out.println("Type: " + element.getType());
                System.out.println("Expiration Date: " + element.getExpirationDate());
                System.out.println("---------------------------");
            }

            // Prompt the user for navigation options
            System.out.println("Options:");
            System.out.println("1. Next Page");
            System.out.println("2. Previous Page");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (currentPage < totalPages) {
                        currentPage++;
                    } else {
                        System.out.println("You are on the last page.");
                    }
                    break;
                case 2:
                    if (currentPage > 1) {
                        currentPage--;
                    } else {
                        System.out.println("You are on the first page.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the catalog.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
