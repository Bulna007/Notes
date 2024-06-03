<!DOCTYPE html>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <h2>Login</h2>
        <p style="color: red;">
            <c:if test="${param.error eq ''}">
                Bad Credentials
            </c:if>
        </p>
        <form method="POST" action="${pageContext.request.contextPath}/j_login">
            <p>
                Username: <input type="text" name="j_username"/>
            </p>
            <p>
                Password: <input type="password" name="j_password"/>
            </p>
            <button type="submit">Login</button>
        </form>
    </body>
</html>