<%--
  Created by IntelliJ IDEA.
  User: LPC
  Date: 2020/10/10
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="domain.User" %>
<% User user =(User) request.getSession().getAttribute("user"); %>
<html>
<head>
    <title>Title</title>
</head>N
<body>N
    <%=user.getName()%>注册成功
    <% request.getSession().removeAttribute("user");%>
    <a href="../src/login.jsp">
        返回登陆页面
    </a>
</body>

</html>
