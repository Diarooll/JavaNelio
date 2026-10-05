package models.service;

import models.entities.Contract;
import models.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentServices onlinePaymentServices;
    private double totalPayment;

    public ContractService(OnlinePaymentServices onlinePaymentServices) {
        this.onlinePaymentServices = onlinePaymentServices;
    }

    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue() / months;

        for(int i=1; i<=months;i++){
            LocalDate duedate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentServices.interest(basicQuota, i);
            double fee = onlinePaymentServices.paymentFee(basicQuota + interest );
            double quota = basicQuota + interest + fee;
            totalPayment +=quota;
            contract.getInstallments().add(new Installment(duedate, quota));
        }
    }
    public double getTotalPayment(){
        return totalPayment;
    }


}
