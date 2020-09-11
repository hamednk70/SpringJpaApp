<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
    <c:choose>
        <c:when test="${mode == 'BOOK_VIEW'}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Pub Date</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.pubDate}</td>
                        <td><a href="updateBook?id=${book.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>

    </c:choose>
    <c:choose>
        <c:when test="${mode == 'BOOK_EDIT' || mode == 'NEW_BOOK'}">
            <form action="save" method="post" >
                <input type="hidden" class="form-control" value="${book.id}" name="id" id="bookId">
                <div class="form-group">
                    <label for="bookName">Book Name :</label>
                    <input type="text" class="form-control" value="${book.bookName}" name="bookName" id="bookName">
                </div>
                <div class="form-group">
                    <label for="author">Author :</label>
                    <input type="text" class="form-control" value="${book.author}" name="author" id="author">
                </div>
                <div class="form-group">
                    <label for="pubDate">Date :</label>
                    <input type="date" class="form-control" value="${book.pubDate}" name="pubDate" id="pubDate">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </c:when>

    </c:choose>

</div>

</body>
</html>