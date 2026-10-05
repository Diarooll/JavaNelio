package Application;

import model.entities.CarRental;
import model.entities.RentalService;
import model.entities.Vehicle;
import model.services.BrazilTaxService;

import javax.swing.text.StyledEditorKit;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // mais utilizado
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        boolean valid = false;
        while(!valid) {
            try {
                //entrada de dados
                System.out.println("Enter the rental data:");
                System.out.print("Car model: ");
                String carModel = sc.nextLine();
                System.out.print("Retirada dd/MM/yyyy HH:mm: ");
                LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
                System.out.print("Retorno dd/MM/yyyy HH:mm: ");
                LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
                System.out.print("Enter the price per hour: ");
                double hourPrice = sc.nextDouble();
                System.out.print("Enter the price per day: ");
                double dailyPrice = sc.nextDouble();

                CarRental carRental = new CarRental(new Vehicle(carModel), start, finish);

                BrazilTaxService taxService = new BrazilTaxService();
                RentalService rs = new RentalService(hourPrice, dailyPrice, taxService);
                rs.processInvoice(carRental);

                valid = true;
            } catch (DateTimeException e) {
                System.out.println("Error: Data should be at the pattern dd/MM/yyyy HH:mm.\n");
            }
        }




        sc.close();
    }
}
