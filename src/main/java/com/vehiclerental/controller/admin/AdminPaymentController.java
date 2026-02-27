package com.vehiclerental.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminPaymentController - Staff tracks and records payments
 * Routes: /admin/payments/...
 */
@Controller
@RequestMapping("/admin/payments")
public class AdminPaymentController {

    @GetMapping
    public String listPayments() {
        return "admin/payments/list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "admin/payments/add";
    }

    @PostMapping("/add")
    public String addPayment() {
        // TODO: Implement add logic
        return "redirect:/admin/payments";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "admin/payments/edit";
    }

    @PostMapping("/edit")
    public String editPayment() {
        // TODO: Implement edit logic
        return "redirect:/admin/payments";
    }
}
