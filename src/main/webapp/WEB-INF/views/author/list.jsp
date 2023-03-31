<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>

Lista Autorów<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Imię</td>
        <td>Nazwisko</td>

    </tr>
    <c:forEach items="${authorsList}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td>
                <a href="/author/form/edit/${author.id}">
                    <button>Edytuj</button>
                </a>
            </td>
            <td>
                <a href="/author/form/confirm/${author.id}">
                    <button style="color: darkred">Usuń</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<button><a href="/author/form/add">Dodaj</a></button>
</body>
</html>