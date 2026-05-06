package com.rentalsystem.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "regular_customer")
public class RegularCustomer extends Customer {

    public RegularCustomer() {
        super();
    }

    public RegularCustomer(String name, String email, String phone, String licenseNumber) {
        super(name, email, phone, licenseNumber);
    }

    @Override
    public String getRoleName() {
        return "Regular Customer";
    }

    @Override
    public double getDiscountRate() {
        return 0.0;
    }
}
