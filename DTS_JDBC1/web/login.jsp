<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h2>用户登录</h2>
${error}  <!-- EL 表达式显示错误 -->
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名: <input type="text" name="username" required><br><br>
    密码: <input type="password" name="password" required><br><br>
    <input type="submit" value="登录">
</form>
<a href="${pageContext.request.contextPath}/pages/register.jsp">注册</a>
</body>
</html>