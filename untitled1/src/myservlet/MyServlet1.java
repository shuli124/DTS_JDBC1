package myservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置响应编码（避免中文乱码）
        response.setContentType("text/html;charset=UTF-8");

        // 2. 获取表单提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 3. 在IDEA控制台打印账号密码
        System.out.println("用户输入的用户名：" + username);
        System.out.println("用户输入的密码：" + password);

        // 4. 也可以给前端返回一个简单提示（可选）
        response.getWriter().write("已在控制台打印账号密码，可返回IDEA查看~");
    }
}