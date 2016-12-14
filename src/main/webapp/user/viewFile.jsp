<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/14/16
  Time: 7:20 AM
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
<h2>${fileName}</h2>
<div class="code-body">
    ${fileContent}
</div>
</div>
</body>
</html>
