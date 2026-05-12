<%@ include file="../fragments/header.jsp" %>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="premium-card">
            <h2 class="mb-4 text-center">Add Client</h2>
            <form action="/customers/register" method="POST">
                <div class="mb-3">
                    <label class="form-label fw-bold">Full Name</label>
                    <input type="text" name="name" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Email Address</label>
                    <input type="email" name="email" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Phone Number</label>
                    <input type="text" name="phone" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Driver's License Number</label>
                    <input type="text" name="license" class="form-control form-control-lg" required>
                </div>
                <div class="mb-4">
                    <label class="form-label fw-bold">Membership Type</label>
                    <select name="type" class="form-select form-select-lg">
                        <option value="REGULAR">Regular Customer (Free)</option>
                        <option value="PREMIUM">Premium Customer (Exclusive Discounts)</option>
                    </select>
                </div>
                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-lg fw-bold">Add Client</button>
                    <a href="/customers/list" class="btn btn-outline-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
