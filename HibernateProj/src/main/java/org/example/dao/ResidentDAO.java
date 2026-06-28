package org.example.dao;

import org.example.entity.Resident;

import java.time.LocalDate;
import java.util.List;

public interface ResidentDAO {
    void save(Resident resident);
    void update(Resident resident);
    void delete(Long id);
    List<Resident> findAll();
    Resident findById(Long id);
    List<Resident> findByName(String name);
    Resident findByPhone(String phone);
    Resident findByEmail(String email);
    List<Resident> findByMoveInDate(LocalDate moveInDate);
    List<Resident> findByResidentType(Resident.ResidentType residentType);
    List<Resident> findFlatsByResident(String name); //Id refers to resident id
    List<Resident> findParkingByResident(String flatNumber); //Id refers to resident id
    List<Resident> findVisitorsByResident(String flatNumber); //Id refers to resident id
}
