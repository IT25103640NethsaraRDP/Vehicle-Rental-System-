package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CustomerController - handles all customer-related routes
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping
    public String listCustomers() {
        return "customers/list"; // → templates/customers/list.html
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "customers/add"; // → templates/customers/add.html
    }

    @PostMapping("/add")
    public String addCustomer() {
        // TODO: Implement add logic
        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "customers/edit"; // → templates/customers/edit.html
    }

    @PostMapping("/edit")
    public String editCustomer() {
        // TODO: Implement edit logic
        return "redirect:/customers";
    }
}
