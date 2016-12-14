<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  entity.User: student
  Date: 10/19/16
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>entity.User Panel</title>
</head>
<body>
<div><p>List of Files:</p></div>
<div class="fileListSection">

    <c:forEach items="${fileList}" var="file">
        <div>
            <p>${file.fileName}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
