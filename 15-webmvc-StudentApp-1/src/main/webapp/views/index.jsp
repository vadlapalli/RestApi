<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Application</h2>
	<p>
		<font color='green'>${msg }</font>
	</p>

	<form:form action="save" modelAttribute="student" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="M" />Male <form:radiobutton
						path="gender" value="F" />Fe-Male</td>
			</tr>
			<tr>
				<td>Courses:</td>
				<td><form:select path="course">Select
						<form:option value="">-Select-</form:option>
						<form:options items="${courses}" />
						<%-- <form:option value="Java">Java</form:option>
						<form:option value="Python">Python</form:option>
						<form:option value="C#">C#</form:option> --%>
					</form:select></td>
			</tr>
			<tr>
				<td>Timings:</td>
				<td><form:checkboxes items="${preTimings}" path="timings" /></td>
				<%-- Morning <form:checkbox
						path="timings" value="noon" />AfterrNoon <form:checkbox
						path="timings" value="evening" />Evening</td> --%>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>