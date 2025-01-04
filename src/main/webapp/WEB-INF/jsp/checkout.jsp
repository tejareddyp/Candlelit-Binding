<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <style>

    #checkout-header {
      display: flex;
      justify-content: center;
      font-family: Oldenburg;
      margin-top: 2rem;
      color: #672a3f;
    }

    form {
      font-family: Oldenburg;
      color:#672a3f;
    }
  </style>
</head>
<body style="background-color: #fcf4d9">

<jsp:include page="include/header.jsp"/>

<section>
  <div id="checkout-header" class="container col-sm-6 col-lg-4">
    <h2>Checkout</h2>
  </div>
</section>

<section>
  <div class="container">
    <form id="form" action="/checkout" method="post">
    <div class="mb-3 col-sm-6 col-lg-4">
      <label for="name" class="form-label"> Full Name</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="enter name" required>
    </div>


      <div class="mb-3 col-sm-6 col-lg-4">
        <label for="address" class="form-label"> Shipping Address</label>
        <input type="text" class="form-control" id="address" name="address" placeholder="123 Anycity..." required>
      </div>

      <div class="mb-3 col-sm-6 col-lg-4">
        <label for="notes" class="form-label">Notes</label>
        <textarea id="notes" name="notes" class="form-control" rows="6" placeholder="Anything else you'd like us to know?"></textarea>
      </div>

      <div class="mb-3 col-sm-6 col-lg-4">
        <button id="btn"  class="btn btn-primary"
                style="background-color: #672a3f;">Place Order</button>
      </div>
      <input type="text" class="form-control" id="cart" name="cart" style="visibility: hidden">

    </form>
  </div>
</section>
<script src="../../pub/js/utils.js"></script>
<c:if test="${checkoutComplete == 'true'}" >
  <script>
    let currentCart = localStorage.getItem('itemsInCart');
    currentCart = (JSON.parse(currentCart));

    let cart = findProductNames(${productsList}, currentCart);

    let totalPrice = 0;

    const date = new Date();
    let subject = "${username}" + " - Placing Order, " + date.getUTCFullYear() + "-" + (date.getUTCMonth() + 1) + "-"
            + date.getUTCDate();

    let body = "Shipping to:%0D%0A${name}%0D%0A${address}%0D%0A%0D%0AOrder Details:%0D%0A";
    cart.forEach(item => {
      totalPrice += item.price * item.quantity;
      body += item.name + " x " + item.quantity + " = $" + (item.price * item.quantity) + "%0D%0A";
    })
    body += "Order Total = $" + totalPrice;

    body += "%0D%0A%0D%0AAdditional Notes: %0D%0A${notes}"

    location.href="mailto:candlelitbinding@outlook.com?subject=" + subject + "&body=" + body;
    window.location.href="/orderPlaced";
  </script>
</c:if>
<jsp:include page="include/footer.jsp"/>
<script>
  window.onload = () => {
    document.getElementById('cart').value = localStorage.getItem('itemsInCart');
  }
</script>
</body>
</html>
