package org.example.dao;

import org.example.entity.Amenity;

import java.util.List;

public interface AmenityDAO {
    void save(Amenity amenity);
    void update(Amenity amenity);
    void delete(Long amenityId);
    Amenity findByAmenityId(Long amenityId);
    Amenity findByAmenityName(String amenityName);
    List<Amenity> findByAmenityAvailability(boolean isAmenityAvailable);
    List<Amenity> findAllAmenities();
    List<Amenity> findAmenityByApartment(String apartmentName);
}
