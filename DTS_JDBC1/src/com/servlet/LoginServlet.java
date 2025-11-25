package com.servlet;

import com.bean.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserServiceImpl us = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = us.userLogin(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("userList");
        } else {
            req.setAttribute("msg", "用户名或密码错误！");
            req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        }
    }
}