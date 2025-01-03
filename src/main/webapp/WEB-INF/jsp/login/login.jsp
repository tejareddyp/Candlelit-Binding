<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        form {
            font-family: "Oldenburg", serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            width:50%;
            margin-top: 1rem;
        }

        #forgotPassword {
            background-color: #fcf4d9;
            color: #672a3f;
            padding:0rem;
            font-size: small;
            margin-top: .25rem;
            border:none;
        }
    </style>
</head>
<body style="background-color:#fcf4d9">

<jsp:include page="../include/header.jsp"/>
<section>
    <div class="container">
        <%--        this will show error message when user fails to login--%>
        <c:if test="${param.error eq ''}">
        <div class="alert alert-danger" role="alert">
            Invalid username or password
        </div>
        </c:if>
    <div class="container d-flex justify-content-center" >
        <form action="/login/loginSubmit" method="post">

            <div class="mb-3 mt-3">
                <h2 style="color: #672a3f">Log in</h2>
            </div>

            <div class="mb-3 col-sm-6 col-lg-4">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                <p id="result"></p>
            </div>
            <div class="mb-0 col-sm-6 col-lg-4">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="" required>
            </div>
            <div class="mb-3 ">
                <button type="submit" id="forgotPassword" class="btn btn-primary">Forgot
                    Password</button>
            </div>
            <div class="mb-3 ">
                <p id="errorMessage"></p>
                <button type="submit" class="btn btn-primary" style="background-color: #672a3f; ">Submit</button>
            </div>
            <div class="mb-3 ">
                <p>New to Candlelit Binding?</p>
            </div>

            <div class="mb-3 ">
                <button id="createAcc" onclick="location.href='createAccount'" class="btn btn-primary"
                        style="background-color: #672a3f;">Create Account</button>
            </div>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>



</body>
</html>
