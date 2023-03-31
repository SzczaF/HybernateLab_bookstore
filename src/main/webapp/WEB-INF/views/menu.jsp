<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BookStore</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333333;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 16px;
            text-decoration: none;
        }

        li a:hover {
            background-color: #111111;
        }

        div.button {
            float: left;
            padding-top: 15px;
            padding-right: 15px;
        }
    </style>
</head>
<body>
<ul>
    <a href="/book/form/add">Dodaj książkę</a><br>
    <a href="/author/form/add">Dodaj autora</a><br>
    <a href="/publisher/form/add">Dodaj wydawcę</a><br><br>
</ul>
