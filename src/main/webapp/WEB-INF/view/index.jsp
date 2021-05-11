<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09.04.2021
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Car Accident</title>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-dark bg-dark">
    <a href="" class="navbar-brand">CAR ACCIDENT</a>
    <div class="navbar-nav">
        <a class="nav-item nav-link" href="<c:url value="/logout"/>">Logout: ${username}</a>
    </div>
</nav>
<br><br>
<div class="container">
    <table class="table" id="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Type</th>
            <th>Description</th>
            <th>Address</th>
            <th>Rules</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="accident" items="${accidents}">
            <tr>
                <th><a href="<c:url value="/update?id=${accident.id}"/>">${accident.id}</a></th>
                <th>${accident.name}</th>
                <th>${accident.type.name}</th>
                <th>${accident.text}</th>
                <th>${accident.address}</th>
                <th>
                    <c:forEach var="rule" items="${accident.rules}">
                        <c:out value="${rule.name}"/><br>
                    </c:forEach>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="<c:url value="/create"/>">Добавить инцидент</a>
</div>
</body>
</html>
