<%--
  Created by IntelliJ IDEA.
  entity.User: student
  Date: 10/19/16
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>entity.User Sign Up</title>
</head>
<body>
<form action="/createUser" method="post">
    User Name:<br>
    <input type="text" name="userName"><br>
    Password:<br>
    <input type="password" name="password"> <br /> <br />
    <input type="submit" value="Create User">
</form>
</body>
</html>
