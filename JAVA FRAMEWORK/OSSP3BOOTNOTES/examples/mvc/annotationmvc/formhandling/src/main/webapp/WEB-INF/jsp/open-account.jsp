<!DOCTYPE html>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Open Account</title>
</head>
<body>
    <h2>Open Account</h2>
    <form:form modelAttribute="openAccountForm">
        <p style="color:red;">
            <form:errors path="*"/>
        </p>

        Firstname: <form:input path="firstName"/> <br/>
        Lastname: <form:input path="lastName"/> <br/>
        Age: <form:input path="age"/> <br/>
        Gender: Male: <form:radiobutton path="gender" value="Male"/> (or) Female: <form:radiobutton path="gender" value="Female"/><br/>
        Identity Type:
            <form:select path="identityType">
                <form:option value="aadhar">Aadhar</form:option>
                <form:option value="pan">Pan</form:option>
                <form:option value="voterid">Voter Card</form:option>
            </form:select><br/>
        Identity Number: <form:input path="identityNo"/><br/>
        Account Type:
            <form:select path="accountType">
                <form:option value="savings">Savings</form:option>
                <form:option value="current">Current</form:option>
            </form:select><br/>
        <input type="submit" value="open account"/>
    </form:form>
</body>
</html>