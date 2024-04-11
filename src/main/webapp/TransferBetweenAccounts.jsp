<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="jus">Transfer Between Account</h3>

				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="TransferBetweenAccountsServlet" method="post">
					<input type="hidden" value="transferMoney" name="formType">
					<div class="mb-4">
						<label class="form-label">From</label> <select class="form-select"
							name="fromAccount" required>
							<%
							List<String> accountTypes = (List<String>) session.getAttribute("accountType");
							if (accountTypes != null) {
								for (String accountType : accountTypes) {
							%>
							<option value="<%=accountType%>"><%=accountType%></option>
							<%
							}
							}
							%>

						</select>
					</div>
					<div class="mb-4">
						<label class="form-label">To</label> <select class="form-select"
							name="toAccount">
							<%
							if (accountTypes != null) {
								for (String accountType : accountTypes) {
							%>
							<option value="<%=accountType%>">
								<%=accountType%>
							</option>
							<%
							}
							}
							%>
						</select>
					</div>
					<div class="mb-4">
						<label>Amount to transfer</label> <input type="number"
							name="transferamount" class="form-control" />
					</div>

					<button type="submit" value="Send" class="btn btn-primary">
						Send</button>
				</form>
			</div>
		</div>
	</div>
</div>
