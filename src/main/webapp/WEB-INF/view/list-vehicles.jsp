<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vehicles List</title>
    <link type="text/css"
          rel="stylesheet"
          href="" />
</head>
<body>
Hello World!
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="logout" />
</form:form>
</body>
</html>