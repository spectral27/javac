package spec;

import java.util.function.Consumer;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;

public class Main {

    @Entity
    public class Processor {

        @Id
        @GeneratedValue
        public int id;
        public String model;

    }

    private EntityManagerFactory factory;

    public Main() {
        factory = Persistence.createEntityManagerFactory("main-unit");
    }

    public void execute(Consumer<EntityManager> consumer) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        consumer.accept(entityManager);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Insert done.");
    }
    
    public static void main(String[] args) {
        Main main = new Main();

        Processor processor = main.new Processor();
        processor.model = "test";

        main.execute(em -> em.persist(processor));
    }

}
