<!DOCTYPE html>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Details</title>
</head>
<body>
    <h2>Account Details</h2>
    <p>
        Congratulations! Your account has been opened successfully, please refer to the below details
    </p>
    Account Number: ${account.accountNo} <br/>
    Account Holder name: ${account.accountHolderName} <br/>
    Branch Name: ${account.branchName}<br/>
    Ifsc Code: ${account.ifscCode}<br/>
    Status: ${account.status}
</body>
</html>