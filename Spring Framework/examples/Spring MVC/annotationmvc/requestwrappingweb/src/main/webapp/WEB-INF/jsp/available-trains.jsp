<!DOCTYPE html>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Available Trains</title>
</head>
<body>
    <h2>Available Trains</h2>
    <table>
        <tr>
            <th>Train No</th>
            <th>Source Station</th>
            <th>Destination Station</th>
            <th>Train Type</th>
            <th>Duration (Hrs)</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
        </tr>
        <c:forEach items="${availableTrains}" var="train">
            <tr>
                <td>${train.trainNo}</td>
                <td>${train.source}</td>
                <td>${train.destination}</td>
                <td>${train.trainType}</td>
                <td>${train.duration}</td>
                <td>${train.departureTime}</td>
                <td>${train.arrivalTime}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>