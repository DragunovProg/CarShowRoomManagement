package ua.dragunov.carshowroommanager.dao;


import ua.dragunov.carshowroommanager.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    @Override
    public void createUser(User user) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User getUserById(Long id) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();

        return user;
    }

    @Override
    public void updateUser(User user) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("update User u set u.firstName = :first_name," +
                "u.lastName = :last_name," +
                "u.email = :email," +
                "u.password = :password," +
                "u.role = :role where u.id = :uid");
        query.setParameter("first_name", user.getFirstName());
        query.setParameter("last_name", user.getLastName());
        query.setParameter("email", user.getEmail());
        query.setParameter("password", user.getPassword());
        query.setParameter("role", user.getRole());
        query.setParameter("uid", user.getId());
        query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeUser(Long userId) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        User removingUser = entityManager.find(User.class, userId);
        entityManager.remove(removingUser);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> getAllUsers() {
        return EntityManagerFactoryProcessor.getEntityManagerFactory().createEntityManager()
                .createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserByEmail(String email) {
        return EntityManagerFactoryProcessor.getEntityManagerFactory().createEntityManager()
                        .createQuery("from User u where u.email = :email", User.class)
                        .setParameter("email", email)
                        .getSingleResult();


    }
}
