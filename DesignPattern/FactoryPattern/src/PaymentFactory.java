public class PaymentFactory {
    private static String type;

    public static PaymentInterface createPayment(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment type cannot be null or empty.");
        }

        if (type.trim().equalsIgnoreCase("Card")) {
            return new Card();
        } else if (type.trim().equalsIgnoreCase("QR")) {
            return new QR();
        } else if (type.trim().equalsIgnoreCase("Cash")) {
            return new Cash();
        } else {
            throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
