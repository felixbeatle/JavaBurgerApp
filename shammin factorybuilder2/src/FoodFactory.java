public class FoodFactory {
    public static BaseBurger createBaseBurger(String breadRoll, String meat) {
        basebuilder builder = new basebuilder();
        return builder.withBreadRoll(breadRoll)

                .build();
    }

    public static HeatlthyBurger createHeatlthyBurger(String breadRoll, String meat) {
        HeatlthyBurgerBuilder builder1 = new HeatlthyBurgerBuilder();
        return builder1

                .build();


    }

    public static DeluxeBurger createDeluxeBurger(String breadRoll, String meat) {
        DeluxeBurgerBuilder builder2 = new DeluxeBurgerBuilder(breadRoll, meat);
        return builder2

                .build();
    }
    public static Pizza createPizza(String Dough, String meat) {
        Pizzabuilder builder3 = new Pizzabuilder();
        return builder3

                .build();
    }

}