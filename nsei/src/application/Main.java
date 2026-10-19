package application;

import entities.Contract;
import entities.Installments;
import services.ContractServices;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the contract's datas: ");
        System.out.print("Number: ");
        int nmb = sc.nextInt();
        System.out.print("date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.println(date.format(dtf));
        System.out.print("Contract value: ");
        double value = sc.nextDouble();

        Contract contract = new Contract(nmb, date, value);

        System.out.print("Number of installments:");
        int installments = sc.nextInt();

        ContractServices service = new ContractServices(new PaypalService());
        service.processContract(contract, installments);

        System.out.println("parcelas");
        for(Installments installment : contract.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}