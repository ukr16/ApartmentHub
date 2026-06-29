package org.example.Impl;

import org.example.dao.ParkingDAO;
import org.example.entity.Amenity;
import org.example.entity.Parking;
import org.example.entity.Resident;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ParkingDAOImpl implements ParkingDAO {

    @Override
    public void save(Parking parking){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(parking);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Parking parking){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.merge(parking);
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
    public List<Parking> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Amenity", Parking.class).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Parking findByParkingId(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Parking.class, id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Parking findByParkingNumber(String parkingNumber){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Parking where parkingNumber = :parkingNumber", Parking.class).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Parking> findByVehicleType(Parking.ParkingType parkingType){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Parking where parkingNumber = :parkingNumber", Parking.class).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Resident> findResidentsByParking(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Parking parking = session.find(Parking.class, id);
            return (parking != null ? parking.getResident():null);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
