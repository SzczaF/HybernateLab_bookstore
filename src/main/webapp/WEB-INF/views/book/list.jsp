<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp"/>


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
                <a href="/book/form/confirm/${book.id}">
                    <button style="color: darkred">Usuń</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<button><a href="/book/form/add">Dodaj</a></button>
</body>
</html>