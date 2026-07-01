package org.example.Impl;

import org.example.dao.ApartmentDAO;
import org.example.entity.Apartment;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ApartmentDAOImpl implements ApartmentDAO {

    @Override
    public void save(Apartment apartment){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(apartment);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Apartment apartment){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.merge(apartment);
            tx.commit();
            session.close();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long apartmentId){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Apartment apartment = session.find(Apartment.class, apartmentId);
            if (apartment != null) {
                session.remove(apartment);
            }
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Apartment findByApartmentId(Long apartmentId){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Apartment.class, apartmentId);
        }
    }

    @Override
    public List<Apartment> findAllApartments(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Apartment", Apartment.class).list();
        }
    }

    @Override
    public Apartment findByApartmentName(String apartmentName){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Apartment where apartmentName = :apartmentName", Apartment.class).setParameter("apartmentName", apartmentName).uniqueResult();
        }
    }
}
