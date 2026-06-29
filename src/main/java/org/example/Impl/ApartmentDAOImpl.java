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
    public void delete(Long id){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            Apartment apartment = session.find(Apartment.class, id);
            if (apartment != null) {
                session.remove(apartment);
            }
            tx.commit();
            session.close();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Apartment findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Apartment.class, id);
        }
    }

    @Override
    public List<Apartment> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Apartment", Apartment.class).list();
        }
    }

    @Override
    public Apartment findByName(String name){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Apartment where name = :name", Apartment.class).setParameter("name", name).uniqueResult();
        }
    }
}
