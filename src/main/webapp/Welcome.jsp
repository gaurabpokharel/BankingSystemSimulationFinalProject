<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    // Check if the user is authenticated
    String username = (String) session.getAttribute("storedValue");
    if (username == null) {
        // If not authenticated, redirect to the login page
        response.sendRedirect("LoginPage.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome Page</title>
</head>
<body>
<p>${sessionScope.storedValue}</p>

<form action="LogoutServlet" method="post">
    <button type="submit">Logout</button>
</form>

<form action="AccountDetailsServlet" method="post">
    <input type="hidden" name="formType" value="fromWelcomeJSP">
    <button type="submit">Create a bank account</button>
</form>

<form action="DepositPageServlet" method="post">
    <input type="hidden" name="formType" value="fromWelcomeJSP">
    <button type="submit">Deposit Page</button>
</form>

<a href="DepositPage.jsp"><button></button></a><br><br>

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
