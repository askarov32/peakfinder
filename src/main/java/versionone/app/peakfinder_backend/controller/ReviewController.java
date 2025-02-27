package versionone.app.peakfinder_backend.controller;

import versionone.app.peakfinder_backend.model.Review;
import versionone.app.peakfinder_backend.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{routeId}")
    public List<Review> getReviewsByRouteId(@PathVariable Long routeId) {
        return reviewService.getReviewsByRouteId(routeId);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }
}
