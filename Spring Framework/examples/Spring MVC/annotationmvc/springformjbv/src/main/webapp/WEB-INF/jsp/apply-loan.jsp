<!DOCTYPE html>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Apply Loan</title>
</head>
<body>
    <h2>Apply Loan</h2>
    <form:form modelAttribute="loanApplicationForm">
        <p style="color:red;">
            <form:errors path="*"/>
        </p>
        First Name: <form:input path="firstName"/> <br/>
        Last Name: <form:input path="lastName"/> <br/>
        Date of Birth (MM/dd/YYYY): <form:input path="dob"/> <br/>
        Gender : Male <form:radiobutton path="gender" value="Male"/> (or) Female <form:radiobutton path="gender" value="Female"/> <br/>
        Mobile No: <form:input path="mobileNumber"/><br/>
        Email Address: <form:input path="emailAddress"/><br/>
        Loan Type:
        <form:select path="loanType">
            <form:option value="">Select</form:option>
            <form:option value="home loan">Home Loan</form:option>
            <form:option value="auto loan">Automobile Loan</form:option>
            <form:option value="personal loan">Personal Loan</form:option>
        </form:select><br/>
        Loan Amount: <form:input path="loanAmount"/><br/>
        Tenure:<form:input path="tenure"/><br/>
        <input type="submit" value="apply loan"/>
    </form:form>
</body>
</html>