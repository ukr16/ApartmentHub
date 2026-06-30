package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apartmentId;
    private String apartmentName;
    private String apartmentAddress;
    private String apartmentContactNumber;
    private String apartmentEmail;
    @OneToMany
    private List<Flats> flats;
    @OneToMany
    private List<Amenity> amenities;

    public Apartment() {
    }

    public Apartment(String apartmentName, String apartmentAddress, String apartmentContactNumber, String apartmentEmail) {
        this.apartmentName = apartmentName;
        this.apartmentAddress = apartmentAddress;
        this.apartmentContactNumber = apartmentContactNumber;
        this.apartmentEmail = apartmentEmail;
    }

    public Long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getApartmentAddress() {
        return apartmentAddress;
    }

    public void setApartmentAddress(String apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }

    public String getApartmentContactNumber() {
        return apartmentContactNumber;
    }

    public void setApartmentContactNumber(String apartmentContactNumber) {
        this.apartmentContactNumber = apartmentContactNumber;
    }

    public String getApartmentEmail() {
        return apartmentEmail;
    }

    public void setApartmentEmail(String apartmentEmail) {
        this.apartmentEmail = apartmentEmail;
    }

    public List<Flats> getFlats() {
        return flats;
    }

    public void setFlats(List<Flats> flats) {
        this.flats = flats;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + apartmentId +
                ", apartmentName='" + apartmentName + '\'' +
                ", apartmentAddress='" + apartmentAddress + '\'' +
                ", apartmentContactNumber='" + apartmentContactNumber + '\'' +
                ", apartmentEmail='" + apartmentEmail + '\'' +
                '}';
    }
}
