
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp" />

<form:form method="post" modelAttribute="publisher">
    Nazwa: <form:input path="name"/><br>
    <button type="submit">Zatwierdź</button>
</form:form>
</body>
</html>
