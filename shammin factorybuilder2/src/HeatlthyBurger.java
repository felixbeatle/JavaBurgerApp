import java.util.Scanner;

public class HeatlthyBurger extends BaseBurger implements Icook {

    private final double basePrice=5.0;
    private  boolean HasTomato = false;
    private boolean hasLettuce=false;
    private boolean hasOnion=false;

    private boolean hasMushroom=false;
    private boolean hasAsparagus=false;

    private boolean hasKale=false;

    private double FinalPrice =basePrice;

    @Override
    public boolean isHasTomato() {
        return HasTomato;
    }

    @Override
    public boolean isHasLettuce() {
        return hasLettuce;
    }

    @Override
    public boolean isHasOnion() {
        return hasOnion;
    }

    @Override
    public boolean isHasMushroom() {
        return hasMushroom;
    }

    public boolean isHasAsparagus() {
        return hasAsparagus;
    }

    public boolean isHasKale() {
        return hasKale;
    }

    public double getFinalPrice() {
        return FinalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        FinalPrice = finalPrice;
    }

    public HeatlthyBurger(String breadRoll, String meat) {
        super(breadRoll, meat);
        this.HasTomato = HasTomato;
        this.hasLettuce = hasLettuce;
        this.hasOnion = hasOnion;
        this.hasMushroom = hasMushroom;
        this.hasAsparagus = hasAsparagus;
        this.hasKale = hasKale;
        FinalPrice = getFinalPrice();
    }


    @Override
    public void AddAdditions() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want tomato? (yes/no)");
        String tomatoChoice = scanner.nextLine();
        if (tomatoChoice.equalsIgnoreCase("yes")) {
            HasTomato = true;
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
        System.out.println("Do you want asparagus? (yes/no)");
        String AsparagusChoice = scanner.nextLine();
        if (AsparagusChoice.equalsIgnoreCase("yes")) {
            hasAsparagus = true;

        }
        System.out.println("Do you want kale? (yes/no)");
        String KaleChoice = scanner.nextLine();
        if (KaleChoice.equalsIgnoreCase("yes")) {
            hasKale = true;
        }
        FoodFactory.createHeatlthyBurger(breadRoll, meat);


    }

    @Override
    public void showPrice() {

        System.out.println("Base price is: " + basePrice);
        System.out.println("final price is: " + FinalPrice);

    }

    @Override
    public double AdditionPrice() {
        double lettuce = 0.5;
        double oignon = 1.0;
        double Tomato = 1.5;
        double mushroom = 2.0;
        double asparagus = 2.5;
        double kale = 3.0;



        if (HasTomato) {
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
        if (hasAsparagus) {
            System.out.println("topping asparagus:" + asparagus);

            FinalPrice += asparagus;

        }
        if (hasKale) {
            System.out.println("topping kale:" + kale);

            FinalPrice += kale;

        }


        return FinalPrice;
    }

    @Override
    public void pay() {

    }
}
