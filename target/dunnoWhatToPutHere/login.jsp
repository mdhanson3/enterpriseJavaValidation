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
    <jsp:include page="/templates/head-details.jsp"/>
</head>

<body>
<div class="page-container">
<jsp:include page="templates/nav-bar-logged-in.jsp"/>



<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>

<div>
    <h4>Don't have an account? <button><a href="signup.jsp">Sign Up</a></button></h4>
</div>
</div>
</body>
</html>
