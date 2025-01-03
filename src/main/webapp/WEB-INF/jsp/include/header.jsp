<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candlelit Binding</title>

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

        .metamorphous-regular {
            font-family: "Metamorphous", serif;
            font-weight: 400;
            font-style: normal;
        }

        .navbar-nav .nav-link, .navbar-brand {
            color: #fcf4d9 !important;
            font-family: "Metamorphous", serif;
        }

        #welcome-user {
            color: #fcf4d9;
            font-family: "Oldenburg", serif;
            font-size: small;

        }
    </style>

</head>


<body>

<section>
    <nav class="navbar navbar-expand-lg navbar-light  pb-0 pt-0 ">
        <div class="container-fluid" style="background-color: #672a3f;">
            <a class="navbar-brand" href="/">CANDLELIT BINDING</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">


                <ul class="navbar-nav ms-auto">
                    <li class="nav-item mt-2">
                        <sec:authorize access="isAuthenticated()">
                        <span class="navbar-text" id="welcome-user">
                            Welcome, <strong><sec:authentication property="name"/></strong>
                        </span>
                        </sec:authorize>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/about">ABOUT</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/shop">SHOP</a>
                    </li>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/login/login">LOGIN</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/login/logout">LOGOUT</a>
                        </li>
                    </sec:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="/contact">CONTACT</a>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/cart">CART</a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <a class="nav-link" href="/account">ACCOUNT</a>
                        </li>
                    </sec:authorize>
                    <%--                    <sec:authorize access="!isAuthenticated()">--%>
                    <%--                        <li class="nav-item">--%>
                    <%--                            <a class="nav-link" href="/login/login">Login</a>--%>
                    <%--                        </li>--%>
                    <%--                    </sec:authorize>--%>
                    <%--                    <sec:authorize access="isAuthenticated()">--%>
                    <%--                        <li class="nav-item">--%>
                    <%--                            <a class="nav-link" href="/login/logout">Logout</a>--%>
                    <%--                        </li>--%>
                    <%--                    </sec:authorize>--%>
                    <sec:authorize access="hasAnyAuthority('ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Admin Only</a>
                        </li>
                    </sec:authorize>

                </ul>
            </div>
        </div>
    </nav>

</section>


</body>

</html>

