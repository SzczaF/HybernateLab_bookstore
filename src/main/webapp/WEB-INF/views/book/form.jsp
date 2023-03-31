
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp" />

<form:form method="post" modelAttribute="book">
    Tytuł: <form:input path="title"/><br>
    Ocena: <form:input path="rating" type="number"/><br>
    Opis: <form:textarea path="description"/><br>
    Wydawca:
    <form:select path="publisher.id">
        <form:option value="0" label="-- wybierz --"/>
        <form:options items="${publishersList}" itemLabel="name" itemValue="id"/>
    </form:select><br>
    Autor:
    <form:select path="authors" multiple="true">
        <form:options items="${authorsList}" itemLabel="fullName" itemValue="id"/>
    </form:select><br>

    <button type="submit">Zatwierdź</button>

</form:form>

</body>
</html>