<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="staticBackdrop3" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="jus">Withdraw Amount</h3>

				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="WithdrawAmountServlet" method="post">

					<input type="hidden" name="formType" value="withdrawAmount">
					<div class="mb-4">
						<label class="form-label" for="username">User Name</label> <input
							type="text" name="username" class="username form-control "
							required />
					</div>
					<div class="mb-4">
						<label class="form-label" for="accountType">Account Type</label> <input
							type="text" id="accountType" name="accountType" value="checking"
							readonly class="form-control" required />
					</div>
					<div class="mb-4">
						<label class="form-label" for="withdrawAmount">Amount:</label> <input
							type="number" id="depositAmount" name="withdrawAmount"
							class="form-control" required />
					</div>

					<button type="submit" value="submit" class="btn btn-primary">
						Withdraw</button>

				</form>
			</div>
		</div>
	</div>
</div>

<script>
	var storedValue = "${sessionScope.storedValue}";
	if (storedValue !== null && storedValue.trim() !== '') {
		document.getElementById("username").value = storedValue;
	}
</script>