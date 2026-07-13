public class Burger {
    private String buns;
    private String meat;
    private String sauce;
    private boolean hasCheese;

    public Burger(String buns, String meat, String sauce, boolean hasCheese) {
        this.buns = buns;
        this.meat = meat;
        this.sauce = sauce;
        this.hasCheese = hasCheese;
    }

    public String getBuns() {
        return buns;
    }

    public String getMeat() {
        return meat;
    }

    public String getSauce() {
        return sauce;
    }

    public boolean isHasCheese() {
        return hasCheese;
    }

    @Override
    public String toString() {
        return "Burger [Bun: " + buns + ", Meat: " + meat + ", Sauce: " + sauce + ", Cheese: " + hasCheese + "]";
    }
}
