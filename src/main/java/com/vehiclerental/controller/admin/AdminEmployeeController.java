package com.vehiclerental.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminEmployeeController - Management manages employee information
 * Routes: /admin/employees/...
 */
@Controller
@RequestMapping("/admin/employees")
public class AdminEmployeeController {

    @GetMapping
    public String listEmployees() {
        return "admin/employees/list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "admin/employees/add";
    }

    @PostMapping("/add")
    public String addEmployee() {
        // TODO: Implement add logic
        return "redirect:/admin/employees";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "admin/employees/edit";
    }

    @PostMapping("/edit")
    public String editEmployee() {
        // TODO: Implement edit logic
        return "redirect:/admin/employees";
    }
}
