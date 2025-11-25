package com.test;

import com.bean.User;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class UserServiceImplTest {
    private UserServiceImpl us = new UserServiceImpl();

    @Test
    public void testLogin() {
        boolean success = us.login("admin", "123456");
        System.out.println("admin登录结果：" + success);  // 应该输出 true
    }

    @Test
    public void testGetAllUsers() {
        List<User> list = us.getAllUsers();   // ← 正确的方法名
        System.out.println("查询所有用户，共 " + list.size() + " 条：");
        for (User u : list) {
            System.out.println(u);
        }
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("test123");
        user.setPassword("123456");
        user.setGender("男");
        user.setEmail("test123@qq.com");

        boolean success = us.addUser(user);
        System.out.println("添加用户 test123 结果：" + success);
    }
}