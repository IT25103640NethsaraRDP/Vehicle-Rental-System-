package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PaymentController - handles all payment-related routes
 */
@Controller
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping
    public String listPayments() {
        return "payments/list"; // → templates/payments/list.html
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "payments/add"; // → templates/payments/add.html
    }

    @PostMapping("/add")
    public String addPayment() {
        // TODO: Implement add logic
        return "redirect:/payments";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "payments/edit"; // → templates/payments/edit.html
    }

    @PostMapping("/edit")
    public String editPayment() {
        // TODO: Implement edit logic
        return "redirect:/payments";
    }
}
