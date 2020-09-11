<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://www.w3schools.com/lib/w3.js"></script>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/employee/update" method="put">
    <input type="text" name="id" readonly value="${employee.id}">
    <input type="text" name="name" value="${employee.name}">
    <input type="submit" value="update">
</form>

</body>
</html>