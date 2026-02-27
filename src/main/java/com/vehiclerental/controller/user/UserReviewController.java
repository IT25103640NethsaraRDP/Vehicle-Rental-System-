package com.vehiclerental.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserReviewController - Customers leave and view reviews
 * Routes: /user/reviews/...
 */
@Controller
@RequestMapping("/user/reviews")
public class UserReviewController {

    @GetMapping
    public String viewMyReviews() {
        return "user/reviews/my-reviews"; // → templates/user/reviews/my-reviews.html
    }

    @GetMapping("/leave")
    public String showReviewForm() {
        return "user/reviews/leave"; // → templates/user/reviews/leave.html
    }

    @PostMapping("/leave")
    public String submitReview() {
        // TODO: Implement review submission
        return "redirect:/user/reviews";
    }
}
