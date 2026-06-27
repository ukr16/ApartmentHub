package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Resident")
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private ResidentType residentType;
    private LocalDate moveInDate;
    @ManyToMany
    private List<Flats> flat;
    @ManyToMany
    private List<Parking> parking;
    @ManyToMany
    private List<Visitor> visitors;

    public enum ResidentType{
        OWNER, TENANT
    }

    public Resident() {
    }

    public Resident(String name, String phone, String email, ResidentType residentType, LocalDate moveInDate) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.residentType = residentType;
        this.moveInDate = moveInDate;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResidentType getResidentType() {
        return residentType;
    }

    public void setResidentType(ResidentType residentType) {
        this.residentType = residentType;
    }

    public LocalDate getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(LocalDate moveInDate) {
        this.moveInDate = moveInDate;
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

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", residentType='" + residentType + '\'' +
                ", moveInDate=" + moveInDate +
                '}';
    }
}
