package com.jin;

import com.bean.User;
import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        
        // 检查参数是否为空
        if (uname == null || uname.isEmpty() || pwd == null || pwd.isEmpty()) {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>用户名或密码不能为空!</h2>");
            out.println("<a href='index.jsp'>返回注册页面</a>");
            out.println("</body></html>");
            return;
        }
        
        User user = new User(uname, pwd);
        UserDao userDao = new UserDao();
        try {
            userDao.addUser(user);
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>注册成功!</h2>");
            out.println("<p>用户名: " + uname + "</p>");
            out.println("<a href='index.jsp'>继续注册</a>");
            out.println("</body></html>");
        } catch (ClassNotFoundException e) {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>数据库驱动未找到!</h2>");
            out.println("<p>错误详情: " + e.getMessage() + "</p>");
            out.println("<a href='index.jsp'>返回注册页面</a>");
            out.println("</body></html>");
            e.printStackTrace();
        } catch (SQLException e) {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>数据库操作失败!</h2>");
            out.println("<p>错误详情: " + e.getMessage() + "</p>");
            out.println("<a href='index.jsp'>返回注册页面</a>");
            out.println("</body></html>");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}