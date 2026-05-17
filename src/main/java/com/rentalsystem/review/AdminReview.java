package com.rentalsystem.review;

import com.rentalsystem.customer.Customer;
import com.rentalsystem.vehicle.Vehicle;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminReview extends Review {

    @Column(length = 1000)
    private String adminNote;

    public AdminReview() {
        super();
    }

    public AdminReview(Customer customer, Vehicle vehicle, int rating, String comment, String adminNote) {
        super(customer, vehicle, rating, comment);
        this.adminNote = adminNote;
    }

    public String getAdminNote() {
        return adminNote;
    }

    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    @Override
    public String getDisplayFormat() {
        return "[Admin] " + getRating() + "★ - " + getComment() + (adminNote != null && !adminNote.isEmpty() ? " (Note: " + adminNote + ")" : "");
    }

    @Override
    public boolean canBeEditedByUser() {
        return false;
    }

    @Override
    public String getReviewBadge() {
        return "Internal Note";
    }
}
