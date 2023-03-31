
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp" />

<div>
    Czy na pewno chcesz usunąć tego wydawcę?<br>
    id: ${publisher.id}<br>
    Tytuł: ${publisher.name}<br>
</div>

<div class="button">
    <a href="/publisher/form/delete/${publisher.id}">
        <button style="color: darkred">Potwierdź</button>
    </a>
</div>
<div class="button">
    <a href="/publisher/all">
        <button>Anuluj</button>
    </a>
</div>

</body>
</html>
