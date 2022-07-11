package ua.dragunov.carshowroommanager.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProcessor {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = createEntityManagerFactory();

    private static EntityManagerFactory createEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("ua.dragunov.carshowroommanager");
        } catch (Throwable ex) {
           throw new ExceptionInInitializerError();

        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }
}
