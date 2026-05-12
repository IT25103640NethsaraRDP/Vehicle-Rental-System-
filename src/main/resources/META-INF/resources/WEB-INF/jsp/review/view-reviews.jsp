<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row mt-5">
    <div class="col-12 d-flex justify-content-between align-items-center mb-4">
        <h2 class="fw-bold">Reviews & System Logs</h2>
        <div>
            <a href="/reviews/submit" class="btn btn-primary">+ Add Record</a>
        </div>
    </div>
    
    <c:forEach var="r" items="${reviews}">
        <div class="col-md-6 mb-4">
            <div class="card border-0 shadow-sm rounded-4 h-100 p-3" style="background-color: #ffffff;">
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <div class="d-flex align-items-center">
                            <div class="bg-primary text-white rounded-circle d-flex align-items-center justify-content-center me-3" style="width: 50px; height: 50px; font-size: 1.2rem; font-weight: bold;">
                                ${r.customer.name.substring(0,1).toUpperCase()}
                            </div>
                            <div>
                                <h5 class="mb-0 fw-bold">${r.customer.name}</h5>
                                <small class="text-muted">${r.reviewDate}</small>
                                <span class="badge bg-secondary ms-2">${r.reviewBadge}</span>
                            </div>
                        </div>
                        <div class="text-end">
                            <a href="/reviews/delete/${r.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('Delete this record?');"><i class="bi bi-trash"></i></a>
                        </div>
                    </div>
                    
                    <h6 class="text-primary fw-bold mb-2"><i class="bi bi-car-front-fill me-1"></i> ${r.displayVehicleName}</h6>
                    
                    <p class="card-text text-secondary fst-italic">"${r.displayFormat}"</p>
                </div>
            </div>
        </div>
    </c:forEach>
    
    <c:if test="${empty reviews}">
        <div class="col-12 text-center py-5">
            <h4 class="text-muted">No records found.</h4>
            <a href="/reviews/submit" class="btn btn-outline-primary mt-3">Add First Record</a>
        </div>
    </c:if>
</div>
<%@ include file="../fragments/footer.jsp" %>
