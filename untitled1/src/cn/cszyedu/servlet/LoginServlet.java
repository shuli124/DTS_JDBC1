package cn.cszyedu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        //获取 session 对象
        HttpSession session = request.getSession();

        if (userName == null || userPwd == null) {
            //request.setAttribute("message", "用户名或密码为空");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else if (userName.equals("lan") && userPwd.equals("123")) {
            session.setAttribute("userName", userName);
            session.setAttribute("userPwd", userPwd);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
        } else {
            //request.setAttribute("message", "用户名或密码错误");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
