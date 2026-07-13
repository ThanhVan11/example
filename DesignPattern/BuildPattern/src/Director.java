public class Director {
    public void makeBeefBurger(IBurgerBuilder builder) {
        builder.orderBuns("Sesame Bun")
                .orderMeat("Grilled Beef")
                .orderSauce("Ketchup")
                .addCheese(true);
    }

    public void makeVeganBurger(IBurgerBuilder builder) {
        builder.orderBuns("Gluten-Free Bun")
                .orderMeat("Plant-based Patty")
                .orderSauce("Vegan Mayo")
                .addCheese(false);
    }
}
