package com.rentalsystem.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "premium_customer")
public class PremiumCustomer extends Customer {

    private double discountRate = 0.15;

    public PremiumCustomer() {
        super();
    }

    public PremiumCustomer(String name, String email, String phone, String licenseNumber) {
        super(name, email, phone, licenseNumber);
    }

    @Override
    public String getRoleName() {
        return "Premium Customer";
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
