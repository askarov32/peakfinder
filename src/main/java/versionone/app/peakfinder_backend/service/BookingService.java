package versionone.app.peakfinder_backend.service;

import versionone.app.peakfinder_backend.model.Booking;
import versionone.app.peakfinder_backend.model.Route;
import versionone.app.peakfinder_backend.repository.BookingRepository;
import versionone.app.peakfinder_backend.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RouteRepository routeRepository;

    public BookingService(BookingRepository bookingRepository, RouteRepository routeRepository) {
        this.bookingRepository = bookingRepository;
        this.routeRepository = routeRepository;
    }

    public List<Booking> getBookingsByRouteId(Long routeId) {
        return bookingRepository.findByRouteId(routeId);
    }

    public Booking createBooking(Booking booking) {
        Route route = routeRepository.findById(booking.getRoute().getId())
                .orElseThrow(() -> new RuntimeException("Маршрут не найден"));

        List<Booking> existingBookings = bookingRepository.findByRouteId(route.getId());
        if (existingBookings.size() >= route.getMaxParticipants()) {
            throw new RuntimeException("Все места уже забронированы!");
        }

        return bookingRepository.save(booking);
    }
}
