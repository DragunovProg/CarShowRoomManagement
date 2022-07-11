package ua.dragunov.carshowroommanager.dao;

import ua.dragunov.carshowroommanager.model.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserRoleDAOImpl implements UserRoleDAO {

    @Override
    public UserRole getUserRoleById(Long id) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        UserRole role = entityManager.find(UserRole.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();

        return role;
    }

    @Override
    public void update(UserRole role) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update UserRole u set u.name = :role_name where u.id = :uid");
        query.setParameter("role_name", role.getName());
        query.setParameter("uid", role.getId());
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void remove(Long roleId) {
        EntityManager entityManager = EntityManagerFactoryProcessor.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        UserRole removingRole = entityManager.find(UserRole.class, roleId);
        entityManager.remove(removingRole);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
