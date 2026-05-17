package com.rentalsystem.booking;

import com.rentalsystem.customer.Customer;
import com.rentalsystem.vehicle.Vehicle;
import com.rentalsystem.customer.CustomerRepository;
import com.rentalsystem.vehicle.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public Long createBooking(Long customerId, Long vehicleId, int durationDays) throws Exception {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Customer not found"));
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new Exception("Vehicle not found"));

        if (!vehicle.isAvailable()) {
            throw new Exception("Vehicle is not available for booking.");
        }

        Booking booking = new Booking(customer, vehicle, LocalDate.now(), durationDays);
        if (booking.getStatus() != "PENDING") {
            booking.setStatus("PENDING");
        }
        booking = bookingRepository.save(booking);

        return booking.getId();
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getPayableBookings() {
        return bookingRepository.findAll().stream()
                .filter(b -> "PENDING".equalsIgnoreCase(b.getStatus()))
                .collect(java.util.stream.Collectors.toList());
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Transactional
    public void returnVehicle(Long bookingId) throws Exception {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new Exception("Booking not found"));

        if ("ACTIVE".equalsIgnoreCase(booking.getStatus())) {
            booking.setStatus("COMPLETED");
            if (booking.getVehicle() != null) {
                booking.getVehicle().setAvailable(true);
                vehicleRepository.save(booking.getVehicle());
            }
            bookingRepository.save(booking);
        }
    }

    @Transactional
    public void cancelBooking(Long bookingId) throws Exception {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new Exception("Booking not found"));
        if ("ACTIVE".equalsIgnoreCase(booking.getStatus()) || "PENDING".equalsIgnoreCase(booking.getStatus())) {
            booking.setStatus("CANCELLED");
            if (booking.getVehicle() != null) {
                booking.getVehicle().setAvailable(true);
                vehicleRepository.save(booking.getVehicle());
            }
            bookingRepository.save(booking);
        }
    }
}
