public class Pizzabuilder {
    public String Dough;
    public String meat;
    private boolean hasTomato;
    private boolean hasLettuce;
    private boolean hasOnion;
    private boolean hasMushroom;

    public Pizzabuilder whitDough(String breadRoll) {
        this.Dough = breadRoll;
        return this;
    }

    public Pizzabuilder withMeat(String meat) {
        this.meat = meat;
        return this;
    }

    public Pizzabuilder withTomato(boolean hasTomato) {
        this.hasTomato = hasTomato;
        return this;
    }

    public Pizzabuilder withLettuce(boolean hasLettuce) {
        this.hasLettuce = hasLettuce;
        return this;
    }

    public Pizzabuilder withOnion(boolean hasOnion) {
        this.hasOnion = hasOnion;
        return this;
    }

    public Pizzabuilder withMushroom(boolean hasMushroom) {
        this.hasMushroom = hasMushroom;
        return this;
    }

    public Pizza build() {
        return new Pizza(Dough, meat);
    }
}
