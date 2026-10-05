package Application;

import models.entities.Contract;
import models.entities.Installment;
import models.service.ContractService;
import models.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the contract number: ");
        int number = sc.nextInt();
        System.out.print("Contract date: ");
        LocalDate contractTime = LocalDate.parse(sc.next(), fmt);
        System.out.print("Contract total value: ");
        double totalValue = sc.nextDouble();
        System.out.print("Enter the number of installments: ");
        int months = sc.nextInt();

        Contract obj = new Contract(number, contractTime, totalValue);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(obj, months);

        System.out.println("parcelas: ");
        for(Installment ins : obj.getInstallments()){
            System.out.println(ins);
        }
        System.out.println("Total payment: " + String.format("%.2f", contractService.getTotalPayment()));


        sc.close();
    }
}