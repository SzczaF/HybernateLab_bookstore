
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp" />

<form:form method="post" modelAttribute="author">
    Imię: <form:input path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    <button type="submit">Zatwierdź</button>
</form:form>
</body>
</html>
