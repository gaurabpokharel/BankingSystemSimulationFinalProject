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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Account Application Form</title>
</head>
<body>
    <h1>Bank Account Application Form</h1>
    <form action="AccountDetailsServlet" method="post">
    
  		<input type="hidden" name="formType" value="createAccount">
  		
        <label for="fullname">Full Name:</label>
        <input type="text" id="fullname" name="fullname" required><br><br>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select><br><br>
		
		<label for="username">User Name:</label>
		<input type="text" id="username" name="username" required><br><br>

        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="sin">Social Insurance Number (SIN):</label>
        <input type="text" id="sin" name="sin" required pattern="[0-9]{3}-[0-9]{3}-[0-9]{3}" title="Enter a valid SIN number (XXX-XXX-XXX)" maxlength="11"><br><br>

        <label for="street">Street Name:</label>
        <input type="text" id="street" name="street" required><br><br>

        <label for="building">Building/Apartment Unit:</label>
        <input type="text" id="building" name="building" required><br><br>

        <label for="postalCode">Postal Code:</label>
        <input type="text" id="postalCode" name="postalCode" required pattern="[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]" title="Enter a valid postal code (e.g., A1A 1A1)"><br><br>

        <label for="accountType">Account Type:</label>
        <select id="accountType" name="accountType" required>
            <option value="checking">Checking Account</option>
            <option value="savings">Savings Account</option>
            <option value="ts">Traditional Savings</option>
            <option value="cd">Certificate of Deposit (CD)</option>
        </select><br><br>

        <label for="initialDeposit">Initial Deposit:</label>
        <input type="number" id="initialDeposit" name="initialDeposit" required><br><br>

        <label for="sourceOfFunds">Source of Funds:</label>
        <input type="text" id="sourceOfFunds" name="sourceOfFunds" required><br><br>

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
