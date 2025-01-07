<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        #cart-header {
            font-family: "Oldenburg", serif;
            color: #672a3f;
            display: flex;
            justify-content: center;
        }
        .item-in-cart {
            border-style: solid;
            border-radius:10px;
            border-width: 1px;
            border-color: #672a3f;
            margin:2rem;
            display: flex;
            font-family: "Oldenburg", serif;
            font-size: large;
            color:#672a3f;
        }

        #checkout-button {
            display: flex;
            justify-content: center;
            font-family: "Oldenburg", serif;
        }

        #total-price {
            font-family: "Oldenburg", serif;
            display: flex;
            justify-content: center;
        }

        img {
            height:20%;
            width:20%;
        }

        select {
            width: 15%;
        }

    </style>
</head>
<body style="background-color: #fcf4d9">
<jsp:include page="include/header.jsp"/>

<section>
    <div class="container  mt-4" id="cart-header">
        <h2>Cart</h2>
    </div>
</section>

<section id="cart-items">
</section>

<jsp:include page="include/footer.jsp"/>

<script>
    let loadCart = () => {
        let currentCart = localStorage.getItem('itemsInCart');
        if (currentCart == null) {
            currentCart = new Map();
        } else {
            currentCart = (JSON.parse(currentCart));
        }
        let cart = findProductNames(${productsList}, currentCart);

        let totalPrice = 0;
        cart.forEach(item => {
            totalPrice += item.price * item.quantity;
        })

        document.getElementById('cart-items').innerHTML = cart.map(cartItem => `<div class="item-in-cart">
                   <img src="../../pub/images/` + cartItem.name + `.jpg" alt="Image of ` + cartItem.name + `" />
                    <div class="container mb-2 mt-2" style="display: flex;flex-direction: column;justify-content: center">
                        <h4 >` + cartItem.name + `</h4>
                        <h6>$` + cartItem.price + ` x ` + cartItem.quantity + ` = $` + cartItem.price * cartItem.quantity + ` </h6>
                        <h6>Stock: ` + cartItem.stock + `</h6>
                        <select name="quanity-select" onchange=updateQuantity(` + cartItem.id + `) id="select-` + cartItem.id + `" >
                            <option ` + cartItem.selected[0] + ` >0</option>
                            <option ` + cartItem.selected[1] + ` >1</option>
                            <option ` + cartItem.selected[2] + ` >2</option>
                            <option ` + cartItem.selected[3] + ` >3</option>
                            <option ` + cartItem.selected[4] + ` >4</option>
                            <option ` + cartItem.selected[5] + ` >5</option>
                        </select>
                    </div>
                </div>`).join(' ') + `
                <section>
                    <div class="container" id="total-price">
                        <h6>Total Price: $` + totalPrice + ` </h6>
                    </div>
                </section>

                <section>
                <div id="checkout-button">
                    <button style="background-color: #672a3f; margin-bottom: 3rem;" type="submit" onclick="location.href='/checkout'" class="btn btn-primary">Checkout</button>
                </div>
                </section>
            `;


    };

    window.onload = () => {loadCart();}
</script>
<script src="../../pub/js/utils.js"></script>
</body>
</html>
