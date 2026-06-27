package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unitNumber;
    private int floor;
    @Enumerated(EnumType.STRING)
    private ApartmentStatus status;
    @ManyToOne
    private Building building;
    public enum ApartmentStatus {
        VACANT, OCCUPIED
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public ApartmentStatus getStatus() {
        return status;
    }

    public void setStatus(ApartmentStatus status) {
        this.status = status;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Apartment() {
    }

    public Apartment(String unitNumber, int floor, ApartmentStatus status, Building building) {
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.status = status;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", unitNumber='" + unitNumber + '\'' +
                ", floor=" + floor +
                ", status=" + status +
                ", building=" + building +
                '}';
    }
}
