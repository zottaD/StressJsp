<%@ page import="by.dorozhuk.stressjsp.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: eugene
  Date: 11.02.19
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>   User Logged Successfully   </title>
</head>

<body>

<center>
    <% User currentUser = (User) (session.getAttribute("currentUser"));%>

    Welcome <%= currentUser.getFirstname() + " " + currentUser.getLastname() %>
</center>

</body>

</html>

