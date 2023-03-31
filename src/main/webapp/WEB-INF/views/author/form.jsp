<%--
  Created by IntelliJ IDEA.
  User: szczaf
  Date: 31.03.2023
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    Imię: <form:input path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    <button type="submit">Zatwierdź</button>
</form:form>
</body>
</html>
