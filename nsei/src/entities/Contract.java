package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private int number;
    private String clientName;
    private double totalValue;
    private LocalDate beginDate;
    private int months;
    private List<Installment> installments = new ArrayList<>();

    public Contract(int number, String clientName, double totalValue, LocalDate beginDate, int months) {
        this.number = number;
        this.clientName = clientName;
        this.totalValue = totalValue;
        this.beginDate = beginDate;
        this.months = months;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public List<Installment> getInstallments() {
        return installments;
    }
}
