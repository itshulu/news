<%--
  Created by IntelliJ IDEA.
  User: 舒露
  Date: 2018/6/14
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>搜索</title>
</head>
<body>
<table align="center">
<tbody>
<tr>
    <td width="100px" height="60px"><a href="/allNewsServlet?method=allNews">所有新闻</a></td>
    <td width="100px" height="60px"><a href="/search.jsp">搜索新闻</a></td>
    <td width="100px" height="60px"><a href="/login.jsp">后台管理</a></td>
</tr>
</tbody>
</table>
<hr>
<form action="/allNewsServlet?method=updataLikeNew" method="post">
    请输入搜索关键字：<input type="text" name="name" align="center">
    <input type="submit" value="搜索新闻" align="center">
</form>
您搜索的结果是：
<table>
    <c:forEach items="${list}" var="newsDetail">
        <tr>
            <td width="180px" height="100px"><a href="/allNewsServlet?method=findById&id=${newsDetail.id}">${newsDetail.title}</a></td>
            <td width="180px" height="100px">${newsDetail.author}</td>
            <td width="180px" height="100px">${newsDetail.type_id}</td>
            <td width="180px" height="100px">${newsDetail.time}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
