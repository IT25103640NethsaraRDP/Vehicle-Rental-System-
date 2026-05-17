<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="premium-card mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="m-0">Employee Management</h2>
        <div class="d-flex gap-2">
            <form action="/staff/list" method="GET" class="d-flex">
                <input type="text" name="keyword" class="form-control me-2" placeholder="Search by name..." value="${keyword}">
                <button type="submit" class="btn btn-outline-secondary">Search</button>
                <c:if test="${not empty keyword}">
                    <a href="/staff/list" class="btn btn-outline-danger ms-2">Clear</a>
                </c:if>
            </form>
            <a href="/staff/add" class="btn btn-primary">+ Add Employee</a>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table table-hover align-middle">
            <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Role</th>
                    <th>Base Salary</th>
                    <th>Calculated Monthly Salary</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="e" items="${employees}">
                    <tr>
                        <td class="fw-bold">${e.id}</td>
                        <td class="fw-bold">${e.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${e.roleName == 'Manager'}"><span class="badge bg-danger">Manager</span></c:when>
                                <c:when test="${e.roleName == 'FieldStaff'}"><span class="badge bg-warning text-dark">Field Staff</span></c:when>
                                <c:otherwise><span class="badge bg-info text-dark">Office Staff</span></c:otherwise>
                            </c:choose>
                        </td>
                        <td>Rs. ${e.baseSalary}</td>
                        <td class="fw-bold text-success">Rs. ${e.calculateMonthlySalary()}</td>
                        <td>
                            <a href="/staff/edit/${e.id}" class="btn btn-sm btn-outline-warning">Edit</a>
                            <a href="/staff/delete/${e.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Remove employee ${e.name}?');">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${empty employees}">
            <div class="text-center py-4 text-muted">No employees found!</div>
        </c:if>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
