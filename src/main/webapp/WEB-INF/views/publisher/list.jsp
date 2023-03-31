
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp" />

Lista książek<br><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Nazwa</td>

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