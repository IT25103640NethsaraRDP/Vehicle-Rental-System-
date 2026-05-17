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

    @GetMapping("/list")
    public String listEmployees(@RequestParam(required = false) String keyword, Model model) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            model.addAttribute("employees", employeeService.searchEmployees(keyword.trim()));
            model.addAttribute("keyword", keyword.trim());
        } else {
            model.addAttribute("employees", employeeService.getAllEmployees());
        }
        return "employee/list-employees";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm() {
        return "employee/add-employee";
    }

    @PostMapping("/add")
    public String addEmployee(
            @RequestParam String name, 
            @RequestParam String role, 
            @RequestParam double baseSalary) {
        
        employeeService.addEmployee(name, role, baseSalary);
        return "redirect:/staff/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee/edit-employee";
        }
        return "redirect:/staff/list";
    }

    @PostMapping("/update")
    public String updateEmployee(
            @RequestParam Long id, 
            @RequestParam String name, 
            @RequestParam double baseSalary) {
        
        employeeService.updateEmployee(id, name, baseSalary);
        return "redirect:/staff/list";
    }

    @GetMapping("/delete/{id}")
    public String removeEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
        return "redirect:/staff/list";
    }
}
