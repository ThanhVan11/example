public class PaymentService {
    private int totalAmount;
    private PaymentStrategy strategy;

    public PaymentService(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout() {
        if (strategy == null) {
            System.out.println("Please choose a payment method!");
            return;
        }
        strategy.pay(totalAmount);
    }
}
