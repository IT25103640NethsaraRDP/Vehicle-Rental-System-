<%@ include file="../fragments/header.jsp" %>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="premium-card">
            <h2 class="mb-4 text-center">Update Customer Info</h2>
            <form action="/customers/update" method="POST">
                <input type="hidden" name="id" value="${customer.id}" />
                <div class="mb-3">
                    <label class="form-label fw-bold">Full Name</label>
                    <input type="text" name="name" value="${customer.name}" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Email Address</label>
                    <input type="email" name="email" value="${customer.email}" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">License Number</label>
                    <input type="text" name="licenseNumber" value="${customer.licenseNumber}" class="form-control form-control-lg" required>
                </div>
                <div class="mb-4">
                    <label class="form-label fw-bold">Phone Number</label>
                    <input type="text" name="phone" value="${customer.phone}" class="form-control form-control-lg" required>
                </div>
                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-warning btn-lg fw-bold text-dark">Save Changes</button>
                    <a href="/customers/list" class="btn btn-outline-secondary">Back to List</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
