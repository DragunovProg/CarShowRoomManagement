package ua.dragunov.carshowroommanager.dao;

import ua.dragunov.carshowroommanager.model.CarSales;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CarSalesDAOImpl implements CarSalesDAO{
    @Override
    public void createCarSales(CarSales carSales) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(carSales);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public CarSales getCarSalesById(Long id) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        CarSales carSales = entityManager.find(CarSales.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();

        return carSales;
    }

    @Override
    public void updateCarSales(CarSales carSales) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("update CarSales cs set cs.car = :car," +
                "cs.user = :user," +
                "cs.fullPrice = :full_price," +
                "cs.purchaseDate = :purchase_date where cs.id = :csid");

        query.setParameter("car", carSales.getCar());
        query.setParameter("user", carSales.getUser());
        query.setParameter("full_price", carSales.getFullPrice());
        query.setParameter("purchase_date", carSales.getPurchaseDate());
        query.setParameter("csid", carSales.getId());
        query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeCarSales(Long carSalesId) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        CarSales removingCarSales = entityManager.find(CarSales.class, carSalesId);
        entityManager.remove(removingCarSales);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<CarSales> getAllCarSales() {
        return EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager()
                .createQuery("select cs from CarSales cs", CarSales.class)
                .getResultList();
    }
}
