package org.example.Impl;

import org.example.dao.AmenityDAO;
import org.example.entity.Amenity;
import org.example.entity.Flats;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AmenityDAOImpl implements AmenityDAO {
    @Override
    public void save(Amenity amenity){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(amenity);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public void update(Amenity amenity){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.merge(amenity);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long amenityId){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Amenity amenity = session.find(Amenity.class, amenityId);
            if(amenity != null) session.remove(amenity);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public Amenity findByAmenityId(Long amenityId){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Amenity.class, amenityId);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Amenity findByAmenityName(String amenityName){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity where amenityName = :amenityName", Amenity.class).setParameter("amenityName", amenityName).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Amenity> findByAmenityAvailability(boolean isAmenityAvailable){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity where isAvailable = :isAvailable", Amenity.class).setParameter("isAmenityAvailable", isAmenityAvailable).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Amenity> findAllAmenities(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity", Amenity.class).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Amenity> findAmenityByApartment(String apartmentName){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity where apartmentName = :apartmentName", Amenity.class).setParameter("apartmentName", apartmentName).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
