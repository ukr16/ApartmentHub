package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Resident")
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long residentId;
    private String residentName;
    private String residentPhone;
    private String residentEmail;
    @Enumerated(EnumType.STRING)
    private ResidentType residentType;
    private LocalDate residentMoveInDate;
    @ManyToMany
    private List<Flats> flat;
    @ManyToMany
    private List<Parking> parking;


    public enum ResidentType{
        OWNER, TENANT
    }

    public Resident() {
    }

    public Resident(String residentName, String residentPhone, String residentEmail, ResidentType residentType, LocalDate residentMoveInDate) {
        this.residentName = residentName;
        this.residentPhone = residentPhone;
        this.residentEmail = residentEmail;
        this.residentType = residentType;
        this.residentMoveInDate = residentMoveInDate;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentPhone() {
        return residentPhone;
    }

    public void setResidentPhone(String residentPhone) {
        this.residentPhone = residentPhone;
    }

    public String getResidentEmail() {
        return residentEmail;
    }

    public void setResidentEmail(String residentEmail) {
        this.residentEmail = residentEmail;
    }

    public ResidentType getResidentType() {
        return residentType;
    }

    public void setResidentType(ResidentType residentType) {
        this.residentType = residentType;
    }

    public LocalDate getResidentMoveInDate() {
        return residentMoveInDate;
    }

    public void setResidentMoveInDate(LocalDate residentMoveInDate) {
        this.residentMoveInDate = residentMoveInDate;
    }

    public List<Flats> getFlat() {
        return flat;
    }

    public void setFlat(List<Flats> flat) {
        this.flat = flat;
    }

    public List<Parking> getParking() {
        return parking;
    }

    public void setParking(List<Parking> parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "residentId=" + residentId +
                ", residentName='" + residentName + '\'' +
                ", residentPhone='" + residentPhone + '\'' +
                ", residentEmail='" + residentEmail + '\'' +
                ", residentType=" + residentType +
                ", residentMoveInDate=" + residentMoveInDate +
                '}';
    }
}
