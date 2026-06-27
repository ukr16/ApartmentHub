package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apartmentName;
    private String address;
    private String contactNumber;
    private String email;
    @OneToMany
    private List<Flats> flats;
    @OneToMany
    private List<Amenity> amenities;

    public Apartment() {
    }

    public Apartment(String apartmentName, String address, String contactNumber, String email) {
        this.apartmentName = apartmentName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "id=" + id +
                ", apartmentName='" + apartmentName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email +
                '}';
    }
}
