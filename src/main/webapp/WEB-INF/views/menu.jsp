<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BookStore</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ubuntu">
    <style>
        body {
            font-family: "Ubuntu", sans-serif;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: darkblue;
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
            background-color: cornflowerblue;
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
    <li><a href="/book/all">Ksiązki</a></li>
    <li><a href="/author/all">Autorzy</a></li>
    <li><a href="/publisher/all">Wydawcy </a></li>
    <li><a href="/book/form/add">Dodaj książkę</a></li>
    <li><a href="/author/form/add">Dodaj autora</a></li>
    <li><a href="/publisher/form/add">Dodaj wydawcę</a></li>
</ul>
<br>
