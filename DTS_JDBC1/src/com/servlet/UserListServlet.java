package com.servlet;

import com.bean.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
    private UserServiceImpl us = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = us.getAllUsers();
        req.setAttribute("users", list);
        req.getRequestDispatcher("/pages/list.jsp").forward(req, resp);
    }
}