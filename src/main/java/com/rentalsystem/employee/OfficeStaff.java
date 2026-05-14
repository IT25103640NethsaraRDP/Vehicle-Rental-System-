package com.rentalsystem.employee;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("OfficeStaff")
public class OfficeStaff extends Employee {

    public OfficeStaff() {
    }

    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateMonthlySalary() {
        return getBaseSalary();
    }
}
