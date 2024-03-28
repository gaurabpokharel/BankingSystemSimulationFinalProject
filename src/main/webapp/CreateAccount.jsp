<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>	
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
		<input type="text" id="username" name="username" required value=""><br><br>
        
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
    var storedValue = localStorage.getItem("username");
    document.getElementById("username").setAttribute("value", storedValue);
	</script>
</html>
