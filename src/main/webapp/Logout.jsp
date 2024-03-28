<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <script>
        function logout() {
            // Clear all items from local storage
            localStorage.clear();
            
            // Redirect the user to the login page
            window.location.href = "LoginPage.jsp"; // Replace "login.jsp" with the actual login page URL
        }
        window.onload = function() {
            var storedValue = localStorage.getItem("username");
            if (!storedValue) {
                // Redirect to login page
                window.location.href = "LoginPage.jsp"; // Replace "login.jsp" with the actual login page URL
            }
        };
    </script>
</head>
<body>

</body>
</html>