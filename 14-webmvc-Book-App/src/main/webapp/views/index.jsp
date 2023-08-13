<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book App with jsp jasfer</title>
</head>
<body>

	<h2>Book Details:</h2>
	<form action="book">
	Book Id: <input type="text" name="id"/>
	        <input type="submit" value="search"/>
	</form>
	<hr>
	Book Id: ${book.bookId} <br>
	Book Name: ${book.bookName} <br>
	Book Price: ${book.bookPrice} <br>
</body>
</html>