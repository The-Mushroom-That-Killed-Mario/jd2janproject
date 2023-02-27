<%--
  Created by IntelliJ IDEA.
  User: Noirix
  Date: 09.02.2023
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>cars</title>
</head>
<body>
${carName}

<div>
    <h1>Все владельцы машин</h1>
</div>
<div>
    <table border="1">
        <tr>
            <td>car Id</td>
            <td>car Name</td>
            <td>car brand</td>
            <td>car price</td>

        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td>${car.id}</td>
                <td>${car.name}</td>
                <td>${car.brand}</td>
                <td>${car.price}</td>

            </tr>
        </c:forEach>
    </table>
</div>
<hr>
<br>
<h1>Пользователи в Минске</h1>
<div>
    <table border="1">
        <tr>
            <td>car Id</td>
            <td>car Name</td>
            <td>car brand</td>
            <td>car price</td>

        </tr>
        <c:forEach var="car" items="${CarsByMinsk}">
            <tr>
                <td>${car.id}</td>
                <td>${car.name}</td>
                <td>${car.brand}</td>
                <td>${car.price}</td>

            </tr>
        </c:forEach>
    </table>
</div>

<hr>
<br>
<h1>Машина Васи</h1>
<div>
    <table border="1">
        <tr>
            <td>car Id</td>
            <td>car Name</td>
            <td>car brand</td>
            <td>car price</td>

        </tr>
        <c:forEach var="car" items="${CarsByVasia}">
            <tr>
                <td>${car.id}</td>
                <td>${car.name}</td>
                <td>${car.brand}</td>
                <td>${car.price}</td>

            </tr>
        </c:forEach>
    </table>
</div>
<hr>
<br>

<form action="" method="post">
    <label for="POST-name">Имя владельца авто:</label>
    <input id="POST-name" type="text" name="name">
    <input type="submit" value="Найти">
</form>

<h1>Поиск по имени владельца: "${userName}"</h1>
<table border="1">
    <tr>
        <td>car Id</td>
        <td>car Name</td>
        <td>car brand</td>
        <td>car price</td>

    </tr>
    <c:forEach var="car" items="${CarsByName}">
        <tr>
            <td>${car.id}</td>
            <td>${car.name}</td>
            <td>${car.brand}</td>
            <td>${car.price}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
