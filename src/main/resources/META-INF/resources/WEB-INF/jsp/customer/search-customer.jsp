<%@ include file="../fragments/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row justify-content-center mt-5">
    <div class="col-md-8">
        <div class="premium-card text-center">
            <h2 class="mb-4">Search Customers</h2>
            <form action="/customers/search" method="GET" class="d-flex mb-5">
                <input type="text" name="keyword" class="form-control form-control-lg me-2" placeholder="Search by name..." required>
                <button type="submit" class="btn btn-primary btn-lg px-4">Search</button>
            </form>
            
            <c:if test="${not empty customers}">
                <div class="table-responsive text-start">
                    <table class="table table-bordered align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="c" items="${customers}">
                                <tr>
                                    <td class="fw-bold">${c.name}</td>
                                    <td>${c.email}</td>
                                    <td>
                                        <a href="/customers/edit/${c.id}" class="btn btn-sm btn-outline-primary">View / Edit</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <c:if test="${empty customers && param.keyword != null}">
                <div class="alert alert-warning text-start">
                    No customers found matching "<strong>${param.keyword}</strong>".
                </div>
            </c:if>
        </div>
    </div>
</div>
<%@ include file="../fragments/footer.jsp" %>
