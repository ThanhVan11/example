public class Main {
    public static void main(String[] args) {
        System.out.println("--- ORDER 1 ---");
        BurgerBuilder builder1 = new BurgerBuilder();
        Burger burger1 = builder1.buns("Sesame Bun")
                .meat("Grilled Beef")
                .sauce("Ketchup")
                .addCheese(true)
                .build();
        System.out.println(burger1);

        System.out.println("\n--- ORDER 2 ---");
        BurgerBuilder builder2 = new BurgerBuilder();
        Burger burger2 = builder2
                .buns("Black Bun")
                .meat("Fried Chicken")
                .sauce("Spicy Chili")
                .addCheese(true)
                .build();
        System.out.println(burger2);

    }
}