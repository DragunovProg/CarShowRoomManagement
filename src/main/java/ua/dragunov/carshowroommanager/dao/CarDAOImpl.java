package ua.dragunov.carshowroommanager.dao;

import ua.dragunov.carshowroommanager.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CarDAOImpl implements CarDAO{

    @Override
    public void createCar(Car car) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Car getCarById(Long id) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        Car car = entityManager.find(Car.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();

        return car;
    }

    @Override
    public void updateCar(Car car) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("update Car c set c.mark = :mark," +
                "c.model = :model," +
                "c.engine = :engine," +
                "c.price = :price," +
                "c.releaseDate = :release_date," +
                "c.quantity = :quantity where c.id = : cid");
        query.setParameter("mark", car.getMark());
        query.setParameter("model", car.getModel());
        query.setParameter("engine", car.getEngine());
        query.setParameter("price", car.getPrice());
        query.setParameter("release_date", car.getReleaseDate());
        query.setParameter("quantity", car.getQuantity());
        query.setParameter("cid", car.getId());
        query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeCar(Long carId) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        Car removingCar = entityManager.find(Car.class, carId);
        entityManager.remove(removingCar);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Car> getAllCars() {
        return EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager()
                .createQuery("select c from Car c", Car.class)
                .getResultList();
    }
}
