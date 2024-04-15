<!-- Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972) -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Account</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<input type="hidden" name="formType" value="createAccount" />
			<div class="modal-body">
				<form action="AccountDetailsServlet" method="post" id="create-form" novalidate>
					<input type="hidden" value="createAccount" name="formType" />
					<div class="mb-3">
						<label for="fullname"class="form-label">Full Name</label> <input
							type="text"  value=""  name="fullname" class="form-control" / required>
							<div class="invalid-feedback">Enter Valid Data</div>
					</div>
					<div class="mb-3">
						<label for="dob" class="form-label">Date of Birth</label> <input
							type="date" class="form-control" name="dob" id="dob" / required>
							<div class="invalid-feedback">Enter Valid Data</div>
							
					</div>
					<div class="mb-3">
						<label for="gender" class="form-label">Gender:</label> <select
							id="gender" class="form-select" name="gender" required>
							<option value="male">Male</option>
							<option value="female">Female</option>
							<option value="other">Other</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="username" class="form-label">Username</label> <input
							type="text" value="" name="username"
							class="form-control username" />
							<div class="invalid-feedback">Enter Valid Data</div>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email:</label> <input
							type="email" value="myemail@email.com" name="email"
							class="form-control" id="email" />
							<div class="invalid-feedback">Enter Valid Email</div>
					</div>
					<div class="mb-3">
						<label for="sin" class="form-label">Social Insurance
							Number(SIN)</label> <input type="text" id="sin" name="sin"
							class="form-control" required
							pattern="[0-9]{3}-[0-9]{3}-[0-9]{3}"
							title="Enter a valid SIN number (XXX-XXX-XXX)" maxlength="11" />
							<div class="invalid-feedback">Enter Valid Sin Number</div>
					</div>
					<div class="mb-3">
						<label for="street" class="form-label">Street Name</label> <input
							type="text" id="street" class="form-control" name="street"
							required />
							<div class="invalid-feedback">Enter Valid Street Name</div>
					</div>
					<div class="mb-3">
						<label for="building" class="form-label">Building/Apartment
							Unit</label> <input type="text" id="building" class="form-control"
							name="building" required />
							<div class="invalid-feedback">Enter Valid Building/Apartment</div>
					</div>
					<div class="mb-3">
						<label for="postalCode" class="form-label">Postal Code</label> <input
							type="text" id="postalCode" name="postalCode" required
							class="form-control"
							pattern="[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]"
							title="Enter a valid postal code (e.g., A1A 1A1)" />
							<div class="invalid-feedback">Please enter correct Postal code.</div>
					</div>
					<div class="mb-3">
						<label for="accountType" class="form-label">Account Type</label> <select
							id="accountType" class="form-select" name="accountType" required>
							<option value="checking">Checking Account</option>
							<option value="savings">Savings Account</option>
							<option value="ts">Traditional Savings</option>
							<option value="cd">Certificate of Deposit (CD)</option>
							<option value="tfsa">Tax-Free Saving Account(TFSA)</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="initialDeposit" class="form-label">Initial
							Deposit</label> <input type="number" id="initialDeposit"
							class="form-control" name="initialDeposit" required />
							
					</div>
					<div class="mb-3">
						<label for="sourceOfFunds" class="form-label">Source of
							Funds</label> <input type="text" id="sourceOfFunds" class="form-control"
							name="sourceOfFunds" required />
							<div class="invalid-feedback">Please enter correct source of fund.</div>
							
					</div>
					<input type="submit" value="Submit" />
				</form>
			</div>
		</div>
	</div>
</div>
<script>
var form = document.getElementById("create-form");
form.addEventListener("submit", function(event) {
  if (!form.checkValidity()) {
    event.preventDefault();
    event.stopPropagation();
  }

  form.classList.add("was-validated");
});
</script>
