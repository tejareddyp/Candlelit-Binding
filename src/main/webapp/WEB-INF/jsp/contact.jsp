<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        form {
            font-family: "Oldenburg", serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 50%;
            margin-top: 1rem;
            color: #672a3f;
            padding: 1rem;
        }

    </style>
</head>
<body style="background-color: #fcf4d9">
<section>

    <jsp:include page="include/header.jsp"/>

    <section>
        <div class="container d-flex justify-content-center">
            <form class="container">

                <div class="mb-2 mt-2">
                    <h1 id="form-header">Contact Us </h1>
                </div>

                <div class="mb-0 col-sm-6 col-lg-4">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" placeholder="" required>
                </div>

                <div class="mb-2 col-sm-6 col-lg-4 ">
                    <label for="email" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="email" placeholder="" required>

                </div>

                <div class="mb-3 col-sm-6 col-lg-4">
                    <label for="Message" class="form-label">Message</label>
                    <textarea id="Message" class="form-control" rows="6" placeholder="Enter your message here"></textarea>
                </div>


                <div class="mt-1 mb-2">
                    <button type="submit" class="btn btn-primary" style="background-color: #672a3f; ">Submit</button>
                </div>


            </form>
        </div>
    </section>

    <jsp:include page="include/footer.jsp"/>


</body>
</html>
