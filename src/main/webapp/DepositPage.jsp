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
<title>Deposit Page</title>
</head>
<body>
	<form action="DepositPageServlet" method="post">
	 <input type="hidden" name="formType" value="depositAmount">
	
	<label for="username">User Name:</label>
	<input type="text" id="username" name="username" required><br><br>
	
	<label for="accountType">Account Type:</label>
	<input type="text" id="accountType" name="accountType" value="checking" readonly><br><br>
	
	<label for="depositAmount">Amount:</label>
	<input type="number" id="depositAmount" name="depositAmount" required><br><br>
		
	<input type="submit" value="Submit">
	</form>
</body>
<script>
    var storedValue = "${sessionScope.storedValue}";
    if (storedValue !== null && storedValue.trim() !== '') {
        document.getElementById("username").value = storedValue;
    }
</script>
</html>