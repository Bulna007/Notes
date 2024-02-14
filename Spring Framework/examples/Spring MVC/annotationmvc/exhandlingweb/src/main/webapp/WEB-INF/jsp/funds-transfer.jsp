<!DOCTYPE html>
<%@page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Funds Transfer</title>
</head>
<body>
    <h2>Apply Loan</h2>
    <form:form modelAttribute="fundsTransferForm">
        <p style="color:red;">
            <form:errors path="*"/>
        </p>
        From Account: <form:input path="fromAccount"/> <br/>
        To Account: <form:input path="toAccount"/> <br/>
        Amount: <form:input path="amount"/> <br/>
        Transfer Type:
        <form:select path="transferType">
            <form:option value="">Select</form:option>
            <form:option value="neft">NEFT</form:option>
            <form:option value="rtgs">RTGS</form:option>
            <form:option value="imps">IMPS</form:option>
        </form:select><br/>
        Remarks: <form:input path="remarks"/><br/>
        <input type="submit" value="Transfer"/>
    </form:form>
</body>
</html>