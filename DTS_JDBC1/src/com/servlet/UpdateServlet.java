package com.servlet;

import com.bean.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateServlet extends HttpServlet {
    private UserServiceImpl us = new UserServiceImpl();

    // 跳转到修改页面（回显）
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = us.getUserById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/pages/update.jsp").forward(req, resp);
    }

    // 真正执行修改
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setGender(req.getParameter("gender"));
        user.setEmail(req.getParameter("email"));

        us.updateUser(user);
        resp.sendRedirect("userList");
    }
}