<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>

Lista wydawców<br><br>
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
                <a href="/publisher/form/edit/${publisher.id}">
                    <button>Edytuj</button>
                </a>
            </td>
            <td>
                <a href="/publisher/form/confirm/${publisher.id}">
                    <button style="color: darkred">Usuń</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<button><a href="/publisher/form/add">Dodaj</a></button>
</body>
</html>