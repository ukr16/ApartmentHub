package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingId;
    private String parkingNumber;
    @Enumerated(EnumType.STRING)
    private ParkingType parkingType;
    @ManyToMany
    private List<Resident> resident;

    public enum ParkingType{
        TWO_WHEELER, THREE_WHEELER, FOUR_WHEELER
    }

    public Parking() {
    }

    public Parking(String parkingNumber, ParkingType parkingType) {
        this.parkingNumber = parkingNumber;
        this.parkingType = parkingType;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public void setParkingId(Long parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(String parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    public List<Resident> getResident() {
        return resident;
    }

    public void setResident(List<Resident> resident) {
        this.resident = resident;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingId=" + parkingId +
                ", parkingNumber='" + parkingNumber + '\'' +
                ", parkingType=" + parkingType +
                '}';
    }
}
