<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">500 Server Error</h1>
        </div>
    </div>
</section>

<%--<sec:authorize access="hasAnyAuthority('ADMIN')">--%>
<section class="bg-light2 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1>${exceptionMessage}</h1>
        </div>
    </div>
</section>
<%--</sec:authorize>--%>


<jsp:include page="../include/footer.jsp"/>
