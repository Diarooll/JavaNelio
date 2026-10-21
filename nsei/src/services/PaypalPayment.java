package services;

public class PaypalPayment implements PaymentService {
    @Override
    public double paymentFee(double value) {
        return value * 0.02;
    }

    @Override
    public double interest(double value, int months) {
        return value * 0.01 * months;
    }
}
