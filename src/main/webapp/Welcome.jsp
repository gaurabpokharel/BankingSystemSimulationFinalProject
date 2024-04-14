<%@page import="java.sql.Date"%>
<%@page import="com.project.model.TransactionDetails"%>
<%@page import="com.project.dao.TransactionDetailsDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.project.dao.AccountDetailsDao"%>
<%@page import="java.util.List"%>
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
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Dashboard</title>
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/dashboard.css" />
<jsp:include page="DepositPage.jsp" />
<jsp:include page="SendMoney.jsp" />
<jsp:include page="TransferBetweenAccounts.jsp" />
<jsp:include page="CreateAccount.jsp" />
<jsp:include page="WithdrawAmount.jsp" />
<jsp:include page="PayUtilities.jsp" />


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />

<link
	href="https://fonts.googleapis.com/css2?family=Cambay:ital,wght@0,400;0,700;1,400;1,700&display=swap"
	rel="stylesheet" />
</head>
<body>

<%
String error = (String) request.getAttribute("error");
if (error != null) {
%>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
    <%= error %>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%
}
%>

	<nav class="nav">
		<div class="left-nav">
			<h1>HB</h1>
		</div>
		<div class="right-nav">
			<ul>
				<li>Home</li>
				<li>About Us</li>
				<li>Contact Us</li>
				<li><form action="LogoutServlet" method="post">
						<button type="submit" class="btn btn-primary">Logout</button>

					</form></li>
			</ul>
		</div>
	</nav>
	<div class="dashboard-container">
		<div class="left-wrapper">
			<div class="left-header">
				<h2 class="totalamount">
					Total Balance: $<%=AccountDetailsDao.getTotalBalance(username)%></h2>
				<div>
					<h1 id="time"></h1>
					<canvas id="myChart"></canvas>
				</div>

				<div class="my_account">
					<div class="my_account_header">
						<h2>Accounts</h2>
						<button type="button" class="btn action_btn"
							data-bs-toggle="modal" data-bs-target="#exampleModal">
							<i class="fa-solid fa-plus"></i> Add account
						</button>
					</div>
					<%
					AccountDetailsDao dao = new AccountDetailsDao();
					HashMap<String, Float> accountTypesAndBalances = dao
							.getAccountTypeAndBalance((String) session.getAttribute("storedValue"));
					for (Map.Entry<String, Float> entry : accountTypesAndBalances.entrySet()) {
						String accountType = entry.getKey();
						Float balance = entry.getValue();
					%>
					<button type="button" class="account_btn">
						<div class="account_name">
							<p><%=accountType%></p>
						</div>
						<div class="account_amount">
							<p>
								$<%=balance%></p>
						</div>
					</button>

					<%
					}
					%>


				</div>
			</div>
		</div>

		<div class="right-wrapper">
			<h1>Financial Operations</h1>
			<div class="btn-container">
				<div class="row row-gap">
					<form action="#" method="post">
						<input type="hidden" name="formType" value="fromWelcomeJSP">
						<button type="button" class="action_btn extra_space"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop">
							<div class="button_content">
								<img
									src="   https://cdn-icons-png.flaticon.com/512/4221/4221591.png "
									width="40" height="40" alt="" title="" class="img-small">
								<span>Deposit Amount</span>
							</div>
						</button>
					</form>

					<form action="TransferBetweenAccountsServlet" method="post">
						<input type="hidden" name="formType" value="fromWelcomeJSP">
						<button type="submit" class="action_btn extra_space"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop1">
							<div class="button_content">
								<img
									src="https://cdn-icons-png.flaticon.com/512/2534/2534219.png"
									width="40" height="40" alt="" title="" class="img-small">
								<span>Transfer Amount</span>
							</div>
						</button>
					</form>
				</div>
				<div class="row row-gap">
					<form action="SendMoneyServlet" method="post">
						<input type="hidden" name="formType" value="fromWelcomeJSP">
						<button type="submit" class="action_btn extra_space"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop2">
							<div class="button_content">
								<img
									src="   https://cdn-icons-png.flaticon.com/512/2842/2842866.png "
									width="40" height="40" alt="" title="" class="img-small">
								<span>Interac e-transfer</span>
							</div>
						</button>
					</form>
					<form action="WithdrawAmountServlet" method="post">
						<input type="hidden" name="formType" value="fromWelcomeJSP">
						<button type="submit" class="action_btn extra_space"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop3">
							<div class="button_content">
								<img
									src="https://cdn-icons-png.flaticon.com/512/3678/3678679.png "
									width="40" height="40" alt="" title="" class="img-small">
								<span>Withdraw Money</span>
							</div>
						</button>
					</form>
				</div>
				<div class="row row-gap">
					<form action="PayUtilitiesServlet" method="post">
						<input type="hidden" name="formType" value="fromWelcomeJSP">
						<button type="submit" class="action_btn extra_space"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop4">
							<div class="button_content">
								<img
									src="https://cdn-icons-png.flaticon.com/512/3678/3678679.png "
									width="40" height="40" alt="" title="" class="img-small">
								<span>Pay Utilities</span>
							</div>
						</button>
					</form>
				</div>
			</div>

			<div class="transaction-history">
				<h2>Transaction History</h2>
				<h3>Received</h3>
				<div class="transaction-container">
					<%
					TransactionDetailsDao dao1 = new TransactionDetailsDao();
					List<TransactionDetails> transactionList = dao1.getAllTransactionDetails(username);
					for (TransactionDetails transaction : transactionList) {
						String fromUsername = transaction.getFromUserName();
						Date transactionDate = transaction.getTransactionDate();
						float amount = transaction.getAmount();
					%>
					<div class="transaction-wrapper">
						<div class="left-container">
							<h5>
								From:
								<%=fromUsername%></h5>
							<h5><%=transactionDate%></h5>
							<!-- Adjust date formatting as needed -->
						</div>
						<div class="right-container">
							<h4>
								$<%=amount%></h4>
						</div>
					</div>
					<%
					}
					%>
				</div>

				<h3>Send</h3>
				<div class="transaction-container">
					<%
					transactionList = dao1.getAllToTransactionDetails(username);
					for (TransactionDetails transaction : transactionList) {
						String toUsername = transaction.getToUserName();
						Date transactionDate = transaction.getTransactionDate();
						float amount = transaction.getAmount();
					%>
					<div class="transaction-wrapper">
						<div class="left-container">
							<h5>
								To :
								<%=toUsername%></h5>
							<h5><%=transactionDate%></h5>
							<!-- Adjust date formatting as needed -->
						</div>
						<div class="right-container">
							<h4>
								- $<%=amount%></h4>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>


		</div>
	</div>
	<script>
      var storedValue = "<%=username != null ? username : ""%>";
      if (storedValue.trim() !== '') {
          var usernameInputs = document.querySelectorAll(".username");
          for (var i = 0; i < usernameInputs.length; i++) {
              usernameInputs[i].value = storedValue;
          }
      }
      var today = new Date();
      var formattedDate = today.toISOString().substr(0, 10);
      document.getElementById("dateInput").value = formattedDate;
      
      var showModal = "<%=session.getAttribute("showModal")%>";
      if (showModal && showModal === "true") {
          window.addEventListener('load', function(e) {
        	  e.preventDefault();
              var myModal = new bootstrap.Modal(document.getElementById('staticBackdrop1'));
              myModal.show();
              <%session.setAttribute("showModal", false);%>
          });
      }

      var showModal2 = "<%=session.getAttribute("showModal2")%>";
		if (showModal2 && showModal2 === "true") {
			window.addEventListener('load', function() {
				var myModal2 = new bootstrap.Modal(document
						.getElementById('staticBackdrop2'));
				myModal2.show();
	<%session.setAttribute("showModal2", false);%>
		});
		}
		
	      var showModal3 = "<%=session.getAttribute("showModal3")%>";
		if (showModal3 && showModal3 === "true") {
			window.addEventListener('load', function() {
				var myModal3 = new bootstrap.Modal(document
						.getElementById('staticBackdrop3'));
				myModal3.show();
	<%session.setAttribute("showModal3", false);%>
		});
		}
		
		 var showModal4 = "<%=session.getAttribute("showModal4")%>";
		if (showModal4 && showModal4 === "true") {
			window.addEventListener('load', function() {
				var myModal4 = new bootstrap.Modal(document
						.getElementById('staticBackdrop4'));
				myModal4.show();
	<%session.setAttribute("showModal4", false);%>
		});
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="https://kit.fontawesome.com/ea02458a39.js"
		crossorigin="anonymous"></script>
	<script>
		const ctx = document.getElementById("myChart");
		new Chart(ctx,
				{
					type : "line",
					data : {
						labels : [ "Red", "Blue", "Yellow", "Green", "Purple",
								"Orange" ],
						datasets : [ {
							label : "Amount",
							data : [ 12, 19, 3, 5, 2, 3 ],
							borderWidth : 1,
						}, ],
					},
					options : {
						scales : {
							x : {
								grid : {
									display : false, // hide x-axis grid lines
								},
							},
							y : {
								grid : {
									display : false, // hide y-axis grid lines
								},
								beginAtZero : true,
							},
						},
					},
				});
	</script>
</body>
</html>
