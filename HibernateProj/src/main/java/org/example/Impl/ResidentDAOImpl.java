package org.example.Impl;

import org.example.dao.ResidentDAO;
import org.example.entity.Resident;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class ResidentDAOImpl implements ResidentDAO {

    @Override
    public void save(Resident resident){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(resident);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Resident resident){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.merge(resident);
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
            Resident resident = session.find(Resident.class, id);
            if(resident != null) session.remove(resident);
            tx.commit();
        }catch(Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Resident> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Resident", Resident.class).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Resident findById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(Resident.class, id);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resident> findByName(String name){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Resident where name = :name", Resident.class).setParameter("name", name).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Resident findByPhone(String phone){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Resident where phone = :phone", Resident.class).setParameter("phone", phone).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Resident findByEmail(String email){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Resident where email = :email", Resident.class).setParameter("email", email).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resident> findByMoveInDate(LocalDate moveInDate){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Resident where moveInDate = :moveInDate", Resident.class).setParameter("moveInDate", moveInDate).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resident> findByResidentType(Resident.ResidentType residentType){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Resident where residentType = :residentType", Resident.class).setParameter("residentType", residentType).list();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    List<Resident> findFlatsByResident(Long id); //Id refers to resident id
//    List<Resident> findParkingByResident(Long id); //Id refers to resident id
//    List<Resident> findVisitorsByResident(Long id); //Id refers to resident id
}
