public interface IBurgerBuilder {
    IBurgerBuilder orderBuns(String buns);
    IBurgerBuilder orderMeat(String meat);
    IBurgerBuilder orderSauce(String sauce);
    IBurgerBuilder addCheese(boolean hasCheese);

    Burger createBurger();
}
