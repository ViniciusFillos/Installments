package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

    private LocalDate dueDate;
    private Double amount;

    public Installment() {
    }

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return dueDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" - "+ String.format(amount.toString(), "%.2f");
    }
}
