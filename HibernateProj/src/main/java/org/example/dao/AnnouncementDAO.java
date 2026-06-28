package org.example.dao;

import org.example.entity.Announcement;

import java.time.LocalDateTime;
import java.util.List;

public interface AnnouncementDAO {
    void save(Announcement announcement);
    Announcement findById(Long id);
    List<Announcement> findAll();
    void update(Announcement announcement);
    void delete(Long id);
    List<Announcement> findByTitle(String title);
    List<Announcement> findByApartment(Long Id);
    List<Announcement> findByCreatedAt(LocalDateTime createdAt);
}
