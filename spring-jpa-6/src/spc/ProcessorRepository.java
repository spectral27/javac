package spc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ProcessorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Processor processor) {
        entityManager.persist(processor);
    }

    public List<Processor> selectAll() {
        return entityManager.createQuery("select p from Processor p", Processor.class).getResultList();
    }

}
