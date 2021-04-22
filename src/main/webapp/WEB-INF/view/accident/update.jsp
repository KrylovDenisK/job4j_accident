<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Update accident</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
   <form action="<c:url value="/save?id=${accident.id}"/>" method="POST">
    <div class="card mx-auto mb-5 my-5" style="max-width: 40%;">
        <div class="card-header" align="center">
            <h2>Update accident</h2>
        </div>
        <div class="card-body">
            <div class="form-group">
                <label for="name" class="control-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${accident.name}" placeholder="Enter name">
            </div>
                <div class="form-group">
                    <label for="type.id" class="control-label">Type:</label>
                    <select name="type.id" id="type.id" class="form-control">
                        <c:forEach var="type" items="${types}" >
                            <c:if test="${type.equals(accident.type)}">
                                <option selected value="${type.id}">${type.name}</option>
                            </c:if>
                            <c:if test="${!type.equals(accident.type)}">
                                <option value="${type.id}">${type.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                <div class="form-group">
                    <label for="text" class="col-xs-2 control-label">Desription:</label>
                    <input type="text" class="form-control" id="text" name="text" value="${accident.text}" placeholder="Enter description">
                </div>
                <div class="form-group">
                    <label for="address" class="col-xs-2 control-label">Address:</label>
                    <input type="text" class="form-control" id="address" name="address" value="${accident.address}" placeholder="Enter address">
                </div>
            </div>
                <div class="form-group" align="center">
                    <button type="submit" class="btn btn-success">UPDATE</button>
                </div>
        </div>
    </div>
    </form>
</div>
</body>
</html>