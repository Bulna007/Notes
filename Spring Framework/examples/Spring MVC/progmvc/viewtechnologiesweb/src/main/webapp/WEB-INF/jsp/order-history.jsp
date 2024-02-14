<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Us</title>
</head>
<body>
    <h2>Order History</h2>
    <form action="${pageContext.request.contextPath}/order-history.htm?viewType=html" method="post">
        <p>Account Number: A0003983GH83</p>
        <p>Account Holder Name: Paul, J</p>
        <p>Choose months:
        <select name="months">
            <option value="3">3 Months</option>
            <option value="6">6 Months</option>
            <option value="9">9 Months</option>
            <option value="12">12 Months</option>
        </select>
        </p>
        <br/>
        <input type="submit" value="show"/>
    </form>
    <c:if test="${orders ne null}">
        <p>
            export as <a href="${pageContext.request.contextPath}/order-history.htm?months=${months}&viewType=pdf">pdf</a> (or)
                        <a href="${pageContext.request.contextPath}/order-history.htm?months=${months}&viewType=xls">xls</a>
        </p>
        <table style="border: 1px solid;">
            <tr>
                <th>Order#</th>
                <th>Order Placed Date</th>
                <th>Quantity</th>
                <th>Amount</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.orderNo}</td>
                    <td>${order.orderPlacedDate}</td>
                    <td>${order.quantity}</td>
                    <td>${order.amount}</td>
                    <td>${order.status}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>