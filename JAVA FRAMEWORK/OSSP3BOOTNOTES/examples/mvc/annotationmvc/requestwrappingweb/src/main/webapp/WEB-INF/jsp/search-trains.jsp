<!DOCTYPE html>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Trains</title>
</head>
<body>
    <h2>Search Trains</h2>
    <form action="${pageContext.request.contextPath}/findAvailableTrains.htm" method="post">
        Source: <input type="text" name="source"/><br/>
        Destination: <input type="text" name="destination"/><br/>
        Train Types:
            <select name="trainType">
                <option value="passenger">passenger</option>
                <option value="express">express</option>
                <option value="goods">goods</option>
                <option value="superfast">super fast</option>
                <option value="vandebharat">vande bharat</option>
            </select><br/>
        Travel Date: <input type="date" name="travelDate"><br/>
        <input type="submit" value="search trains"/>
    </form>
</body>
</html>