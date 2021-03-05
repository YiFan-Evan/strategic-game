<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <script>
        window.onload=function () {
            document.getElementById("img").onclick=function () {
                this.src="checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="registerServlet" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
<a href="login.jsp">登录</a>
<div>${requestScope.cc_error}</div>
<div>${requestScope.cc_notfound}</div>
</body>
</html>
