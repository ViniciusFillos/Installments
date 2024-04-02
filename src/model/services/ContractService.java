package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    public void processContract(Contract contract, Integer months) {
        OnlinePaymentService paymentService = new PaypalService();
        for(int i=1; i<=months; i++) {
            double amount;
            LocalDate dateInstallment = contract.getDate().plusMonths(i);
            Double amountPerMonth = contract.getTotalValue()/months;
            amount = amountPerMonth;
            amount += paymentService.interest(amountPerMonth,i);
            amount += paymentService.paymentFee(amount);
            Installment installment = new Installment(dateInstallment, amount);
            contract.getInstallments().add(installment);
        }
    }
}
