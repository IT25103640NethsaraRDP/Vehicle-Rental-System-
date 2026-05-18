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
        validateId(customerId, "Customer");
        validateId(vehicleId, "Vehicle");
        validateDuration(durationDays);

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Customer not found"));
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new Exception("Vehicle not found"));

        if (!customer.isActive()) {
            throw new Exception("Customer is not active.");
        }

        if (!vehicle.isAvailable()) {
            throw new Exception("Vehicle is not available for booking.");
        }

        Booking booking = new Booking(customer, vehicle, LocalDate.now(), durationDays);
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
        validateId(bookingId, "Booking");

        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new Exception("Booking not found"));

        if (!"ACTIVE".equalsIgnoreCase(booking.getStatus())) {
            throw new Exception("Only active bookings can be returned.");
        }

        booking.setStatus("COMPLETED");
        if (booking.getVehicle() != null) {
            booking.getVehicle().setAvailable(true);
            vehicleRepository.save(booking.getVehicle());
        }
        bookingRepository.save(booking);
    }

    @Transactional
    public void cancelBooking(Long bookingId) throws Exception {
        validateId(bookingId, "Booking");

        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new Exception("Booking not found"));

        if (!"ACTIVE".equalsIgnoreCase(booking.getStatus()) && !"PENDING".equalsIgnoreCase(booking.getStatus())) {
            throw new Exception("Only pending or active bookings can be cancelled.");
        }

        booking.setStatus("CANCELLED");
        if (booking.getVehicle() != null) {
            booking.getVehicle().setAvailable(true);
            vehicleRepository.save(booking.getVehicle());
        }
        bookingRepository.save(booking);
    }

    private void validateId(Long id, String fieldName) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception(fieldName + " is required.");
        }
    }

    private void validateDuration(int durationDays) throws Exception {
        if (durationDays < 1 || durationDays > 365) {
            throw new Exception("Rental duration must be between 1 and 365 days.");
        }
    }
}
