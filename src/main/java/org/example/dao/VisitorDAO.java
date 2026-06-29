package org.example.dao;

import org.example.entity.Visitor;

import java.util.List;

public interface VisitorDAO {
    void save(Visitor visitor);
    void update(Visitor visitor);
    void delete(Long id);
    List<Visitor> findAll();
    Visitor findById(Long id);
    List<Visitor> findByName(String name);
    Visitor findByPhone(String phone);
    List<Visitor> findByPurpose(Visitor.Purpose purpose);
    List<Visitor> findByVehicleType(Visitor.VehicleType vehicleType);
    List<Visitor> findActiveVisitors();
    List<Visitor> findByFlatId(Long id);
    List<Visitor> findByResident(Long id);
}
