<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-4">
    <h1 class="mb-4 text-center fw-bold">Booking Portal</h1>
    
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <!-- Nav Tabs -->
    <ul class="nav nav-pills nav-fill mb-4 p-2 bg-white rounded shadow-sm" id="bookingTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button class="nav-link active fw-bold" id="make-booking-tab" data-bs-toggle="tab" data-bs-target="#makeBooking" type="button" role="tab">Make a Booking</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link fw-bold" id="ongoing-tab" data-bs-toggle="tab" data-bs-target="#ongoing" type="button" role="tab">Ongoing Bookings</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link fw-bold" id="previous-tab" data-bs-toggle="tab" data-bs-target="#previous" type="button" role="tab">Previous Bookings</button>
      </li>
    </ul>

    <div class="tab-content" id="bookingTabContent">
      
      <!-- TAB 1: MAKE A BOOKING -->
      <div class="tab-pane fade show active" id="makeBooking" role="tabpanel">
        <div class="premium-card mb-4" style="background: rgba(255,255,255,0.9); backdrop-filter: blur(10px);">
            <div class="row align-items-end g-3">
                <div class="col-md-6">
                    <label class="form-label fw-bold">Select Customer</label>
                    <select id="selectedCustomer" class="form-select form-select-lg">
                        <option value="" disabled selected>-- Choose Customer --</option>
                        <c:forEach var="c" items="${customers}">
                            <option value="${c.id}">${c.name} (${c.roleName})</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6">
                    <label class="form-label fw-bold">Rental Duration (Days)</label>
                    <input type="number" id="selectedDuration" min="1" max="365" class="form-control form-control-lg" value="1">
                </div>
            </div>
        </div>

        <div id="vehiclesContainer" class="d-none">
            <h3 class="mb-3 fw-bold">Available Vehicles</h3>
            <div class="row g-4">
            <c:forEach var="v" items="${vehicles}">
                <div class="col-md-4">
                    <div class="card h-100 border-0 shadow-sm" style="border-radius: 15px; overflow: hidden; transition: transform 0.2s;">
                        <!-- Display Custom or Premium Placeholder Image -->
                        <c:choose>
                            <c:when test="${not empty v.imageUrl}">
                                <img src="${v.imageUrl}" class="card-img-top" style="height: 200px; object-fit: cover;">
                            </c:when>
                            <c:when test="${v.entityType == 'Car'}"><img src="https://images.unsplash.com/photo-1549317661-bd32c8ce0be2?auto=format&fit=crop&w=600&q=80" class="card-img-top" style="height: 200px; object-fit: cover;"></c:when>
                            <c:when test="${v.entityType == 'Bike'}"><img src="https://images.unsplash.com/photo-1558981403-c5f9899a28bc?auto=format&fit=crop&w=600&q=80" class="card-img-top" style="height: 200px; object-fit: cover;"></c:when>
                            <c:when test="${v.entityType == 'Lorry'}"><img src="https://images.unsplash.com/photo-1601584115197-04ecc0da31d7?auto=format&fit=crop&w=600&q=80" class="card-img-top" style="height: 200px; object-fit: cover;"></c:when>
                            <c:otherwise><img src="https://images.unsplash.com/photo-1494976388531-d1058494cdd8?auto=format&fit=crop&w=600&q=80" class="card-img-top" style="height: 200px; object-fit: cover;"></c:otherwise>
                        </c:choose>
                        
                        <div class="card-body">
                            <span class="badge bg-secondary mb-2">${v.entityType}</span>
                            <h5 class="card-title fw-bold">${v.brand} ${v.model}</h5>
                            <p class="card-text text-muted mb-3">Reg: ${v.registrationNumber}</p>
                            
                            <div class="d-flex justify-content-between align-items-center mt-auto">
                                <h4 class="text-primary mb-0 fw-bold">Rs. ${v.dailyRate}<small class="fs-6 text-muted">/day</small></h4>
                                <button class="btn btn-success fw-bold" onclick="submitBooking(${v.id})">Make a Payment</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <c:if test="${empty vehicles}">
               <div class="col-12"><div class="alert alert-info border-0 shadow-sm">No vehicles currently available for booking.</div></div>
            </c:if>
        </div>
        </div>
      </div>

      <!-- TAB 2: ONGOING BOOKINGS -->
      <div class="tab-pane fade" id="ongoing" role="tabpanel">
        <div class="premium-card">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light"><tr><th>Ref ID</th><th>Customer</th><th>Vehicle</th><th>Period</th><th>Cost</th><th>Actions</th></tr></thead>
                    <tbody>
                        <c:set var="hasOngoing" value="false" />
                        <c:forEach var="b" items="${bookings}">
                            <c:if test="${b.status == 'ACTIVE'}">
                                <c:set var="hasOngoing" value="true" />
                                <tr>
                                    <td class="fw-bold">BKG-${b.id}</td>
                                    <td>${b.customer.name}</td>
                                    <td>${b.displayVehicleName}</td>
                                    <td>${b.bookingDate} to ${b.returnDate} <br><small class="text-muted">${b.durationDays} days</small></td>
                                    <td class="fw-bold text-success">Rs. ${b.totalCost}</td>
                                    <td>
                                        <a href="/bookings/return/${b.id}" class="btn btn-sm btn-outline-success">Return</a>
                                        <a href="/bookings/cancel/${b.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Cancel this booking?');">Cancel</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${not hasOngoing}">
                    <div class="text-center py-4 text-muted">No ongoing bookings currently.</div>
                </c:if>
            </div>
        </div>
      </div>

      <!-- TAB 3: PREVIOUS BOOKINGS -->
      <div class="tab-pane fade" id="previous" role="tabpanel">
        <div class="premium-card">
             <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light"><tr><th>Ref ID</th><th>Customer</th><th>Vehicle</th><th>Period</th><th>Cost</th><th>Status</th></tr></thead>
                    <tbody>
                        <c:set var="hasPast" value="false" />
                        <c:forEach var="b" items="${bookings}">
                            <c:if test="${b.status != 'ACTIVE'}">
                                <c:set var="hasPast" value="true" />
                                <tr>
                                    <td class="fw-bold text-muted">BKG-${b.id}</td>
                                    <td>${b.customer.name}</td>
                                    <td>${b.displayVehicleName}</td>
                                    <td><small>${b.bookingDate} - ${b.returnDate}</small></td>
                                    <td class="fw-bold">Rs. ${b.totalCost}</td>
                                    <td>
                                        <c:if test="${b.status == 'COMPLETED'}"><span class="badge bg-success">Completed</span></c:if>
                                        <c:if test="${b.status == 'CANCELLED'}"><span class="badge bg-danger">Cancelled</span></c:if>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${not hasPast}">
                    <div class="text-center py-4 text-muted">No previous bookings found.</div>
                </c:if>
            </div>
        </div>
      </div>
      
    </div>
