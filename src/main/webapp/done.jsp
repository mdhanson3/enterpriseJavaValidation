<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--

--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <jsp:include page="/templates/head-details.jsp"/>

    <script type="text/javascript" src="/javascript/hover.js"></script>

</head>
<body>
<div class="page-container">
<jsp:include page="/templates/nav-bar-logged-in.jsp"/>

    <div>
        <h2>${fileName}</h2>
    </div>
    <div class="code-body">

        <c:forEach var="line" items="${fileContents}">
            ${line}


        </c:forEach>
    </div>
</div>
</body>
</html>