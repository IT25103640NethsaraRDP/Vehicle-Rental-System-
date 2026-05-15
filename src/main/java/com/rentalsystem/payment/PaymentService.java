package com.rentalsystem.payment;

import com.rentalsystem.booking.Booking;
import com.rentalsystem.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private com.rentalsystem.vehicle.VehicleRepository vehicleRepository;

    public void processPayment(Long bookingId, String type, String refNumber, String gateway) throws Exception {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new Exception("Booking not found"));

        Payment payment;
        if ("ONLINE".equalsIgnoreCase(type)) {
            payment = new OnlinePayment(booking, booking.getTotalCost(), refNumber, gateway);
        } else {
            payment = new CashPayment(booking, booking.getTotalCost(), refNumber);
        }

        boolean success = payment.processPayment();
        paymentRepository.save(payment);

        if (!success) {
            throw new Exception("Payment processing failed.");
        }

        // Activate booking and mark vehicle unavailable
        booking.setStatus("ACTIVE");
        bookingRepository.save(booking);
        if (booking.getVehicle() != null) {
            booking.getVehicle().setAvailable(false);
            vehicleRepository.save(booking.getVehicle());
        }
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
