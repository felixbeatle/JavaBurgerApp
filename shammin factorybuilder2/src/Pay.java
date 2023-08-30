import java.sql.*;
import java.util.Scanner;

public class Pay {

    public void pay() {
        // Existing code for menu selection and order details
        int pay = 0 ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Burger Joint! Do you want to order a burger(1) or a Pizza(2)? ");

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("1")) {
            System.out.println("========== MENU ==========");
            System.out.println("  1. Base Burger");
            System.out.println("  2. Healthy Burger");
            System.out.println("  3. Deluxe Burger (BLT)");
            System.out.println("==========================");
            System.out.print("Enter your choice: ");
            int burgerChoice = scanner.nextInt();
            scanner.nextLine();

            switch (burgerChoice) {
                case 1:
                    System.out.println("Enter your type of bread (white, brioche)");
                    String breadChoice = scanner.nextLine();
                    System.out.println("Enter your type of meat (beef, chicken)");
                    String meatChoice = scanner.nextLine();

                    BaseBurger baseBurger = FoodFactory.createBaseBurger(breadChoice, meatChoice);
                    int baseBurgerId = insertBaseBurgerIntoDatabase(baseBurger);
                    insertSalesIntoDatabase(baseBurgerId, baseBurger.getfinalPrice(), "baseburger");
                    insertBaseBurgerIntoDatabase(baseBurger);
                    System.out.println("Bread type: " + breadChoice);
                    System.out.println("Meat type: " + meatChoice);



                    break;

                case 2:
                    System.out.println("Enter your type of bread (white, brioche)");
                    String breadChoice2 = scanner.nextLine();
                    System.out.println("Enter your type of meat (Veggie, chicken)");
                    String meatChoice2 = scanner.nextLine();
                    HeatlthyBurger healthyBurger = FoodFactory.createHeatlthyBurger(breadChoice2, meatChoice2);
                    int healthyBurgerId = insertHealthyBurgerIntoDatabase(healthyBurger);
                    insertSalesIntoDatabase(healthyBurgerId, healthyBurger.getfinalPrice(), "healthyburger");
                    insertHealthyBurgerIntoDatabase(healthyBurger);
                    System.out.println("Bread type: " + breadChoice2);
                    System.out.println("Meat type: " + meatChoice2);


                    // Insert healthy burger additions and price into the database

                    break;

                case 3:
                    System.out.println("Enter your type of bread (white, brioche)");
                    String breadChoice3 = scanner.nextLine();
                    System.out.println("Enter your type of meat (beef, chicken)");
                    String meatChoice3 = scanner.nextLine();
                    DeluxeBurger deluxeBurger = FoodFactory.createDeluxeBurger(breadChoice3, meatChoice3);
                    int deluxeBurgerId = insertDeluxeBurgerIntoDatabase(deluxeBurger);
                    insertSalesIntoDatabase(deluxeBurgerId, deluxeBurger.getfinalPrice(), "deluxeburger");
                    insertDeluxeBurgerIntoDatabase(deluxeBurger);
                    System.out.println("Bread type: " + breadChoice3);
                    System.out.println("Meat type: " + meatChoice3);



                    // Insert deluxe burger additions and price into the database

                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } else {
            System.out.println("Enter your type of dough (pan, regular)");
            String doughChoice = scanner.nextLine();
            System.out.println("Enter your type of meat (Pepperoni,chicken)");
            String meatChoice = scanner.nextLine();
            Pizza pizza = FoodFactory.createPizza(doughChoice, meatChoice);
            int pizzaId = insertPizzaIntoDatabase(pizza);
            insertSalesIntoDatabase(pizzaId, pizza.getFinalPrice(), "pizza");

            insertPizzaIntoDatabase(pizza);
            System.out.println("Dough type: " + doughChoice);
            System.out.println("Meat type: " + meatChoice);





        }
    }

    private int insertBaseBurgerIntoDatabase(BaseBurger baseBurger) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\database\\burger.db");
             PreparedStatement statement = conn.prepareStatement("INSERT INTO baseburger (price, tomato, oignon, lettuce, mushroom) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            baseBurger.AddAdditions();

            statement.setDouble(1, baseBurger.AdditionPrice());
            statement.setBoolean(2, baseBurger.isHasTomato());
            statement.setBoolean(3, baseBurger.isHasOnion());
            statement.setBoolean(4, baseBurger.isHasLettuce());
            statement.setBoolean(5, baseBurger.isHasMushroom());

            baseBurger.showPrice();
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retrieve the auto-generated ID
                }
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return -1;
    }

    private int insertHealthyBurgerIntoDatabase(HeatlthyBurger healthyBurger) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\database\\burger.db");
             PreparedStatement statement = conn.prepareStatement("INSERT INTO healthyburger (price, tomato, oignon, lettuce, mushroom, asparagus, kale) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            healthyBurger.AddAdditions();
            statement.setDouble(1, healthyBurger.AdditionPrice());
            statement.setBoolean(2, healthyBurger.isHasTomato());
            statement.setBoolean(3, healthyBurger.isHasOnion());
            statement.setBoolean(4, healthyBurger.isHasLettuce());
            statement.setBoolean(5, healthyBurger.isHasMushroom());
            statement.setBoolean(6, healthyBurger.isHasAsparagus());
            statement.setBoolean(7, healthyBurger.isHasKale());

            healthyBurger.showPrice();

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retrieve the auto-generated ID
                }
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return -1;
    }
    private int insertDeluxeBurgerIntoDatabase(DeluxeBurger deluxeBurger) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\database\\burger.db");
             PreparedStatement statement = conn.prepareStatement("INSERT INTO deluxeburger (price, chips, drink) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            deluxeBurger.AddAdditions();
            statement.setDouble(1, deluxeBurger.AdditionPrice());
            statement.setBoolean(2, deluxeBurger.isHasChips());
            statement.setBoolean(3, deluxeBurger.isHasDrinks());

            deluxeBurger.showPrice();
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retrieve the auto-generated ID
                }
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return -1;
    }
    private int insertPizzaIntoDatabase(Pizza pizza) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\database\\burger.db");
             PreparedStatement statement = conn.prepareStatement("INSERT INTO pizza (price, tomato, oignon, lettuce, mushroom) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            pizza.AddAdditions();
            statement.setDouble(1, pizza.AdditionPrice());
            statement.setBoolean(2, pizza.isHasTomato());
            statement.setBoolean(3, pizza.isHasOnion());
            statement.setBoolean(4, pizza.isHasLettuce());
            statement.setBoolean(5, pizza.isHasMushroom());

            pizza.showPrice();
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retrieve the auto-generated ID
                }
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return -1;
    }
    private void insertSalesIntoDatabase(double price, double v, String type) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\database\\burger.db");
             PreparedStatement statement = conn.prepareStatement("INSERT INTO sales (price, type) VALUES (?, ?)")) {
            statement.setDouble(1, price);
            statement.setString(2, type);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(type + " sold successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private String convertArrayToJson(boolean[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (int i = 0; i < array.length; i++) {
            json.append(array[i]);
            if (i < array.length - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

    // Rest of the Pay class implementation
}
