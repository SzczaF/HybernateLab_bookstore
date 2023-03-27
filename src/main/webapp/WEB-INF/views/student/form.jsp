<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szczaf
  Date: 19.03.2023
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--firstName (pole tekstowe)--%>
<%--lastName (pole tekstowe)--%>
<%--gender (radio button)--%>
<%--country (select z możliwością pojedynczego wyboru)--%>
<%--notes (textarea)--%>
<%--mailingList (checkbox)--%>
<%--programmingSkills (select z możliwością wyboru wielu opcji)--%>
<%--hobbies (grupa checkboxów)--%>

<form:form modelAttribute="student">
    Imie: <form:input path="firstName"/><br>
    Nazwisko: <form:input path="lastName"/><br>
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/><br>
    Kraj:
    <form:select path="country">
        <form:option value="-" label="--Please Select--"/>
        <form:options items="${countryItems}"/>
    </form:select><br>
    Notatki: <form:textarea path="notes"/><br>
    Lista Mailingowa: <form:checkbox path="mailingList"/><br>
    Lista języków:
    <form:select path="programmingSkills" multiple="true">
        <form:options items="${skillsItems}"/>
    </form:select><br>
    Hobby: <form:checkboxes path="hobbies" items="${hobbyItems}"/><br>
    <input type="submit"/>

</form:form>
</body>
</html>
