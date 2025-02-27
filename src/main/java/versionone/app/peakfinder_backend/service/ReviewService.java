package versionone.app.peakfinder_backend.service;

import versionone.app.peakfinder_backend.model.Review;
import versionone.app.peakfinder_backend.model.Route;
import versionone.app.peakfinder_backend.repository.ReviewRepository;
import versionone.app.peakfinder_backend.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RouteRepository routeRepository;

    public ReviewService(ReviewRepository reviewRepository, RouteRepository routeRepository) {
        this.reviewRepository = reviewRepository;
        this.routeRepository = routeRepository;
    }

    public List<Review> getReviewsByRouteId(Long routeId) {
        return reviewRepository.findByRouteId(routeId);
    }

    public Review addReview(Review review) {
        Route route = routeRepository.findById(review.getRoute().getId())
                .orElseThrow(() -> new RuntimeException("Маршрут не найден"));

        Review savedReview = reviewRepository.save(review);
        updateRouteRating(route.getId());
        return savedReview;
    }

    private void updateRouteRating(Long routeId) {
        List<Review> reviews = reviewRepository.findByRouteId(routeId);
        if (reviews.isEmpty()) return;

        double avgRating = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Маршрут не найден"));
        route.setRating(avgRating);
        routeRepository.save(route);
    }
}
