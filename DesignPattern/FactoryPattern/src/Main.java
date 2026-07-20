//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentInterface qr = PaymentFactory.createPayment("qr");
        qr.pay();
        PaymentInterface cash = PaymentFactory.createPayment("cash");
        cash.pay();
        PaymentInterface card = PaymentFactory.createPayment("card  ");
        card.pay();
    }
}