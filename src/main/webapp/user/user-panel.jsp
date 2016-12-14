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
    <jsp:include page="/templates/head-details.jsp"/>
</head>
<body>
<div class="page-container">


<div>
    <jsp:include page="/templates/nav-bar-logged-in.jsp" />
</div>
<div><p>List of Files:</p></div>
<div class="page-body">
    <table>

    <c:forEach items="${fileList}" var="file">

            <tr><td><a href="/ViewFile?fileId=${file.id}">${file.fileName}</a></td>
                <td><form method="POST" action="../RemoveFile" >
                    <input type="hidden" value="${file.id}" name="fileId" />
                    <input class="btn" type="submit" value="Delete" />
                </form></td>
            </tr>

    </c:forEach>
    </table>
</div>
</div>
</body>
</html>
