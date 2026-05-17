package com.rentalsystem.employee;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Employee {

    public Manager() {
    }

    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateMonthlySalary() {
        return getBaseSalary() + 20000;
    }
}
