<%@ include file="../fragments/header.jsp" %>
<div class="row mt-5">
    <div class="col-md-6 offset-md-3">
        <div class="premium-card">
            <h2 class="mb-4">Edit Employee Account</h2>
            <form action="/staff/update" method="POST">
                <input type="hidden" name="id" value="${employee.id}">
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" name="name" class="form-control" value="${employee.name}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Role</label>
                    <input type="text" class="form-control" value="${employee.roleName}" disabled>
                    <small class="text-muted">Role cannot be changed after registration.</small>
                </div>
                <div class="mb-3">
                    <label class="form-label">Base Salary</label>
                    <input type="number" step="0.01" name="baseSalary" class="form-control" value="${employee.baseSalary}" required>
                </div>
                <div class="mt-4">
                    <a href="/staff/list" class="btn btn-secondary">Cancel</a>
                    <button type="submit" class="btn btn-warning ms-2">Save Changes</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
