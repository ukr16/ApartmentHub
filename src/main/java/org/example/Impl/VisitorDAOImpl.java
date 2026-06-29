package org.example.Impl;

import org.example.dao.VisitorDAO;

import org.example.entity.Visitor;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VisitorDAOImpl implements VisitorDAO {

    @Override
    public void save(Visitor visitor){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(visitor);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Visitor visitor){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.merge(visitor);
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
            Visitor visitor = session.find(Visitor.class, id);
            if(visitor != null) session.remove(visitor);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public List<Visitor> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor", Visitor.class).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Visitor findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Visitor.class, id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Visitor> findByName(String name){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor where name = :name", Visitor.class).setParameter("name", name).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Visitor findByPhone(String phone){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor where phone = :phone", Visitor.class).setParameter("phone", phone).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Visitor> findByPurpose(Visitor.Purpose purpose){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor where purpose = :purpose", Visitor.class).setParameter("purpose", purpose).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Visitor> findByVehicleType(Visitor.VehicleType vehicleType){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor where vehicleType = :vehicleType", Visitor.class).setParameter("vehicleType", vehicleType).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Visitor> findActiveVisitors(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor where exitTime is null", Visitor.class).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public List<Visitor> findByFlatId(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor where id = :id", Visitor.class).setParameter("id", id).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Visitor> findByResident(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Visitor where id = :id", Visitor.class).setParameter("id", id).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
