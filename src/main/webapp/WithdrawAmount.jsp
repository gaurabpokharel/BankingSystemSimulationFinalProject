<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div class="modal fade" id="staticBackdrop3" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="jus">Withdraw Amount</h3>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="withdrawAmountForm" action="WithdrawAmountServlet" method="post" onsubmit="return validateWithdrawAmount()">

                    <input type="hidden" name="formType" value="withdrawAmount">
                    <div class="mb-4">
                        <label class="form-label" for="username">User Name</label>
                        <input type="text" id="username" name="username" class="username form-control " required />
                    </div>
                    <div class="mb-4">
                        <label class="form-label" for="accountType">Account Type</label>
                        <input type="text" id="accountType" name="accountType" value="checking" readonly class="form-control" required />
                    </div>
                    <div class="mb-4">
                        <label class="form-label" for="withdrawAmount">Amount:</label>
                        <input type="number" id="withdrawAmount" name="withdrawAmount" class="form-control" required />
                        <div id="withdrawAmountError" style="color: red; display: none;">Please enter a valid amount.</div>
                    </div>

                    <button type="submit" class="btn btn-primary">
                        Withdraw
                    </button>

                </form>
            </div>
        </div>
    </div>
</div>

<script>
    function validateWithdrawAmount() {
        var availableAmount = parseFloat("${sessionScope.amount}");
        var withdrawAmount = parseFloat(document.getElementById("withdrawAmount").value);
        var withdrawAmountField = document.getElementById("withdrawAmount");
        var withdrawAmountError = document.getElementById("withdrawAmountError");

        if (isNaN(withdrawAmount) || withdrawAmount <= 0 || withdrawAmount > availableAmount) {
            withdrawAmountField.style.borderColor = "red";
            withdrawAmountError.style.display = "block";
            return false;
        } else {
            withdrawAmountField.style.borderColor = "";
            withdrawAmountError.style.display = "none";
        }
        document.getElementById("withdrawAmountForm").submit();
    }

</script>
