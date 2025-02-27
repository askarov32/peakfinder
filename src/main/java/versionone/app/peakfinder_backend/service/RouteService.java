package versionone.app.peakfinder_backend.service;

import org.springframework.stereotype.Service;
import versionone.app.peakfinder_backend.model.Route;
import versionone.app.peakfinder_backend.model.RouteType;
import versionone.app.peakfinder_backend.repository.RouteRepository;

import java.util.List;

public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route getRouteById(Long id) {
        return routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Маршрут не найден"));
    }

    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    public List<Route> filterRoutes(String difficulty, String type, String bestSeason, Integer maxDuration, Double minPrice, Double maxPrice) {
        if (difficulty != null) return routeRepository.findByDifficulty(difficulty);
        if (type != null) {
            RouteType routeType;
            try {
                routeType = RouteType.valueOf(type.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Некорректный тип маршрута: " + type);
            }
            return routeRepository.findByType(String.valueOf(routeType));
        }
        if (bestSeason != null) return routeRepository.findByBestSeason(bestSeason);
        if (maxDuration != null) return routeRepository.findByDurationInDaysLessThanEqual(maxDuration);
        if (minPrice != null && maxPrice != null) return routeRepository.findByPriceBetween(minPrice, maxPrice);
        return routeRepository.findAll();
    }
}