<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>管理</title>
</head>
<body>
<h2 align="center">新闻管理系统</h2>
<table align="center">
    <tbody>
    <tbody>
    <tr>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/allNewsServlet?method=AllNews">所有新闻</a></td>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/typeServlet?method=typeList">添加新闻</a></td>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/login.jsp">系统登陆</a></td>
        <td width="100px" height="60px"><a href="${pageContext.request.contextPath}/allNewsServlet?method=AllNews">新闻主页</a></td>
        <td><a href="${pageContext.request.contextPath}/LoginOut">注销</a></td>
    </tr>
    <table>
        </tbody>
    </table>
    <hr>
    <table align="center">

        <thead align="center">所有新闻列表</thead>
        <tbody>
        <tr>
            <td>新闻标题</td>
            <td>新闻作者</td>
            <td>新闻分类</td>
            <td>发布时间</td>
            <td>是否删除</td>
            <td>是否编辑</td>
        </tr>
        <c:forEach items="${list}" var="newsDetail">
            <tr>
                <td width="180px" height="100px"><a
                        href="${pageContext.request.contextPath}/allNewsServlet?method=findById&id=${newsDetail.id}">${newsDetail.title}</a></td>
                <td width="180px" height="100px">${newsDetail.author}</td>
                <td width="180px" height="100px">${newsDetail.type_id}</td>
                <td width="180px" height="100px">${newsDetail.time}</td>
                <td><a href="${pageContext.request.contextPath}/allNewsServlet?method=delect&id=${newsDetail.id}">删除</a></td>
                <td><a href="${pageContext.request.contextPath}/allNewsServlet?method=findBynewId&id=${newsDetail.id}">编辑</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    </tbody>
</table>
</body>
</html>
