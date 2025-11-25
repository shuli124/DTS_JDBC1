<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.bean.User" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<h2>欢迎：${sessionScope.username} <a href="${pageContext.request.contextPath}/logout">注销</a></h2>
<a href="${pageContext.request.contextPath}/pages/add.jsp">添加用户</a>
<table border="1">
    <tr><th>ID</th><th>用户名</th><th>密码</th><th>性别</th><th>邮箱</th><th>操作</th></tr>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        if (users != null && !users.isEmpty()) {
            for (User u : users) {
    %>
    <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getUsername() %></td>
        <td><%= u.getPassword() %></td>
        <td><%= u.getGender() != null ? u.getGender() : "" %></td>
        <td><%= u.getEmail() != null ? u.getEmail() : "" %></td>
        <td>
            <a href="${pageContext.request.contextPath}/updateUser?id=<%= u.getId() %>">修改</a>
            <a href="${pageContext.request.contextPath}/deleteUser?id=<%= u.getId() %>" onclick="return confirm('确定删除?')">删除</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="6">暂无数据</td></tr>
    <% } %>
</table>
</body>
</html>