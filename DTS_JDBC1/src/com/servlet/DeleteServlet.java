package com.servlet;

import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteServlet extends HttpServlet {
    private UserServiceImpl us = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        us.deleteUser(id);
        resp.sendRedirect("userList");
    }
}