package com.devPortes.fields.entities;

import com.devPortes.location.model.Location;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "fields")
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private final Location location;

    @Column(name = "url_img",nullable = false)
    private String urlImg;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String capacity;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private List<String> details;
    @Column(name = "hourly_rate", nullable = false, precision = 10, scale = 2)
    private String hourlyRate;
    @Column(nullable = false)
    private boolean state;


}
