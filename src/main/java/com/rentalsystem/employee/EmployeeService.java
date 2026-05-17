package com.rentalsystem.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public List<Employee> searchEmployees(String keyword) {
        return employeeRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void addEmployee(String name, String role, double baseSalary) {
        Employee employee;
        
        switch (role) {
            case "Manager":
                employee = new Manager(name, baseSalary);
                break;
            case "FieldStaff":
                employee = new FieldStaff(name, baseSalary);
                break;
            case "OfficeStaff":
            default:
                employee = new OfficeStaff(name, baseSalary);
                break;
        }
        
        employeeRepository.save(employee);
    }

    public void updateEmployee(Long id, String name, double baseSalary) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(name);
            employee.setBaseSalary(baseSalary);
            employeeRepository.save(employee);
        }
    }

    public void removeEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
