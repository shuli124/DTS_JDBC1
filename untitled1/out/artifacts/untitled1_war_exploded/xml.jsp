<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!-- 配置Servlet -->
    <servlet>
        <servlet-name>MyServlet1</servlet-name>
        <servlet-class>myservlet.MyServlet1</servlet-class> <!-- 对应Servlet的包路径+类名 -->
    </servlet>

    <!-- 配置Servlet的访问路径 -->
    <servlet-mapping>
        <servlet-name>MyServlet1</servlet-name>
        <url-pattern>/s1</url-pattern> <!-- 与表单action="s1"一致 -->
    </servlet-mapping>
</web-app>
