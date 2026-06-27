package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Purpose purpose;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    @ManyToMany
    private Flats flat;
    @ManyToMany
    private Resident resident;

    public enum Purpose{
        DELIVERY, GUEST, HOUSEHELP
    }

    public enum VehicleType{
        TWO_WHEELER, THREE_WHEELER, FOUR_WHEELER
    }

    public Visitor() {
    }

    public Visitor(String name, String phone, Purpose purpose, VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime, Flats flat, Resident resident) {
        this.name = name;
        this.phone = phone;
        this.purpose = purpose;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.flat = flat;
        this.resident = resident;
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

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Flats getFlat() {
        return flat;
    }

    public void setFlat(Flats flat) {
        this.flat = flat;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", purpose=" + purpose +
                ", vehicleType=" + vehicleType +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", flat=" + flat +
                ", resident=" + resident +
                '}';
    }
}
