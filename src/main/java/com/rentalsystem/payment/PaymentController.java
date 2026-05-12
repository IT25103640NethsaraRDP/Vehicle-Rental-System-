package com.rentalsystem.payment;

import com.rentalsystem.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/process")
    public String showPaymentForm(@RequestParam(required = false) Long bookingId, Model model) {
        model.addAttribute("bookings", bookingService.getPayableBookings());
        model.addAttribute("selectedBookingId", bookingId);
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payment/process-payment";
    }

    @PostMapping("/process")
    public String submitPayment(
            @RequestParam Long bookingId, @RequestParam String type,
            @RequestParam(required = false) String refNumber,
            @RequestParam(required = false) String gateway,
            @RequestParam(required = false) String cardType,
            Model model) {
        try {
            String gatewayValue = gateway != null ? gateway : cardType;
            paymentService.processPayment(bookingId, type, refNumber, gatewayValue);
            return "redirect:/payments/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return showPaymentForm(bookingId, model);
        }
    }

    @GetMapping("/list")
    public String paymentHistory(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payment/list-payments";
    }
}
