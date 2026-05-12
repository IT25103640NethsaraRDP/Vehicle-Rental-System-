package com.rentalsystem.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void registerCustomer(String name, String email, String phone, String license, String type) {
        Customer customer;
        if ("Premium".equalsIgnoreCase(type)) {
            customer = new PremiumCustomer(name, email, phone, license);
        } else {
            customer = new RegularCustomer(name, email, phone, license);
        }
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void updateCustomer(Long id, String name, String phone, String email, String licenseNumber) {
        Customer c = getCustomerById(id);
        if (c != null) {
            c.setName(name);
            c.setPhone(phone);
            c.setEmail(email);
            c.setLicenseNumber(licenseNumber);
            customerRepository.save(c);
        }
    }

    public void deleteCustomer(Long id) {
        Customer c = getCustomerById(id);
        if (c != null) {
            c.setActive(false);
            customerRepository.save(c);
        }
    }

    public void restoreCustomer(Long id) {
        Customer c = getCustomerById(id);
        if (c != null) {
            c.setActive(true);
            customerRepository.save(c);
        }
    }

    public List<Customer> searchByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }
}
