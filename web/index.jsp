<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
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
  </body>
</html>
