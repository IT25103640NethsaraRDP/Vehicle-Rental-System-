package com.rentalsystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "customer/register-customer";
    }

    @PostMapping("/register")
    public String registerCustomer(
            @RequestParam String name, @RequestParam String email, 
            @RequestParam String phone,
            @RequestParam String license, @RequestParam String type) {
        
        customerService.registerCustomer(name, email, phone, license, type);
        return "redirect:/customers/list";
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        java.util.List<Customer> allCustomers = customerService.getAllCustomers();
        java.util.List<Customer> activeCustomers = allCustomers.stream().filter(Customer::isActive).toList();
        java.util.List<Customer> inactiveCustomers = allCustomers.stream().filter(c -> !c.isActive()).toList();
        
        model.addAttribute("activeCustomers", activeCustomers);
        model.addAttribute("inactiveCustomers", inactiveCustomers);
        return "customer/list-customers";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam(required = false) String keyword, Model model) {
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("customers", customerService.searchByName(keyword));
        }
        return "customer/search-customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer c = customerService.getCustomerById(id);
        if (c == null) return "redirect:/customers/list";
        model.addAttribute("customer", c);
        return "customer/update-customer";
    }

    @PostMapping("/update")
    public String updateCustomer(@RequestParam Long id, @RequestParam String name, @RequestParam String phone, @RequestParam String email, @RequestParam String licenseNumber) {
        customerService.updateCustomer(id, name, phone, email, licenseNumber);
        return "redirect:/customers/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/list";
    }

    @GetMapping("/restore/{id}")
    public String restoreCustomer(@PathVariable Long id) {
        customerService.restoreCustomer(id);
        return "redirect:/customers/list";
    }
}
