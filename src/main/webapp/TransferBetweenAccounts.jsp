<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String username = (String) session.getAttribute("storedValue");
    if (username == null) {
        response.sendRedirect("LoginPage.jsp");
        return; // Stop further execution
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="TransferBetweenAccountsServlet" method="post">
<input type="hidden" name="formType" value="transferMoney">
    From:
     <select name="fromAccount">
        <% 
        List<String> accountTypes = (List<String>) session.getAttribute("acountType");
        if (accountTypes != null) {
            for (String accountType : accountTypes) {
        %>
        <option value="<%= accountType %>"><%= accountType %></option>
        <%
            }
        }
        %>
    </select>
    <br>
    To:
    <select name="toAccount">
        <% 
        if (accountTypes != null) {
            for (String accountType : accountTypes) {
        %>
        <option value="<%= accountType %>"><%= accountType %></option>
        <%
            }
        }
        %>
    </select>
    <br>
Amount:<input type="number" name ="transferamount">
Date:<input type="date" id="dateInput" value="">
<input type="submit" value="Send">
</form>
</body>
<script>
    // Get today's date
    var today = new Date();

    // Format date to yyyy-mm-dd
    var formattedDate = today.toISOString().substr(0, 10);

    // Set the input field value to today's date
    document.getElementById("dateInput").value = formattedDate;
</script>
</html>