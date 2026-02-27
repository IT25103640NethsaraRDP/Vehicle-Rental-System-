package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController - Handles root URL "/" routing
 * Routes to appropriate dashboard based on user role.
 *
 * This is YOUR controller as team leader (Member 3 - Booking Management).
 * The entry point for the application.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Redirect to home page showing links to both dashboards
        return "index"; // → templates/index.html
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard"; // → templates/admin/dashboard.html
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "user/dashboard"; // → templates/user/dashboard.html
    }
}
