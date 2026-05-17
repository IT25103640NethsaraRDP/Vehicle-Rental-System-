package com.rentalsystem.vehicle;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
public class Car extends Vehicle {

    private int seatingCapacity;

    public Car() {}

    public Car(String brand, String model, String registrationNumber, double dailyRate, int seatingCapacity) {
        super(brand, model, registrationNumber, dailyRate);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() { return seatingCapacity; }
    public void setSeatingCapacity(int seatingCapacity) { this.seatingCapacity = seatingCapacity; }

    @Override
    public double calculateRentalCost(int days) {
        double baseRate = getDailyRate() * days;
        return baseRate + (baseRate * 0.05); 
    }
}
