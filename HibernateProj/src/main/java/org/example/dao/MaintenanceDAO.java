package org.example.dao;

import org.example.entity.Maintenance;

import java.time.LocalDate;
import java.util.List;

public interface MaintenanceDAO {
    Maintenance findById(Long id);
    List<Maintenance> findAll();
    void update(Maintenance maintenance);
    void delete(Long id);
    List<Maintenance> findByStatus(Maintenance.Status status);
    List<Maintenance> findByFlat(Long Id);
    List<Maintenance> findByDueDate(LocalDate dueDate);
    List<Maintenance> findOverdueMaintenances();
}
