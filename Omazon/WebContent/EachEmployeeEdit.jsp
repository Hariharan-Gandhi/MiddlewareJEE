<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "org.omazon.java.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editing Employee</title>
</head>
<body>
<img src="Images/Omazon.jpg" alt="Welcome to Omazon.com" width="1500" height="400"></img>
<%

String eID = request.getParameter("empID");

System.out.println(eID);

Employee e = new Employee();
manageEmployee ME = new manageEmployee();

e = ME.getEmployee(eID);

String empFName  = e.getEmpFName();
String empLName = e.getEmpLName();
String empDes = e.getEmpDesignation();
String empTelNo = e.getEmpTelNo();
String empAddress = e.getEmpAddress();
%>

<form action = "dbEditEmployee.jsp" method = "get">
<input type="hidden" name="empID" value="<%= e.getEmpID() %>" />
<table border = "1" align = "center">
	<tr>
	<td>Employee First Name:</td>
	<td> <input type="text" name="empFName" value="<%= e.getEmpFName() %>" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Last Name:</td>
	<td> <input type="text" name="empLName" value="<%= e.getEmpLName() %>" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Designation:</td>
	<td> <input type="text" name="empDesignation" value="<%= e.getEmpDesignation() %>" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Telephone Number:</td>
	<td> <input type="text" name="empTelNo" value="<%= e.getEmpTelNo() %>" /> <br /></td>
	</tr>
	<tr>
	<td>Employee Address:</td>
	<td> <input type="text" name="empAddress" value="<%= e.getEmpAddress() %>" /><br /></td>
	</tr>
	</table>
	<p align = "center">
	<input type = "submit" name = "AddEmployee" value = "Save" />
	</p> 
</form>

</body>
</html>