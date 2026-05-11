<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="premium-card">
            <h2 class="mb-4 text-center">Book a Vehicle</h2>
            
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>
            
            <form action="/bookings/add" method="POST">
                <div class="mb-3">
                    <label class="form-label fw-bold">Select Customer</label>
                    <select name="customerId" class="form-select form-select-lg" required>
                        <option value="" disabled selected>-- Choose Customer --</option>
                        <c:forEach var="c" items="${customers}">
                            <option value="${c.id}">${c.name} (${c.roleName} - ${c.discountRate * 100}% off)</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Select Vehicle</label>
                    <select name="vehicleId" class="form-select form-select-lg" required>
                        <option value="" disabled selected>-- Choose Available Vehicle --</option>
                        <c:forEach var="v" items="${vehicles}">
                            <option value="${v.id}">${v.brand} ${v.model} - Rs. ${v.dailyRate}/day</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="mb-4">
                    <label class="form-label fw-bold">Rental Duration (Days)</label>
                    <input type="number" name="durationDays" min="1" max="365" class="form-control form-control-lg" value="1" required>
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-lg fw-bold">Confirm Booking</button>
                    <a href="/bookings/list" class="btn btn-outline-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
