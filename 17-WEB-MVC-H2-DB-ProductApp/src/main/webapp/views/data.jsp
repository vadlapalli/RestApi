<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>
</head>
<body>
	<h2>All Products</h2>
	<a href="/">Add New Product</a>
	<br>
	<br>
	<table border="1">
		<thead>
			<tr>
				<td>S.No</td>
				<td>Name</td>
				<td>Quantity</td>
				<td>Price</td>
			</tr>
		</thead>
		<tbody>
			   <c:forEach items="${products}" var="product" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${product.name}</td>
                <td>${product.qty}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
		</tbody>
	</table>
</body>
</html>