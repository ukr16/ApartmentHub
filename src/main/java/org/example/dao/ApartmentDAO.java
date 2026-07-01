package org.example.dao;

import org.example.entity.Apartment;

import java.util.List;

public interface ApartmentDAO {
    void save(Apartment apartment);
    void update(Apartment apartment);
    void delete(Long apartmentId);
    Apartment findByApartmentId(Long apartmentId);
    List<Apartment> findAllApartments();
    Apartment findByApartmentName(String apartmentName);
}
