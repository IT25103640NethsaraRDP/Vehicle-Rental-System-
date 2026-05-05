package com.rentalsystem.admin;

import com.rentalsystem.booking.BookingService;
import com.rentalsystem.customer.CustomerService;
import com.rentalsystem.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("totalCustomers", customerService.getAllCustomers().size());
        model.addAttribute("totalVehicles", vehicleService.getAllVehicles().size());
        model.addAttribute("totalBookings", bookingService.getAllBookings().size());
        return "admin/admin-dashboard";
    }

}
