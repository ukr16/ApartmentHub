package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "Amenity")
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;
    private String amenityName;
    private String amenityDescription;
    private boolean isAmenityAvailable;
    private LocalTime amenityOpeningTime;
    private LocalTime amenityClosingTime;
    private int amenityCapacity;
    @ManyToOne
    private Apartment apartment;

    public Amenity() {
    }

    public Amenity(String amenityName, String amenityDescription, boolean isAmenityAvailable, LocalTime amenityOpeningTime, LocalTime amenityClosingTime, int amenityCapacity, Apartment apartment) {
        this.amenityName = amenityName;
        this.amenityDescription = amenityDescription;
        this.isAmenityAvailable = isAmenityAvailable;
        this.amenityOpeningTime = amenityOpeningTime;
        this.amenityClosingTime = amenityClosingTime;
        this.amenityCapacity = amenityCapacity;
        this.apartment = apartment;
    }

    public Long getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Long amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public String getAmenityDescription() {
        return amenityDescription;
    }

    public void setAmenityDescription(String amenityDescription) {
        this.amenityDescription = amenityDescription;
    }

    public boolean isAmenityAvailable() {
        return isAmenityAvailable;
    }

    public void setAmenityAvailable(boolean amenityAvailable) {
        isAmenityAvailable = amenityAvailable;
    }

    public LocalTime getAmenityOpeningTime() {
        return amenityOpeningTime;
    }

    public void setAmenityOpeningTime(LocalTime amenityOpeningTime) {
        this.amenityOpeningTime = amenityOpeningTime;
    }

    public LocalTime getAmenityClosingTime() {
        return amenityClosingTime;
    }

    public void setAmenityClosingTime(LocalTime amenityClosingTime) {
        this.amenityClosingTime = amenityClosingTime;
    }

    public int getAmenityCapacity() {
        return amenityCapacity;
    }

    public void setAmenityCapacity(int amenityCapacity) {
        this.amenityCapacity = amenityCapacity;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityId=" + amenityId +
                ", amenityName='" + amenityName + '\'' +
                ", amenityDescription='" + amenityDescription + '\'' +
                ", isAmenityAvailable=" + isAmenityAvailable +
                ", amenityOpeningTime=" + amenityOpeningTime +
                ", amenityClosingTime=" + amenityClosingTime +
                ", amenityCapacity=" + amenityCapacity +
                ", apartment=" + apartment +
                '}';
    }
}
