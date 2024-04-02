package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Contract value: ");
        double value = sc.nextDouble();
        Contract contract = new Contract(number, date, value);

        System.out.print("Number of installments: ");
        int months = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, months);

        System.out.println();
        System.out.println("Installments");
        for(Installment i : contract.getInstallments()) {
            System.out.println(i);
        }
//        8028
//        25/06/2018
//        600.00
//        3
        sc.close();
    }
}
