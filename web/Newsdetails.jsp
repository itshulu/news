<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
    <h2 align="center">新闻管理系统</h2>
    <table align="center">
        <tbody>
        <tr>
            <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/allNewsServlet?method=allNews">所有新闻</a></td>
            <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/search.jsp">搜索新闻</a></td>
            <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/login.jsp">后台管理</a></td>
        </tr>
        </tbody>
    </table>
    <hr>
    <table align="center">
        <tr>
            <td>新闻标题：</td>
            <td>${detail.title}</td>
        </tr>
        <tr>
            <td>新闻类型：</td>
            <td>${detail.type_id}</td>
        </tr>
        <tr>
            <td>新闻作者：</td>
            <td>${detail.author}</td>
        </tr>
        <tr>
            <td>新闻内容：</td>
            <td>${detail.content}</td>
        </tr>
        <tr>
            <td>发布时间：</td>
            <td>${detail.time}</td>
        </tr>
    </table>
</body>
</html>
