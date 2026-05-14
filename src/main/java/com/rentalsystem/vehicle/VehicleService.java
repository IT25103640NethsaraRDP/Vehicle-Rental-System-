package com.rentalsystem.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private com.rentalsystem.booking.BookingRepository bookingRepository;

    @Autowired
    private com.rentalsystem.review.ReviewRepository reviewRepository;

    public void addVehicle(String type, String brand, String model, String regNumber, double dailyRate, Integer seatingCapacity, Boolean hasGear, Double loadCapacity, String imageUrl) {
        Vehicle vehicle;
        if ("CAR".equalsIgnoreCase(type)) {
            vehicle = new Car(brand, model, regNumber, dailyRate, seatingCapacity != null ? seatingCapacity : 5);
        } else if ("LORRY".equalsIgnoreCase(type)) {
            vehicle = new Lorry(brand, model, regNumber, dailyRate, loadCapacity != null ? loadCapacity : 2.0);
        } else {
            vehicle = new Bike(brand, model, regNumber, dailyRate);
        }
        if (imageUrl != null && !imageUrl.isEmpty()) {
            vehicle.setImageUrl(imageUrl);
        }
        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findByAvailableTrue().stream().filter(Vehicle::isActive).toList();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public void updateVehicle(Long id, String brand, String model, String regNumber, double dailyRate, boolean available, String imageUrl) {
        Vehicle v = getVehicleById(id);
        if (v != null) {
            v.setBrand(brand);
            v.setModel(model);
            v.setRegistrationNumber(regNumber);
            v.setDailyRate(dailyRate);
            v.setAvailable(available);
            if (imageUrl != null && !imageUrl.isEmpty()) {
                v.setImageUrl(imageUrl);
            }
            vehicleRepository.save(v);
        }
    }

    public void deleteVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        if (v != null) {
            v.setActive(false);
            vehicleRepository.save(v);
        }
    }

    public void restoreVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        if (v != null) {
            v.setActive(true);
            vehicleRepository.save(v);
        }
    }

    public List<Vehicle> searchVehicles(String keyword) {
        return vehicleRepository.searchByBrandOrModel(keyword);
    }
}
