<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>H2 DB Product App</title>
</head>
<body>
	<h2>Product Application</h2>
	
	<a href="/all">View All Products</a>
	
	<br>
	<br>
	<p><font color="green" >${msg}</font></p>
	<form:form action="save" modelAttribute="product" method="POST">
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td><form:input path="qty" /></td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="save" /></td>
		</tr>
	</table>
	</form:form>
</body>
</html>