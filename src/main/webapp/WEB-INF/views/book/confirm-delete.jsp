
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp" />
<div>
    Czy na pewno chcesz usunąć tę księżkę?<br>
    id: ${book.id}<br>
    Tytuł: ${book.title}<br>
</div>

<div class="button">
    <a href="/book/form/delete/${book.id}">
        <button style="color: darkred">Potwierdź</button>
    </a>
</div>
<div class="button">
    <a href="/book/all">
        <button>Anuluj</button>
    </a>
</div>

</body>
</html>
