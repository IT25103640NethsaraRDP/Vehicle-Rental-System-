package com.rentalsystem.review;

import com.rentalsystem.customer.Customer;
import com.rentalsystem.vehicle.Vehicle;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CUSTOMER")
public class CustomerReview extends Review {

    private boolean verifiedPurchase;

    public CustomerReview() {
        super();
    }

    public CustomerReview(Customer customer, Vehicle vehicle, int rating, String comment, boolean verifiedPurchase) {
        super(customer, vehicle, rating, comment);
        this.verifiedPurchase = verifiedPurchase;
    }

    public boolean isVerifiedPurchase() {
        return verifiedPurchase;
    }

    public void setVerifiedPurchase(boolean verifiedPurchase) {
        this.verifiedPurchase = verifiedPurchase;
    }

    @Override
    public String getDisplayFormat() {
        String base = "[Customer] " + getRating() + "★ - " + getComment();
        if (verifiedPurchase) {
            base += " (Verified Purchase)";
        }
        return base;
    }

    @Override
    public boolean canBeEditedByUser() {
        return true;
    }

    @Override
    public String getReviewBadge() {
        return "Customer Feedback";
    }
}
