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
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
<%--            <td>${book.author.fullName}</td>--%>
            <td>
                <a href="/book/form/edit/${book.id}">
                    <button>Edytuj</button>
                </a>
            </td>
            <td>
                <a href="/book/form/delete/${book.id}">
                    <button style="color: darkred">Usuń</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>