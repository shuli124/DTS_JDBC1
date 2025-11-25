package com.servlet;

import com.bean.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addUser")
public class AddServlet extends HttpServlet {
    private UserServiceImpl us = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setGender(req.getParameter("gender"));
        user.setEmail(req.getParameter("email"));

        us.addUser(user);
        resp.sendRedirect("userList");
    }
}