<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>

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
        p {
            width:100%;
            text-align: left;
            font-family: "Oldenburg", serif;
            color: #672a3f;
            padding-right: 4rem;
            padding-left: 4rem;
            font-size: large;


        }

        .oldenburg-regular {
            font-family: "Oldenburg", serif;
            font-weight: 400;
            font-style: normal;
        }

        body {
            height: 100%;
        }
        .container {
padding-top: 4rem;
            text-align: center;
            display: flex;
        }

    </style>


</head>

<body style="background-color: #fcf4d9;">

<jsp:include page="include/header.jsp"/>

<div class="container">
    <p>At Candlelit Binding, we’re passionate about creating unique, one-of-a-kind books and binders that stand the test of time.
        Each piece is meticulously handcrafted using only the finest materials, ensuring exceptional quality and durability.

    </br></br></br>
        &nbsp
From elegant travel journals to playful Spiderman-themed books, our collection offers something for everyone.
    Can’t find exactly what you’re looking for?
    No worries! Simply reach out to us via the “Contact” tab, and we’ll work closely with you to bring your vision to life.
        </br></br></br>

    </p>

    <jsp:include page="include/footer.jsp"/>
</div>




</body>

</html>


