<!-- Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972) -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- Send Money Modal -->
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
                <form id="sendMoneyForm" action="SendMoneyServlet" method="post" onsubmit="return validateSendMoneyForm()">
                    <input type="hidden" name="formType" value="sendMoney">
                    <div class="mb-4">Available Amount: <span id="availableAmount">${sessionScope.amount}</span></div>
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
                            id="receiverAmount2" name="receiveramount" class="form-control" required />
                        <div id="receiverAmountError2" style="color: red; display: none;">Please enter a valid amount.</div>
                    </div>
                    <button type="submit" class="btn btn-primary">
                        Send
                    </button>
                    <div id="errorMessage2" style="color: red; display: none;"></div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    // Get available amount from the span element
    var availableAmount = parseFloat("${sessionScope.amount}");

    function validateSendMoneyForm() {
        var receiverAmount = parseFloat(document.getElementById("receiverAmount2").value);
        var receiverAmountField = document.getElementById("receiverAmount2");
        var receiverAmountError = document.getElementById("receiverAmountError2");
        var errorMessage = document.getElementById("errorMessage2");

        if (isNaN(receiverAmount) || receiverAmount <= 0 || receiverAmount > availableAmount) {
            receiverAmountField.style.borderColor = "red";
            receiverAmountError.style.display = "block";
            errorMessage.style.display = "none";
            return false;
        } else {
            receiverAmountField.style.borderColor = "";
            receiverAmountError.style.display = "none";
            errorMessage.style.display = "none";
            return true;
        }
    }
</script>
