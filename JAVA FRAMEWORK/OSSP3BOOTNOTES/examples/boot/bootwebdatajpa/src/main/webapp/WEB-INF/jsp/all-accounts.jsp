<!DOCTYPE html>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>All Accounts</title>
    </head>
    <body>
        <h2>Accounts</h2>
        <table>
            <tr>
                <th>account no</th>
                <th>account holder name</th>
                <th>balance</th>
            </tr>
            <c:forEach items="${accounts}" var="account">
                <tr style="color: red;">
                    <td>${account.accountNo}</td>
                    <td>${account.accountHolderName}</td>
                    <td>${account.balance}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>