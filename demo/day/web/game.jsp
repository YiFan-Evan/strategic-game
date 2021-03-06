<%@ page import="domain.User" %>
<%@ page import="java.net.Socket" %>
<%@ page import="web.servlet.Client" %><%--
  Created by IntelliJ IDEA.
  User: LPC
  Date: 2021/3/5
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user=(User) session.getAttribute("user");
int isStart=0;
Client client=null;
StringBuilder message= new StringBuilder();
if(session.getAttribute("client") != null){
    client=(Client) session.getAttribute("client");
    isStart=1;
    for (int i=0;i<client.current;i++){
        message.append(client.message.get(i).substring(0, client.length.get(i)).replace('\r', '@').replace('\n', '#').replace('\0', '%'));
    }
    System.out.println(message);
}
%>
<script>
</script>
<html>
<head>
    <title>决策游戏</title>
</head>
<body>
<form method="get" action="/clientServlet">
    <input type="submit" value="开始游戏">
</form>
<label>
    <textarea cols="90" rows="130" id="123">
    </textarea>
</label>
<form method="get" action="/answerServlet">
    <input type="text" name="operate">
    <input type="submit">
</form>

<script>
    <%--setInterval(function(){--%>
    <%--    <%if(session.getAttribute("client") != null){%>--%>
    <%--        var str="<%=((Client) session.getAttribute("client")).message %>"--%>
    <%--        alert(str);--%>
    <%--    <%}%>--%>
    <%--}, 10000);--%>
    var isStart="<%=isStart%>";
    var str="<%=message.toString()%>".replace(/@/g,'\r').replace(/#/g,'\n').replace(/%/g,'\0');
    function fun(){
        return str;
    }
    document.getElementById("123").innerHTML+=str;
</script>
</body>
</html>
