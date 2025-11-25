<!-- request.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<p>获取文本框提交的信息：
        <% String strContent = request.getParameter("boy"); %>
        <%= strContent %>
<p>获取按钮的名字：
        <% String strButtonName = request.getParameter("submit"); %>
        <%= strButtonName %>
</body>
</html>
