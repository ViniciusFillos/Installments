package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {

        for(int i=1; i<=months; i++) {
            double amountIsntallment;
            LocalDate dateInstallment = contract.getDate().plusMonths(i);
            Double amountPerMonth = contract.getTotalValue()/months;
            amountIsntallment = amountPerMonth;
            amountIsntallment += paymentService.interest(amountPerMonth,i);
            amountIsntallment += paymentService.paymentFee(amountIsntallment);

            contract.getInstallments().add(new Installment(dateInstallment, amountIsntallment));
        }
    }
}
