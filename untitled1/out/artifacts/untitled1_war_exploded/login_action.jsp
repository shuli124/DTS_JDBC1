<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>登录处理</title></head>
<body>
处理页面
<%
    String userName = request.getParameter("userName");
    String userPwd = request.getParameter("userPwd");
    if(userName==null || userPwd == null){
        //request.setAttribute("message", "用户名或密码为空");
        pageContext.forward("login.jsp");
    }else if((userName.equals("lan") && userPwd.equals("123")) || 
              (userName.equals("admin") && userPwd.equals("admin123"))){
        session.setAttribute("userName", userName);
        session.setAttribute("userPwd", userPwd);
        pageContext.forward("user.jsp");
        //response.sendRedirect(request.getContextPath()+"/jsp/user.jsp");
    }else{
        //request.setAttribute("message", "用户名或密码错误");
        pageContext.forward("login.jsp");
    }
%>
</body>
</html>