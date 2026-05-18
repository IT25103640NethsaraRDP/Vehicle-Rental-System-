<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="premium-card mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="m-0">Payment Ledger</h2>
        <a href="/payments/process" class="btn btn-success">+ Record Payment</a>
    </div>
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
                        <td><a href="/bookings/list">BKG-${p.booking.id}</a></td>
                        <td class="fw-bold text-success">Rs. ${p.amount}</td>
                        <td>
                            <c:if test="${p.entityType == 'OnlinePayment'}">
                                <span class="badge bg-primary"><i class="bi bi-globe me-1"></i> ${p.gatewayProvider}</span><br>
                                <small class="text-muted">ID: ${p.transactionId}</small>
                            </c:if>
                            <c:if test="${p.entityType == 'CardPayment'}">
                                <span class="badge bg-info text-dark"><i class="bi bi-credit-card me-1"></i> ${p.cardType}</span><br>
                                <small class="text-muted">Ref: ${p.transactionId}</small>
                            </c:if>
                            <c:if test="${p.entityType == 'CashPayment'}">
                                <span class="badge bg-secondary"><i class="bi bi-cash-coin me-1"></i> Cash</span><br>
                                <small class="text-muted">Rec: ${p.receiptNumber}</small>
                            </c:if>
                        </td>
                        <td>${p.paymentDate.toLocalDate()}</td>
                        <td>
                            <c:if test="${p.status == 'SUCCESS'}"><span class="badge bg-success">Success</span></c:if>
                            <c:if test="${p.status == 'FAILED'}"><span class="badge bg-danger">Failed</span></c:if>
                            <c:if test="${p.status == 'PENDING'}"><span class="badge bg-warning text-dark">Pending</span></c:if>
                        </td>
                        <td>
                            <a href="/payments/edit/${p.id}" class="btn btn-sm btn-outline-primary" title="Edit Payment">Edit</a>
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
<%@ include file="../fragments/footer.jsp" %>
