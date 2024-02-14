<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Signup form</title>
</head>
<body>
    <h2>Signup</h2>
    <form:form modelAttribute="signupForm">
        <div style="color:red;">
            <form:errors path="*"/>
        </div>
        Email Address: <form:input path="emailAddress"/> <br/>
        Password: <form:password path="password"/> <br/>
        Re-Type Password: <form:password path="reTypePassword"/> <br/>
        Full Name: <form:input path="fullname"/><br/>
        Gender: Male: <form:radiobutton path="gender" value="Male"/> (or) Female: <form:radiobutton path="gender" value="Female"/> <br/>
        Age: <form:input path="age"/><br/>
        <input type="submit" value="sigup"/>
    </form:form>
</body>
</html>