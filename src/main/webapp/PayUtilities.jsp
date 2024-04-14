<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="staticBackdrop4" data-bs-backdrop="static"
    data-bs-keyboard="false" tabindex="-1"
    aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="jus">Pay Utilities</h3>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="payUtilitiesForm" action="PayUtilitiesServlet" method="post" onsubmit="return validateForm()">

                    <input type="hidden" name="formType" value="payUtilities">
                    <div class="mb-4">Available Amount: ${sessionScope.amount}</div>
                    <div class="mb-4">
                        <label class="form-label" for="payUsername">User Name</label>
                        <input type="text" id="payUsername" name="username" class="username form-control" required />
                    </div>
                    <div class="mb-4">
                        <label class="form-label" for="payAccountType">Account Type</label>
                        <input type="text" id="payAccountType" name="accountType" value="checking" readonly class="form-control" required />
                    </div>
                    <div class="mb-4">
                        <label class="form-label" for="payWithdrawAmount">Amount:</label>
                        <input type="number" id="payWithdrawAmount" name="withdrawAmount" class="form-control" required />
                        <div id="payWithdrawAmountError" style="color: red; display: none;">Please enter a valid amount.</div>
                    </div>
                    <div class="mb-3">
                        <label for="payTo" class="form-label">Payee</label>
                        <select id="payTo" class="form-select" name="payTo" required>
                            <option value="Hydro">Hydro</option>
                            <option value="Electricity">Electricity</option>
                            <option value="Insurance">Insurance</option>
                            <option value="Mortgage">Mortgage</option>
                            <option value="Lambton College">Lambton College</option>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-primary">
                        Withdraw
                    </button>
                    <div id="payWithdrawAmountError" style="color: red; display: none;">Please enter a valid amount.</div>

                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function validateForm() {
        var availableAmount = parseFloat("${sessionScope.amount}");
        var withdrawAmount = parseFloat(document.getElementById("payWithdrawAmount").value);
        var withdrawAmountField = document.getElementById("payWithdrawAmount");
        var withdrawAmountError = document.getElementById("payWithdrawAmountError");

        if (isNaN(withdrawAmount) || withdrawAmount <= 0 || withdrawAmount > availableAmount) {
            withdrawAmountField.style.borderColor = "red";
            withdrawAmountError.style.display = "block";
            return false;
        } else {
            withdrawAmountField.style.borderColor = "";
            withdrawAmountError.style.display = "none";
        }
        document.getElementById("payUtilitiesForm").submit();
    }

    var storedValue = "${sessionScope.storedValue}";
    if (storedValue !== null && storedValue.trim() !== '') {
        document.getElementById("payUsername").value = storedValue;
    }
</script>
