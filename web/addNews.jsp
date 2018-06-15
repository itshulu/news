<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/6/14
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<h2 align="center">新闻管理系统</h2>
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
<form action="/allNewsServlet?method=addNews" method="post">
    <table align="center">
        <tbody>
        <tbody>
        <tr>
            <td>新闻标题：<input type="text" name="title"></td>
        </tr>
        <tr>
            <td> 新闻内容：<textarea name="content"></textarea></td>
        </tr>
        <tr>
            <td> 新闻类型：<label>
                <select name="cid" style="width:80px">
                    <c:forEach items="${list}" var="Type">
                        <option value="${Type.type_id}">${Type.typename}</option>
                    </c:forEach>
                </select>
            </label></td>
        </tr>
        <tr>
            <td> 新闻作者：<input type="text" name="author"></td>
        </tr>
        <tr>
            <td><input type="submit" value="确认"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
