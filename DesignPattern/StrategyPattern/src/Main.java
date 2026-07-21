public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(5000);

        paymentService.setStrategy(new Card());
        paymentService.checkout();

        paymentService.setStrategy(new QR());
        paymentService.checkout();

        paymentService.setStrategy(new Cash());
        paymentService.checkout();
    }
}