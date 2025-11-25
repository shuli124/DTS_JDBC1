<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" %>
<html>
<head><title>使用request对象获取并显示全部请求头信息</title></head>
<body>
<h1>您客户端发送的HTTP请求头包含如下信息：</h1>
<%
    Enumeration<String> headers=request.getHeaderNames();
    while(headers.hasMoreElements()){
        String headerName = headers.nextElement();
        String headerValue = request.getHeader(headerName);
%>
<b><%= headerName %></b>:<%= headerValue %><br/>
<%
    }
%>
</body>
</html>
