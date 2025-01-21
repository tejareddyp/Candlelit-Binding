<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Metamorphous&family=Oldenburg&display=swap" rel="stylesheet">

    <style>
        .oldenburg-regular {
            font-family: "Oldenburg", serif;
            font-weight: 400;
            font-style: normal;
        }

        div.gallery {
            border: 1px solid #672a3f;
            padding: 1rem;
        }

        div.gallery:hover {
            border: 1px solid black;
        }

        div.gallery img {
            width: 100%;
            padding: 1rem;
        }

        div.desc {
            padding: 15px;
            text-align: center;
            height: 25%;
        }

        * {
            box-sizing: border-box;
        }

        .responsive {
            padding: 6px 6px;
            float: left;
            width: 22%;
            border-color: #672a3f;
            margin: 1.1rem;
        }

        @media only screen and (max-width: 700px) {
            .responsive {
                width: 49.99999%;
                margin: 6px 0;
            }
        }

        @media only screen and (max-width: 500px) {
            .responsive {
                width: 100%;
                margin: 1rem;
                margin-top: 5rem;
            }
        }

        .clearfix:after {
            content: "";
            display: table;
            clear: both;
        }

        .addToCart {
            background-color: #672a3f;
            color: #fcf4d9;
            width: 50%;
            margin-right: 3rem;
            margin-left: 3.5rem;
            margin-bottom: 1rem;
            border-radius: 15px;
            font-size: small;
        }


        #backToTop {
            position: fixed;
            bottom: .5rem;
            right: .5rem;
            background-color: #672a3f;
            color: #fcf4d9;
            border: none;
            padding: 10px;
            border-radius: 40%;
            font-size: 18px;
            cursor: pointer;
            display: none;
        }

        #backToTop:hover {
            background-color: #672a3f;
        }

        #main-div {
            font-family: "Oldenburg", serif;
            color: #672a3f;
        }

        #header {
            font-family: "Oldenburg", serif;
            color: #672a3f;
            display: flex;
            justify-content: center;
            padding-top: 1rem;
        }

    </style>

</head>

<body style="background-color: #fcf4d9;">

<jsp:include page="include/header.jsp"/>

<section>

    <div id="header">
        <h2>Shop</h2>
    </div>

    <div id="main-div">
        <c:forEach var="product" items="${productsList}">
            <div class="responsive">
                <div class="gallery">
                    <img src="../../pub/images/${product.name}.jpg" alt="image of ${product.name}">
                    <div class="desc">
                        <h5><c:out
                                value="${product.name}"/></h5>
                        <h6>$<c:out value="${product.price}"/></h6>
                        <h6>Stock: <c:out value="${product.stock}"/></h6>
                    </div>
                    <input class="addToCart" type="button" onclick=addToCart("${product.id}") value="Add to Cart"/>
                </div>
            </div>
        </c:forEach>

    </div>

</section>

<!-- Back to Top Button -->
<button id="backToTop" title="Go to top">&#8593;</button>

<script>

    // When the user clicks on the button, scroll to the top of the document
    let mybutton = document.getElementById("backToTop");


    window.onscroll = function () {
        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            mybutton.style.display = "block";
        } else {
            mybutton.style.display = "none";
        }
    };

    mybutton.onclick = function () {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    };

    let addToCart = (productId) => {
        let currentCart = localStorage.getItem('itemsInCart');

        if (currentCart == null) {
            currentCart = new Map();
        } else {
            currentCart = new Map(JSON.parse(currentCart));
        }

        if (currentCart.has(productId)) {
            let temp = currentCart.get(productId) + 1;
            if (temp <= 5) {
                currentCart.set(productId, temp);
                alert("Item added to cart!")
            } else {
                alert("Max quantity per item is 5!")
            }
        } else {
            currentCart.set(productId, 1);
            alert("Item added to cart!")
        }


        localStorage.setItem('itemsInCart', JSON.stringify(Array.from(currentCart.entries())));
    }


</script>

<jsp:include page="include/footer.jsp"/>

</body>
</html>
