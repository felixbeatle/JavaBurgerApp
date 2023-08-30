import java.util.Scanner;

public class BaseBurger implements Icook {
    public String breadRoll;
    public String meat;
    private boolean hasTomato;
    private boolean hasLettuce;
    private boolean hasOnion;
    private boolean hasMushroom;
public final double basePrice=5.0;
    private double FinalPrice =basePrice;

    public BaseBurger(String breadRoll, String meat) {
        this.breadRoll = breadRoll;
        this.meat = meat;

    }

    @Override
    public void AddAdditions() {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Do you want tomato? (yes/no)");
        String tomatoChoice = scanner.nextLine();
        if (tomatoChoice.equalsIgnoreCase("yes")) {
            hasTomato = true;

        }
        System.out.println("Do you want lettuce? (yes/no)");
        String lettuceChoice = scanner.nextLine();
        if (lettuceChoice.equalsIgnoreCase("yes")) {
            hasLettuce = true;
        }
        System.out.println("Do you want oignon? (yes/no)");
        String oignonChoice = scanner.nextLine();
        if (oignonChoice.equalsIgnoreCase("yes")) {
            hasOnion = true;

        }
        System.out.println("Do you want mushroom? (yes/no)");
        String MushroomChoice = scanner.nextLine();
        if (MushroomChoice.equalsIgnoreCase("yes")) {
            hasMushroom = true;
        }

    }

    @Override
    public void showPrice() {
        System.out.println("Base price: $" + basePrice);
        System.out.println("Final total: $" + FinalPrice);
    }

    public double AdditionPrice() {
        double lettuce = 0.5;
        double oignon = 1.0;
        double Tomato = 1.5;
        double mushroom = 2.0;


        if (hasTomato) {
            FinalPrice += Tomato;
            System.out.println("topping tomato:" + Tomato);

        }
        if (hasLettuce) {
            System.out.println("topping lettuce:" + lettuce);
            FinalPrice += lettuce;

        }
        if (hasOnion) {
            System.out.println("topping oignon:" + oignon);

            FinalPrice += oignon;

        }
        if (hasMushroom) {
            System.out.println("topping mushroom:" + mushroom);

            FinalPrice += mushroom;

        }
        return FinalPrice;
    };

    public boolean isHasTomato() {
        return hasTomato;
    }

    public boolean isHasLettuce() {
        return hasLettuce;
    }

    public boolean isHasOnion() {
        return hasOnion;
    }

    public boolean isHasMushroom() {
        return hasMushroom;
    }

    public final double getfinalPrice() {


        return FinalPrice;
    }

    @Override
    public void pay() {


    }

}