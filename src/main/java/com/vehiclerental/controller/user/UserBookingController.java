package com.vehiclerental.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserBookingController - Customers make and manage their bookings
 * Routes: /user/bookings/...
 */
@Controller
@RequestMapping("/user/bookings")
public class UserBookingController {

    @GetMapping
    public String viewMyBookings() {
        return "user/bookings/my-bookings"; // → templates/user/bookings/my-bookings.html
    }

    @GetMapping("/new")
    public String showBookingForm() {
        return "user/bookings/new"; // → templates/user/bookings/new.html
    }

    @PostMapping("/new")
    public String createBooking() {
        // TODO: Implement booking creation
        return "redirect:/user/bookings";
    }

    @GetMapping("/details")
    public String viewBookingDetails() {
        return "user/bookings/details"; // → templates/user/bookings/details.html
    }

    @GetMapping("/cancel")
    public String showCancelForm() {
        return "user/bookings/cancel"; // → templates/user/bookings/cancel.html
    }

    @PostMapping("/cancel")
    public String cancelBooking() {
        // TODO: Implement cancellation
        return "redirect:/user/bookings";
    }
}
