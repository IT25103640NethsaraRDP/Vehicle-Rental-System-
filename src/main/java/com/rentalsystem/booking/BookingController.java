package com.rentalsystem.booking;

import com.rentalsystem.customer.Customer;
import com.rentalsystem.vehicle.Vehicle;
import com.rentalsystem.customer.CustomerService;
import com.rentalsystem.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/add")
    public String showBookingForm(Model model) {
        List<Customer> customers = customerService.getAllCustomers().stream().filter(Customer::isActive).toList();
        List<Vehicle> vehicles = vehicleService.getAvailableVehicles();

        model.addAttribute("customers", customers);
        model.addAttribute("vehicles", vehicles);
        return "booking/book-vehicle";
    }

    @PostMapping("/add")
    public String createBooking(@RequestParam Long customerId, @RequestParam Long vehicleId,
            @RequestParam int durationDays, Model model) {
        try {
            Long bookingId = bookingService.createBooking(customerId, vehicleId, durationDays);
            return "redirect:/payments/process?bookingId=" + bookingId;
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return listBookings(model);
        }
    }

    @GetMapping("/list")
    public String listBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("vehicles", vehicleService.getAvailableVehicles());
        return "booking/list-bookings";
    }

    @GetMapping("/return/{id}")
    public String showReturnForm(@PathVariable Long id, Model model) {
        model.addAttribute("booking", bookingService.getBookingById(id));
        return "booking/return-vehicle";
    }

    @PostMapping("/return")
    public String processReturn(@RequestParam Long bookingId) {
        try {
            bookingService.returnVehicle(bookingId);
        } catch (Exception e) {
            System.err.println("Error processing return: " + e.getMessage());
        }
        return "redirect:/bookings/list";
    }

    @GetMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable Long id) {
        try {
            bookingService.cancelBooking(id);
        } catch (Exception e) {
            System.err.println("Error processing cancellation: " + e.getMessage());
        }

        return "redirect:/bookings/list";
    }
}
