package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitorId;
    private String visitorName;
    private String visitorPhone;
    @Enumerated(EnumType.STRING)
    private VisitPurpose visitPurpose;
    @Enumerated(EnumType.STRING)
    private VisitorVehicleType visitorVehicleType;
    private LocalDateTime visitorEntryTime;
    private LocalDateTime visitorExitTime;
    @ManyToOne
    private Flats flat;
    @ManyToOne
    private Resident resident;

    public enum VisitPurpose{
        DELIVERY, GUEST, HOUSEHELP
    }

    public enum VisitorVehicleType{
        TWO_WHEELER, THREE_WHEELER, FOUR_WHEELER
    }

    public Visitor() {
    }

    public Visitor(String visitorName, String visitorPhone, VisitPurpose visitPurpose, VisitorVehicleType visitorVehicleType, LocalDateTime visitorEntryTime, LocalDateTime visitorExitTime, Flats flat, Resident resident) {
        this.visitorName = visitorName;
        this.visitorPhone = visitorPhone;
        this.visitPurpose = visitPurpose;
        this.visitorVehicleType = visitorVehicleType;
        this.visitorEntryTime = visitorEntryTime;
        this.visitorExitTime = visitorExitTime;
        this.flat = flat;
        this.resident = resident;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public VisitPurpose getVisitPurpose() {
        return visitPurpose;
    }

    public void setVisitPurpose(VisitPurpose visitPurpose) {
        this.visitPurpose = visitPurpose;
    }

    public VisitorVehicleType getVisitorVehicleType() {
        return visitorVehicleType;
    }

    public void setVisitorVehicleType(VisitorVehicleType visitorVehicleType) {
        this.visitorVehicleType = visitorVehicleType;
    }

    public LocalDateTime getVisitorEntryTime() {
        return visitorEntryTime;
    }

    public void setVisitorEntryTime(LocalDateTime visitorEntryTime) {
        this.visitorEntryTime = visitorEntryTime;
    }

    public LocalDateTime getVisitorExitTime() {
        return visitorExitTime;
    }

    public void setVisitorExitTime(LocalDateTime visitorExitTime) {
        this.visitorExitTime = visitorExitTime;
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
                "visitorId=" + visitorId +
                ", visitorName='" + visitorName + '\'' +
                ", visitorPhone='" + visitorPhone + '\'' +
                ", visitPurpose=" + visitPurpose +
                ", visitorVehicleType=" + visitorVehicleType +
                ", visitorEntryTime=" + visitorEntryTime +
                ", visitorExitTime=" + visitorExitTime +
                ", flatId=" + (flat != null ? flat.getId() : null) +
                ", residentId=" + (resident != null ? resident.getResidentId() : null) +
                '}';
    }
}
