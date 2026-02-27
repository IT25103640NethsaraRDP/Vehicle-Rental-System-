package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BookingController - handles all booking-related routes
 */
@Controller
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    public String listBookings() {
        return "bookings/list"; // → templates/bookings/list.html
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "bookings/add"; // → templates/bookings/add.html
    }

    @PostMapping("/add")
    public String addBooking() {
        // TODO: Implement add logic
        return "redirect:/bookings";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "bookings/edit"; // → templates/bookings/edit.html
    }

    @PostMapping("/edit")
    public String editBooking() {
        // TODO: Implement edit logic
        return "redirect:/bookings";
    }
}
