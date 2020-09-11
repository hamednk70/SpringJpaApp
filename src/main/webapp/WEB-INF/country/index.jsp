<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">BOOK</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">ALL BOOKS</a></li>
            <li><a href="newBook">NEW BOOK</a></li>
            <li><a href="#">Page 3</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="card">
            <div class="card-block">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Country</th>
                        <th>Capital</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${datas}" var="data">
                        <tr>
                            <td>${data.id}</td>
                            <td>${data.name}</td>
                            <td>${data.capital}</td>
                            <td><a href="/findOneCountry?id=${data.id}" class="eBtn"><span class="glyphicon glyphicon-pencil"></span></a></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <hr/>
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="country?pageNum=1" class="nav-link"></a></li>
                    <li class="nav-item"><a href="country?pageNum=2" class="nav-link"></a></li>
                </ul>
            </div>
        </div>
        <div class="myForm">
            <form action="/save" method="post">
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Update Or Create</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                                <div class="form-group">
                                    <label for="id" class="col-form-label">ID:</label>
                                    <input type="text" class="form-control" id="id" name="id" value="" />
                                </div>
                                <div class="form-group">
                                    <label for="name" class="col-form-label">Country:</label>
                                    <input type="text" class="form-control" id="name" name="name" value="" />
                                </div>
                            <div class="form-group">
                                <label for="capital" class="col-form-label">Capital:</label>
                                <input type="text" class="form-control" id="capital" name="capital" value="" />
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-primary" value="save"/>
                        </div>
                    </div>
                </div>
            </div>
            </form>
        </div>
    </div>


</div>

</body>
</html>
<script>
    $(document).ready(function () {
        $('.table .eBtn').on('click',function () {
            $('.myForm #exampleModal').modal();
            alert("test");
        });
    });
</script>
