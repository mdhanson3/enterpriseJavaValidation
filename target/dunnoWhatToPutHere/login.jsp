<%--
  Created by IntelliJ IDEA.
  entity.User: student
  Date: 10/9/16
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
Dis where you login


<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>entity.User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>

</body>
</html>
