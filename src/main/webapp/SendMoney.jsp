
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String username = (String) session.getAttribute("storedValue");
    if (username == null) {
        response.sendRedirect("LoginPage.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interac e-transfer</title>
</head>
<body>
<% String message = (String) request.getAttribute("message"); %>
<% if (message != null) { %>
    <p><%= message %></p>
<% } %>
${sessionScope.storedValue}
<form action="SendMoneyServlet" method="post">
<input type="hidden" name="formType" value="sendMoney">
Available Amount:${sessionScope.amount}<br>
User name:<input type="text" name="receiverusername"><br>
Email:<input type ="email" name="receiveremail"><br>
Amount:<input type="number" name="receiveamount"><br>
<input type="submit" value="Send">
</form>
</html>