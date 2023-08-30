public class HeatlthyBurgerBuilder {
    private final double basePrice=5.0;
    private  Boolean HasTomato = false;
    private boolean hasLettuce=false;
    private boolean hasOnion=false;

    private boolean hasMushroom=false;
    private boolean hasAsparagus=false;

    private boolean hasKale=false;

    private double FinalPrice =basePrice;



    public HeatlthyBurgerBuilder withTomato(boolean hasTomato) {
        this.HasTomato = hasTomato;

        return this;
    }

    public HeatlthyBurgerBuilder withLettuce(boolean hasLettuce) {
        this.hasLettuce = hasLettuce;
        return this;
    }

    public HeatlthyBurgerBuilder withOnion(boolean hasOnion) {
        this.hasOnion = hasOnion;
        return this;
    }

    public HeatlthyBurgerBuilder withMushroom(boolean hasMushroom) {
        this.hasMushroom = hasMushroom;
        return this;
    }
    public HeatlthyBurgerBuilder withAsparagus(boolean hasAsparagus) {
        this.hasAsparagus = hasAsparagus;
        return this;
    }
    public HeatlthyBurgerBuilder withKale(boolean hasKale) {
        this.hasKale = hasKale;
        return this;
    }


    public HeatlthyBurger build() {
        return new HeatlthyBurger("Brown Rye Bread Roll", "");


}
}
