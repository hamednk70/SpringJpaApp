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
<table>
    <thead>
    <th>Id</th>
    <th>name</th>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <th>${employee.name}</th>
            <th>
                <form action="/employee/delete">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="delete">
                </form>
            </th>
            <td>
                <a href="/employee/findById/?id=${employee.id}"> update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<hr>
<div id="id01" w3-repeat="Employee">
    {{name}} {{id}}
</div>
<hr>
<br>
<table id="id02">
    <tr>

        <th>name</th>
    </tr>

    <tr w3-repeat="Employee">
        <td id="idEdit"></td>
        <td id="titleEdit"></td>
        <td>{{name}}</td>

    </tr>
</table>
<script>
    $('document').ready(function () {
        $('table #editButton').on('click',function (event) {
            event.preventDefault();
            var href = "/rest/emp";
            $.get(href,function (employee, status) {
                $('#idEdit').val(employee.id);
                $('#titleEdit').val(employee.name);
                // $('#albomEdit').val(style.alboms.title);
            });

            $('#editModal').modal();
        });

        $('table #deleteButton').on('click',function (event) {
            event.preventDefault();
            var href = $(this).attr('href');

            $('#confirmDeleteButton').attr('href', href);

            $('#deleteModal').modal();
        });
    });
</script>
<script>
    w3.getHttpObject("/rest/emp", myFunction);

    function myFunction(myObject) {
        w3.displayObject("id02", myObject);
    }
</script>
</body>
</html>