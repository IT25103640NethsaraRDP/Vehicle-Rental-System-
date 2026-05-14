<%@ include file="../fragments/header.jsp" %>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="premium-card">
            <h2 class="mb-4 text-center">Add New Vehicle</h2>
            <form action="/vehicles/add" method="POST" enctype="multipart/form-data">
                <div class="mb-3">
                    <label class="form-label fw-bold">Vehicle Type</label>
                    <select name="type" id="vehicleType" class="form-select form-select-lg" onchange="toggleFields()">
                        <option value="CAR">Car</option>
                        <option value="BIKE">Bike</option>
                        <option value="LORRY">Lorry</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Brand</label>
                    <input type="text" name="brand" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Model Name</label>
                    <input type="text" name="modelName" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Registration Number</label>
                    <input type="text" name="regNumber" class="form-control form-control-lg" required>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Daily Rate (Rs.)</label>
                    <input type="number" step="0.01" name="dailyRate" class="form-control form-control-lg" required>
                </div>
                
                <div class="mb-3">
                    <label class="form-label fw-bold">Vehicle Photo (Optional)</label>
                    <input type="file" name="image" class="form-control form-control-lg" accept="image/*">
                </div>
                
                <!-- Dynamic Fields -->
                <div class="mb-4" id="carFields">
                    <label class="form-label fw-bold">Seating Capacity</label>
                    <input type="number" name="seatingCapacity" class="form-control form-control-lg" value="5">
                </div>

                <div class="mb-4 d-none" id="lorryFields">
                    <label class="form-label fw-bold">Load Capacity (kg)</label>
                    <input type="number" step="1" name="loadCapacity" class="form-control form-control-lg" value="1000" placeholder="e.g. 5000">
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary btn-lg fw-bold">Add Vehicle</button>
                    <a href="/vehicles/list" class="btn btn-outline-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
function toggleFields() {
    var type = document.getElementById("vehicleType").value;
    document.getElementById("carFields").classList.add("d-none");
    document.getElementById("lorryFields").classList.add("d-none");
    if (type === "CAR") {
        document.getElementById("carFields").classList.remove("d-none");
    } else if (type === "LORRY") {
        document.getElementById("lorryFields").classList.remove("d-none");
    }
}
</script>
<%@ include file="../fragments/footer.jsp" %>
