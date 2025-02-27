package versionone.app.peakfinder_backend.service;

import org.springframework.stereotype.Service;
import versionone.app.peakfinder_backend.model.Route;
import versionone.app.peakfinder_backend.repository.RouteRepository;

import java.util.List;

@Service
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
}
