public class DeluxeBurgerBuilder  {
    private boolean HasDrinks =false;
    private boolean HasChips = false ;


    public DeluxeBurgerBuilder(String breadRoll, String meat) {

    }


    public DeluxeBurgerBuilder withDrinks(boolean HasDrinks) {
        this.HasDrinks = HasDrinks;
        return this;
    }
    public DeluxeBurgerBuilder withChips(boolean HasChips) {
        this.HasChips = HasChips;
        return this;
    }

    public DeluxeBurger build() {
        return new DeluxeBurger("", "");
    }


}
