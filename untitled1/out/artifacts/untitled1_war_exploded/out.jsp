<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>注销登录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<%
    if (session.getAttribute("userName") != null) {
        session.invalidate(); // 销毁Session
        response.sendRedirect("/index.jsp"); // 重定向到登录入口
    } else {
        response.sendRedirect("/index.jsp");
    }
%>
</body>
</html>
