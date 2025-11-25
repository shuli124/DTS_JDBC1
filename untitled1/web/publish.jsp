<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>文章显示页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
        table {
            border-color: #aaaaaa;
        }
        .td_01 {
            width: 500px;
            height: 50px;
            text-align: center;
            font-weight: bold;
            font-size: 20pt;
            background-color: #cccccc;
            color: #222222;
        }
        .td_02{
            width: 180px;
            text-align: center;
        }
        .td_03{
            height: 100px;
            text-align: center;
        }
    </style>
</head>

<body>
<form action="${pageContext.request.contextPath}/PublishServlet" method="post">
    <table border="1" cellspacing="0" align="center">
        <tr>
            <td colspan="2" class="td_01">发表文章</td>
        </tr>
        <tr>
            <td class="td_02">文章类型:</td>
            <td>
                <select name="articType">
                    <option value="程序设计">程序设计</option>
                    <option value="军事">军事</option>
                    <option value="艺术设计">艺术设计</option>
                    <option value="传统文化">传统文化</option>
                    <option value="篮球体育">篮球体育</option>
                    <option value="世界地图">世界地图</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="td_02">文章标题:</td>
            <td>
                <input type="text" name="articTitle"/>
            </td>
        </tr>
        <tr>
            <td class="td_03">文章内容:</td>
            <td>
                <textarea rows="10" cols="41" name="articContent"></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_02">您已发表的文章数:</td>
            <td>${sessionScope.count }篇</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="确定发表"> &nbsp;&nbsp;
                <input type="button" onclick="out()" value="返回首页"> &nbsp;&nbsp;
                <input type="button" onclick="back()" value="返回用户界面">
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function out(){
        window.location.href="${pageContext.request.contextPath}/index.jsp";
    }
    //var path = ${pageContext.request.contextPath };
    function back(){
        window.location.href="${pageContext.request.contextPath}/user.jsp";
    }
</script>
</body>
</html>