package com.rentalsystem.review;

import com.rentalsystem.customer.Customer;
import com.rentalsystem.vehicle.Vehicle;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reviews")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "review_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Review {

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

    private int rating; 
    
    @Column(length = 1000)
    private String comment;
    
    private LocalDate reviewDate;
    private boolean approved;

    public Review() {}

    public Review(Customer customer, Vehicle vehicle, int rating, String comment) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.vehicleNameSnapshot = vehicle != null ? vehicle.getBrand() + " " + vehicle.getModel() : "";
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = LocalDate.now();
        this.approved = false; 
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
    public LocalDate getReviewDate() { return reviewDate; }
    public void setReviewDate(LocalDate reviewDate) { this.reviewDate = reviewDate; }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }

    public String getVehicleNameSnapshot() { return vehicleNameSnapshot; }
    public void setVehicleNameSnapshot(String vehicleNameSnapshot) { this.vehicleNameSnapshot = vehicleNameSnapshot; }

    public String getDisplayVehicleName() {
        return vehicle != null ? vehicle.getBrand() + " " + vehicle.getModel() : vehicleNameSnapshot;
    }

    public abstract String getDisplayFormat();
    
    public abstract boolean canBeEditedByUser();

    public String getReviewBadge() { return "Review"; }

    public String getEntityType() {
        return this.getClass().getSimpleName();
    }
}
