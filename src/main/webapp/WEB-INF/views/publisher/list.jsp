<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 19.03.2023
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/book/form/add">Dodaj książkę</a><br><br>
Lista książek<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Tytuł</td>
        <td>Rating</td>
        <td>Opis</td>
        <td>Wydawca</td>
    </tr>
    <c:forEach items="${publishersList}" var="publisher">
        <tr>
            <td>${publisher.id}</td>
            <td>${publisher.name}</td>

            <td>
                <a href="/author/form/edit/${publisher.id}">
                    <button>Edytuj</button>
                </a>
            </td>
            <td>
                <a href="/author/form/confirm/${publisher.id}">
                    <button style="color: darkred">Usuń</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>