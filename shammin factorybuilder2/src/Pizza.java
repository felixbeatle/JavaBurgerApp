import java.util.Scanner;

public class Pizza implements Icook {
        public String Dough;
        public String meat;
        private boolean hasTomato;
        private boolean hasLettuce;
        private boolean hasOnion;
        private boolean hasMushroom;
        public final double basePrice=5.0;
        public double FinalPrice =basePrice;

        public Pizza(String Dough, String meat) {
            this.Dough = Dough;
            this.meat = meat;

        }
        public Pizza(String Dough, String meat, boolean hasTomato, boolean hasLettuce, boolean hasOnion, boolean hasMushroom) {
            this.Dough = Dough;
            this.meat = meat;
            this.hasTomato = hasTomato;
            this.hasLettuce = hasLettuce;
            this.hasOnion = hasOnion;
            this.hasMushroom = hasMushroom;
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
            FoodFactory.createBaseBurger(Dough, meat);

        }

    @Override
    public void showPrice() {
        System.out.println("Base price: $" + basePrice);
        System.out.println("Final total: $" + AdditionPrice());
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

            return FinalPrice   ;
        };

    public double getFinalPrice() {
        return FinalPrice;
    }

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

    @Override
        public void pay() {


        }

        // Other methods for BaseBurger

}
