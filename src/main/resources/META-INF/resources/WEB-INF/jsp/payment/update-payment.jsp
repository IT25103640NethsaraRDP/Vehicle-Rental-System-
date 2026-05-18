<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row justify-content-center mt-5 mb-5">
    <div class="col-md-6">
        <div class="premium-card">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h2>Edit Payment TXN-${payment.id}</h2>
                <span class="badge bg-secondary fs-6">${payment.entityType}</span>
            </div>

            <form action="/payments/update/${payment.id}" method="POST">
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Booking Reference</label>
                    <input type="text" class="form-control form-control-lg bg-light" value="BKG-${payment.booking.id}" disabled>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Amount (Rs.)</label>
                    <input type="number" step="0.01" name="amount" class="form-control form-control-lg" value="${payment.amount}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Status</label>
                    <select name="status" class="form-select form-select-lg" required>
                        <option value="SUCCESS" ${payment.status == 'SUCCESS' ? 'selected' : ''}>Success</option>
                        <option value="PENDING" ${payment.status == 'PENDING' ? 'selected' : ''}>Pending</option>
                        <option value="FAILED" ${payment.status == 'FAILED' ? 'selected' : ''}>Failed</option>
                    </select>
                </div>

                <hr class="my-4">

                <c:if test="${payment.entityType == 'OnlinePayment'}">
                    <div class="mb-3">
                        <label class="form-label fw-bold">Gateway Provider</label>
                        <input type="text" name="provider" class="form-control form-control-lg" value="${payment.gatewayProvider}">
                    </div>
                    <div class="mb-3">
                        <label class="form-label fw-bold">Transaction ID</label>
                        <input type="text" name="refNumber" class="form-control form-control-lg" value="${payment.transactionId}">
                    </div>
                </c:if>

                <c:if test="${payment.entityType == 'CardPayment'}">
                    <div class="mb-3">
                        <label class="form-label fw-bold">Card Type</label>
                        <input type="text" name="provider" class="form-control form-control-lg" value="${payment.cardType}">
                    </div>
                    <div class="mb-3">
                        <label class="form-label fw-bold">Reference Number</label>
                        <input type="text" name="refNumber" class="form-control form-control-lg" value="${payment.transactionId}">
                    </div>
                </c:if>

                <c:if test="${payment.entityType == 'CashPayment'}">
                    <div class="mb-3">
                        <label class="form-label fw-bold">Receipt Number</label>
                        <input type="text" name="refNumber" class="form-control form-control-lg" value="${payment.receiptNumber}">
                    </div>
                </c:if>

                <div class="d-grid gap-2 mt-4">
                    <button type="submit" class="btn btn-primary btn-lg fw-bold"><i class="bi bi-save"></i> Save Changes</button>
                    <a href="/payments/list" class="btn btn-outline-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="../fragments/footer.jsp" %>
