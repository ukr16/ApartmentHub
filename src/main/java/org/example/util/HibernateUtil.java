package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
           SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
           System.out.println("Connection Establish Successful");
           return sessionFactory;
        }catch(RuntimeException e) {
            System.out.println("Session Creation Failed " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutdown(){
        try{
            getSessionFactory().close();
            System.out.println("Connection Shutdown Successful");
        }catch (RuntimeException e){
            System.out.println("Session shutdown Failed " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
