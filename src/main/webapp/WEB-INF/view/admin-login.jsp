<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="css/admin-login-style.css"/>
    </head>
    <body>
        <p class="header">Log In</p>

<!--
        <form class="form">

        	<h2>Admin Login</h2>

        	<input type="text" name="username" class="text-field" placeholder="Username" />
            <input type="password" name="password" class="text-field" placeholder="Password" />

          <a href=""><input type="button"  class="button" value="Log In" /></a>

        </form>
-->

        <form:form class="form" action="${pageContext.request.contextPath}/authenticateTheUser"
                    method="POST">
            <h2>Admin Login</h2>
            <br/>
            <c:if test="${param.error != null}">
                <div class="">
                    <h4>Invalid username or password.</h4>
                </div>
            </c:if>

            <c:if test="${param.logout != null}">
                <div class="">
                    You have been logged out.
                </div>
            </c:if>

            <input type="text" name="username" class="text-field" placeholder="Username" />
            <input type="password" name="password" class="text-field" placeholder="Password" />

          <input type="submit" class="button" value="Log In" />
        </form:form>
    </body>
</html>