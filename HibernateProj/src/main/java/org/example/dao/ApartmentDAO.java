package org.example.dao;

import org.example.entity.Apartment;

import java.util.List;

public interface ApartmentDAO {
    void save(Apartment apartment);
    void update(Apartment apartment);
    void delete(Long id);
    Apartment findById(Long id);
    List<Apartment> findAll();
    Apartment findByName(String name);
}
