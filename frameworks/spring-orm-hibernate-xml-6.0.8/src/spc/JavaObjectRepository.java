package spc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class JavaObjectRepository {
    
    private final SessionFactory sessionFactory;

    public JavaObjectRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertJavaObject(JavaObject javaObject) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(javaObject);
        session.getTransaction().commit();
        session.close();
    }

    public List<JavaObject> selectJavaObjects() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<JavaObject> javaObjects = session
                .createQuery("select j from JavaObject j", JavaObject.class)
                .list();
        session.getTransaction().commit();
        session.close();
        return javaObjects;
    }

}
