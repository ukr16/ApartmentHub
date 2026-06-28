package org.example.dao;

import org.example.entity.Amenity;

import java.util.List;

public interface AmenityDAO {
    void save(Amenity amenity);
    void update(Amenity amenity);
    void delete(Long id);
    Amenity findById(Long id);
    Amenity findByName(String name);
    List<Amenity> findByAvailability(boolean isAvailable);
    List<Amenity> findAll();
    List<Amenity> findByApartment(String apartmentName);
}
