package com.company;

import com.company.HttpServletRequest;
import com.company.HttpServletResponse;
import com.company.ServletException;
import com.company.IOException;
import com.company.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hello World from Servlet!</h1>");
            out.println("<p>这是使用Java Servlet创建的简单Hello World应用程序。</p>");
            out.println("<p>当前时间: " + new java.util.Date() + "</p>");
            out.println("<a href='index.jsp'>返回首页</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}