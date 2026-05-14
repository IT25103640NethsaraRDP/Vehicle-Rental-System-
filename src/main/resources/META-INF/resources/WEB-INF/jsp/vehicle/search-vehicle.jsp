<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-8">
        <div class="premium-card text-center">
            <h2 class="mb-4">Search Fleet</h2>
            <form action="/vehicles/search" method="GET" class="d-flex mb-5">
                <input type="text" name="keyword" class="form-control form-control-lg me-2" placeholder="Search by brand or model..." required>
                <button type="submit" class="btn btn-primary btn-lg px-4">Search</button>
            </form>
            
            <c:if test="${not empty vehicles}">
                <div class="table-responsive text-start">
                    <table class="table table-bordered align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th>Make & Model</th>
                                <th>Reg. Number</th>
                                <th>Availability</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="v" items="${vehicles}">
                                <tr>
                                    <td class="fw-bold">${v.brand} ${v.model}</td>
                                    <td>${v.registrationNumber}</td>
                                    <td>
                                        <c:if test="${v.available}"><span class="badge bg-success">Yes</span></c:if>
                                        <c:if test="${!v.available}"><span class="badge bg-danger">No</span></c:if>
                                    </td>
                                    <td>
                                        <a href="/vehicles/edit/${v.id}" class="btn btn-sm btn-outline-primary">View / Edit</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <c:if test="${empty vehicles && param.keyword != null}">
                <div class="alert alert-warning text-start">
                    No vehicles found matching "<strong>${param.keyword}</strong>".
                </div>
            </c:if>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
