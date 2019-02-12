<%--
  Created by IntelliJ IDEA.
  User: eugene
  Date: 12.02.19
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registartion</title>
</head>
<body>
<form action="RegistrationServlet">
    first name
    <input type="text" name="firstname" />
    last name
    <input type="text" name="lastname" />
    email
    <input type="text" name="email" />
    login
    <input type="text" name="username" />
    password
    <input type="password" name="password" />
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
