package com.rentalsystem.vehicle;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
@Table(name = "vehicles")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String model;
    private String brand;
    private String registrationNumber;
    private double dailyRate;
    private boolean available;
    private String imageUrl;
    
    private boolean active = true;

    public Vehicle() {}

    public Vehicle(String brand, String model, String registrationNumber, double dailyRate) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public abstract double calculateRentalCost(int days);

    public String getEntityType() {
        return this.getClass().getSimpleName();
    }
}
