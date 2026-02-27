package com.vehiclerental.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminReviewController - Staff manages customer feedback and reviews
 * Routes: /admin/reviews/...
 */
@Controller
@RequestMapping("/admin/reviews")
public class AdminReviewController {

    @GetMapping
    public String listReviews() {
        return "admin/reviews/list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "admin/reviews/add";
    }

    @PostMapping("/add")
    public String addReview() {
        // TODO: Implement add logic
        return "redirect:/admin/reviews";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "admin/reviews/edit";
    }

    @PostMapping("/edit")
    public String editReview() {
        // TODO: Implement edit logic
        return "redirect:/admin/reviews";
    }
}
