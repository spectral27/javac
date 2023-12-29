package spc;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        DatabaseInitializer.initialize();

        JavaObject java = new JavaObject();
        java.setId(1);
        java.setName("Java");
        java.setVersion("21.0.0");

        JavaObject hibernate = new JavaObject();
        hibernate.setId(2);
        hibernate.setName("Hibernate");
        hibernate.setVersion("5.6.15");

        HibernateApi hibernateApi = new HibernateApi();

        hibernateApi.insert(java);
        hibernateApi.insert(hibernate);

        List<JavaObject> javaObjects = hibernateApi.selectAll();

        javaObjects.forEach(JavaObject::print);
    }

}
