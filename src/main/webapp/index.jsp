<html>
<head>
    <jsp:include page="/templates/head-details.jsp"/>
</head>
<body>
<div class="page-container">
<div>
    <jsp:include page="/templates/nav-bar-logged-in.jsp" />
</div>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <div class="page-body">
        <h2>Hi Java People</h2>
        <p>Navigate using the nav-bar or click here to <a href="${pageContext.request.contextPath}/webserviceservlet">check your ip address.</a></p>
    </div>
</div>
</body>
</html>
