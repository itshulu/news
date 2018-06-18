<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<h2 align="center">新闻管理系统</h2>
<table align="center">
    <tbody>
    <tr>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/login.jsp">所有新闻</a></td>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/login.jsp">添加新闻</a></td>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/login.jsp">系统登陆</a></td>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/login.jsp">新闻主页</a></td>
        <td><a href="${pageContext.request.contextPath}/LoginOut">注销</a></td>
    </tr>
    </tbody>
</table>
<hr>
<form action="${pageContext.request.contextPath}/adminServlet?method=adminQuire" method="post">
    用户名：<input type="text" name="adminname">
    密码：<input type="text" name="adminpass">
    <input type="submit" value="确定">
</form>
</body>
</html>
