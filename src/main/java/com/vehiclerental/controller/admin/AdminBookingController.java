package com.vehiclerental.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminBookingController - Staff manages rental bookings
 * Routes: /admin/bookings/...
 */
@Controller
@RequestMapping("/admin/bookings")
public class AdminBookingController {

    @GetMapping
    public String listBookings() {
        return "admin/bookings/list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "admin/bookings/add";
    }

    @PostMapping("/add")
    public String addBooking() {
        // TODO: Implement add logic
        return "redirect:/admin/bookings";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "admin/bookings/edit";
    }

    @PostMapping("/edit")
    public String editBooking() {
        // TODO: Implement edit logic
        return "redirect:/admin/bookings";
    }
}
