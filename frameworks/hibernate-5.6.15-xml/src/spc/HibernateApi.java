package spc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateApi {

    private final SessionFactory sessionFactory;

    public HibernateApi() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public void insert(JavaObject javaObject) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(javaObject);
        session.getTransaction().commit();
        session.close();
    }

    public List<JavaObject> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<JavaObject> javaObjects = session.createQuery("select j from JavaObject j", JavaObject.class).list();
        session.getTransaction().commit();
        session.close();
        return javaObjects;
    }

}
