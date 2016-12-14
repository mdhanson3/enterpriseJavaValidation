<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/12/16
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <jsp:include page="/templates/head-details.jsp"/>
</head>
<body>

<div class="page-container">


<div>
    <jsp:include page="/templates/nav-bar-logged-in.jsp" />
</div>
<div class="errorMessage">
    ${errorMessage}
</div>
<div class="page-body">
    Select a file to upload: <br />
    <form method="POST" action="../FileUploadServlet" enctype="multipart/form-data" >
        <input type="file" name="file" id="file" /> <br/>
        <br />
        <button class="btn btn-lg btn-primary" type="submit" value="Upload" name="upload" id="upload">Upload</button>
    </form>
</div>
</div>
</body>
</html>
