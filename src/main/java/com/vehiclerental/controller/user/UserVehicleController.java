package com.vehiclerental.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserVehicleController - Customers browse available vehicles
 * Routes: /user/vehicles/...
 */
@Controller
@RequestMapping("/user/vehicles")
public class UserVehicleController {

    @GetMapping
    public String browseVehicles() {
        return "user/vehicles/browse"; // → templates/user/vehicles/browse.html
    }

    @GetMapping("/details")
    public String viewVehicleDetails() {
        return "user/vehicles/details"; // → templates/user/vehicles/details.html
    }
}
