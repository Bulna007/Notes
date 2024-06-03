<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="margin: auto; width="100%">
    <span style="align: right; width="100%">
    <c:choose>
        <c:when test="${not empty pageContext.request.userPrincipal.name}">
            Welcome ${pageContext.request.userPrincipal.name} &nbsp;
            | &nbsp; <a href="${pageContext.request.contextPath}/j_logout">Logout</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:otherwise>
    </c:choose>
    </span>
</div>