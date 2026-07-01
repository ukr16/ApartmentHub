package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Compliant")
public class Compliant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compliantId;
    private String compliantTitle;
    private String compliantDescription;
    @Enumerated(EnumType.STRING)
    private CompliantStatus compliantStatus;
    private LocalDateTime compliantCreatedAt;
    @ManyToOne
    private Resident resident;
    @ManyToOne
    private Flats flats;

    public enum CompliantStatus{
        OPEN, IN_PROGRESS, RESOLVED
    }

    public Compliant() {
    }

    public Compliant(String compliantTitle, String compliantDescription, CompliantStatus compliantStatus, LocalDateTime compliantCreatedAt, Resident resident, Flats flats) {
        this.compliantTitle = compliantTitle;
        this.compliantDescription = compliantDescription;
        this.compliantStatus = compliantStatus;
        this.compliantCreatedAt = compliantCreatedAt;
        this.resident = resident;
        this.flats = flats;
    }

    public Long getCompliantId() {
        return compliantId;
    }

    public void setCompliantId(Long compliantId) {
        this.compliantId = compliantId;
    }

    public String getCompliantTitle() {
        return compliantTitle;
    }

    public void setCompliantTitle(String compliantTitle) {
        this.compliantTitle = compliantTitle;
    }

    public String getCompliantDescription() {
        return compliantDescription;
    }

    public void setCompliantDescription(String compliantDescription) {
        this.compliantDescription = compliantDescription;
    }

    public CompliantStatus getCompliantStatus() {
        return compliantStatus;
    }

    public void setCompliantStatus(CompliantStatus compliantStatus) {
        this.compliantStatus = compliantStatus;
    }

    public LocalDateTime getCompliantCreatedAt() {
        return compliantCreatedAt;
    }

    public void setCompliantCreatedAt(LocalDateTime compliantCreatedAt) {
        this.compliantCreatedAt = compliantCreatedAt;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Flats getFlats() {
        return flats;
    }

    public void setFlats(Flats flats) {
        this.flats = flats;
    }

    @Override
    public String toString() {
        return "Compliant{" +
                "compliantId=" + compliantId +
                ", compliantTitle='" + compliantTitle + '\'' +
                ", compliantDescription='" + compliantDescription + '\'' +
                ", compliantStatus=" + compliantStatus +
                ", compliantCreatedAt=" + compliantCreatedAt +
                ", residentId=" + (resident != null ? resident.getResidentId() : null) +
                ", flatId=" + (flats != null ? flats.getFlatId() : null) +
                '}';
    }
}
