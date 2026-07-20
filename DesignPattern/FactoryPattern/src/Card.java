public class Card implements PaymentInterface {
    @Override
    public void pay() {
        System.out.println("Pay by Card.");
    }
}
