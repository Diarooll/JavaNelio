package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private PaymentService service;

    public ContractService(PaymentService service) {
        this.service = service;
    }

    public void processPayment(Contract contract, int months){
        double totalValue = contract.getTotalValue();
        double valuePerMonth = totalValue/ months;

        for(int i=0;i<months;i++){
            LocalDate date = contract.getBeginDate().plusMonths(i+1);
            double withInterest = valuePerMonth + service.interest(valuePerMonth, i+1);
            double totalMonth = withInterest + service.paymentFee(withInterest);
            contract.getInstallments().add(new Installment(date, totalMonth));
        }
    }
}
