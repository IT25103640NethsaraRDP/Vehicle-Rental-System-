package com.rentalsystem.payment;

import com.rentalsystem.booking.Booking;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CASH")
public class CashPayment extends Payment {

    private String receiptNumber;

    public CashPayment() {}

    public CashPayment(Booking booking, double amount, String receiptNumber) {
        super(booking, amount);
        this.receiptNumber = receiptNumber;
    }

    public String getReceiptNumber() { return receiptNumber; }
    public void setReceiptNumber(String receiptNumber) { this.receiptNumber = receiptNumber; }

    @Override
    public boolean processPayment() {
        this.setStatus("SUCCESS");
        return true;
    }
}
