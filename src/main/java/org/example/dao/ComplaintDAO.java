package org.example.dao;

import org.example.entity.Compliant;

import java.time.LocalDateTime;
import java.util.List;

public interface ComplaintDAO {
    void save(Compliant compliant);
    Compliant findByCompliantId(Long compliantId);
    List<Compliant> findAllCompliants();
    void update(Compliant compliant);
    void delete(Long compliantId);
    List<Compliant> findByCompliantTitle(String compliantTitle);
    List<Compliant> findByCompliantStatus(Compliant.CompliantStatus compliantStatus);
    List<Compliant> findByResident(Long residentId);
    List<Compliant> findByFlat(Long flatId);
    List<Compliant> findByCompliantCreatedAt(LocalDateTime compliantCreatedAt);
}
