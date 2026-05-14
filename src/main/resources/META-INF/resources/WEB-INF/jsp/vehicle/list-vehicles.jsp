<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="premium-card mt-5">
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            ${errorMessage}
        </div>
    </c:if>
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="m-0">Fleet Management</h2>
        <div>
            <a href="/vehicles/search" class="btn btn-outline-primary"><i class="bi bi-search"></i> Search</a>
            <a href="/vehicles/add" class="btn btn-primary">+ Add Vehicle</a>
        </div>
    </div>
    <ul class="nav nav-tabs mb-3" id="vehicleTabs" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active" id="active-tab" data-bs-toggle="tab" data-bs-target="#active-vehicles" type="button" role="tab" style="color: black !important;">Active Fleet</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="inactive-tab" data-bs-toggle="tab" data-bs-target="#inactive-vehicles" type="button" role="tab" style="color: black !important;">Retired Fleet</button>
        </li>
    </ul>

    <div class="tab-content" id="vehicleTabsContent">
        <!-- Active Pane -->
        <div class="tab-pane fade show active" id="active-vehicles" role="tabpanel">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>Type</th><th>Make & Model</th><th>Reg. Number</th><th>Daily Rate</th><th>Status</th><th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="v" items="${activeVehicles}">
                            <tr>
                                <td>
                                    <c:if test="${v.entityType == 'Car'}"><span class="badge bg-secondary"><i class="bi bi-car-front-fill me-1"></i> CAR</span></c:if>
                                    <c:if test="${v.entityType == 'Bike'}"><span class="badge bg-secondary"><i class="bi bi-bicycle me-1"></i> BIKE</span></c:if>
                                    <c:if test="${v.entityType == 'Lorry'}"><span class="badge bg-secondary"><i class="bi bi-truck me-1"></i> LORRY</span></c:if>
                                </td>
                                <td class="fw-bold">${v.brand} ${v.model}</td>
                                <td>${v.registrationNumber}</td>
                                <td>Rs. ${v.dailyRate}</td>
                                <td>
                                    <c:if test="${v.available}"><span class="badge bg-success">Available</span></c:if>
                                    <c:if test="${!v.available}"><span class="badge bg-danger">Rented</span></c:if>
                                </td>
                                <td>
                                    <a href="/vehicles/edit/${v.id}" class="btn btn-sm btn-outline-warning">Edit</a>
                                    <a href="/vehicles/delete/${v.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Retire this vehicle?');">Retire</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${empty activeVehicles}"><div class="text-center py-4 text-muted">No active vehicles!</div></c:if>
            </div>
        </div>
        
        <!-- Inactive Pane -->
        <div class="tab-pane fade" id="inactive-vehicles" role="tabpanel">
            <div class="table-responsive">
                <table class="table table-hover align-middle text-muted">
                    <thead class="table-light">
                        <tr>
                            <th>Type</th><th>Make & Model</th><th>Reg. Number</th><th>Daily Rate</th><th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="v" items="${inactiveVehicles}">
                            <tr>
                                <td>
                                    <c:if test="${v.entityType == 'Car'}"><span class="badge bg-secondary"><i class="bi bi-car-front-fill me-1"></i> CAR</span></c:if>
                                    <c:if test="${v.entityType == 'Bike'}"><span class="badge bg-secondary"><i class="bi bi-bicycle me-1"></i> BIKE</span></c:if>
                                    <c:if test="${v.entityType == 'Lorry'}"><span class="badge bg-secondary"><i class="bi bi-truck me-1"></i> LORRY</span></c:if>
                                </td>
                                <td class="fw-bold">${v.brand} ${v.model}</td>
                                <td>${v.registrationNumber}</td>
                                <td>Rs. ${v.dailyRate}</td>
                                <td>
                                    <a href="/vehicles/restore/${v.id}" class="btn btn-sm btn-outline-success">Restore</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${empty inactiveVehicles}"><div class="text-center py-4 text-muted">No retired vehicles!</div></c:if>
            </div>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
