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
    public void delete(Long id){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Amenity amenity = session.find(Amenity.class, id);
            if(amenity != null) session.remove(amenity);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public Amenity findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Amenity.class, id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Amenity findByName(String name){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity where name = :name", Amenity.class).setParameter("name", name).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Amenity> findByAvailability(boolean isAvailable){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity where isAvailable = :isAvailable", Amenity.class).setParameter("isAvailable", isAvailable).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Amenity> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity", Amenity.class).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Amenity> findByApartment(String apartmentName){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity where apartmentName = :apartmentName", Amenity.class).setParameter("apartmentName", apartmentName).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
