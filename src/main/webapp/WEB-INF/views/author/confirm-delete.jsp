
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../menu.jsp" />

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
