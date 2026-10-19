package services;

import entities.Contract;
import entities.Installments;
import interfaces.OnlinePaymentService;

import java.time.LocalDate;

public class ContractServices {
    private OnlinePaymentService onlinePaymentService;

    public ContractServices(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){

        double basicQuota = contract.getTotalValue() / months;

        for(int i=0;i<months;i++){
            LocalDate dueDate = contract.getDate().plusMonths(i+1);
            double interest = onlinePaymentService.interest(basicQuota, i+1);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installments(dueDate, quota));
        }

    }
}
