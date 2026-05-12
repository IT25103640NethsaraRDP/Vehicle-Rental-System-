package com.rentalsystem.vehicle;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
public class Bike extends Vehicle {


    public Bike() {}

    public Bike(String brand, String model, String registrationNumber, double dailyRate) {
        super(brand, model, registrationNumber, dailyRate);
    }


    @Override
    public double calculateRentalCost(int days) {
        double baseRate = getDailyRate() * days;
        if (days > 3) {
            return baseRate * 0.95; 
        }
        return baseRate;
    }
}
