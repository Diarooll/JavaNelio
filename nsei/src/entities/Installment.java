package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dueDate;
    private double monthPayment;

    public Installment(LocalDate dueDate, double monthPayment) {
        this.dueDate = dueDate;
        this.monthPayment = monthPayment;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(double monthPayment) {
        this.monthPayment = monthPayment;
    }

    @Override
    public String toString() {
        return dueDate.format(dtf) + " - " + String.format("%.2f", monthPayment);
    }
}
