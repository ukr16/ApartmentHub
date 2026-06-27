package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private boolean isAvailable;
    private String openingTime;
    private String closingTime;
    private int capacity;
    @ManyToOne
    private Apartment apartment;
}
