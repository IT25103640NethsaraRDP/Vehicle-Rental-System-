package com.rentalsystem.review;

import com.rentalsystem.customer.CustomerService;
import com.rentalsystem.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/submit")
    public String showSubmitForm(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "review/submit-review";
    }

    @PostMapping("/submit")
    public String submitReview(
            @RequestParam Long customerId, @RequestParam Long vehicleId, 
            @RequestParam String comment, 
            @RequestParam(required = false, defaultValue = "CUSTOMER") String reviewType,
            @RequestParam(required = false, defaultValue = "false") boolean verifiedPurchase,
            @RequestParam(required = false) String adminNote,
            @RequestParam(required = false, defaultValue = "0") int rating,
            Model model) {
        try {
            reviewService.addReview(customerId, vehicleId, comment, rating, reviewType, verifiedPurchase, adminNote);
            return "redirect:/reviews/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return showSubmitForm(model);
        }
    }

    @GetMapping("/list")
    public String viewReviews(Model model) {
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "review/view-reviews";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "redirect:/reviews/list";
    }
}
