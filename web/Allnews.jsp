<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>所有新闻</title>
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
    <tbody>
    <tr>
        <td width="180px" height="100px">新闻标题</td>
        <td width="180px" height="100px">新闻作者</td>
        <td width="180px" height="100px">新闻类型</td>
        <td width="180px" height="100px">发布时间</td>
    </tr>
    <c:forEach items="${list}" var="newsDetail">
        <tr>
            <td width="180px" height="100px"><a
                    href="${pageContext.request.contextPath}/allNewsServlet?method=findById&id=${newsDetail.id}">${newsDetail.title}</a></td>
            <td width="180px" height="100px">${newsDetail.author}</td>
            <td width="180px" height="100px">${newsDetail.type_id}</td>
            <td width="180px" height="100px">${newsDetail.time}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
