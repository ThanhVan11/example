public class CustomBurgerBuilder implements IBurgerBuilder {
    private String buns;
    private String meat;
    private String sauce;
    private boolean hasCheese;

    @Override
    public IBurgerBuilder orderBuns(String buns) {
        this.buns = buns;
        return this;
    }

    @Override
    public IBurgerBuilder orderMeat(String meat) {
        this.meat = meat;
        return this;
    }

    @Override
    public IBurgerBuilder orderSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    @Override
    public IBurgerBuilder addCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
        return this;
    }

    @Override
    public Burger createBurger() {
        return new Burger(buns, meat, sauce, hasCheese);
    }
}
