<%@ page import="domain.User" %><% User user =(User) request.getSession().getAttribute("user"); %><%--
  Created by IntelliJ IDEA.
  User: LPC
  Date: 2020/3/26
  Time: 13:56
  To change this template use File | Settings | File Templates.z
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%=user.getUsername()%>,欢迎您</h1>
</body>
</html>
