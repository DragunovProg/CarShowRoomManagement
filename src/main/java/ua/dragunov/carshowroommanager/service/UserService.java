package ua.dragunov.carshowroommanager.service;


import ua.dragunov.carshowroommanager.dao.UserDAOImpl;
import ua.dragunov.carshowroommanager.model.User;

import java.util.List;

public class UserService {
    private static final UserDAOImpl userDao = new UserDAOImpl();


    public void createUser(User user) {
        userDao.createUser(user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void removeUser(Long userId) {
        userDao.removeUser(userId);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
