<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="premium-card">
            <h2 class="mb-4 text-center">Edit Vehicle Status</h2>
            <form action="/vehicles/update" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${vehicle.id}" />
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Brand</label>
                    <input type="text" name="brand" class="form-control form-control-lg" value="${vehicle.brand}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Model Name</label>
                    <input type="text" name="modelName" class="form-control form-control-lg" value="${vehicle.model}" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Registration Number</label>
                    <input type="text" name="regNumber" class="form-control form-control-lg" value="${vehicle.registrationNumber}" required>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Daily Rate (Rs.)</label>
                    <input type="number" step="0.01" name="dailyRate" value="${vehicle.dailyRate}" class="form-control form-control-lg" required>
                </div>

                <div class="mb-3">
                    <label class="form-label fw-bold">Vehicle Photo</label>
                    <c:if test="${not empty vehicle.imageUrl}">
                        <div class="mb-2">
                            <img src="${vehicle.imageUrl}" alt="Current vehicle photo"
                                 style="width:100%; height:180px; object-fit:cover; border-radius:10px; border:1px solid #ddd;">
                            <p class="text-muted small mt-1">Current photo — upload a new one below to replace it.</p>
                        </div>
                    </c:if>
                    <c:if test="${empty vehicle.imageUrl}">
                        <p class="text-muted small mb-2">No photo uploaded yet.</p>
                    </c:if>
                    <input type="file" name="image" accept="image/*" class="form-control form-control-lg">
                </div>
                
                <div class="mb-4">
                    <label class="form-label fw-bold">Availability</label>
                    <div class="form-check form-switch pt-2">
                      <input class="form-check-input" type="checkbox" name="available" value="true" ${vehicle.available ? 'checked' : ''} style="transform: scale(1.5); margin-left: -1.5rem;">
                      <label class="form-check-label ms-3" style="font-size: 1.1rem; padding-top: 2px;">Available for Rent</label>
                    </div>
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-warning btn-lg fw-bold text-dark">Save Changes</button>
                    <a href="/vehicles/list" class="btn btn-outline-secondary">Go Back</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
