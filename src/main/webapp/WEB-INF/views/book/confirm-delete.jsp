<%--
  Created by IntelliJ IDEA.
  User: szczaf
  Date: 27.03.2023
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    Czy na pewno chcesz usunąć tę księżkę?<br>
    ${book}<br>
</div>
<div>
    <a href="/book/form/delete/${book.id}">
        <button style="color: darkred">Potwierdź</button>
    </a>
    <a href="/book/all">
        <button>Anuluj</button>
    </a>
</div>
</body>
</html>
