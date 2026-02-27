package com.vehiclerental.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AdminVehicleController - Staff manages vehicle inventory
 * Routes: /admin/vehicles/...
 */
@Controller
@RequestMapping("/admin/vehicles")
public class AdminVehicleController {

    @GetMapping
    public String listVehicles() {
        return "admin/vehicles/list"; // → templates/admin/vehicles/list.html
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "admin/vehicles/add"; // → templates/admin/vehicles/add.html
    }

    @PostMapping("/add")
    public String addVehicle() {
        // TODO: Implement add logic
        return "redirect:/admin/vehicles";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "admin/vehicles/edit"; // → templates/admin/vehicles/edit.html
    }

    @PostMapping("/edit")
    public String editVehicle() {
        // TODO: Implement edit logic
        return "redirect:/admin/vehicles";
    }
}
