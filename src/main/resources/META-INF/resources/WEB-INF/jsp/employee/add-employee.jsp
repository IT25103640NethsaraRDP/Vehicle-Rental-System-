<%@ include file="../fragments/header.jsp" %>
<div class="row mt-5">
    <div class="col-md-6 offset-md-3">
        <div class="premium-card">
            <h2 class="mb-4">Register New Employee</h2>
            <form action="/staff/add" method="POST">
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
                <div class="mt-4">
                    <a href="/staff/list" class="btn btn-secondary">Cancel</a>
                    <button type="submit" class="btn btn-primary ms-2">Add Employee</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
