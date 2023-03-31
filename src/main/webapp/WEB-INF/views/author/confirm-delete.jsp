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
    <style>
        div.button {
            float: left;
            padding-top: 15px;
            padding-right: 15px;
        }

    </style>
</head>
<body>
<div>
    Czy na pewno chcesz usunąć tego autora?<br>
    id: ${author.id}<br>
    Tytuł: ${author.getFullname}<br>
</div>

<div class="button">
    <a href="/author/form/delete/${author.id}">
        <button style="color: darkred">Potwierdź</button>
    </a>
</div>
<div class="button">
    <a href="/author/all">
        <button>Anuluj</button>
    </a>
</div>

</body>
</html>
