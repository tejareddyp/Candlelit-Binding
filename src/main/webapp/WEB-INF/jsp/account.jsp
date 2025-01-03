<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <style>
        h4 {
            font-family: Oldenburg;
            color: #672a3f;
            text-align: center;
        }
    </style>
</head>
<body style="background-color: #fcf4d9">

<jsp:include page="include/header.jsp"/>

<section>
    <div class="container col-sm-6 col-lg-4 mt-3">
        <h4>Your Orders</h4>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>
</body>
</html>
