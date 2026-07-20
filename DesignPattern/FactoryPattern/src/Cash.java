public class Cash implements PaymentInterface{
    @Override
    public void pay() {
        System.out.println("Pay by Cash.");
    }
}
