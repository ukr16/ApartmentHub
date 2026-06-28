package org.example.dao;

import org.example.entity.Parking;
import org.example.entity.Resident;

import java.util.List;

public interface ParkingDAO {
    void save(Parking parking);
    void update(Parking parking);
    void delete(Long id);
    List<Parking> findAll();
    Parking findByParkingId(Long id);
    Parking findByParkingNumber(String parkingNumber);
    List<Parking> findByVehicleType(Parking.ParkingType parkingType);
    List<Resident> findResidentsByParking(Long id); //id refers to parking id
}
