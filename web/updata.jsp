<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/6/15
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<table align="center">
    <tbody>
    <tbody>
    <tr>
        <td width="100px" height="60px"><a href="/allNewsServlet?method=AllNews">所有新闻</a></td>
        <td width="100px" height="60px"><a href="/allNewsServlet?method=addNews">添加新闻</a></td>
        <td width="100px" height="60px"><a href="/login.jsp">系统登陆</a></td>
        <td width="100px" height="60px"><a href="/allNewsServlet?method=AllNews">新闻主页</a></td>
    </tr>
    </tbody>
</table>
<hr>
<form action="/allNewsServlet?method=updata" method="post">
    <table align="center">
        <tbody>
        <input type="hidden" name="id" value="${detail.id}">
        <tr>
            <td>新闻标题：<input type="text" name="title" value="${detail.title}"></td>
        </tr>
        <tr>
            <td> 新闻内容：<textarea name="content">${detail.content}</textarea></td>
        </tr>
        <tr>
            <td> 新闻类型：<label>
                <select name="type_id" style="width:80px">
                    <c:forEach items="${list}" var="Type">
                        <option value="${Type.type_id}">${Type.typename}</option>
                    </c:forEach>
                </select>
            </label></td>
        </tr>
        <tr>
            <td> 新闻作者：<input type="text" name="author" value="${detail.author}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="确认"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
