package ua.dragunov.carshowroommanager.service;


import ua.dragunov.carshowroommanager.dao.UserRoleDAOImpl;
import ua.dragunov.carshowroommanager.model.UserRole;

public class UserRoleService {
    private static final UserRoleDAOImpl userRoleDao = new UserRoleDAOImpl();

    public UserRole getUserRoleById(Long roleId) {
        return userRoleDao.getUserRoleById(roleId);
    }

    public void updateUserRole(UserRole role) {
        userRoleDao.update(role);
    }

    public void removeUserRole(Long roleId) {
        userRoleDao.remove(roleId);
    }
}
