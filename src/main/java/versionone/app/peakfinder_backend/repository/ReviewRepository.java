package versionone.app.peakfinder_backend.repository;

import versionone.app.peakfinder_backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRouteId(Long routeId);
}
