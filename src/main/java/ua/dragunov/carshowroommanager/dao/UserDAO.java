package ua.dragunov.carshowroommanager.dao;

import ua.dragunov.carshowroommanager.model.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void removeUser(Long userId);

    List<User> getAllUsers();

    User getUserByEmail(String email);

}
