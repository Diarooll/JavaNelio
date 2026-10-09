import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService brIntSer = new BrazilInterestService(2.0);
        double payment = brIntSer.payment(amount, months);

        System.out.println("Payment after " + months + " months: ");
        System.out.println(payment);

        sc.close();
    }
}
