package versionone.app.peakfinder_backend.controller;

import versionone.app.peakfinder_backend.model.Booking;
import versionone.app.peakfinder_backend.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{routeId}")
    public List<Booking> getBookingsByRouteId(@PathVariable Long routeId) {
        return bookingService.getBookingsByRouteId(routeId);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}
