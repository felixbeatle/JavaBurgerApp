class Element {
    private String articlename;
    private int quantity;
    private double price;
    private String type;
    private String expirationDate;

    public Element(String articlename, int quantity, double price, String type, String expirationDate) {
        this.articlename = articlename;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    // Getter methods

    public String getArticlename() {
        return articlename;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}