<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <div class="premium-card">
            <h2 class="mb-4 text-center">Add Review / Log</h2>
            
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>

            <form action="/reviews/submit" method="POST">
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Record Type</label>
                    <select id="reviewType" name="reviewType" class="form-select" onchange="toggleFields()">
                        <option value="CUSTOMER">Customer Feedback</option>
                        <option value="ADMIN">Internal Admin Note</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Customer</label>
                    <select name="customerId" class="form-select" required>
                        <option value="" disabled selected>Select associated customer</option>
                        <c:forEach var="c" items="${customers}">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Vehicle</label>
                    <select name="vehicleId" class="form-select" required>
                        <option value="" disabled selected>Select vehicle</option>
                        <c:forEach var="v" items="${vehicles}">
                            <option value="${v.id}">${v.brand} ${v.model}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Rating (1-5)</label>
                    <input type="number" name="rating" class="form-control" min="1" max="5" value="5" required>
                </div>

                <div class="mb-4">
                    <label class="form-label fw-bold">Main Comment</label>
                    <textarea name="comment" class="form-control" rows="3" placeholder="Enter review or details..." required></textarea>
                </div>

                <!-- Customer specific fields -->
                <div id="customerFields" class="mb-3">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="verifiedPurchase" id="verifiedPurchase" value="true" checked>
                        <label class="form-check-label fw-bold" for="verifiedPurchase">
                            Verified Purchase
                        </label>
                    </div>
                </div>

                <!-- Admin specific fields -->
                <div id="adminFields" class="mb-4" style="display: none;">
                    <label class="form-label fw-bold">Admin Internal Note</label>
                    <textarea name="adminNote" class="form-control" rows="2" placeholder="Private note..."></textarea>
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-lg fw-bold">Save Record</button>
                    <a href="/reviews/list" class="btn btn-outline-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
function toggleFields() {
    var type = document.getElementById("reviewType").value;
    if (type === "CUSTOMER") {
        document.getElementById("customerFields").style.display = "block";
        document.getElementById("adminFields").style.display = "none";
    } else {
        document.getElementById("customerFields").style.display = "none";
        document.getElementById("adminFields").style.display = "block";
    }
}
</script>
<%@ include file="../fragments/footer.jsp" %>
