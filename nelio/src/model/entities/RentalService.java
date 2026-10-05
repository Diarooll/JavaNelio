package model.entities;

import model.services.BrazilTaxService;

import java.time.Duration;

public class RentalService {
    private double pricePerHour;
    private double pricePerDay;

    private BrazilTaxService brazilTax;

    public RentalService(double pricePerHour, double pricePerDay, BrazilTaxService brazilTax) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.brazilTax = brazilTax;
    }

    public void processInvoice(CarRental carRental){

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60;
        double basicPayment;

        if(hours >= 12){
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        else {
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        double tax = brazilTax.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
