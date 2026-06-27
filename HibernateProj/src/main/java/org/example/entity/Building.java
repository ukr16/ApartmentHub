package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Apartment> apartments;
    @ManyToOne
    private Society society;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }

    public Building() {
    }

    public Building(String name, List<Apartment> apartments, Society society) {
        this.name = name;
        this.apartments = apartments;
        this.society = society;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apartments=" + apartments +
                ", society=" + society +
                '}';
    }
}
