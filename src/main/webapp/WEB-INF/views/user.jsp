<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01/06/2020
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome</h1>
<h3>Account: ${user.getAccount()}</h3>
<h3>Name: ${user.getName()}</h3>
<h3>Email: ${user.getEmail()}</h3>
<h3>Age: ${user.getAge()}</h3>
</body>
</html>