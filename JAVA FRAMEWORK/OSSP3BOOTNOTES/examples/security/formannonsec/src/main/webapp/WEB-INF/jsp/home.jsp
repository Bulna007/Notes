<!DOCTYPE html>
<%@page isELIgnored="false"%>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h2>Home</h2>
        <jsp:include page="header.jsp"/>
        <a href="${pageContext.request.contextPath}/loan-info">Loan Information</a>
    </body>
</html>