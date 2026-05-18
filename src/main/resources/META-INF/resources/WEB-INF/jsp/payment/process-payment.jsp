<%@ include file="../fragments/header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
                <div class="premium-card">
                    <h2 class="mb-4 text-center">Process Payment</h2>

                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                    </c:if>

                    <form action="/payments/process" method="POST">
                        <div class="mb-4">
                            <label class="form-label fw-bold">Select Booking</label>
                            <select name="bookingId" class="form-select form-select-lg" required>
                                <option value="" disabled ${empty selectedBookingId ? 'selected' : '' }>-- Choose
                                    Booking --</option>
                                <c:forEach var="b" items="${bookings}">
                                    <option value="${b.id}" ${b.id==selectedBookingId ? 'selected' : '' }>BKG-${b.id} -
                                        ${b.customer.name} - Rs. ${b.totalCost}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label fw-bold">Payment Method</label>
                            <select name="type" id="paymentType" class="form-select form-select-lg"
                                onchange="togglePaymentFields()" required>
                                <option value="" disabled selected>-- Select Method --</option>
                                <option value="CASH">Cash at Desk</option>
                                <option value="CARD">Card</option>
                            </select>
                        </div>

                        <!-- Card type: only shown when CARD is selected -->
                        <div id="cardTypeField" class="mb-3 d-none">
                            <label class="form-label fw-bold">Card Type</label>
                            <select name="cardType" id="cardType" class="form-select form-select-lg">
                                <option value="Visa">Visa</option>
                                <option value="Mastercard">Mastercard</option>
                                <option value="Amex">American Express</option>
                                <option value="UnionPay">UnionPay</option>
                            </select>
                        </div>

                        <!-- Online gateway: only shown when ONLINE is selected -->
                        <div id="gatewayField" class="mb-3 d-none">
                            <label class="form-label fw-bold">Payment Gateway</label>
                            <select name="gateway" class="form-select form-select-lg">
                                <option value="Card">Card</option>
                            </select>
                        </div>

                        <!-- Reference number: shown for all types once method is selected -->
                        <div id="refNumberField" class="mb-4 d-none">
                            <label class="form-label fw-bold" id="refNumberLabel">Reference Number</label>
                            <input type="text" name="refNumber" id="refNumber" class="form-control form-control-lg"
                                placeholder="Enter reference / receipt number">
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-success btn-lg fw-bold"><i class="bi bi-wallet2"></i>
                                Process Payment</button>
                            <a href="/payments/list" class="btn btn-outline-secondary">View History</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="row justify-content-center mt-5 mb-5">
            <div class="col-md-10">
                <div class="premium-card">
                    <h4 class="mb-4">Payment Ledger</h4>
                    <div class="table-responsive">
                        <table class="table table-hover align-middle">
                            <thead class="table-light">
                                <tr>
                                    <th>Ref ID</th>
                                    <th>Booking Ref</th>
                                    <th>Amount</th>
                                    <th>Method</th>
                                    <th>Date</th>
                                    <th>Status</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="p" items="${payments}">
                                    <tr>
                                        <td class="fw-bold">TXN-${p.id}</td>
                                        <td>BKG-${p.booking.id}</td>
                                        <td class="fw-bold text-success">Rs. ${p.amount}</td>
                                        <td>
                                            <c:if test="${p.entityType == 'OnlinePayment'}">
                                                <span class="badge bg-primary"><i class="bi bi-globe me-1"></i>
                                                    ${p.gatewayProvider}</span><br>
                                                <small class="text-muted">Ref: ${p.transactionId}</small>
                                            </c:if>
                                            <c:if test="${p.entityType == 'CardPayment'}">
                                                <span class="badge bg-info text-dark"><i
                                                        class="bi bi-credit-card me-1"></i> ${p.cardType}</span><br>
                                                <small class="text-muted">Ref: ${p.transactionId}</small>
                                            </c:if>
                                            <c:if test="${p.entityType == 'CashPayment'}">
                                                <span class="badge bg-secondary"><i class="bi bi-cash-coin me-1"></i>
                                                    Cash</span><br>
                                                <small class="text-muted">Rec: ${p.receiptNumber}</small>
                                            </c:if>
                                        </td>
                                        <td>${p.paymentDate.toLocalDate()}</td>
                                        <td>
                                            <c:if test="${p.status == 'SUCCESS'}"><span
                                                    class="badge bg-success">Success</span></c:if>
                                            <c:if test="${p.status == 'FAILED'}"><span
                                                    class="badge bg-danger">Failed</span></c:if>
                                            <c:if test="${p.status == 'PENDING'}"><span
                                                    class="badge bg-warning text-dark">Pending</span></c:if>
                                        </td>
                                        <td>
                                            <a href="/payments/edit/${p.id}" class="btn btn-sm btn-outline-primary"
                                                title="Edit Payment">Edit</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <c:if test="${empty payments}">
                            <div class="text-center py-4 text-muted">No payments recorded yet!</div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function togglePaymentFields() {
                var type = document.getElementById("paymentType").value;
                var cardTypeField = document.getElementById("cardTypeField");
                var gatewayField = document.getElementById("gatewayField");
                var refField = document.getElementById("refNumberField");
                var refLabel = document.getElementById("refNumberLabel");

                // Hide all conditional fields first
                cardTypeField.classList.add("d-none");
                gatewayField.classList.add("d-none");

                if (type === "CARD") {
                    cardTypeField.classList.remove("d-none");
                    refLabel.textContent = "Card Reference Number";
                } else if (type === "ONLINE") {
                    gatewayField.classList.remove("d-none");
                    refLabel.textContent = "Transaction ID";
                } else if (type === "CASH") {
                    refLabel.textContent = "Receipt Number";
                }

                // Show ref number field for all types
                refField.classList.remove("d-none");
            }
        </script>
        <%@ include file="../fragments/footer.jsp" %>