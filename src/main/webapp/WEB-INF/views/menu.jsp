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

        /*    table */
        /*
        table {
            border: 0px solid #C3C3C3;
            background-color: #B1CAF3;
            width: 100px;
            text-align: center;
        }
        table td, table.greenTable th {
            border: 2px solid #FFFFFF;
            padding: 3px 2px;
        }
        table tbody td {
            font-size: 13px;
        }
        table thead {
            background: #0716C3;
            border-bottom: 0px solid #444444;
        }
        table thead th {
            font-size: 19px;
            font-weight: bold;
            color: #F0F0F0;
            text-align: center;
            border-left: 0px solid #444444;
        }
        table thead th:first-child {
            border-left: none;
        }

        table tfoot {
            font-size: 13px;
            font-weight: bold;
            color: #F0F0F0;
            background: #B1CAF3;
            background: -moz-linear-gradient(top, #c4d7f6 0%, #b8cff4 66%, #B1CAF3 100%);
            background: -webkit-linear-gradient(top, #c4d7f6 0%, #b8cff4 66%, #B1CAF3 100%);
            background: linear-gradient(to bottom, #c4d7f6 0%, #b8cff4 66%, #B1CAF3 100%);
            border-top: 1px solid #B1CAF3;
        }
        table tfoot td {
            font-size: 13px;
        }
        table tfoot .links {
            text-align: right;
        }
        table tfoot .links a{
            display: inline-block;
            background: #FFFFFF;
            color: #4B5668;
            padding: 2px 8px;
            border-radius: 5px;
        }
        */

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
