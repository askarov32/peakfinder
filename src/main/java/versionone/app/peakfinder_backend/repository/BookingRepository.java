package versionone.app.peakfinder_backend.repository;

import versionone.app.peakfinder_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRouteId(Long routeId);
}
