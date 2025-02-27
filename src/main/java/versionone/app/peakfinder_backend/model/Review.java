package versionone.app.peakfinder_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
