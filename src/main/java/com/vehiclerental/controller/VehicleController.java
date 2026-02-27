package com.vehiclerental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * VehicleController - handles all vehicle-related routes
 */
@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @GetMapping
    public String listVehicles() {
        return "vehicles/list"; // → templates/vehicles/list.html
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "vehicles/add"; // → templates/vehicles/add.html
    }

    @PostMapping("/add")
    public String addVehicle() {
        // TODO: Implement add logic
        return "redirect:/vehicles";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "vehicles/edit"; // → templates/vehicles/edit.html
    }

    @PostMapping("/edit")
    public String editVehicle() {
        // TODO: Implement edit logic
        return "redirect:/vehicles";
    }
}
