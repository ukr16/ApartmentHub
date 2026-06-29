package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;
    private String announcementTitle;
    private String announcementMessage;
    private LocalDateTime announcementCreatedAt;
    @ManyToOne
    private Apartment apartment;

    public Announcement() {
    }

    public Announcement(String announcementTitle, String announcementMessage, LocalDateTime announcementCreatedAt, Apartment apartment) {
        this.announcementTitle = announcementTitle;
        this.announcementMessage = announcementMessage;
        this.announcementCreatedAt = announcementCreatedAt;
        this.apartment = apartment;
    }

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementMessage() {
        return announcementMessage;
    }

    public void setAnnouncementMessage(String announcementMessage) {
        this.announcementMessage = announcementMessage;
    }

    public LocalDateTime getAnnouncementCreatedAt() {
        return announcementCreatedAt;
    }

    public void setAnnouncementCreatedAt(LocalDateTime announcementCreatedAt) {
        this.announcementCreatedAt = announcementCreatedAt;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId +
                ", announcementTitle='" + announcementTitle + '\'' +
                ", announcementMessage='" + announcementMessage + '\'' +
                ", announcementCreatedAt=" + announcementCreatedAt +
                ", apartment=" + apartment +
                '}';
    }
}
