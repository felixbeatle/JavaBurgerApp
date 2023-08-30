public class basebuilder {
    public String breadRoll;
    public String meat;
    private boolean hasTomato;
    private boolean hasLettuce;
    private boolean hasOnion;
    private boolean hasMushroom;

    public basebuilder withBreadRoll(String breadRoll) {
        this.breadRoll = breadRoll;
        return this;
    }

    public basebuilder withMeat(String meat) {
        this.meat = meat;
        return this;
    }

    public basebuilder withTomato(boolean hasTomato) {
        this.hasTomato = hasTomato;
        return this;
    }

    public basebuilder withLettuce(boolean hasLettuce) {
        this.hasLettuce = hasLettuce;
        return this;
    }

    public basebuilder withOnion(boolean hasOnion) {
        this.hasOnion = hasOnion;
        return this;
    }

    public basebuilder withMushroom(boolean hasMushroom) {
        this.hasMushroom = hasMushroom;
        return this;
    }

    public BaseBurger build() {
        return new BaseBurger(breadRoll, meat);
    }
}