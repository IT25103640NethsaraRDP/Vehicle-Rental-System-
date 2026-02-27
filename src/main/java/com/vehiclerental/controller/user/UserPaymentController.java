package com.vehiclerental.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserPaymentController - Customers manage their payments and invoices
 * Routes: /user/payments/...
 */
@Controller
@RequestMapping("/user/payments")
public class UserPaymentController {

    @GetMapping
    public String viewPaymentHistory() {
        return "user/payments/history"; // → templates/user/payments/history.html
    }

    @GetMapping("/invoices")
    public String viewInvoices() {
        return "user/payments/invoices"; // → templates/user/payments/invoices.html
    }

    @GetMapping("/make-payment")
    public String showPaymentForm() {
        return "user/payments/make-payment"; // → templates/user/payments/make-payment.html
    }

    @PostMapping("/make-payment")
    public String makePayment() {
        // TODO: Implement payment processing
        return "redirect:/user/payments";
    }
}
