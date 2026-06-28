package org.example.dao;

import org.example.entity.Compliant;

import java.time.LocalDateTime;
import java.util.List;

public interface ComplaintDAO {
    void save(Compliant compliant);
    Compliant findById(Long id);
    List<Compliant> findAll();
    void update(Compliant compliant);
    void delete(Long id);
    List<Compliant> findByTitle(String title);
    List<Compliant> findByStatus(Compliant.Status status);
    List<Compliant> findByResident(Long residentId);
    List<Compliant> findByFlat(Long Id);
    List<Compliant> findByCreatedAt(LocalDateTime createdAt);
}
