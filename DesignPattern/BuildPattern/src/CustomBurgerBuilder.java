public class BurgerBuilder {
    private String buns;
    private String meat;
    private String sauce;
    private boolean hasCheese;

    public BurgerBuilder buns(String buns) {
        this.buns = buns;
        return this;
    }

    public BurgerBuilder meat(String meat) {
        this.meat = meat;
        return this;
    }

    public BurgerBuilder sauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public BurgerBuilder addCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
        return this;
    }

    public Burger build() {
        return new Burger(buns, meat, sauce, hasCheese);
    }
}
