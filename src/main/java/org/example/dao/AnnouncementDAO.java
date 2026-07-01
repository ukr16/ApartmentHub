package org.example.dao;

import org.example.entity.Announcement;

import java.time.LocalDateTime;
import java.util.List;

public interface AnnouncementDAO {
    void save(Announcement announcement);
    Announcement findByAnnouncementId(Long announcementId);
    List<Announcement> findAllAnnouncements();
    void update(Announcement announcement);
    void delete(Long announcementId);
    List<Announcement> findByAnnouncementTitle(String announcementTitle);
    List<Announcement> findAnnouncementByApartment(Long announcementId);
    List<Announcement> findAnnouncementByCreatedAt(LocalDateTime announcementCreatedAt);
}
