<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .form_input_error {
            color: red;
        }

        h1 {
            color: #672a3f;
            font-family: "Oldenburg", serif;
        }

        form {
            font-family: "Oldenburg", serif;
        }
    </style>


</head>
<body style="background-color: #fcf4d9">
<jsp:include page="../include/header.jsp"/>

<section class=" pt-5 pb-2">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Forgot Password</h1>
        </div>
    </div>
</section>


<section class="p2-5 pb-5">
    <div class="container">
        <form action="/login/forgotPassword" method="post">
            <div class="row justify-content-center">
                <div class="col-sm-6 col-lg-4">
                    <dd class="mb-0 form_input_error">${error}</dd>
                </div>
            </div>
            <div class="mt-3 row justify-content-center">
                <label for="firstname" class="col-sm-2 col-form-label">Confirm First Name</label>
                <div class="col-sm-6 col-lg-4 ">
                    <input type="text" class="form-control" id="firstname" name="firstname" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('firstname')}">
                <div class="row justify-content-center">
                    <div class="col-sm-6 col-lg-4">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('firstname')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="lastname" class="col-sm-2 col-form-label">Confirm Last Name</label>
                <div class="col-sm-6 col-lg-4">
                    <input type="text" class="form-control" id="lastname" name="lastname" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('lastname')}">
                <div class="row justify-content-center">
                    <div class="col-sm-6 col-lg-4">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('lastname')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="username" class="col-sm-2 col-form-label">Confirm User Name</label>
                <div class="col-sm-6 col-lg-4">
                    <input type="text" class="form-control" id="username" name="username" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('username')}">
                <div class="row justify-content-center">
                    <div class="col-sm-6 col-lg-4">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('username')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="email" class="col-sm-2 col-form-label">Confirm Email</label>
                <div class="col-sm-6 col-lg-4">
                    <input type="email" class="form-control" id="email" name="email" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('email')}">
            <div class="row justify-content-center">
                <div class="col-sm-2"></div>
                <div class="col-sm-6 col-lg-4">
                    <c:forEach var="error" items="${bindingResult.getFieldErrors('email')}">
                        <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                    </c:forEach>

                </div>
                </c:if>


                <div class="mt-3 row justify-content-center">
                    <label for="password" class="col-sm-2 col-form-label">New Password</label>
                    <div class="col-sm-6 col-lg-4">
                        <input type="password" class="form-control" id="password" name="password" value="">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('password')}">
                <div class="row justify-content-center">
                    <div class="col-sm-6 col-lg-4">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('password')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
                </c:if>

                <div class="mt-3 row justify-content-center">
                    <div class="col-sm-6 col-lg-4 d-flex justify-content-center">
                        <button style="background-color: #672a3f" type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>


</body>
</html>
