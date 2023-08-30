import java.util.Scanner;

public class DeluxeBurger extends BaseBurger implements  Icook{

    private final double basePrice=7.50;
    private boolean HasDrinks =false;
    private boolean HasChips = false ;
    private double FinalPrice =basePrice;

    public boolean isHasDrinks() {
        return HasDrinks;
    }

    public boolean isHasChips() {
        return HasChips;
    }

    public DeluxeBurger(String breadRoll, String meat) {
        super(breadRoll, meat);
        this.breadRoll = breadRoll;
        this.meat = meat;

    }



    @Override
    public void AddAdditions() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want Drinks? (yes/no)");
            String DrinksChoice = scanner.nextLine();
            if (DrinksChoice.equalsIgnoreCase("yes")) {
                HasDrinks = true;
            }
            System.out.println("Do you want Chips? (yes/no)");
            String ChipsChoice = scanner.nextLine();
            if (ChipsChoice.equalsIgnoreCase("yes")) {
                HasChips = true;
            }
            FoodFactory.createDeluxeBurger(breadRoll, meat);

    }

    @Override
    public void showPrice() {
        System.out.println("Base price: $" + basePrice);
        System.out.println("Final total: $" + FinalPrice);

    }

    @Override
    public double AdditionPrice() {
        double drinkPrice = 1.50;
        double chipsPrice = 1.50;
        if (HasDrinks) {
            FinalPrice += drinkPrice;
            System.out.println("drinks:" + drinkPrice);
        }
        if (HasChips) {
            FinalPrice += chipsPrice;
            System.out.println("chips:" + chipsPrice);
        }

        System.out.println("Final total: $" + FinalPrice);


        return FinalPrice;
    }

    @Override
    public void pay() {


    }
}
