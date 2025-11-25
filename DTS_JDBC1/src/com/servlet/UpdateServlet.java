package com.servlet;

import com.bean.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUserById(id);
        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/pages/update.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/userList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setId(Integer.parseInt(req.getParameter("id")));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setGender(req.getParameter("gender"));
        user.setEmail(req.getParameter("email"));

        if (userService.updateUser(user)) {
            resp.sendRedirect(req.getContextPath() + "/userList");
        } else {
            req.setAttribute("error", "修改失败！");
            req.getRequestDispatcher("/pages/update.jsp").forward(req, resp);
        }
    }
}