package ua.dragunov.carshowroommanager.dao;

import ua.dragunov.carshowroommanager.model.UserRole;

public interface UserRoleDAO {

    UserRole getUserRoleById(Long id);

    void update(UserRole role);

    void remove(Long roleId);
}
