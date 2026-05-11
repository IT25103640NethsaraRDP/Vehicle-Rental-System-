package com.rentalsystem.booking;

import com.rentalsystem.customer.Customer;
import com.rentalsystem.vehicle.Vehicle;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = true)
    private Vehicle vehicle;

    private String vehicleNameSnapshot;

    private LocalDate bookingDate;
    private LocalDate returnDate;
    
    private String status; 
    private double totalCost;

    public Booking() {}

    public Booking(Customer customer, Vehicle vehicle, LocalDate bookingDate, int durationDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.vehicleNameSnapshot = vehicle.getBrand() + " " + vehicle.getModel();
        this.bookingDate = bookingDate;
        this.returnDate = bookingDate.plusDays(durationDays);
        this.status = "ACTIVE";
        calculateTotalCost(durationDays);
    }

    private void calculateTotalCost(int durationDays) {
        double cost = vehicle.calculateRentalCost(durationDays);
        double discount = customer.getDiscountRate();
        this.totalCost = cost - (cost * discount);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public String getVehicleNameSnapshot() { return vehicleNameSnapshot; }
    public void setVehicleNameSnapshot(String vehicleNameSnapshot) { this.vehicleNameSnapshot = vehicleNameSnapshot; }

    public String getDisplayVehicleName() {
        return vehicle != null ? vehicle.getBrand() + " " + vehicle.getModel() : vehicleNameSnapshot;
    }

    public int getDurationDays() {
        if (bookingDate != null && returnDate != null) {
            return (int) ChronoUnit.DAYS.between(bookingDate, returnDate);
        }
        return 0;
    }
}
