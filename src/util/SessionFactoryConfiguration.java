package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.LaptopEntity;
import entity.StudentEntity;

import org.hibernate.Session;

public class SessionFactoryConfiguration {
    
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration(){
        Configuration  configuration=new Configuration().configure()
        .addAnnotatedClass(LaptopEntity.class)
        .addAnnotatedClass(StudentEntity.class);
      
      
        sessionFactory=configuration.buildSessionFactory();

    }

    public static SessionFactoryConfiguration getInstance(){
        return  sessionFactoryConfiguration== null? 
        sessionFactoryConfiguration =new SessionFactoryConfiguration()
        :sessionFactoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
