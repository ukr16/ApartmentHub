package org.example.Impl;

import org.example.dao.AnnouncementDAO;
import org.example.entity.Announcement;
import org.example.entity.Apartment;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class AnnouncementDAOImpl implements AnnouncementDAO {
    @Override
    public void save(Announcement announcement){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(announcement);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public Announcement findByAnnouncementId(Long announcementId){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Announcement.class, announcementId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Announcement> findAllAnnouncements(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Announcement", Announcement.class).list();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void update(Announcement announcement){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.merge(announcement);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long announcementId){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Announcement announcement = session.find(Announcement.class, announcementId);
            if(announcementId != null) session.remove(announcement);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public List<Announcement> findByAnnouncementTitle(String announcementTitle){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Announcement where :announcementTitle = announcementTitle", Announcement.class).setParameter("announcementTitle", announcementTitle).list();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Announcement> findAnnouncementByApartment(Long announcementId){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Announcement where :announcementId = announcementId", Announcement.class).setParameter("announcementId", announcementId).list();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Announcement> findAnnouncementByCreatedAt(LocalDateTime announcementCreatedAt){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Announcement where :announcementCreatedAt = announcementCreatedAt", Announcement.class).setParameter("announcementCreatedAt", announcementCreatedAt).list();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
