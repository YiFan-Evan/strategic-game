<%--
  Created by IntelliJ IDEA.
  User: LPC
  Date: 2021/1/4
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>
            Parameter Name
        </td>
        <td>
            Parameter Value(s)
        </td>
    </tr>
    <tr>
        <td>
            ItemNum
        </td>
        <td>
            <%=request.getParameter("a")%>
        </td>
    </tr>
    <tr>
        <td>
            description
        </td>
        <td>
            <%=request.getParameter("b")%>
        </td>
    </tr>
    <tr>
        <td>
            price
        </td>
        <td>
            <%=request.getParameter("c")%>
        </td>
    </tr>
    <tr>
        <td>
            firstName
        </td>
        <td>
            <%=request.getParameter("d")%>
        </td>
    </tr>
    <tr>
        <td>
            lastName
        </td>
        <td>
            <%=request.getParameter("e")%>
        </td>
    </tr>
    <tr>
        <td>
            initial
        </td>
        <td>
            <%=request.getParameter("f")%>
        </td>
    </tr>
    <tr>
        <td>
            address
        </td>
        <td>
            <%=request.getParameter("g")%>
        </td>
    </tr>
    <tr>
        <td>
            cardType
        </td>
        <td>
            <%=request.getParameter("h")%>
        </td>
    </tr>
    <tr>
        <td>
            cardNum
        </td>
        <td>
            <li>
                <%=request.getParameter("i")%>
            </li>
            <li>
                <%=request.getParameter("j")%>
            </li>
        </td>
    </tr>
</table>
</body>
</html>
