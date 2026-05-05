<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-6">
        <div class="premium-card text-center">
            <h2 class="mb-4 text-primary"><i class="bi bi-box-arrow-in-left"></i> Process Return</h2>
            
            <c:if test="${booking != null}">
                <div class="mb-4 text-start bg-light p-4 rounded-3 shadow-sm border">
                    <h5 class="fw-bold mb-3 border-bottom pb-2">Booking Summary: BKG-${booking.id}</h5>
                    <p class="mb-1"><strong>Customer:</strong> ${booking.customer.name}</p>
                    <p class="mb-1"><strong>Vehicle:</strong> ${booking.displayVehicleName}</p>
                    <p class="mb-1"><strong>Duration:</strong> ${booking.durationDays} Days</p>
                    <p class="mb-1"><strong>Total Cost:</strong> <span class="text-success fw-bold">Rs. ${booking.totalCost}</span></p>
                </div>
                
                <form action="/bookings/return" method="POST">
                    <input type="hidden" name="bookingId" value="${booking.id}">
                    <p class="text-muted fst-italic mb-4">Please verify vehicle condition before completing. The vehicle status will be updated to Available once confirmed.</p>
                    
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-success btn-lg fw-bold">Confirm Return & Complete</button>
                        <a href="/bookings/list" class="btn btn-outline-secondary">Go Back</a>
                    </div>
                </form>
            </c:if>
            <c:if test="${booking == null}">
                <div class="alert alert-danger">Booking not found or already completed!</div>
                <a href="/bookings/list" class="btn btn-primary">Back to Booking List</a>
            </c:if>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
