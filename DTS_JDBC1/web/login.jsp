<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>用户登录</title></head>
<body>
<h2>用户登录系统</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username" required><br><br>
    密　码：<input type="password" name="password" required><br><br>
    <input type="submit" value="登录">
</form>
</