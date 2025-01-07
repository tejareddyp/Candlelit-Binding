%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        #header {
            width: 100%;
            text-align: center;
            font-family: "Oldenburg", serif;
            color: #672a3f;
            padding-top: 4rem;
            padding-right: 4rem;
            padding-left: 4rem;
            font-size: xxx-large;
        }

        #main-para {
            width: 100%;
            text-align: center;
            font-family: "Oldenburg", serif;
            color: #672a3f;
            padding-top: 4rem;
            padding-right: 4rem;
            padding-left: 4rem;
            font-size: x-large;
        }
    </style>


</head>
<body style="background-color: #fcf4d9">
<jsp:include page="include/header.jsp"/>

<div class="container d-flex justify-content-center">
    <p id="header">order placed, thank you!</p>
</div>
<div>
    <p id="main-para">Since we are a small business selling handmade items,
        we personally confirm every order.
        We'll be in touch shortly to finalize shipping and payment details.
        Until then, enjoy!
    </p>
</div>

<jsp:include page="include/footer.jsp"/>
</body>
</html>
