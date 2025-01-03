<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

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
    <form id="form">
    <div class="mb-3 col-sm-6 col-lg-4">
      <label for="name" class="form-label"> Full Name</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="enter name" required>
    </div>


      <div class="mb-3 col-sm-6 col-lg-4">
        <label for="address" class="form-label"> Shipping Address</label>
        <input type="text" class="form-control" id="address" name="address" placeholder="123 Anycity..." required>
      </div>

      <div class="mb-3 col-sm-6 col-lg-4">
        <label for="Notes" class="form-label">Notes</label>
        <textarea id="Notes" class="form-control" rows="6" placeholder="Anything else you'd like us to know?"></textarea>
      </div>

      <div class="mb-3 col-sm-6 col-lg-4">
        <button id="btn"  class="btn btn-primary"
                style="background-color: #672a3f;">Place Order</button>
      </div>

    </form>
  </div>
</section>

<jsp:include page="include/footer.jsp"/>


</body>
</html>
