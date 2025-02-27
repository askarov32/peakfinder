package versionone.app.peakfinder_backend.repository;

import versionone.app.peakfinder_backend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import versionone.app.peakfinder_backend.model.RouteType;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByDifficulty(String difficulty);
    List<Route> findByType(String type);
    List<Route> findByBestSeason(String bestSeason);
    List<Route> findByDurationInDaysLessThanEqual(int maxDuration);
    List<Route> findByPriceBetween(double minPrice, double maxPrice);
}