</div>

<!-- Hidden Form to submit booking -->
<form id="submissionForm" action="/bookings/add" method="POST" style="display:none;">
    <input type="hidden" name="customerId" id="submitCustomerId">
    <input type="hidden" name="vehicleId" id="submitVehicleId">
    <input type="hidden" name="durationDays" id="submitDurationDays">
</form>

<script>
function checkRevealGrid() {
    const cid = document.getElementById('selectedCustomer').value;
    const dur = document.getElementById('selectedDuration').value;
    if (cid && dur && dur >= 1) {
        document.getElementById('vehiclesContainer').classList.remove('d-none');
    } else {
        document.getElementById('vehiclesContainer').classList.add('d-none');
    }
}
document.getElementById('selectedCustomer').addEventListener('change', checkRevealGrid);
document.getElementById('selectedDuration').addEventListener('input', checkRevealGrid);

function submitBooking(vid) {
    const cid = document.getElementById('selectedCustomer').value;
    const dur = document.getElementById('selectedDuration').value;
    
    if(!cid) {
        alert("Please select a customer first!");
        window.scrollTo({top: 0, behavior: 'smooth'});
        return;
    }
    if(!dur || dur < 1) {
        alert("Please enter a valid rental duration!");
        window.scrollTo({top: 0, behavior: 'smooth'});
        return;
    }
    
    document.getElementById('submitCustomerId').value = cid;
    document.getElementById('submitVehicleId').value = vid;
    document.getElementById('submitDurationDays').value = dur;
    
    document.getElementById('submissionForm').submit();
}
</script>

<style>
/* Hover effect for vehicle cards */
.card {
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}
.card:hover {
    transform: translateY(-5px);
    box-shadow: 0 10px 20px rgba(0,0,0,0.15) !important;
}
.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
    background-color: var(--primary-color, #0d6efd);
    color: white !important;
}
.nav-pills .nav-link {
    color: black !important;
    margin: 0 5px;
    border-radius: 10px;
}
</style>

<%@ include file="../fragments/footer.jsp" %>
