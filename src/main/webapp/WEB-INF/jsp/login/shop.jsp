<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
        }

        div.gallery:hover {
            border: 1px solid blueviolet;
        }

        div.gallery img {
            width: 100%;
            padding: 1rem;


        }

        div.desc {
            padding: 15px;
            text-align: center;
        }

        * {
            box-sizing: border-box;
        }

        .responsive {
            padding: 6px 6px;
            float: left;
            width: 20%;
            border-color: #672a3f;
            /* background-color:rgb(221, 221, 178); */
            margin: 1rem;


        }

        @media only screen and (max-width: 700px) {
            .responsive {
                width: 49.99999%;
                margin: 6px 0;
            }
        }

        @media only screen and (max-width: 500px) {
            .responsive {
                width: 80%;
                margin: 1rem;
                margin-top: 5rem;
            }
        }

        .clearfix:after {
            content: "";
            display: table;
            clear: both;
        }
    </style>
</head>

<body style="background-color: #fcf4d9;">

</body>
</html>
