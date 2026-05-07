package com.rentalsystem.payment;

import com.rentalsystem.booking.Booking;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ONLINE")
public class OnlinePayment extends Payment {

    private String transactionId;
    private String gatewayProvider;

    public OnlinePayment() {}

    public OnlinePayment(Booking booking, double amount, String transactionId, String gatewayProvider) {
        super(booking, amount);
        this.transactionId = transactionId;
        this.gatewayProvider = gatewayProvider;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getGatewayProvider() { return gatewayProvider; }
    public void setGatewayProvider(String gatewayProvider) { this.gatewayProvider = gatewayProvider; }

    @Override
    public boolean processPayment() {
        if (transactionId != null && !transactionId.isEmpty()) {
            this.setStatus("SUCCESS");
            return true;
        }
        this.setStatus("FAILED");
        return false;
    }
}
