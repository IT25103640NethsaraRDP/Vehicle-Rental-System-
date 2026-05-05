<%@ include file="../fragments/header.jsp" %>
<div class="row mt-5">
    <div class="col-12 text-center mb-4">
        <h2 class="fw-bold">Administrator Dashboard</h2>
        <p class="text-muted">System Overview & Quick Stats</p>
    </div>
    
    <div class="col-md-4 mb-4">
        <div class="card bg-primary text-white text-center py-4 border-0 shadow-sm rounded-4 h-100" style="transition: transform 0.2s;">
            <div class="card-body">
                <i class="bi bi-people-fill display-4 mb-3 d-block"></i>
                <h3 class="card-title display-6 fw-bold">${totalCustomers}</h3>
                <p class="card-text fs-5">Total Customers</p>
            </div>
            <div class="card-footer bg-transparent border-0 opacity-75">
                <a href="/customers/list" class="text-white text-decoration-none">Manage Customers &rarr;</a>
            </div>
        </div>
    </div>
    
    <div class="col-md-4 mb-4">
        <div class="card bg-success text-white text-center py-4 border-0 shadow-sm rounded-4 h-100">
            <div class="card-body">
                <i class="bi bi-car-front-fill display-4 mb-3 d-block"></i>
                <h3 class="card-title display-6 fw-bold">${totalVehicles}</h3>
                <p class="card-text fs-5">Active Vehicles</p>
            </div>
            <div class="card-footer bg-transparent border-0 opacity-75">
                <a href="/vehicles/list" class="text-white text-decoration-none">Manage Fleet &rarr;</a>
            </div>
        </div>
    </div>
    
    <div class="col-md-4 mb-4">
        <div class="card bg-warning text-dark text-center py-4 border-0 shadow-sm rounded-4 h-100">
            <div class="card-body">
                <i class="bi bi-calendar2-check-fill display-4 mb-3 d-block"></i>
                <h3 class="card-title display-6 fw-bold">${totalBookings}</h3>
                <p class="card-text fs-5">Total Rentals</p>
            </div>
            <div class="card-footer bg-transparent border-0">
                <a href="/bookings/list" class="text-dark text-decoration-none">Manage Bookings &rarr;</a>
            </div>
        </div>
    </div>
    
    <div class="col-12 text-center mt-3">
        <a href="/staff/manage" class="btn btn-outline-dark btn-lg px-5">Manage Employees <i class="bi bi-people-fill ms-2"></i></a>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
