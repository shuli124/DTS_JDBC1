<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>添加用户</title>
</head>
<body>
<h2>添加用户</h2>
${error}
<form action="${pageContext.request.contextPath}/addUser" method="post">
  用户名: <input type="text" name="username" required><br><br>
  密码: <input type="password" name="password" required><br><br>
  性别:
  <input type="radio" name="gender" value="男" checked>男
  <input type="radio" name="gender" value="女">女<br><br>
  邮箱: <input type="email" name="email"><br><br>
  <input type="submit" value="添加">
</form>
<a href="${pageContext.request.contextPath}/userList">返回列表</a>
</body>
</html>