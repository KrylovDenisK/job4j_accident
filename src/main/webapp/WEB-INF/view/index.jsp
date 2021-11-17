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
    <link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <title>Car Accident</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12" >
            <nav class="navbar navbar-fixed-top navbar-dark bg-dark">
                <a href="" class="navbar-brand">CAR ACCIDENT</a>
                <div class="collapse navbar-collapse">
                    <div class="navbar-nav">
                        <div class="nav-item">
                            <a class="nav-link" href="<c:url value="/create"/>" >Добавить инцидент</a>
                        </div>
                    </div>
                </div>
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="<c:url value="/logout"/>">Logout: ${username}</a>
                </div>
            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Адрес</th>
                    <th scope="col">Тип</th>
                    <th scope="col">Статья</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Редактировать</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${accidents}" var="accident">
                    <tr>
                        <th scope="row"><c:out value="${accident.id}"/></th>
                        <td><c:out value="${accident.name}"/></td>
                        <td><c:out value="${accident.address}"/></td>
                        <td><c:out value="${accident.type.name}"/></td>
                        <td>
                            <c:forEach items="${accident.rules}" var="rule">
                                <c:out value="${rule.name}"/>
                            </c:forEach>
                        </td>
                        <td><c:out value="${accident.text}"/></td>
                        <td class="text-center"><a href="<c:url value="/update?id=${accident.id}"/>"><i class="fa fa-gear custom"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <a href="<c:url value="/create"/>" class="btn btn-secondary btn-lg btn-block" role="button" aria-pressed="true">Добавить</a>
        </div>
    </div>
</div>
</body>
</html>