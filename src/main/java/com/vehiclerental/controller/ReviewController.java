package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ReviewController - handles all review-related routes
 */
@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @GetMapping
    public String listReviews() {
        return "reviews/list"; // → templates/reviews/list.html
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "reviews/add"; // → templates/reviews/add.html
    }

    @PostMapping("/add")
    public String addReview() {
        // TODO: Implement add logic
        return "redirect:/reviews";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "reviews/edit"; // → templates/reviews/edit.html
    }

    @PostMapping("/edit")
    public String editReview() {
        // TODO: Implement edit logic
        return "redirect:/reviews";
    }
}
