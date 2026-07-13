public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        System.out.println("--- ORDER 1: FROM MENU (Using Director) ---");
        IBurgerBuilder builder1 = new CustomBurgerBuilder();
        director.makeBeefBurger(builder1);
        Burger beefBurger = builder1.createBurger();
        System.out.println(beefBurger);

        System.out.println("\n--- ORDER 2: CUSTOM ORDER (Without Director) ---");
        IBurgerBuilder builder2 = new CustomBurgerBuilder();
        Burger customBurger = builder2.orderBuns("Black Bun").orderMeat("Fried Chicken").orderSauce("Spicy Chili").addCheese(true).createBurger();
        System.out.println(customBurger);

    }
}