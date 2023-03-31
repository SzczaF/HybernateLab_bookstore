
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../menu.jsp" />

<form:form method="post" modelAttribute="person">
    Login<form:input path="login"/><br>
    Hasło<form:password path="password"/><br>
    Email<form:input type="email" path="email"/><br>
    <input type="submit" value="wyślij">
</form:form>
<%--<br>--%>
<%--<br>--%>
<%--<form method="post" action="/person/form">--%>
<%--Login:<input type="text" name="login"/><br>--%>
<%--Hasło:<input type="password" name="password"/><br>--%>
<%--E-mail:<input type="email" name="email"/><br>--%>
<%--<input type="submit" value="wyślij">--%>
<%--</form>--%>

</body>
</html>
