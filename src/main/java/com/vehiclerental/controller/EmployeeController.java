package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * EmployeeController - handles all employee-related routes
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String listEmployees() {
        return "employees/list"; // → templates/employees/list.html
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "employees/add"; // → templates/employees/add.html
    }

    @PostMapping("/add")
    public String addEmployee() {
        // TODO: Implement add logic
        return "redirect:/employees";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "employees/edit"; // → templates/employees/edit.html
    }

    @PostMapping("/edit")
    public String editEmployee() {
        // TODO: Implement edit logic
        return "redirect:/employees";
    }
}
