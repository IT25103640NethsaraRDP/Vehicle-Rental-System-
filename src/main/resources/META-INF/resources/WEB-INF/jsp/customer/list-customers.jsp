<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="premium-card mt-5">
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            ${errorMessage}
        </div>
    </c:if>
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="m-0">Customer Directory</h2>
        <div>
            <a href="/customers/search" class="btn btn-outline-primary"><i class="bi bi-search"></i> Search</a>
            <a href="/customers/register" class="btn btn-primary">+ Add New</a>
        </div>
    </div>
    <ul class="nav nav-tabs mb-3" id="customerTabs" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active text-dark" id="active-tab" data-bs-toggle="tab" data-bs-target="#active-customers" type="button" role="tab" style="color: black !important;">Active Customers</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link text-dark" id="inactive-tab" data-bs-toggle="tab" data-bs-target="#inactive-customers" type="button" role="tab" style="color: black !important;">Inactive Customers</button>
        </li>
    </ul>
    <div class="tab-content" id="customerTabsContent">
        <!-- Active Pane -->
        <div class="tab-pane fade show active" id="active-customers" role="tabpanel">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-light">
                        <tr>
                            <th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>License</th><th>Type</th><th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${activeCustomers}">
                            <tr>
                                <td>${c.id}</td><td class="fw-bold">${c.name}</td><td>${c.email}</td><td>${c.phone}</td><td>${c.licenseNumber}</td>
                                <td><span class="badge bg-info text-dark">${c.roleName}</span></td>
                                <td>
                                    <a href="/customers/edit/${c.id}" class="btn btn-sm btn-outline-warning">Edit</a>
                                    <a href="/customers/delete/${c.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Suspend this customer?');">Deactivate</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${empty activeCustomers}"><div class="text-center py-4 text-muted">No active customers found!</div></c:if>
            </div>
        </div>
        <!-- Inactive Pane -->
        <div class="tab-pane fade" id="inactive-customers" role="tabpanel">
            <div class="table-responsive">
                <table class="table table-hover align-middle text-muted">
                    <thead class="table-light">
                        <tr>
                            <th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>License</th><th>Type</th><th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${inactiveCustomers}">
                            <tr>
                                <td>${c.id}</td><td class="fw-bold">${c.name}</td><td>${c.email}</td><td>${c.phone}</td><td>${c.licenseNumber}</td>
                                <td><span class="badge bg-secondary">${c.roleName}</span></td>
                                <td>
                                    <a href="/customers/restore/${c.id}" class="btn btn-sm btn-outline-success">Restore</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${empty inactiveCustomers}"><div class="text-center py-4 text-muted">No inactive customers!</div></c:if>
            </div>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
