package com.rentalsystem.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/staff")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/manage")
    public String manageEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "admin/manage-employees";
    }

    @PostMapping("/add")
    public String addEmployee(
            @RequestParam String name, 
            @RequestParam String role, 
            @RequestParam double baseSalary) {
        
        employeeService.addEmployee(name, role, baseSalary);
        return "redirect:/staff/manage";
    }

    @PostMapping("/update")
    public String updateEmployee(
            @RequestParam Long id, 
            @RequestParam String name, 
            @RequestParam double baseSalary) {
        
        employeeService.updateEmployee(id, name, baseSalary);
        return "redirect:/staff/manage";
    }

    @GetMapping("/delete/{id}")
    public String removeEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
        return "redirect:/staff/manage";
    }
}
