<%--
  Created by IntelliJ IDEA.
  User: szczaf
  Date: 31.03.2023
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    Nazwa: <form:input path="name"/><br>
    <button type="submit">Zatwierdź</button>
</form:form>
</body>
</html>
