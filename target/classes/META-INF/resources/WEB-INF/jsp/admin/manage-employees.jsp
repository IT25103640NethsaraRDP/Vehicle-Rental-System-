<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="premium-card mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="m-0">Employee Management</h2>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addEmployeeModal">+ Add Employee</button>
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
                        <td>$${e.baseSalary}</td>
                        <td class="fw-bold text-success">$${e.calculateMonthlySalary()}</td>
                        <td>
                            <button class="btn btn-sm btn-outline-warning" onclick="openEditModal('${e.id}', '${e.name}', '${e.baseSalary}')">Edit</button>
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

<!-- Add Employee Modal -->
<div class="modal fade" id="addEmployeeModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Register New Employee</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <form action="/staff/add" method="POST">
      <div class="modal-body">
            <div class="mb-3">
                <label class="form-label">Full Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Role</label>
                <select name="role" class="form-select" required>
                    <option value="Manager">Manager</option>
                    <option value="FieldStaff">Field Staff</option>
                    <option value="OfficeStaff">Office Staff</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Base Salary</label>
                <input type="number" step="0.01" name="baseSalary" class="form-control" required>
            </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Add Employee</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- Edit Employee Modal -->
<div class="modal fade" id="editEmployeeModal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Edit Employee Account</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <form action="/staff/update" method="POST">
      <input type="hidden" name="id" id="editEmployeeId">
      <div class="modal-body">
            <div class="mb-3">
                <label class="form-label">Full Name</label>
                <input type="text" name="name" id="editEmployeeName" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Base Salary</label>
                <input type="number" step="0.01" name="baseSalary" id="editEmployeeSalary" class="form-control" required>
            </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-warning">Save Changes</button>
      </div>
      </form>
    </div>
  </div>
</div>

<script>
function openEditModal(id, name, baseSalary) {
    document.getElementById('editEmployeeId').value = id;
    document.getElementById('editEmployeeName').value = name;
    document.getElementById('editEmployeeSalary').value = baseSalary;
    new bootstrap.Modal(document.getElementById('editEmployeeModal')).show();
}
</script>
<%@ include file="../fragments/footer.jsp" %>
