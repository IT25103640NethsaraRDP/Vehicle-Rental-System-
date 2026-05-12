package com.rentalsystem.employee;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FieldStaff")
public class FieldStaff extends Employee {

    public FieldStaff() {
    }

    public FieldStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateMonthlySalary() {
        return getBaseSalary() + 10000;
    }
}
