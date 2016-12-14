<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/templates/head-details.jsp"/>
    <script type="text/javascript" src="scripts/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="javascript/tinymce/js/tinymce/tinymce.min.js"></script>
    <script type="text/javascript" src="javascript/validator.js"></script>
</head>
<body>
<div class="page-container">
    <div class="page-container">
        <jsp:include page="/templates/nav-bar-logged-in.jsp" />
    <div>
        <h2>Your IP Address is: ${origin}</h2>
    </div>
</div>
</body>
</html>