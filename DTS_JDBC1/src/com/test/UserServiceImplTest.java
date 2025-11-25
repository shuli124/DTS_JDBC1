package com.test;

import com.bean.User;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class UserServiceImplTest {
    private UserServiceImpl us = new UserServiceImpl();

    @Test
    public void testGetAllUsers() {
        List<User> list = us.getAllUsers();  // ← 正确的小写方法名
        System.out.println("查询所有用户，共 " + list.size() + " 条：");
        for (User u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void testLogin() {
        boolean success = us.login("admin", "123456");
        System.out.println("admin 登录结果：" + success);  // true
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("123456");
        user.setGender("男");
        user.setEmail("test@163.com");
        boolean success = us.addUser(user);
        System.out.println("添加 testuser 结果：" + success);  // true，如果不重复
    }
}