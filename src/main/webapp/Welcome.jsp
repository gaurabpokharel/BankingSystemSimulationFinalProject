<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome Page</title>
</head>
<body>
<p>${sessionScope.storedValue}</p>
<button onclick="logout()">Logout</button><br><br>
<a href="CreateAccount.jsp"><button>Create a bank account</button></a><br><br>

<a href="DepositPage.jsp"><button>Deposit Page</button></a><br><br>

<form action="SendMoneyServlet" method="post">
    <input type="hidden" name="formType" value="fromWelcomeJSP">
    <button type="submit">Interac e-Transfer</button>
</form>
<br>

<form action="TransferBetweenAccountsServlet" method="post">
	<input type="hidden" name="formType" value="fromWelcomeJSP">
    <button type="submit">Transfer between accounts</button>
</form>


</body>
</html>
