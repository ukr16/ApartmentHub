package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Flats")
public class Flats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flatNumber;
    private int floor;
    private String block;
    @Enumerated(EnumType.STRING)
    private FlatStatus flatStatus;
    private double rentAmount;
    @ManyToMany
    private Apartment apartment;
    @ManyToMany
    private Resident resident;
    public enum FlatStatus{
        VACANT, OCCUPIED
    }

    public Flats() {
    }

    public Flats(String flatNumber, int floor, String block, FlatStatus flatStatus, double rentAmount, Apartment apartment) {
        this.flatNumber = flatNumber;
        this.floor = floor;
        this.block = block;
        this.flatStatus = flatStatus;
        this.rentAmount = rentAmount;
        this.apartment = apartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public FlatStatus getFlatStatus() {
        return flatStatus;
    }

    public void setFlatStatus(FlatStatus flatStatus) {
        this.flatStatus = flatStatus;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    @Override
    public String toString() {
        return "Flats{" +
                "id=" + id +
                ", flatNumber='" + flatNumber + '\'' +
                ", floor=" + floor +
                ", block='" + block + '\'' +
                ", flatStatus=" + flatStatus +
                ", rentAmount=" + rentAmount +
                ", apartment=" + apartment +
                '}';
    }
}
