<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <div id="order-container">
        Failed to load data
    </div>
</section>

<jsp:include page="include/footer.jsp"/>
<script>
    let loadOrders = () => {
        let orderDetails = JSON.parse(`${orderDetailsJson}`);
        console.log(orderDetails)

        document.getElementById('order-container').innerHTML = orderDetails.map(od =>
        `<div id="order1" class="container col-sm-6 col-lg-4 mt-4">
        <div>
            <h5>Order Date: ` + od[1].slice(0,10) + `</h5>
            <h5>Amount: $` + od[3] + ` x ` + od[2] + ` = $` + (od[2] * od[3]) + `</h5>
        </div>
        <div>
            <img src="../../pub/images/` + od[0] + `.jpg"/>
            <h6>` + od[0] + `</h6>
        </div>
    </div>`
        )

    }

    window.onload = () => loadOrders();
</script>
</body>
</html>
