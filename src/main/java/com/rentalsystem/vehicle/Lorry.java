package com.rentalsystem.vehicle;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LORRY")
public class Lorry extends Vehicle {

    private double loadCapacity;

    public Lorry() {}

    public Lorry(String brand, String model, String registrationNumber, double dailyRate, double loadCapacity) {
        super(brand, model, registrationNumber, dailyRate);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() { return loadCapacity; }
    public void setLoadCapacity(double loadCapacity) { this.loadCapacity = loadCapacity; }

    @Override
    public double calculateRentalCost(int days) {
        double baseRate = getDailyRate() * days;
        return baseRate + (baseRate * 0.10); 
    }
}
