
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static"
	data-bs-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="jus">Send Money</h3>

				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form action="SendMoneyServlet" method="post">
					<input type="hidden" name="formType" value="sendMoney">
					<div class="mb-4">Available Amount: ${sessionScope.amount}</div>
					<div class="mb-4">
						<label class="form-label">Username</label> <input type="text"
							name="receiverusername" class="form-control" required />

					</div>
					<div class="mb-4">
						<label class="form-label">Email</label> <input type="email"
							name="receiveremail" class="form-control" required />

					</div>
					<div class="mb-4">
						<label class="form-label">Amount</label> <input type="number"
							name="receiveramount" class="form-control" required />

					</div>
					<button type="submit" value="Send" class="btn btn-primary">
						Send</button>
				</form>
			</div>
		</div>
	</div>
</div>