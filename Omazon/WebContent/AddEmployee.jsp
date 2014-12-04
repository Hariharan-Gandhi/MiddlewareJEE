<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Page</title>
</head>
<body>
<img src = "Images/Omazon.jpg" height = 200 width = 1000 />
<form action = "dbAddEmployee.jsp" method = "get">
<table border = "1" align = "center">
	<tr>
	<tr>
	<td>Employee First Name:</td>
	<td><input type = "text" name = "empFName" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Last Name:</td>
	<td><input type = "text" name = "empLName" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Email ID:</td>
	<td><input type = "text" name = "email" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Password:</td>
	<td><input type = "password" name = "password" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Designation:</td>
	<td><input type = "text" name = "empDesignation" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Telephone Number:</td>
	<td><input type = "text" name = "empTelNo" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Address:</td>
	<td><input type = "text" name = "empAddress" /> <br /></td>
	</tr>
	</table>
	<p align = "center">
	<input type = "submit" name = "AddEmployee" value = "Add" />
	</p> 
</form>
</body>
</html>