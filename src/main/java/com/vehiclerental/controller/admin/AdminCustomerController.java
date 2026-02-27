package com.vehiclerental.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminCustomerController - Staff manages customer records
 * Routes: /admin/customers/...
 */
@Controller
@RequestMapping("/admin/customers")
public class AdminCustomerController {

    @GetMapping
    public String listCustomers() {
        return "admin/customers/list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "admin/customers/add";
    }

    @PostMapping("/add")
    public String addCustomer() {
        // TODO: Implement add logic
        return "redirect:/admin/customers";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "admin/customers/edit";
    }

    @PostMapping("/edit")
    public String editCustomer() {
        // TODO: Implement edit logic
        return "redirect:/admin/customers";
    }
}
