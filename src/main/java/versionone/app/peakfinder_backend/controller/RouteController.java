package versionone.app.peakfinder_backend.controller;

import versionone.app.peakfinder_backend.model.Route;
import versionone.app.peakfinder_backend.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id);
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeService.createRoute(route);
    }

    @GetMapping("/filter")
    public List<Route> filterRoutes(
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String bestSeason,
            @RequestParam(required = false) Integer maxDuration,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return routeService.filterRoutes(difficulty, type, bestSeason, maxDuration, minPrice, maxPrice);
    }
}
