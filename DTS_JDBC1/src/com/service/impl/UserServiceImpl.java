package com.service.impl;

import com.bean.User;
import com.dao.impl.UserDaoImpl;
import com.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) return false;
        return user.getPassword().equals(password);
    }

    @Override
    public boolean register(User user) {
        int rows = userDao.addUser(user);
        return rows > 0;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public boolean addUser(User user) {
        int rows = userDao.addUser(user);
        return rows > 0;
    }

    @Override
    public boolean updateUser(User user) {
        int rows = userDao.updateUser(user);
        return rows > 0;
    }

    @Override
    public boolean deleteUser(int id) {
        int rows = userDao.deleteUser(id);
        return rows > 0;
    }
}