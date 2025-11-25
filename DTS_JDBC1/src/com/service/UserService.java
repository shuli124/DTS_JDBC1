package com.service;

import com.bean.User;
import java.util.List;

public interface UserService {
    boolean login(String username, String password);
    boolean register(User user);
    List<User> getAllUsers();
    User getUserById(int id);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}