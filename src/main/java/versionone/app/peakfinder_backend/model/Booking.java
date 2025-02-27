package versionone.app.peakfinder_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
