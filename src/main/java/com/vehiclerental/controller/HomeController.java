package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController - handles the root URL "/"
 * Redirects to the home/dashboard page.
 *
 * This is YOUR controller as team leader (Member 3 - Booking Management).
 * The index page is shared infrastructure — you own it.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // → templates/index.html
    }
}
