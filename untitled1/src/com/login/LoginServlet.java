package com.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// 注解配置Servlet路径（替代web.xml，更简单）
@WebServlet("/servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码（必须放在获取参数之前）
        request.setCharacterEncoding("UTF-8");

        // 获取表单提交的账号和密码（name要和表单中input的name一致）
        String account = request.getParameter("userAccount");
        String password = request.getParameter("userPassword");

        // 打印到IDEA控制台
        System.out.println("用户输入的账号：" + account);
        System.out.println("用户输入的密码：" + password);

        // 给网页返回提示（可选）
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("提交成功！账号密码已显示在IDEA控制台");
    }
}