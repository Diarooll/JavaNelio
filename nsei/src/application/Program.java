package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaymentService;
import services.PaypalPayment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract's datas:");
        System.out.print("number: ");
        int number = sc.nextInt();
        System.out.print("Day: ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        sc.nextLine();
        System.out.print("Client name: ");
        String clientName = sc.nextLine();
        System.out.print("Total value: ");
        double totalValue = sc.nextDouble();
        System.out.print("Number of months/installments: ");
        int months = sc.nextInt();

        Contract contract = new Contract(number, clientName, totalValue, date, months);

        ContractService service = new ContractService(new PaypalPayment());
        service.processPayment(contract, contract.getMonths());

        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }




    }
}
