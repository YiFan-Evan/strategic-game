<%--
  Created by IntelliJ IDEA.
  User: LPC
  Date: 2020/10/11
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="j2ee" action="demore.jsp" method="get">
    Item Number:<input type="text" name="a"/>
    <br/>
    Description:<input type="text" name="b"/>
    <br/>
    Price Each:<input type="text" name="c"/>
    <hr/>
    First Name:<input type="text" name="d"/>
    <br/>
    Last Name:<input type="text" name="e"/>
    <br/>
    Middle Initial:<input type="text" name="f"/>
    <br/>
    Shipping Address:<textarea name="g" form="j2ee"></textarea>
    <br/>
    Credit Card:
    <br/>
    <input type="radio" name="h" value="Visa"/>Visa
    <br/>
    <input type="radio" name="h" value="MasterCard"/>MasterCard
    <br/>
    <input type="radio" name="h" value="American Express"/>American Express
    <br/>
    <input type="radio" name="h" value="Discover"/>Discover
    <br/>
    <input type="radio" name="h" value="Java SmartCard"/>Java SmartCard
    <br/>
    Credit Card Number:<input type="text" name="i"/>
    <br/>
    Repeat Credit Card Number:<input type="text" name="j"/>
    <br/>
    <br/>
    <script>
        for (let i = 0; i < 120; i++) {
            document.write("&nbsp;");
        }
    </script><input type="submit" value="Submit Order"/>
</form>
</body>
</html>
