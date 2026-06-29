package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Compliant")
public class Compliant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;
    @ManyToOne
    private Resident resident;
    @ManyToOne
    private Flats flats;

    public enum Status{
        OPEN, IN_PROGRESS, RESOLVED
    }

    public Compliant() {
    }

    public Compliant(String title, String description, Status status, LocalDateTime createdAt, Resident resident, Flats flats) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.resident = resident;
        this.flats = flats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", resident=" + resident +
                ", flats=" + flats +
                '}';
    }
}
