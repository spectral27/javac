package spc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            DriverManager.getConnection(
                "jdbc:h2:mem:db1;INIT=runscript from 'classpath:data.sql'",
                "username",
                "password"
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainpersistenceunit");

        JavaObject java = new JavaObject();
        java.setId(1);
        java.setVendor(System.getProperty("java.vendor"));
        java.setVersion(System.getProperty("java.version"));

        JavaObject jpa = new JavaObject();
        jpa.setId(2);
        jpa.setVendor("Jakarta Persistence API");
        jpa.setVersion("3.1.0");

        JavaObject hibernate = new JavaObject();
        hibernate.setId(3);
        hibernate.setVendor("Hibernate ORM");
        hibernate.setVersion("6.2.1");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(java);
        entityManager.persist(jpa);
        entityManager.persist(hibernate);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<JavaObject> javaObjects = entityManager
                .createQuery("select j from JavaObject j", JavaObject.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        for (JavaObject javaObject : javaObjects) {
            System.out.printf("%s %s\n", javaObject.getVendor(), javaObject.getVersion());
        }
    }

}
