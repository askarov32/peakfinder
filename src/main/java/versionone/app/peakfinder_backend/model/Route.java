package versionone.app.peakfinder_backend.model;

import jakarta.persistence.*;
import lombok.*;
import versionone.app.peakfinder_backend.model.Guide;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String location;

    @Enumerated(EnumType.STRING)
    private RouteType type;

    private String difficulty;
    private double price;
    private int durationInDays;
    private String bestSeason;
    private int maxParticipants;
    private boolean isOvernight;
    private double latitude;
    private double longitude;
    private double rating;

    @ElementCollection
    private List<String> images;

    @ElementCollection
    private List<String> requiredItems;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Guide> guides;
}