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
    <jsp:include page="/templates/head-details.jsp"/>
</head>
<body>
<div class="page-container">
<div>
    <jsp:include page="/templates/nav-bar-logged-in.jsp" />
</div>
    <div class="page-body">
<form action="/createUser" method="post">
    User Name:<br>
    <input type="text" name="userName"><br>
    Password:<br>
    <input type="password" name="password"> <br /> <br />
    <button class="btn btn-lg btn-primary" type="submit" value="Create User">Create User</button>
</form>
</div>
</div>
</body>
</html>
