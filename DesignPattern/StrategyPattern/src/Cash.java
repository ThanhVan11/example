public class Cash implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Cash");
    }
}
