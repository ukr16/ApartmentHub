package org.example;


import org.example.util.HibernateUtil;

public class Main {

    static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        HibernateUtil.shutdown();
    }
}