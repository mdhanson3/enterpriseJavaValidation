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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="style.css" type="text/css">

    <title>Java Validation</title>
</head>
<body>
<div class="errorMessage">
    ${errorMessage}
</div>
<div>
    Select a file to upload: <br />
    <form method="POST" action="../FileUploadServlet" enctype="multipart/form-data" >
        <input type="file" name="file" id="file" /> <br/>
        <br />
        <input type="submit" value="Upload" name="upload" id="upload" />
    </form>
</div>
</body>
</html>
