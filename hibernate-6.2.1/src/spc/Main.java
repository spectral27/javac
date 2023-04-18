package spc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DriverManager.getConnection(
                    "jdbc:h2:mem:db1;INIT=runscript from 'classpath:data.sql'",
                    "username",
                    "password"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        JavaObject java = new JavaObject();
        java.setVendor(System.getProperty("java.vendor"));
        java.setVersion(System.getProperty("java.version"));

        JavaObject hibernate = new JavaObject();
        hibernate.setVendor("Hibernate Framework");
        hibernate.setVersion("6.2.1");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(java);
        session.persist(hibernate);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();

        List<JavaObject> javaObjects = session
                .createQuery("select j from JavaObject j", JavaObject.class)
                .list();

        session.getTransaction().commit();
        session.close();

        for (JavaObject javaObject : javaObjects) {
            System.out.printf("%s %s\n", javaObject.getVendor(), javaObject.getVersion());
        }
    }

}
