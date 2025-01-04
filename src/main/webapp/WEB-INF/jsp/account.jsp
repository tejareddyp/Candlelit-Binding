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

        #order1, #order2 {
            font-family: Oldenburg;
            color: #672a3f;
            border-style: solid;
            border-radius: 10px;
            border-width: 1px;
            display: flex;
            justify-content: center;
            flex-direction: column;
        }

        img {
            height: 15%;
            width: 15%;
            margin: 1rem
        }
    </style>

</head>
<body style="background-color: #fcf4d9">

<jsp:include page="include/header.jsp"/>

<section>
    <div class="container col-sm-6 col-lg-4 mt-3">
        <h4>Your Orders</h4>
    </div>

    <div id="order1" class="container col-sm-6 col-lg-4 mt-4">
        <div>
            <h5>Order Date:</h5>
            <h5>Amount:</h5>
        </div>
        <div>
            <img src="../../pub/images/fall%20leaves%20book%20small.jpg"/>
            <h6>Image name</h6>
        </div>

    </div>

    <div id="order2" class="container col-sm-6 col-lg-4 mt-4">
        <div>
            <h5>Order Date:</h5>
            <h5>Amount:</h5>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>
</body>
</html>
