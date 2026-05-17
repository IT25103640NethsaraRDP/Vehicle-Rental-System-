package com.rentalsystem.review;

import com.rentalsystem.customer.Customer;
import com.rentalsystem.vehicle.Vehicle;
import com.rentalsystem.booking.BookingRepository;
import com.rentalsystem.customer.CustomerRepository;
import com.rentalsystem.vehicle.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import jakarta.annotation.PostConstruct;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void fixOldRecords() {
        try {
            jdbcTemplate.update("UPDATE reviews SET review_type = 'ADMIN' WHERE review_type IS NULL OR review_type = ''");
        } catch (Exception e) {
            // Ignore if table doesn't exist yet
        }
    }

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public void addReview(Long customerId, Long vehicleId, String comment, int rating, String reviewType, boolean verifiedPurchase, String adminNote) throws Exception {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new Exception("Customer not found"));
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new Exception("Vehicle not found"));

        Review review;
        if ("CUSTOMER".equalsIgnoreCase(reviewType)) {
            review = new CustomerReview(customer, vehicle, rating, comment, verifiedPurchase);
        } else {
            review = new AdminReview(customer, vehicle, rating, comment, adminNote);
        }
        review.setApproved(true);
        reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getApprovedReviews() {
        return reviewRepository.findByApprovedTrue();
    }

    public void approveReview(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            review.setApproved(true);
            reviewRepository.save(review);
        }
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
