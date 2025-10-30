package com.example.airBnbApp.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "hotel"
)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    private String city;
    @Column(columnDefinition = "TEXT[]")
    private String[] photos;
    @Column(nullable = false)
    private Boolean isActive;
    @Column(columnDefinition = "TEXT[]")
    private String[] amenities;
    @Embedded
    private HotelContactInfo hotelInfo;
    @Embedded
    private Auditing auditing;
}
