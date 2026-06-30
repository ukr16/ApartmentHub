package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;
    private double maintenanceAmount;
    private LocalDate maintenanceDueDate;
    private LocalDate maintenancePaymentDate;
    @Enumerated(EnumType.STRING)
    private MaintenanceStatus maintenancePaymentStatus;
    @ManyToOne
    private Flats flat;

    public enum MaintenanceStatus{
        PAID, UNPAID, OVERDUE
    }

    public Maintenance() {
    }

    public Maintenance(double maintenanceAmount, LocalDate maintenanceDueDate, LocalDate maintenancePaymentDate, MaintenanceStatus maintenancePaymentStatus, Flats flat) {
        this.maintenanceAmount = maintenanceAmount;
        this.maintenanceDueDate = maintenanceDueDate;
        this.maintenancePaymentDate = maintenancePaymentDate;
        this.maintenancePaymentStatus = maintenancePaymentStatus;
        this.flat = flat;
    }

    public Long getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Long maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public double getMaintenanceAmount() {
        return maintenanceAmount;
    }

    public void setMaintenanceAmount(double maintenanceAmount) {
        this.maintenanceAmount = maintenanceAmount;
    }

    public LocalDate getMaintenanceDueDate() {
        return maintenanceDueDate;
    }

    public void setMaintenanceDueDate(LocalDate maintenanceDueDate) {
        this.maintenanceDueDate = maintenanceDueDate;
    }

    public LocalDate getMaintenancePaymentDate() {
        return maintenancePaymentDate;
    }

    public void setMaintenancePaymentDate(LocalDate maintenancePaymentDate) {
        this.maintenancePaymentDate = maintenancePaymentDate;
    }

    public MaintenanceStatus getMaintenancePaymentStatus() {
        return maintenancePaymentStatus;
    }

    public void setMaintenancePaymentStatus(MaintenanceStatus maintenancePaymentStatus) {
        this.maintenancePaymentStatus = maintenancePaymentStatus;
    }

    public Flats getFlat() {
        return flat;
    }

    public void setFlat(Flats flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId=" + maintenanceId +
                ", maintenanceAmount=" + maintenanceAmount +
                ", maintenanceDueDate=" + maintenanceDueDate +
                ", maintenancePaymentDate=" + maintenancePaymentDate +
                ", maintenancePaymentStatus=" + maintenancePaymentStatus +
                ", flatId=" + (flat != null ? flat.getFlatId() : null) +
                '}';
    }
}
