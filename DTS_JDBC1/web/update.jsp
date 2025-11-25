<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bean.User" %>
<html>
<head>
  <title>修改用户</title>
</head>
<body>
<h2>修改用户</h2>
<%
  User user = (User) request.getAttribute("user");
  if (user != null) {
%>
${error}
<form action="${pageContext.request.contextPath}/updateUser" method="post">
  <input type="hidden" name="id" value="<%= user.getId() %>">
  用户名: <input type="text" name="username" value="<%= user.getUsername() %>" required><br><br>
  密码: <input type="password" name="password" value="<%= user.getPassword() %>" required><br><br>
  性别:
  <input type="radio" name="gender" value="男" <%= "男".equals(user.getGender()) ? "checked" : "" %>>男
  <input type="radio" name="gender" value="女" <%= "女".equals(user.getGender()) ? "checked" : "" %>>女<br><br>
  邮箱: <input type="email" name="email" value="<%= user.getEmail() != null ? user.getEmail() : "" %>"><br><br>
  <input type="submit" value="修改">
</form>
<% } else { %>
<p>用户不存在！</p>
<% } %>
<a href="${pageContext.request.contextPath}/userList">返回列表</a>
</body>
</html>