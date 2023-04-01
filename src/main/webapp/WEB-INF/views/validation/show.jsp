<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../menu.jsp"/>



  <c:forEach items="${messageList}" var="message">
    ${message.propertyPath} = ${message.message}<br>
  </c:forEach>

<br>

</body>
</html>